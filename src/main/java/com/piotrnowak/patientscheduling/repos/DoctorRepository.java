package com.piotrnowak.patientscheduling.repos;

import org.springframework.data.repository.CrudRepository;

import com.piotrnowak.patientscheduling.entities.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {

}
