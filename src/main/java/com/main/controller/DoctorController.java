package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.entity.Doctor;
import com.main.services.IDoctorService;

@RestController
@RequestMapping("/api")
public class DoctorController 
{
	@Autowired
	private IDoctorService service;
	
	 @PostMapping("/register")
     public ResponseEntity<String> registerDoctor(@RequestBody Doctor doctor)
     {
    	   
		 String msg = service.createDoctorRecord(doctor);
		 
		 return new ResponseEntity<String>(msg,HttpStatus.CREATED);
     }
	 @GetMapping("/getAllDoctors")
	 public ResponseEntity<List<Doctor>> displayAllDoctors() 
	 {
		 List<Doctor> list = service.getAllDoctors();
		 
		return new ResponseEntity<List<Doctor>>(list,HttpStatus.OK);
	 }
	 
	 @GetMapping("/getDoctorsByIds")
	 public ResponseEntity<List<Doctor>> getAllDoctorsByIds(@RequestParam Integer i1, @RequestParam Integer i2, @RequestParam Integer i3)
	 {
		 List<Doctor> list = service.getAllDoctorsByIds(i1,i2,i3);
		 
		 return new ResponseEntity<List<Doctor>>(list,HttpStatus.OK);
	 }
	 
	 @GetMapping("/getDoctorsByName/{name1}/{name2}")
	 public ResponseEntity<List<Doctor>> displayDoctorsByName(@PathVariable("name1") String name1, @PathVariable("name2") String name2)
	 {
		 List<Doctor>  list = service.getDoctorsByName(name1, name2);
		 
		 return new ResponseEntity<List<Doctor>>(list,HttpStatus.OK);
	 }
}
