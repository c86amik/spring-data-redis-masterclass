/**
 * 
 */
package com.springcavaj.redis.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.springcavaj.redis.model.Employee;
import com.springcavaj.redis.repository.SpringDataRedisMongoRepository;

/**
 * @author springcavaj
 * 
 */
@Service
public class SpringDataRedisMongoService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringDataRedisMongoService.class);
	
	@Autowired
	private SpringDataRedisMongoRepository springDataRedisMongoRepository;
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	private static final String EMPLOYEE_KEY_PREFIX = "EMP_";
	
	public Employee saveEmployee(Employee employee) {
		Employee savedEmployee = springDataRedisMongoRepository.save(employee);
        redisTemplate.opsForValue().set(EMPLOYEE_KEY_PREFIX + savedEmployee.getEmployeeId(), savedEmployee);
        LOGGER.info("saveEmployee -> Saved the Employee : {}", savedEmployee);
        return savedEmployee;
    }
	
	public Employee getEmployee(String employeeId) {
		Employee employee = (Employee) redisTemplate.opsForValue().get(EMPLOYEE_KEY_PREFIX + employeeId);
		LOGGER.info("getEmployee -> Employee data from Redis : {}", employee);
        if (null == employee) {
        	employee = springDataRedisMongoRepository.findById(employeeId).orElse(null);
            if (null != employee) {
                redisTemplate.opsForValue().set(EMPLOYEE_KEY_PREFIX + employee.getEmployeeId(), employee);
            }
            LOGGER.info("getEmployee -> Employee data from Database : {}", employee);
        }
        return employee;
    }
	
	public List<Employee> getAllEmployees() {
		LOGGER.info("getAllEmployees -> Returned all employees");
        return springDataRedisMongoRepository.findAll();
    }
	
	public Employee updateEmployee(String employeeId, Employee employee) {
		Employee existingEmployee = getEmployee(employeeId);
		LOGGER.info("updateEmployee -> Fetch Employee from Redis : {}", existingEmployee);
        if (null != existingEmployee) {
        	existingEmployee.setEmployeeId(employee.getEmployeeId());
        	existingEmployee.setPanCard(employee.getPanCard());
        	existingEmployee.setEmpName(employee.getEmpName());
        	springDataRedisMongoRepository.save(existingEmployee);
            redisTemplate.opsForValue().set(EMPLOYEE_KEY_PREFIX + existingEmployee.getEmployeeId(), existingEmployee);
            LOGGER.info("updateEmployee -> Update Employee in Redis and in DB : {}", existingEmployee);
            return existingEmployee;
        }
        return null;
    }
	
	public void deleteEmployee(String employeeId) {
		Employee existingEmployee = getEmployee(employeeId);
		LOGGER.info("deleteEmployee -> Fetch Employee from Redis : {}", existingEmployee);
		if(null != existingEmployee) {
			springDataRedisMongoRepository.deleteById(employeeId);
	        redisTemplate.delete(EMPLOYEE_KEY_PREFIX + employeeId);
	        LOGGER.info("deleteEmployee -> Delete Employee from both Redis & DB : {}", existingEmployee);
		}
    }
	

}
