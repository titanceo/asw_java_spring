package com.turns.asw.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.turns.asw.model.Commerce;

@Entity
@Table(name="asw_services")
public class Service {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name_service;
	
	@ManyToOne
	@JoinColumn(name="id_commerce")
	private Commerce commerce;
	
	@Temporal(TemporalType.TIME)
	@JsonFormat(pattern = "HH:mm:ss")
	private Date time_open;
	
	@Temporal(TemporalType.TIME)
	@JsonFormat(pattern = "HH:mm:ss")
	private Date time_end;	
	
	private int duration;	
	
	public Service() {}
	
	public Service(Long id, String name_service, Commerce commerce, Date time_open, Date time_end,
			int duration) {
		super();
		this.id = id;
		this.name_service = name_service;
		this.commerce = commerce;
		this.time_open = time_open;
		this.time_end = time_end;
		this.duration = duration;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName_service() {
		return name_service;
	}

	public void setName_service(String name_service) {
		this.name_service = name_service;
	}

	public Date getTime_open() {
		return time_open;
	}

	public void setTime_open(Date time_open) {
		this.time_open = time_open;
	}

	public Date getTime_end() {
		return time_end;
	}

	public void setTime_end(Date time_end) {
		this.time_end = time_end;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Commerce getCommerce() {
		return commerce;
	}

	public void setCommerce(Commerce commerce) {
		this.commerce = commerce;
	}
}
