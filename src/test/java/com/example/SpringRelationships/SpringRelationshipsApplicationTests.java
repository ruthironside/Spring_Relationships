package com.example.SpringRelationships;

import com.example.SpringRelationships.models.Department;
import com.example.SpringRelationships.models.Employee;
import com.example.SpringRelationships.models.Project;
import com.example.SpringRelationships.repositories.DepartmentRepository;
import com.example.SpringRelationships.repositories.EmployeeRepository;
import com.example.SpringRelationships.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRelationshipsApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createProject(){
		Department department = new Department("The Department of Awesome");
		departmentRepository.save(department);

		Employee employee = new Employee("Ruth", "Ironside", 1, department);
		employeeRepository.save(employee);
		
		Employee employee2 = new Employee("Michael", "Anderson", 2, department);
		employeeRepository.save(employee2);

		Project project = new Project("Spring", 1);

		project.addEmployee(employee);
		project.addEmployee(employee2);
		projectRepository.save(project);
	}



//	public void createRaid(){
//		Ship ship1 = new Ship("Ship For Brains");
//		shipRepository.save(ship1);
//
//		Pirate pirate2 = new Pirate("Angry", "Andy", 38, ship1);
//		pirateRepository.save(pirate2);
//
//		Raid raid = new Raid("Smoo Cave", 200);
//		raid.addPirate(pirate2);
//
//		raidRepository.save(raid);
//	}


}
