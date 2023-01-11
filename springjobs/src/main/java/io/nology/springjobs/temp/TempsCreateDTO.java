package io.nology.springjobs.temp;

import java.util.ArrayList;

import io.nology.springjobs.job.Jobs;

public class TempsCreateDTO {
	
	String firstName;
	String lastName;
	ArrayList<Jobs> jobs = new ArrayList<Jobs>();
	
	public TempsCreateDTO(String firstName, String lastName, ArrayList<Jobs> jobs){
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.jobs = jobs;
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

	public ArrayList<Jobs> getJobs() {
		return jobs;
	}

	public void setJobs(ArrayList<Jobs> jobs) {
		this.jobs = jobs;
	}

	
	
	
}
