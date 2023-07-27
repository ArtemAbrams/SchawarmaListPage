package com.example.schawarmashop.domain.mapper;

import com.example.schawarmashop.domain.data.SchawarmaData;
import com.example.schawarmashop.domain.dto.SchawarmaDto;
import com.example.schawarmashop.domain.entity.Schawarma;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SchawarmaMapper {

    public SchawarmaDto entityToDto(Schawarma schawarma) {
        return SchawarmaDto.builder()
                .cooker(schawarma.getCooker())
                .price(schawarma.getPrice())
                .size(schawarma.getSize())
                .schwarmaPicture(schawarma.getSchwarmaPicture())
                .build();
    }

    public Schawarma dataToEntity(SchawarmaData schawarmaData, byte[] bytes) {
        return Schawarma.builder()
                .cooker(schawarmaData.getCooker())
                .size(schawarmaData.getSize())
                .price(schawarmaData.getPrice())
                .schwarmaPicture(bytes)
                .build();
    }
}
