package com.kbit.senicare.service;

import org.springframework.http.ResponseEntity;

import com.kbit.senicare.dto.request.auth.IdCheckRequestDto;
import com.kbit.senicare.dto.request.auth.SignInRequestDto;
import com.kbit.senicare.dto.request.auth.SignUpRequestDto;
import com.kbit.senicare.dto.request.auth.TelAuthCheckRequestDto;
import com.kbit.senicare.dto.request.auth.TelAuthRequestDto;
import com.kbit.senicare.dto.response.ResponseDto;
import com.kbit.senicare.dto.response.auth.SignInResponseDto;

public interface AuthService {
    
    ResponseEntity<ResponseDto> idCheck(IdCheckRequestDto dto);
    ResponseEntity<ResponseDto> telAuth(TelAuthRequestDto dto);
    ResponseEntity<ResponseDto> telAuthCheck(TelAuthCheckRequestDto dto);
    ResponseEntity<ResponseDto> signUp(SignUpRequestDto dto);
    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
    
}
