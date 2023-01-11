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


@RestController
@RequestMapping("/jobs")
public class JobsController {
	
	@Autowired
	private JobsService service;

	@GetMapping
	public ResponseEntity<List<Jobs>> all(){
		List<Jobs> allJobs = this.service.all();
		return new ResponseEntity<>(allJobs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Jobs> find(@PathVariable Long id){
		Optional<Jobs> maybeJob = this.service.find(id);
		
		if(maybeJob.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(maybeJob.get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Jobs> create(@Valid @RequestBody JobsCreateDTO data){
		Jobs JobsCreated = this.service.create(data);
		return new ResponseEntity<>(JobsCreated, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable long id){
		Jobs deletedJob = this.service.delete(id);
		if(deletedJob == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(deletedJob, HttpStatus.OK);
		
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<?> changeName(@PathVariable long id){
		Jobs changedJob = this.service.changeName(id);
		if(changedJob == null) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(changedJob, HttpStatus.OK);
		
	}
	
	
	

}
