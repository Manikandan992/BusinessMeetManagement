package com.example.businessmeetmanagement.services.impl;

import com.example.businessmeetmanagement.dto.AddonDto;
import com.example.businessmeetmanagement.exceptions.ResourceNotFoundException;
import com.example.businessmeetmanagement.mapper.AddonMapper;
import com.example.businessmeetmanagement.entities.Addon;
import com.example.businessmeetmanagement.repositories.AddonRepository;
import com.example.businessmeetmanagement.services.AddonService;
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

    @Autowired
    private AddonMapper mapper;

    @Override
    public AddonDto addAddon(AddonDto addon) {
        Addon addon1 = mapper.toAddon(addon);
        addon1=addonRepository.save(addon1);
        log.info("New Addon created");
        return mapper.toAddonDto(addon1);
    }

    @Override
    public AddonDto getAddon(int addonId) {
        return mapper.toAddonDto(addonRepository.findById(addonId)
                .orElseThrow(()->new ResourceNotFoundException("Addon not found")));
    }

    @Override
    public List<AddonDto> getAddons() {
        return mapper.toAddonDtos(addonRepository.findAll());
    }

    @Override
    public AddonDto updateAddon(int addonId, AddonDto addon) {
        AddonDto update=mapper.toAddonDto(addonRepository.findById(addonId)
                .orElseThrow(()-> new ResourceNotFoundException("Addon not found")));
        update.setAddonName(addon.getAddonName());
        update.setAddonDescription(addon.getAddonDescription());
        update.setAddonPrice(addon.getAddonPrice());
        Addon addon1 = mapper.toAddon(update);
        addon1=addonRepository.save(addon1);
        log.info("Addon Updated");
        return mapper.toAddonDto(addon1);
    }

    @Override
    public void deleteAddon(int addonId) {
        addonRepository.deleteById(addonId);
        log.warn("Addon Deleted");
    }
}
