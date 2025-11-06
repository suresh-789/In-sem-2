package com.example.medicalappointmentsystem.controller;

import com.example.medicalappointmentsystem.model.User;
import com.example.medicalappointmentsystem.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final UserRepository userRepository;

    public DoctorController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // GET /api/doctors → returns list of doctors
    @GetMapping
    public List<User> getAllDoctors() {
        return userRepository.findByRole(User.Role.DOCTOR);  // ✅ Use enum, not string
    }
}
