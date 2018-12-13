package com.spring.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/demo")
public class EmployeeController {
	@Autowired
	private EmployeeRepository empRepository;

	@PostMapping(path = "/add")
	public @ResponseBody String addEmployee(@RequestBody Employee emp) {
		empRepository.save(emp);
		return "Saved";
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Employee> getAllEmployees() {
		return empRepository.findAll();
	}

	@PutMapping(path = "/update/{id}")
	public @ResponseBody String updateEmployee(@RequestBody Employee emp, @PathVariable("id") Integer id) {
		empRepository.findById(id);
		emp.setId(id);
		empRepository.save(emp);
		return "Updated";

	}

	@DeleteMapping("/delete/{id}")
	public @ResponseBody String deleteStudent(@PathVariable("id") Integer id) {
		empRepository.deleteById(id);
		return "Deleted";
	}
}
