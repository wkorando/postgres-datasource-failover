package com.ibm.developer.datasourcefailover;

public class ActiveDatabaseHolder {
	private static ActiveDatabase activeDatabase;

	public static void set(ActiveDatabase activeDatabase) {
		ActiveDatabaseHolder.activeDatabase = activeDatabase;
	}

	public boolean inFailover() {
		return activeDatabase == ActiveDatabase.FAILOVER;
	}

	public ActiveDatabase getActiveDatabase() {
		return activeDatabase;
	}
}