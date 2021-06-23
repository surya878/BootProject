package com.nt.surya.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "emptab")
public class Employee {

	@Id
	@Column(name = "eid")
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
	private Integer empId;
	
	@Column(name = "ename")
	private String empName;
	
	@Column(name = "esal")
	private Double empSal;
	
	@Column(name = "edept")
	private String empDept;
	
	@Column(name = "ehra")
	private Double empHra;
	
	@Column(name = "eta")
	private Double empTa;
	
}
