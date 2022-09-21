package com.turns.asw.model.requestpersonalized;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class TurnCreate {

	private Long id;
	@Temporal(TemporalType.DATE)
	private Date date_start;
	
	@Temporal(TemporalType.DATE)
	private Date date_end;

	public Long getId() {
		return id;
	}

	public Date getDate_start() {
		return date_start;
	}

	public void setDate_start(Date date_start) {
		this.date_start = date_start;
	}

	public Date getDate_end() {
		return date_end;
	}

	public void setDate_end(Date date_end) {
		this.date_end = date_end;
	}

	public void setId(Long id) {
		this.id = id;
	}

}