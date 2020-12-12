package com.ibm.developer.datasourcefailover;

import org.springframework.data.repository.CrudRepository;

public interface PostgresTableRepo extends CrudRepository<PostgresTable, Integer> {

}
