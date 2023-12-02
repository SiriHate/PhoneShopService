package com.siri_hate.phone_shop_service.dto;

import com.siri_hate.phone_shop_service.entity.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper interface responsible for converting instances of {@link PhoneRequest} to {@link Phone} entities.
 * Utilizes MapStruct, a code generation tool, to automatically generate the mapping implementation during compilation.
 */
@Mapper
public interface PhoneRequestMapper {

    /**
     * Singleton instance of the PhoneRequestMapper interface, obtained using MapStructs Mappers factory.
     */
    PhoneRequestMapper INSTANCE = Mappers.getMapper(PhoneRequestMapper.class);

    /**
     * Converts a {@link PhoneRequest} object to a corresponding {@link Phone} entity.
     *
     * @param phoneRequest The PhoneRequest object to be converted.
     * @return A Phone entity representing the converted data.
     */
    Phone toPhoneEntity(PhoneRequest phoneRequest);

}
