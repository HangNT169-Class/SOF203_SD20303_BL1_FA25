package com.example.sof203_sd20303_bl1_fa25.B10_JDBC.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Category {

    // liet ke cac thuoc tinh
    private Long id;

    private String categoryCode;

    private String categoryName;

}
