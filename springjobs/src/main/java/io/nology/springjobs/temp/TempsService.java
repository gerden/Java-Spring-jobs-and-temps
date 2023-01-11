package io.nology.springjobs.temp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.nology.springjobs.job.Jobs;

@Service
public class TempsService {
	
	

	@Autowired
	private TempsRepository repository;
	
	public Temps create(TempsCreateDTO data) {
		String firstName = data.getFirstName().trim();
		String lastName = data.getLastName().trim();
		ArrayList<Jobs> jobs = data.getJobs();
		Temps newTemp = new Temps(firstName,lastName, jobs);
		this.repository.save(newTemp);
		return newTemp;
	}
	
	public List<Temps> all() {
		return this.repository.findAll();		
	}	
	
	public Optional<Temps> find(long id) {
		return this.repository.findById(id);		
	}
	
	public Temps delete(long id) {
		Optional<Temps> maybeTemp = this.find(id);
//		this.repository.delete(maybeJob);
		
		if (maybeTemp.isEmpty()) {
			return null;
		}
		this.repository.delete(maybeTemp.get());
		return maybeTemp.get(); 
	}
	
}
