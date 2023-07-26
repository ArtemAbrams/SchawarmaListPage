package com.example.schawarmashop.entity;

import com.example.schawarmashop.enums.Size;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "schawarmas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Schawarma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp creatDate;
    @UpdateTimestamp
    private Timestamp lastUpdatedDate;
    private double price;
    @Enumerated(value = EnumType.STRING)
    private Size size;
    private String cooker;
    @Lob
    @Column(length = 1000000000)
    private byte[] schwarmaPicture;
}
