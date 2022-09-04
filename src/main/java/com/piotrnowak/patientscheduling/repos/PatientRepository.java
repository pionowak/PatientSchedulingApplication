package com.piotrnowak.patientscheduling.repos;

import org.springframework.data.repository.CrudRepository;

import com.piotrnowak.patientscheduling.entities.Patient;

public interface PatientRepository extends CrudRepository<Patient, Long> {

}
