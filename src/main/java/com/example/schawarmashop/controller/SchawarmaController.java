package com.example.schawarmashop.controller;

import com.example.schawarmashop.data.SchawarmaData;
import com.example.schawarmashop.dto.SchawarmaDto;
import com.example.schawarmashop.entity.Schawarma;
import com.example.schawarmashop.enums.Size;
import com.example.schawarmashop.repositoty.SchawarmaRepository;
import com.example.schawarmashop.service.SchawarmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SchawarmaController {
    private final SchawarmaService pagingSortingSchawarmaService;
    private final SchawarmaRepository schawarmaRepository;
    @GetMapping("/get")
    public ResponseEntity<List<SchawarmaDto>> findAll(@RequestParam int page,
                                      @RequestParam int pageSize) throws IOException {
       var schawarmasDtos = pagingSortingSchawarmaService.findAll(page, pageSize);
       return ResponseEntity.ok(schawarmasDtos);
    }
    @PostMapping(value = "/save")
    public ResponseEntity<SchawarmaDto> save(@RequestPart("file") MultipartFile file,
                                              @RequestPart("data") SchawarmaData schawarmaData) throws IOException {
        var schawarma = pagingSortingSchawarmaService.save(schawarmaData, file);
      return ResponseEntity.ok(SchawarmaDto.builder()
              .price(schawarma.getPrice())
              .size(schawarma.getSize())
              .cooker(schawarma.getCooker())
              .schwarmaPicture(schawarma.getSchwarmaPicture())
              .build());
    }
}
