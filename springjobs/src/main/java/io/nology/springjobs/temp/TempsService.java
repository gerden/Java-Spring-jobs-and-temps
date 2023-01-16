package io.nology.springjobs.temp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.nology.springjobs.job.Job;

@Service
public class TempsService {
	
	

	@Autowired
	private TempsRepository repository;
	
	public Temp create(TempsCreateDTO data) {
		String firstName = data.getFirstName();
		String lastName = data.getLastName();
		Set<Job> jobs = data.getJobs();
		Temp newTemp = new Temp(firstName,lastName, jobs);
		this.repository.save(newTemp);
		return newTemp;
	}
	
	public List<Temp> all() {
		return this.repository.findAll();		
	}	
	
	public Optional<Temp> find(long id) {
		return this.repository.findById(id);		
	}
	
	public Temp delete(long id) {
		Optional<Temp> maybeTemp = this.find(id);
//		this.repository.delete(maybeJob);
		
		if (maybeTemp.isEmpty()) {
			return null;
		}
		this.repository.delete(maybeTemp.get());
		return maybeTemp.get(); 
	}
	
}
