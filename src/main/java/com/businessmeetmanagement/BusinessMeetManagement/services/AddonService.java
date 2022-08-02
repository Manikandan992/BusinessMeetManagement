package com.businessmeetmanagement.BusinessMeetManagement.services;

import com.businessmeetmanagement.BusinessMeetManagement.models.Addon;

import java.util.List;

public interface AddonService {
    Addon addAddon(Addon addon);
    Addon getAddon(int addonId);
    List<Addon> getAddons();
    Addon updateAddon(int addonId,Addon addon);
    void deleteAddon(int addonId);
}
