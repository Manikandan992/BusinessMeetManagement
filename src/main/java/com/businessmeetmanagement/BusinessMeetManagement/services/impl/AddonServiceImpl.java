package com.businessmeetmanagement.BusinessMeetManagement.services.impl;

import com.businessmeetmanagement.BusinessMeetManagement.exceptions.ResourceNotFoundException;
import com.businessmeetmanagement.BusinessMeetManagement.models.Addon;
import com.businessmeetmanagement.BusinessMeetManagement.repositories.AddonRepository;
import com.businessmeetmanagement.BusinessMeetManagement.services.AddonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
public class AddonServiceImpl implements AddonService {

    @Autowired
    private AddonRepository addonRepository;

    @Override
    public Addon addAddon(Addon addon) {
        log.info("New Addon created");
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
        log.info("Addon Updated");
        return addonRepository.save(update);
    }

    @Override
    public void deleteAddon(int addonId) {
        addonRepository.deleteById(addonId);
        log.warn("Addon Deleted");
    }
}
