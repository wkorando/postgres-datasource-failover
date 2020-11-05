package com.ibm.developer.datasourcefailover;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class DatasourceFailoverApplication {

	ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(DatasourceFailoverApplication.class, args);
	}

	@Bean
	@ConfigurationProperties(prefix = "primary.datasource")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	@ConfigurationProperties(prefix = "failover.datasource")
	public DataSource failoverDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	@Primary
	@DependsOn({"primaryDataSource", "failoverDataSource"})
	public DataSource creatingRoutingDatasource(
			@Qualifier("primaryDataSource") DataSource primaryDataSource,
			@Qualifier("failoverDataSource") DataSource failoverDataSource
			) throws SQLException {
		Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put(ActiveDatabase.PRIMARY, primaryDataSource);
		targetDataSources.put(ActiveDatabase.FAILOVER, failoverDataSource);

		FailoverDatasourceRouter failoverDatasource = new FailoverDatasourceRouter();
		failoverDatasource.setTargetDataSources(targetDataSources);
		failoverDatasource.setDefaultTargetDataSource(primaryDataSource);
		return failoverDatasource;
	}
}
