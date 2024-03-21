package com.main.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.main.entity.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> 
{
   public List<Doctor> findByDocNameIn(List<String> nameList);
}
