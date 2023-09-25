package com.minhvan.hrm.services;

import com.minhvan.hrm.dtos.AddressDto;
import com.minhvan.hrm.entities.Address;

public interface IAddressService {
    AddressDto create(Address entity);
}
