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

import com.turns.asw.model.Service;

@Entity
@Table(name="asw_turns")
public class Turn {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_service")
	private Service service;
	
	@Temporal(TemporalType.DATE)
	private Date date_turn;
	
	@Temporal(TemporalType.TIME)
	private Date time_start;
	
	@Temporal(TemporalType.TIME)
	private Date time_end;
	
	private String state;
	
	public Turn() {}
	
	public Turn(Long id, Service service, Date date_turn, Date time_start, Date time_end, String state) {
		super();
		this.id = id;
		this.service = service;
		this.date_turn = date_turn;
		this.time_start = time_start;
		this.time_end = time_end;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Date getDate_turn() {
		return date_turn;
	}

	public void setDate_turn(Date date_turn) {
		this.date_turn = date_turn;
	}

	public Date getTime_start() {
		return time_start;
	}

	public void setTime_start(Date time_start) {
		this.time_start = time_start;
	}

	public Date getTime_end() {
		return time_end;
	}

	public void setTime_end(Date time_end) {
		this.time_end = time_end;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	

}
