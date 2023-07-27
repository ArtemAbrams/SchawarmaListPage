package com.example.schawarmashop.domain.data;

import com.example.schawarmashop.domain.enums.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SchawarmaData {

    private double price;
    private Size size;
    private String cooker;
}
