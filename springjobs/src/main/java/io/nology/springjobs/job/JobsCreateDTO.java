package io.nology.springjobs.job;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import io.nology.springjobs.temp.*;

public class JobsCreateDTO {
	@NotBlank
	String name;

//	@NotBlank
	String StartDate;

	String EndDate;

	
	public JobsCreateDTO(@NotBlank String name, @NotBlank String startDate, String endDate) {
		super();
		this.name = name;
		StartDate = startDate;
		EndDate = endDate;
		
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String startDate) {
		StartDate = startDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	
	

}
