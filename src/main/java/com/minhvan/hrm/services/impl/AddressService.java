package com.minhvan.hrm.services.impl;

import com.minhvan.hrm.converter.AddressConverter;
import com.minhvan.hrm.dtos.AddressDto;
import com.minhvan.hrm.entities.Address;
import com.minhvan.hrm.repositories.IAddressRepository;
import com.minhvan.hrm.services.IAddressService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AddressService implements IAddressService {
    @Autowired
    private IAddressRepository iAddressRepository;

    @Autowired
    private AddressConverter addressConverter;

    @Override
    public AddressDto create(Address entity) {
        entity = iAddressRepository.save(entity);
        AddressDto result = addressConverter.toDto(entity);
        return result;
    }
}
