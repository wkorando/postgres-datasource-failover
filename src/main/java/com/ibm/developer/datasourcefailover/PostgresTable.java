package com.ibm.developer.datasourcefailover;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pg_tables")
public class PostgresTable {

	@Id
	private String tablename;
	private String schemaname;
	private String tableowner;

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public String getSchemaname() {
		return schemaname;
	}

	public void setSchemaname(String schemaname) {
		this.schemaname = schemaname;
	}

	public String getTableowner() {
		return tableowner;
	}

	public void setTableowner(String tableowner) {
		this.tableowner = tableowner;
	}

}
