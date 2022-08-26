package com.example.businessmeetmanagement.dto;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddonDto {
    private int id;
    private String addonName;
    private String addonimageUrl;
    private long addonPrice;
}
