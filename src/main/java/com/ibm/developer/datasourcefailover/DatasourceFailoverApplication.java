package com.ibm.developer.datasourcefailover;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class DatasourceFailoverApplication {

	ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(DatasourceFailoverApplication.class, args);
	}

	@Bean
	@Primary
	public DataSource creatingRoutingDatasource(@Qualifier("primary") DataSource primaryDatasource,
			@Qualifier("failover") DataSource failoverDatasource) throws SQLException {
		Map<Object, Object> targetDataSources = new HashMap<>();
		targetDataSources.put(ActiveDatabase.PRIMARY, primaryDatasource);
		targetDataSources.put(ActiveDatabase.FAILOVER, failoverDatasource);

		FailoverDatasourceRouter aaFailoverDatasourceRouter = new FailoverDatasourceRouter();
		aaFailoverDatasourceRouter.setTargetDataSources(targetDataSources);
		aaFailoverDatasourceRouter.setDefaultTargetDataSource(primaryDatasource);
		return aaFailoverDatasourceRouter;
	}
}
