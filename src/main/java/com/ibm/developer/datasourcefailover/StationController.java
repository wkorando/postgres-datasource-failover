package com.ibm.developer.datasourcefailover;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StationController {
	private StationRepo repo;
	public StationController(StationRepo repo) {
		this.repo = repo;
	}

	@GetMapping
	public Iterable<Station> getName() {
		return repo.findAll();
	}
}
