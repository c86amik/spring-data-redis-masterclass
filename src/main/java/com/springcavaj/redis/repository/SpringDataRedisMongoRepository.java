/**
 * 
 */
package com.springcavaj.redis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springcavaj.redis.model.Employee;

/**
 * 
 * @author springcavaj
 * 
 */
@Repository
public interface SpringDataRedisMongoRepository extends MongoRepository<Employee, String> {

}
