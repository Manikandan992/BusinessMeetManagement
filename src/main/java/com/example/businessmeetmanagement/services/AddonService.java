package com.example.businessmeetmanagement.services;

import com.example.businessmeetmanagement.dto.AddonDto;

import java.util.List;

public interface AddonService {
    AddonDto addAddon(AddonDto addon);
    AddonDto getAddon(int id);
    List<AddonDto> getAddons();
    AddonDto updateAddon(int id,AddonDto addon);
    void deleteAddon(int id);
}
