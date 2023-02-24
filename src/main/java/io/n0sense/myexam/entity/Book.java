package io.n0sense.myexam.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data @Builder
@AllArgsConstructor @NoArgsConstructor
public class Book {
    private Long b_id;
    private String b_name;
    private String b_author;
    private BigDecimal b_price;
    private String b_press;
}
