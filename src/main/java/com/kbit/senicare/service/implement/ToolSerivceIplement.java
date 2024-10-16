package com.kbit.senicare.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kbit.senicare.dto.request.tool.PatchToolRequestDto;
import com.kbit.senicare.dto.request.tool.PostToolRequestDto;
import com.kbit.senicare.dto.response.ResponseDto;
import com.kbit.senicare.dto.response.tool.GetToolListResponseDto;
import com.kbit.senicare.dto.response.tool.GetToolResponseDto;
import com.kbit.senicare.entity.ToolEntity;
import com.kbit.senicare.repository.ToolRepository;
import com.kbit.senicare.service.ToolService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ToolSerivceIplement implements ToolService {

    private final ToolRepository toolRepository;

    @Override
    public ResponseEntity<ResponseDto> postTool(PostToolRequestDto dto) {

        try {
            ToolEntity toolEntity = new ToolEntity(dto);
            toolRepository.save(toolEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetToolListResponseDto> getToolList() {
        
        List<ToolEntity> toolEntities = new ArrayList<>();

        try {

            toolEntities =toolRepository.findByOrderByToolNumberDesc();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetToolListResponseDto.success(toolEntities);

    }

    @Override
    public ResponseEntity<? super GetToolResponseDto> getTool(Integer toolNumber) {

        ToolEntity toolEntity = null;

        try {
            
            toolEntity = toolRepository.findByToolNumber(toolNumber);
            if(toolEntity == null) return ResponseDto.noExistTool();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetToolResponseDto.success(toolEntity);
    }

    @Override
    public ResponseEntity<ResponseDto> patchTool(Integer toolNumber,PatchToolRequestDto dto) {

        try {
            ToolEntity toolEntity = toolRepository.findByToolNumber(toolNumber);
            if(toolEntity == null) return ResponseDto.noExistTool();
            
            toolEntity.patch(dto);
            toolRepository.save(toolEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
    
        return ResponseDto.success();
    }

    @Override
    public ResponseEntity<ResponseDto> deleteTool(Integer toolNumber) {

        try {
            ToolEntity toolEntity = toolRepository.findByToolNumber(toolNumber);
            if(toolNumber == null) return ResponseDto.noExistTool();

            toolRepository.delete(toolEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }

    
    
}
