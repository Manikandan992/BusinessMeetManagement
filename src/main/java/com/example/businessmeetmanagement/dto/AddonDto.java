package com.example.businessmeetmanagement.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddonDto {
    private int id;
    private String addonName;
    private String addonimageUrl;
    private long addonPrice;
}
