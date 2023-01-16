package io.nology.springjobs.job;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.nology.springjobs.temp.TempsCreateDTO;


@RestController
@RequestMapping("/jobs")
public class JobsController {
	
	@Autowired
	private JobsService service;

	@GetMapping
	public ResponseEntity<List<Job>> all(){
		List<Job> allJobs = this.service.all();
		

//		System.out.println(allJobs.get(0).name);
//		System.out.println(allJobs.get(0).temp.getFirstName());
		
		return new ResponseEntity<>(allJobs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Job> find(@PathVariable Long id){
		Optional<Job> maybeJob = this.service.find(id);
		
		if(maybeJob.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(maybeJob.get(), HttpStatus.OK);
	}

//	@GetMapping(value = "/assigned/{id}/{assigned}")
//	public ResponseEntity<List<Job>> assignedFilter(@PathVariable Long id, @PathVariable Boolean assigned){
//		List<Job> allJobs = this.service.all();
//		
//		for(int i = 0; i < allJobs.size(); i++) {
//			if(allJobs.get(i)) {
//				
//			}
//			
//		}
//		
//		return new ResponseEntity<>(allJobs, HttpStatus.OK);
//	}
	
	@GetMapping(value = "/assigned/{id}/{assigned}")
	public ResponseEntity<Job> assigned(@PathVariable Long id, @PathVariable Boolean assigned){
		Optional<Job> maybeJob = this.service.find(id);
		
		if(maybeJob.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(maybeJob.get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Job> create(@Valid @RequestBody JobsCreateDTO data){
		Job JobsCreated = this.service.create(data);
		return new ResponseEntity<>(JobsCreated, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable long id){
		Job deletedJob = this.service.delete(id);
		if(deletedJob == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(deletedJob, HttpStatus.OK);
		
	}
	
	@PatchMapping("/name/{id}")
	public ResponseEntity<?> changeName(@PathVariable long id){
		Job changedJob = this.service.changeName(id);
		if(changedJob == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(changedJob, HttpStatus.OK);
		
	}
	
	
	@PatchMapping("/temp/{id}/{temp}")
	public ResponseEntity<?> changeTemp(@PathVariable long id, @PathVariable long temp){
		Job changedJob = this.service.changeTemp(id, temp);
		if(changedJob == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(changedJob, HttpStatus.OK);
		
	}
	
	
	

}
