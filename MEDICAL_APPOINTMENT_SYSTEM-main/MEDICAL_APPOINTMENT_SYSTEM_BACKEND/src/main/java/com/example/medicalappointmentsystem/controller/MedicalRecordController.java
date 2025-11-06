// src/main/java/com/example/medicalappointmentsystem/controller/MedicalRecordController.java
package com.example.medicalappointmentsystem.controller;

import com.example.medicalappointmentsystem.model.MedicalRecord;
import com.example.medicalappointmentsystem.repository.MedicalRecordRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/records")
@CrossOrigin(origins = "http://localhost:5173")
public class MedicalRecordController {

    private final MedicalRecordRepository recordRepository;

    public MedicalRecordController(MedicalRecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    // ✅ Create new record
    @PostMapping
    public MedicalRecord createRecord(@RequestBody MedicalRecord record) {
        return recordRepository.save(record);
    }

    // ✅ Get all records
    @GetMapping
    public List<MedicalRecord> getAllRecords() {
        return recordRepository.findAll();
    }

    // ✅ Get a single record by ID
    @GetMapping("/{id}")
    public MedicalRecord getRecord(@PathVariable Long id) {
        return recordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found with id " + id));
    }

    // ✅ Update a record
    @PutMapping("/{id}")
    public MedicalRecord updateRecord(@PathVariable Long id, @RequestBody MedicalRecord updatedRecord) {
        return recordRepository.findById(id)
                .map(record -> {
                    record.setPatientName(updatedRecord.getPatientName());
                    record.setPhoneNumber(updatedRecord.getPhoneNumber());
                    record.setDisease(updatedRecord.getDisease());
                    record.setTreatment(updatedRecord.getTreatment());
                    record.setRemarks(updatedRecord.getRemarks());
                    return recordRepository.save(record);
                })
                .orElseThrow(() -> new RuntimeException("Record not found with id " + id));
    }

    // ✅ Delete a record
    @DeleteMapping("/{id}")
    public String deleteRecord(@PathVariable Long id) {
        if (!recordRepository.existsById(id)) {
            throw new RuntimeException("Record not found with id " + id);
        }
        recordRepository.deleteById(id);
        return "Record with id " + id + " deleted successfully!";
    }
}
