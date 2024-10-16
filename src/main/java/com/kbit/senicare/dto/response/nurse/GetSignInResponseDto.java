package com.kbit.senicare.dto.response.nurse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.kbit.senicare.dto.response.ResponseCode;
import com.kbit.senicare.dto.response.ResponseDto;
import com.kbit.senicare.dto.response.ResponseMessage;
import com.kbit.senicare.entity.NurseEntity;

import lombok.Getter;

@Getter
public class GetSignInResponseDto extends ResponseDto {
    
    private String userId;
    private String name;
    private String telNumber;

    public GetSignInResponseDto(NurseEntity nurseEntity) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.userId = nurseEntity.getUserId();
        this.name = nurseEntity.getName();
        this.telNumber = nurseEntity.getTelNumber();
    }

    public static ResponseEntity<GetSignInResponseDto> success(NurseEntity nurseEntity) {
        GetSignInResponseDto responseBody = new GetSignInResponseDto(nurseEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

}