package com.example.schawarmashop.bootstrap;

import com.example.schawarmashop.domain.entity.Schawarma;
import com.example.schawarmashop.domain.enums.Size;
import com.example.schawarmashop.repositoty.SchawarmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class SetData {
    private final SchawarmaRepository schawarmaRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void run() {
        if (schawarmaRepository.count() == 0) {
            final Random random = new Random();
            for (int i = 0; i < 50; i++) {
                Schawarma schawarma = Schawarma.builder()
                        .price(random.nextDouble(1, 100))
                        .cooker("Alisher " + random.nextInt(0, 15))
                        .size(getRandomSize())
                        .build();
                schawarmaRepository.saveAndFlush(schawarma);
            }
        }
    }
    private Size getRandomSize(){
        Random random = new Random();
        var sizes = Size.values();
        int index = random.nextInt(sizes.length);
        return sizes[index];
    }
}
