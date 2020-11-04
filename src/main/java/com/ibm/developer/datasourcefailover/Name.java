package com.ibm.developer.datasourcefailover;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="names")
public class Name {
	@Id
	private int id;
	private String name;

	public Name() {
	}

	public Name(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Name [id=" + id + ", name=" + name + "]";
	}

}
