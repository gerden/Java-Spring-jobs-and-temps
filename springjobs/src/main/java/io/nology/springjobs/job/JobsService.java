package io.nology.springjobs.job;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import io.nology.springjobs.temp.Temps;

@Service
//@Transactional
public class JobsService {

	@Autowired
	private JobsRepository repository;
	
	public Jobs create(JobsCreateDTO data) {
		String cleanName = data.getName().trim();
		String cleanSDate = data.getStartDate();
		String cleanEDate = data.getEndDate();
		Jobs newJob = new Jobs(cleanName,cleanSDate,cleanEDate);
		this.repository.save(newJob);
		System.out.println(cleanName);
		System.out.println(cleanSDate);
		System.out.println(cleanEDate);
		return newJob;
	}
	
	public List<Jobs> all() {
		return this.repository.findAll();		
	}	
	
	public Optional<Jobs> find(long id) {
		return this.repository.findById(id);		
	}

	public Jobs delete(long id) {
		Optional<Jobs> maybeJob = this.find(id);
//		this.repository.delete(maybeJob);
		
		if (maybeJob.isEmpty()) {
			return null;
		}
		this.repository.delete(maybeJob.get());
		return maybeJob.get(); 
	}
	
	public Jobs changeName(long id) {
		Optional<Jobs> maybeJob = this.find(id);
//		this.repository.delete(maybeJob);
		
		if (maybeJob.isEmpty()) {
			return null;
		}
//		this.repository.delete(maybeJob.get());
		maybeJob.get().setName("test555555555555");;
//		realJob.setName("test2");
		this.repository.save(maybeJob.get());
		return maybeJob.get(); 
	}
}
