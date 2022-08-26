package com.example.businessmeetmanagement.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodMenuDto {
    private int id;
    private String menuName;
    private String menuImageUrl;
    private long menuPrice;
    private String itemCategory;
}
