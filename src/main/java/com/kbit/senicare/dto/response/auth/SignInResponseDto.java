package com.kbit.senicare.dto.response.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.kbit.senicare.dto.response.ResponseCode;
import com.kbit.senicare.dto.response.ResponseDto;
import com.kbit.senicare.dto.response.ResponseMessage;

import lombok.Getter;


@Getter
public class SignInResponseDto extends ResponseDto {

    private String accessToken;
    private Integer expiration;

    private SignInResponseDto(String accessToken) {

        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.accessToken = accessToken;
        this.expiration = 10 * 3600 ;
    }
    
    public static ResponseEntity<SignInResponseDto> success(String accessToken) {
        SignInResponseDto responseBody = new SignInResponseDto(accessToken);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

}
