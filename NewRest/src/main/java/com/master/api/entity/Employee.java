package com.master.api.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Employee_details")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private Long id;
	
	@Column(name="First_Name")
	private String firstName;
	
	@Column(name="Last_Name")
	private String lastName;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="Gender")
	private String gender;
	
	@Column(name="mobileNo")
	private BigDecimal mobileNo;
	
	@Column(name="Email")
	private String emailId;
	
//	@Column(name="Created_Date")
//	private LocalDate createdDate;
//	
//	@Column(name="Created_Time")
//	private LocalTime createdtime;
//	
//	@Column(name="Updated_Date_Time")
//	private LocalDateTime updatedDateAndTime;
	
	@Column(name="Adhar_Number")
	private BigDecimal adharNumber;
	
	@Column(name="Pan_Number")
	private String panCard;
	
}
