package io.nology.springjobs.temp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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

	@OneToMany(mappedBy = "Temp")	
	List<Jobs> jobs;
//	List<Jobs> jobs = new List<Jobs>();
	
//	@OneToMany
	
	
	
	public Temps() {
	}
	
	public Temps(String firstName, String lastName, List<Jobs> jobs) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.jobs = jobs;
	}

	
	
	public List<Jobs> getJobs() {
		return jobs;
	}

	public void setJobs(List<Jobs> jobs) {
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
