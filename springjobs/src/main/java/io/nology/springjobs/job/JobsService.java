package io.nology.springjobs.job;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import io.nology.springjobs.temp.Temp;
import io.nology.springjobs.temp.TempsRepository;

@Service
//@Transactional
public class JobsService {

	@Autowired
	private JobsRepository repository;
	
	@Autowired
	private TempsRepository tempRepository;
	
	public Job create(JobsCreateDTO data) {
		String cleanName = data.getName().trim();
		LocalDateTime cleanSDate = data.getStartDate();
		LocalDateTime cleanEDate = data.getEndDate();
		if(data.getTemp() == null) {
			Job newJob = new Job(cleanName,cleanSDate,cleanEDate);	
			this.repository.save(newJob);		
			return newJob;		
		}
		else {
			Long cleanTemp = data.getTemp();
			Optional<Temp> maybeTemp = this.tempRepository.findById(cleanTemp);
			if(maybeTemp.isEmpty()) {
				Job newJob = new Job(cleanName,cleanSDate,cleanEDate);
				this.repository.save(newJob);
				return newJob;
			}
			else {
				Job newJob = new Job(cleanName,cleanSDate,cleanEDate,maybeTemp.get());
				this.repository.save(newJob);		
				return newJob;
			}		
		}
//		this.repository.save(newJob);
//		System.out.println(cleanName);
//		System.out.println(cleanSDate);
//		System.out.println(cleanEDate);
//		return newJob;
	}
	
	public List<Job> all() {
		long id = 0;
		return this.repository.findAll();		
	}	
	
	public Optional<Job> find(long id) {
		return this.repository.findById(id);		
	}

	public Job delete(long id) {
		Optional<Job> maybeJob = this.find(id);
//		this.repository.delete(maybeJob);
		
		if (maybeJob.isEmpty()) {
			return null;
		}
		this.repository.delete(maybeJob.get());
		return maybeJob.get(); 
	}
	
	public Job changeName(long id) {
		Optional<Job> maybeJob = this.find(id);
//		this.repository.delete(maybeJob);
		
		if (maybeJob.isEmpty()) {
			return null;
		}
//		this.repository.delete(maybeJob.get());
		maybeJob.get().setName("test11111111111");;
//		realJob.setName("test2");
		this.repository.save(maybeJob.get());
		return maybeJob.get(); 
	}
	
	public Job changeTemp(long id, long tempId) {
		Optional<Job> maybeJob = this.find(id);
		Optional<Temp> maybeTemp = tempRepository.findById(tempId);
//		this.repository.delete(maybeJob);

		if (maybeJob.isEmpty()) {
			return null;
		}
		if (maybeTemp.isEmpty()) {
			return null;
		}
//		this.repository.delete(maybeJob.get());
		System.out.println(maybeTemp.get().getFirstName());
//		System.out.println(tempRepository.getById(tempId));
		maybeJob.get().setTemp(maybeTemp.get());;
//		realJob.setName("test2");
		this.repository.save(maybeJob.get());
		return maybeJob.get(); 
	}
}
