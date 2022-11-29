package com.master.api.repo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.master.api.entity.Employee;

import jakarta.websocket.server.PathParam;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	@Query(value="select first_name,last_name,address from employee_details  where Id= :id",nativeQuery = true)
	Employee getEmployeeDetails(@Param("id") Long id);
			

	//Optional<Employee> findOne(BigDecimal adhar);

	//void findAll(LocalDate date);


}
