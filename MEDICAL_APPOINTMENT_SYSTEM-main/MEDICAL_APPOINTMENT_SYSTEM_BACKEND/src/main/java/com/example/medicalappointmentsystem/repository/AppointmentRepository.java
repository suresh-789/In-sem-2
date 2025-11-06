package com.example.medicalappointmentsystem.repository;

import com.example.medicalappointmentsystem.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    // later you can add custom queries like:
    // List<Appointment> findByPatientId(Long patientId);
}
