package com.example.schawarmashop.bootstrap;

import com.example.schawarmashop.entity.Schawarma;
import com.example.schawarmashop.enums.Size;
import com.example.schawarmashop.repositoty.SchawarmaRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.type.descriptor.converter.internal.OrdinalEnumValueConverter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@RequiredArgsConstructor
public class SetData implements CommandLineRunner {
    private final SchawarmaRepository schawarmaRepository;
    @Override
    public void run(String... args) throws Exception {
        Random random = new Random();
        for (int i=0; i<50; i++){
            Schawarma schawarma = Schawarma.builder()
                    .price(random.nextDouble(1, 100))
                    .cooker("Alisher " + random.nextInt(0, 15))
                    .size(getRandomSize())
                    .build();
            schawarmaRepository.save(schawarma);
        }
    }
    private Size getRandomSize(){
        Random random = new Random();
        var sizes = Size.values();
        int index = random.nextInt(sizes.length);
        return sizes[index];
    }
}
