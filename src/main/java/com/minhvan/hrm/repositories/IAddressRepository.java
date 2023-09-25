package com.minhvan.hrm.repositories;

import com.minhvan.hrm.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Long> {
}
