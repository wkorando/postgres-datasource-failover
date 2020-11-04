package com.ibm.developer.datasourcefailover;

import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class FailoverDatasourceRouter extends AbstractRoutingDataSource {
	private static final Logger LOGGER = LoggerFactory.getLogger(FailoverDatasourceRouter.class);
	private ActiveDatabase activeDatabase = ActiveDatabase.PRIMARY;
	ActiveDatabaseHolder activeDatabaseHolder = new ActiveDatabaseHolder();

	@Override
	protected Object determineCurrentLookupKey() {
		return activeDatabase;
	}

	@Override
	public Connection getConnection() throws SQLException {
		try {
			/*
			 * Calls the super class which, if the datasource is defined correctly, will
			 * test the connection. If successful, will simply return connection, if
			 * connection fails, into throws block.
			 * 
			 */
			return super.getConnection();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage(), e);
			/*
			 * If connected to primary database, switch to failover, and recursively call AaFailoverDatasourceRouter.getConnection().
			 */
			if (activeDatabase == ActiveDatabase.PRIMARY) {
				activeDatabase = ActiveDatabase.FAILOVER;
				return getConnection();
			} else {
				/*
				 * If already in failover, presumably boned at this point, so throw error and 500.
				 */
				throw e;
			}
		}
	}

}
