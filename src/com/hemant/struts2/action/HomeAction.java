package com.hemant.struts2.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.util.SubsetIteratorFilter.Decider;

import com.hemant.struts2.model.Employee;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class HomeAction extends ActionSupport implements ModelDriven<Employee> {

	private static final long serialVersionUID = 1L;
	private Employee emp = new Employee();
	
	public String execute() {
		emp.setId(100);
		emp.setRole("Developer");
		
		List<String> cities = new ArrayList<>();
		cities.add("San Jose");
		cities.add("New Delhi");
		cities.add("Bangalore");
		cities.add("Los Angeles");
		emp.setCitiesList(cities);
		
		List<String> countryList = new ArrayList<>();
		countryList.add("Nepal");
		countryList.add("USA");
		countryList.add("Germany");
		countryList.add("Brazil");
		emp.setCountryList(countryList);
		
		Map<String, String> props = new HashMap<>();
		props.put("salary", "15000$");
		props.put("group", "manager");
		props.put("company", "VisionTech");
		props.put("age", "29 years");
		emp.setPropertiesMap(props);
		
		return SUCCESS;
	}
	
	public Decider getCountryDecider() {
		return new Decider() {

			@Override
			public boolean decide(Object element) throws Exception {
				String input = (String) element;
				if (input.equalsIgnoreCase("USA")) {
					return false;
				} else {
					return true;
				}
			}

		};
	}

	@Override
	public Employee getModel() {
		return emp;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}
}
