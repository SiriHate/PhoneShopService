package com.siri_hate.phone_shop_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

/**
 * The {@code PhoneRequest} class represents a data transfer object (DTO) for creating or updating phone information.
 * It includes attributes such as manufacturer, model, storage size, color, cost, and quantity.
 * This class is used to transfer data between the client and the server in a structured format.
 *
 * <p>The class is annotated with Lombok annotations for automatic generation of getter methods, a constructor with all fields,
 * and appropriate access levels for the setter methods. Additionally, it includes validation annotations from Jakarta Bean Validation
 * to enforce constraints on the data, such as ensuring non-blank values and positive numeric values for certain fields.
 *
 */
@Data
@AllArgsConstructor
public class PhoneRequest {

    /**
     * The unique identifier for the phone. Set with {@code AccessLevel.NONE} to prevent external modification.
     */
    @Setter(AccessLevel.NONE)
    Integer id;

    /**
     * The manufacturer of the phone. Must not be blank.
     */
    @NotBlank(message = "Manufacturer should not be null")
    String manufacturer;

    /**
     * The model of the phone. Must not be blank.
     */
    @NotBlank(message = "Model should not be null")
    String model;

    /**
     * The storage size of the phone. Must be a positive value.
     */
    @Positive(message = "Storage size should be greater than zero")
    int storageSize;

    /**
     * The color of the phone. Must not be blank.
     */
    @NotBlank(message = "Color should not be null")
    String color;

    /**
     * The cost of the phone. Must be a positive value.
     */
    @Positive(message = "Cost should be greater than zero")
    int cost;

    /**
     * The quantity of the phone. Must be a positive value.
     */
    @Positive(message = "Quantity should be greater than zero")
    int quantity;

}