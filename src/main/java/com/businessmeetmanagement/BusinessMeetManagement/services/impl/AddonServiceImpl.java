package com.businessmeetmanagement.BusinessMeetManagement.services.impl;

import com.businessmeetmanagement.BusinessMeetManagement.exceptions.ResourceNotFoundException;
import com.businessmeetmanagement.BusinessMeetManagement.models.Addon;
import com.businessmeetmanagement.BusinessMeetManagement.repositories.AddonRepository;
import com.businessmeetmanagement.BusinessMeetManagement.services.AddonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AddonServiceImpl implements AddonService {

    @Autowired
    private AddonRepository addonRepository;

    @Override
    public Addon addAddon(Addon addon) {
        return addonRepository.save(addon);
    }

    @Override
    public Addon getAddon(int addonId) {
        return addonRepository.findById(addonId)
                .orElseThrow(()->new ResourceNotFoundException("Addon not found"));
    }

    @Override
    public List<Addon> getAddons() {
        return addonRepository.findAll();
    }

    @Override
    public Addon updateAddon(int addonId, Addon addon) {
        Addon update=addonRepository.findById(addonId).orElseThrow(()-> new ResourceNotFoundException("Addon not found"));
        update.setAddonName(addon.getAddonName());
        update.setAddonDescription(addon.getAddonDescription());
        update.setAddonPrice(addon.getAddonPrice());
        return addonRepository.save(update);
    }

    @Override
    public void deleteAddon(int addonId) {
        addonRepository.deleteById(addonId);
    }
}
