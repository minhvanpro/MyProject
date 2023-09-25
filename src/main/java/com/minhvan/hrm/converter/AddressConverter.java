package com.minhvan.hrm.converter;

import com.minhvan.hrm.dtos.AddressDto;
import com.minhvan.hrm.entities.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressConverter {
    public Address toEntity(AddressDto dto) {
        Address entity = new Address();
        entity.setId(dto.getId());
        entity.setCommune(dto.getCommune());
        entity.setDistrict(dto.getDistrict());
        entity.setCity(dto.getCity());
        return entity;
    }

    public AddressDto toDto(Address entity) {
        AddressDto dto = new AddressDto();
        dto.setId(entity.getId());
        dto.setCommune(entity.getCommune());
        dto.setDistrict(entity.getDistrict());
        dto.setCity(entity.getCity());
        return dto;
    }
}
