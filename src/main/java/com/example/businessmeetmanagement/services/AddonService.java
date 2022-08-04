package com.example.businessmeetmanagement.services;

import com.example.businessmeetmanagement.dto.AddonDto;

import java.util.List;

public interface AddonService {
    AddonDto addAddon(AddonDto addon);
    AddonDto getAddon(int addonId);
    List<AddonDto> getAddons();
    AddonDto updateAddon(int addonId,AddonDto addon);
    void deleteAddon(int addonId);
}
