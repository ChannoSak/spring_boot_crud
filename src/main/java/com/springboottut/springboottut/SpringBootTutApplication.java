package com.springboottut.springboottut;

import com.springboottut.springboottut.model.Employee;
import com.springboottut.springboottut.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTutApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTutApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public void run(String... args) throws Exception {
//		Employee employee = new Employee();
//		employee.setFirstName("Keo");
//		employee.setLastName("Dare");
//		employee.setEmail("keodara@gmail.com");
//		employeeRepository.save(employee);
//
//		Employee employee1 = new Employee();
//		employee1.setFirstName("Chandra");
//		employee1.setLastName("Ty");
//		employee1.setEmail("chandraty@gmail.com");
//		employeeRepository.save(employee1);
	}
}
