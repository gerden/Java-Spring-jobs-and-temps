package io.nology.springjobs.job;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import io.nology.springjobs.temp.*;


@Entity
public class Jobs {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column
	String name;

//	@NotBlank
	@Column
	String StartDate;

	@Column
	String EndDate;

//	@Column
//	Temps Temp;


	
	public Jobs() {
	}
	
	public Jobs(String name, String startDate, String endDate) {
		super();
		this.name = name;
		StartDate = startDate;
		EndDate = endDate;
	}
	
//	public Jobs(String name, String startDate, String endDate, Temps temp) {
//		super();
//		this.name = name;
//		StartDate = startDate;
//		EndDate = endDate;
//		Temp = temp;
//	}
	

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


	public String getStartDate() {
		return StartDate;
	}


	public void setStartDate(String startDate) {
		StartDate = startDate;
	}


	public String getEndDate() {
		return EndDate;
	}


	public void setEndDate(String endDate) {
		EndDate = endDate;
	}

	

}
