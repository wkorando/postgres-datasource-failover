package com.ibm.developer.datasourcefailover;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {
	private NameRepo repo;

	public NameController(NameRepo repo) {
		this.repo = repo;
	}

	@GetMapping
	public Iterable<Name> getName() {
		return repo.findAll();
	}
}
