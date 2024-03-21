package com.main.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.main.entity.Doctor;

public interface IDoctorService 
{
    public String createDoctorRecord(Doctor doctor);
    public List<Doctor> getAllDoctors();
    public List<Doctor> getAllDoctorsByIds(Integer i1, Integer i2, Integer i3);
    public List<Doctor> getDoctorsByName(String name1, String name2);
}
