package com.kbit.senicare.service;

import org.springframework.http.ResponseEntity;

import com.kbit.senicare.dto.request.tool.PatchToolRequestDto;
import com.kbit.senicare.dto.request.tool.PostToolRequestDto;
import com.kbit.senicare.dto.response.ResponseDto;
import com.kbit.senicare.dto.response.tool.GetToolListResponseDto;
import com.kbit.senicare.dto.response.tool.GetToolResponseDto;

public interface ToolService {
    
    ResponseEntity<ResponseDto> postTool(PostToolRequestDto dto);
    ResponseEntity<? super GetToolListResponseDto> getToolList();
    ResponseEntity<? super GetToolResponseDto>  getTool(Integer toolNumber);
    ResponseEntity<ResponseDto> patchTool(Integer toolNumber, PatchToolRequestDto dto);
    ResponseEntity<ResponseDto> deleteTool(Integer toolNumber);

}
