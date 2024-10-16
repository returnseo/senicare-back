package com.kbit.senicare.service;

import org.springframework.http.ResponseEntity;

import com.kbit.senicare.dto.request.nurse.PatchNurseRequestDto;
import com.kbit.senicare.dto.response.ResponseDto;
import com.kbit.senicare.dto.response.nurse.GetChargedCutomerResponseDto;
import com.kbit.senicare.dto.response.nurse.GetNurseListResponseDto;
import com.kbit.senicare.dto.response.nurse.GetNurseResponseDto;
import com.kbit.senicare.dto.response.nurse.GetSignInResponseDto;

public interface NurseService {
    
    ResponseEntity<? super GetNurseListResponseDto> getNurseList();
    ResponseEntity<? super GetNurseResponseDto> getNurse(String userId); 
    ResponseEntity<? super GetSignInResponseDto> getSignIn(String userId);
    ResponseEntity<ResponseDto> patchNurse(PatchNurseRequestDto dto, String userId);
    ResponseEntity<? super GetChargedCutomerResponseDto> getChargedCustomer(String nurseId);

}