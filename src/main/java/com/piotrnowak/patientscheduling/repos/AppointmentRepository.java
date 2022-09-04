package com.piotrnowak.patientscheduling.repos;

import org.springframework.data.repository.CrudRepository;

import com.piotrnowak.patientscheduling.entities.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

}
