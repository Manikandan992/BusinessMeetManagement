package com.example.businessmeetmanagement.dto;

import lombok.*;


@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

public class FoodMenuDto {
    private int id;
    private String menuName;
    private String menuImageUrl;
    private long menuPrice;
    private String itemCategory;
}
