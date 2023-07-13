package bl.services.department.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bl.services.department.model.Department;
import bl.services.department.repository.DepartmentRepository;

@RestController
public class DepartmentController {

	private static final Logger LOGGER= LoggerFactory.getLogger(DepartmentController.class);
	
	DepartmentRepository DepartmentRepo;
	
	public DepartmentController() {
		this.DepartmentRepo=DepartmentRepo;
	}
	
	@PostMapping("/")
	public Department add(@RequestBody Department Department) {
		LOGGER.info("Department added ");
		return DepartmentRepo.add(Department);
	}
	
	@GetMapping("/{id}")
	public Department findById(@PathVariable Long id) {
		LOGGER.info("Department findbyId "+id);
		return DepartmentRepo.getbyId(id);
	}
	
	@GetMapping("/")
	public List<Department> findAll() {
		LOGGER.info("Department FindAll");
		return DepartmentRepo.findAll();
	}
	@GetMapping("/organization/{organizationId}")
	public List<Department> findByOrganization(@PathVariable("organizationId") Long organizationId) {
		LOGGER.info("Department find: organizationId={}", organizationId);
		return DepartmentRepo.findbyOrganization(organizationId);
	}
}
