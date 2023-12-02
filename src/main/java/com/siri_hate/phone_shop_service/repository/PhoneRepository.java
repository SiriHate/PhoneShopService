package com.siri_hate.phone_shop_service.repository;

import com.siri_hate.phone_shop_service.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for accessing and managing Phone entities in the database.
 * Extends JpaRepository, providing CRUD (Create, Read, Update, Delete) operations for the Phone entity.
 */
@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> { }
