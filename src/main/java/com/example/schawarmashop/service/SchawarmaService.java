package com.example.schawarmashop.service;

import com.example.schawarmashop.domain.data.SchawarmaData;
import com.example.schawarmashop.domain.dto.SchawarmaDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface SchawarmaService {
    SchawarmaDto save(SchawarmaData schawarmaData, MultipartFile file)  throws IOException;
    List<SchawarmaDto> findAll(int page, int pageSize);
}
