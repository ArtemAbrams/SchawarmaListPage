package com.example.schawarmashop.controller;

import com.example.schawarmashop.domain.data.SchawarmaData;
import com.example.schawarmashop.domain.dto.SchawarmaDto;
import com.example.schawarmashop.service.impl.SchawarmaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SchawarmaController {

    private final SchawarmaServiceImpl pagingSortingSchawarmaServiceImpl;

    @GetMapping("/get")
    public ResponseEntity<List<SchawarmaDto>> findAll(@RequestParam int page,
                                                      @RequestParam int pageSize) {
       return ResponseEntity.ok(pagingSortingSchawarmaServiceImpl.findAll(page, pageSize));
    }
    @PostMapping(value = "/save")
    public ResponseEntity<SchawarmaDto> save(@RequestPart("file") MultipartFile file,
                                             @RequestPart("data") SchawarmaData schawarmaData) throws IOException {
        return ResponseEntity.ok(pagingSortingSchawarmaServiceImpl.save(schawarmaData, file));
    }
}
