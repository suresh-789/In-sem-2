package com.example.medicalappointmentsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MedicalAppointmentSystemApplication extends SpringBootServletInitializer {

    // ✅ Override this method to configure the WAR deployment
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MedicalAppointmentSystemApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MedicalAppointmentSystemApplication.class, args);
    }
}
