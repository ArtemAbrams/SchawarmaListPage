package com.example.schawarmashop.service.impl;

import com.example.schawarmashop.domain.data.SchawarmaData;
import com.example.schawarmashop.domain.dto.SchawarmaDto;
import com.example.schawarmashop.domain.entity.Schawarma;
import com.example.schawarmashop.domain.mapper.SchawarmaMapper;
import com.example.schawarmashop.repositoty.SchawarmaRepository;
import com.example.schawarmashop.service.SchawarmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SchawarmaServiceImpl implements SchawarmaService {

    private final SchawarmaRepository schawarmaRepository;

    public SchawarmaDto save(SchawarmaData schawarmaData, MultipartFile file) throws IOException {
        final Schawarma schawarma = SchawarmaMapper.dataToEntity(schawarmaData, file.getBytes());
        schawarmaRepository.saveAndFlush(schawarma);
        return SchawarmaMapper.entityToDto(schawarma);
    }

    public List<SchawarmaDto> findAll(int page, int pageSize) {
        return schawarmaRepository
                .findAll(PageRequest.of(page, pageSize))
                .stream()
                .map(SchawarmaMapper::entityToDto)
                .toList();
    }
}
