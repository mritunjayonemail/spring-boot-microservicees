package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	
	@GetMapping(path="/filtering")
	public SomeBean retrieveSomeBean() {
		SomeBean somebean = new SomeBean("value1", "value2", "value3");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2");
		SimpleFilterProvider filters = new SimpleFilterProvider().addFilter("SomeBean", filter);
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(somebean);
		mappingJacksonValue.setFilters(filters);
		return somebean;
	}
	
	@GetMapping(path="/filtering-list")
	public List<SomeBean> retrieveListOfSomeBean() {
		return  Arrays.asList(new SomeBean("value11", "value21", "value31"), new SomeBean("value12", "value22", "value32"));
	}

}
