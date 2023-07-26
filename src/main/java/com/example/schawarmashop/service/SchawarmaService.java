package com.example.schawarmashop.service;

import com.example.schawarmashop.controller.SchawarmaController;
import com.example.schawarmashop.data.SchawarmaData;
import com.example.schawarmashop.dto.SchawarmaDto;
import com.example.schawarmashop.entity.Schawarma;
import com.example.schawarmashop.repositoty.SchawarmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SchawarmaService {
    private final SchawarmaRepository schawarmaRepository;

    public Schawarma save(SchawarmaData schawarmaData, MultipartFile file) throws IOException {
        Schawarma schawarma = Schawarma.builder()
                .cooker(schawarmaData.getCooker())
                .size(schawarmaData.getSize())
                .price(schawarmaData.getPrice())
                .schwarmaPicture(file.getBytes())
                .build();
        schawarmaRepository.save(schawarma);
        return schawarma;
    }
    public List<SchawarmaDto> findAll(int page, int pageSize) throws IOException  {
        var schawarmaDtos = schawarmaRepository.findAll(PageRequest.of(page, pageSize))
                .stream()
                .map(e -> new SchawarmaDto(e.getPrice(), e.getSize(),
                                e.getCooker(), e.getSchwarmaPicture()))
                .toList();
        return schawarmaDtos;
    }
}
