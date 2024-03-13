package com.java.controller;

import com.java.entity.Company;
import com.java.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllCompanies() {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.getAllCompanies());
    }

    @PostMapping
    public ResponseEntity<Object> addCompany(@RequestBody Company company) {
        return ResponseEntity.status(HttpStatus.CREATED).body(companyService.addCompany(company));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        Company updatedCompany = companyService.updateCompany(id, company);
        if (updatedCompany != null) {
            return ResponseEntity.status(HttpStatus.OK).body(company);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No company found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCompany(@PathVariable Long id) {
        boolean deleted = companyService.deleteCompany(id);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.OK).body("Company id: " + id + " deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No company found");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCompany(@PathVariable Long id) {
        Company company = companyService.getCompany(id);
        if (company != null) {
            return ResponseEntity.status(HttpStatus.OK).body(company);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No company found");
    }

}
