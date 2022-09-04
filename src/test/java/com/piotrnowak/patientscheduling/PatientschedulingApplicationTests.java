package com.piotrnowak.patientscheduling;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.piotrnowak.patientscheduling.entities.Appointment;
import com.piotrnowak.patientscheduling.entities.Doctor;
import com.piotrnowak.patientscheduling.entities.Insurance;
import com.piotrnowak.patientscheduling.entities.Patient;
import com.piotrnowak.patientscheduling.repos.AppointmentRepository;
import com.piotrnowak.patientscheduling.repos.DoctorRepository;
import com.piotrnowak.patientscheduling.repos.PatientRepository;

@SpringBootTest
class PatientschedulingApplicationTests {

	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	AppointmentRepository appointmentRepository;

	@Test
	public void testCreateDoctor() {

		Doctor doctor = new Doctor();
		doctor.setFirstName("Anthon");
		doctor.setLastName("Smith");
		doctor.setSpeciality("Cardiologist");
		doctorRepository.save(doctor);

		assertThat(doctor.getId()).isNotNull();

		System.out.println(doctor);
	}

	@Test
	public void testCreateDoctorAnthon() {

		Doctor doctor = new Doctor();

		doctor.setFirstName("Anthon");
		doctor.setLastName("Smith");
		doctor.setSpeciality("Cardiologist");

		assertEquals(doctor.getFirstName(), "Anthon");
		assertEquals(doctor.getLastName(), "Smith");
		assertEquals(doctor.getSpeciality(), "Cardiologist");
	}

	@Test
	public void testRemoveDoctorWithNoAppoitments() {
		
		doctorRepository.deleteById(1l);
		assertThat(doctorRepository.findById(1l)).isEmpty();
	}

	@Test
	public void testCreatePatient() {

		Patient patient = new Patient();
		patient.setFirstName("John");
		patient.setLastName("Stinsen");
		patient.setPhone("334-456-523");

		Insurance insurance = new Insurance();
		insurance.setProviderName("Aviva");
		insurance.setCopay(10d);

		patient.setInsurance(insurance);

		Doctor doctor = doctorRepository.findById(1L).get();
		List<Doctor> doctors = Arrays.asList(doctor);
		patient.setDoctors(doctors);

		patientRepository.save(patient);

		assertThat(patient.getId()).isNotNull();

		System.out.println(patient);

	}

	@Test
	public void testCreateAppointment() {

		Appointment appointment = new Appointment();
		Timestamp appointmentTime = new Timestamp(new Date().getTime());
		appointment.setAppointmentTime(appointmentTime);
		appointment.setReason("I have a headache");
		appointment.setStarted(true);

		appointment.setPatient(patientRepository.findById(1l).get());
		appointment.setDoctor(doctorRepository.findById(1L).get());

		appointmentRepository.save(appointment);

		assertThat(appointment.getId()).isNotNull();

		System.out.println(appointment);

	}

}
