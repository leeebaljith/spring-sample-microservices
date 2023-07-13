package bl.services.department.repository;

import java.util.ArrayList;
import java.util.List;

import bl.services.department.model.Department;

public class DepartmentRepository {

	private List<Department> department=new ArrayList<Department>();
	
	public Department add(Department dep) {
		dep.setId((long)department.size()+1);
		department.add(dep);
		return dep;
	}
	public Department getbyId(Long id) {
	return	department.stream().filter(i-> i.getId().equals(id)).findFirst().orElseThrow();
	}
	public List<Department> findAll(){
		return department;
	}
	public List<Department> findbyOrganization(Long OrganizationId){
	  return	department.stream().filter(i-> i.getOrganizationId().equals(OrganizationId)).toList();
	}
}
