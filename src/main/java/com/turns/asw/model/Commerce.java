package com.turns.asw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="asw_commerce")
public class Commerce {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private int capacity_max;
	
	public Commerce() {}
	
	public Commerce(Long id, String name, int capacity_max) {
		super();
		this.id = id;
		this.name = name;
		this.capacity_max = capacity_max;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCapacity_max() {
		return capacity_max;
	}
	public void setCapacity_max(int capacity_max) {
		this.capacity_max = capacity_max;
	}
}
