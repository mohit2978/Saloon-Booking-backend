package com.magma.userService.Payload.Request;

import lombok.Data;

@Data
public class Credential {

    private String type;
    private String value;
    private boolean temporary;

}
