package com.app.paymentservice.payload.response;

import com.app.paymentservice.domain.UserRole;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthResponse {
	private String jwt;
	private String message;
	private String title;
	private UserRole role;
	
}
