package com.example.medicalappointmentsystem.dto;

public class PatientDTO {
    private Long id;
    private String username;
    private String email;
    private String phoneNumber;

    public PatientDTO(Long id, String username, String email, String phoneNumber) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
