/**
 * 
 */
package com.springcavaj.redis.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springcavaj.redis.model.Employee;
import com.springcavaj.redis.service.SpringDataRedisMongoService;

/**
 * 
 * @author springcavaj
 * 
 */
@RestController
public class SpringDataRedisMongoController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringDataRedisMongoController.class);
	
	@Autowired
	private SpringDataRedisMongoService springDataRedisMongoService;
	
	@GetMapping("/allEmployees")
    public List<Employee> getAllEmployeeData() {
		LOGGER.info("getAllEmployeeData -> All Data are fetched");
		return springDataRedisMongoService.getAllEmployees();
    }
	
	@PostMapping("/saveEmployee")
    public Employee saveEmployeeData(@RequestBody Employee employee) {
        LOGGER.info("saveEmployeeData -> New Record of Employee saved");
        return springDataRedisMongoService.saveEmployee(employee);
    }
	
	@PutMapping("/updateEmployee/{empId}")
    public Employee updateEmployeeData(@PathVariable(value = "empId") String employeeId, @RequestBody Employee employee) {
        LOGGER.info("updateEmployeeData -> Update the existing Employee Record");
        return springDataRedisMongoService.updateEmployee(employeeId, employee);
    }
	
	@GetMapping("/getEmployee/{empId}")
    public Employee getEmployeeDataById(@PathVariable(value = "empId") String employeeId) {
    	LOGGER.info("getEmployeeDataById -> Fetch the Employee Detail by EmployeeId as : {}", employeeId);
        return springDataRedisMongoService.getEmployee(employeeId);
    }
	
	@DeleteMapping("/deleteEmployee/{empId}")
    public void deleteEmployee(@PathVariable(value = "empId") String employeeId) {
    	LOGGER.info("deleteEmployee -> Delete the Employee of employeeId : {}", employeeId);
    	springDataRedisMongoService.deleteEmployee(employeeId);
    }

}
