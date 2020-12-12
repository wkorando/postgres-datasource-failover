package com.ibm.developer.datasourcefailover;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostgresTableController {
	private PostgresTableRepo repo;
	public PostgresTableController(PostgresTableRepo repo) {
		this.repo = repo;
	}

	@GetMapping
	public Iterable<PostgresTable> getName() {
		return repo.findAll();
	}
}
