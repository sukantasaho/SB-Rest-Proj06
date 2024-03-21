package com.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.Doctor;
import com.main.repository.DoctorRepository;

@Service("docService")
public class DoctorServiceImp implements IDoctorService 
{
    @Autowired
	private DoctorRepository repo;
	
	@Override
	public String createDoctorRecord(Doctor doctor) 
	{
		 
		return "Doctor Record Is Created With ID-"+repo.save(doctor).getDocId();
	}

	@Override
	public List<Doctor> getAllDoctors() 
	{
		 
		return (List<Doctor>) repo.findAll();
	}

	@Override
	public List<Doctor> getAllDoctorsByIds(Integer i1, Integer i2, Integer i3) 
	{
		            List<Integer> ids = List.of(i1,i2,i3);
		return (List<Doctor>) repo.findAllById(ids);
	}

	@Override
	public List<Doctor> getDoctorsByName(String name1, String name2) 
	{
		 
		return repo.findByDocNameIn(List.of(name1,name2));
	}

}
