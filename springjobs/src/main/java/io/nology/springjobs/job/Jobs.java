package io.nology.springjobs.job;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	LocalDateTime StartDate;

	@Column
	LocalDateTime EndDate;

//	@Column
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn( name = "temp_id", referencedColumnName = "id")
	Temps Temp;


//	referencedColumnName = “id"

	public Jobs() {
	}
	
	public Jobs(String name, LocalDateTime startDate, LocalDateTime endDate) {
		super();
		this.name = name;
		StartDate = startDate;
		EndDate = endDate;
	}
	
	public Jobs(String name, LocalDateTime startDate, LocalDateTime endDate, Temps temp) {
		super();
		this.name = name;
		StartDate = startDate;
		EndDate = endDate;

		System.out.println("test1");
		
		List<Jobs> jobs = temp.getJobs();
		
		System.out.println(jobs.get(19).getId());

		System.out.println(StartDate.isBefore(jobs.get(0).getEndDate()));

		System.out.println(jobs.size());
		System.out.println("");
		System.out.println(StartDate);
		System.out.println(EndDate);
		System.out.println("");
		System.out.println(jobs.get(19).getStartDate());
		System.out.println(jobs.get(19).getEndDate());
		System.out.println("");
		
		Boolean validTemp = true;
		
		for(int i = 0; i < jobs.size(); i++) {
			
			if(!(!(StartDate.isBefore(jobs.get(i).getEndDate())) || !(EndDate.isAfter(jobs.get(i).getStartDate())))) {
				System.out.println("not valid");
				validTemp = false;
				i = jobs.size();
				
			}
		}

		if (validTemp) {
			Temp = temp;
			System.out.println("valid");
			
		}
//		"endDate": "2015-03-29T19:30:40",
//        "startDate": "2015-03-29T19:30:40"
		
		System.out.println("test2");
		
		
		
//		Temp = temp;
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


	public LocalDateTime getStartDate() {
		return StartDate;
	}


	public void setStartDate(LocalDateTime startDate) {
		StartDate = startDate;
	}


	public LocalDateTime getEndDate() {
		return EndDate;
	}


	public void setEndDate(LocalDateTime endDate) {
		EndDate = endDate;
	}

	

}
