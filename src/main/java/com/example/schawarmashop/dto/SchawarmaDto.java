package com.example.schawarmashop.dto;

import com.example.schawarmashop.enums.Size;
import lombok.*;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class SchawarmaDto implements Serializable {
    private double price;
    private Size size;
    private String cooker;
    private byte[] schwarmaPicture;
}
