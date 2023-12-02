package com.siri_hate.phone_shop_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A simple data class representing a message.
 * This class is typically used to encapsulate textual information for communication.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Message {

    /**
     * The textual content of the message.
     */
    String message;

}
