package com.example.schawarmashop.data;

import com.example.schawarmashop.enums.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.core.io.Resource;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SchawarmaData {

    private double price;
    private Size size;
    private String cooker;
}
