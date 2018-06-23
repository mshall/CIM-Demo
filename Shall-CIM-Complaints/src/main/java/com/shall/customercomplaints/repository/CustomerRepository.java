package com.shall.customercomplaints.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shall.customercomplaints.model.Complaint;

@Repository
public interface CustomerRepository extends JpaRepository<Complaint, Long> {
}
