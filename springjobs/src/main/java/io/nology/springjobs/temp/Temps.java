package io.nology.springjobs.temp;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.nology.springjobs.job.Jobs;

@Entity
public class Temps {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column
	String firstName;

//	@NotBlank
	@Column
	String lastName;

	@Column
	ArrayList<Jobs> jobs = new ArrayList<Jobs>();
	
	public Temps() {
	}
	
	public Temps(String firstName, String lastName, ArrayList<Jobs> jobs) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.jobs = jobs;
	}

	
	
	public ArrayList<Jobs> getJobs() {
		return jobs;
	}

	public void setJobs(ArrayList<Jobs> jobs) {
		this.jobs = jobs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
