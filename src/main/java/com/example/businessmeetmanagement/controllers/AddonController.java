package com.example.businessmeetmanagement.controllers;

import com.example.businessmeetmanagement.dto.AddonDto;
import com.example.businessmeetmanagement.services.AddonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins="http://localhost:4200/")
public class AddonController {

    @Autowired
    private AddonService addonService;

    @PostMapping("/addAddon")
    public ResponseEntity<AddonDto> addAddon(@RequestBody AddonDto addon){
        return ResponseEntity.ok(addonService.addAddon(addon));
    }

    @GetMapping("/addon/{id}")
    public ResponseEntity<AddonDto> getAddon(@PathVariable("id") Integer addonId){
        return ResponseEntity.ok(addonService.getAddon(addonId));
    }

    @GetMapping("/addons")
    public ResponseEntity<List<AddonDto>> getAddons(){
        List<AddonDto> addons=addonService.getAddons();
        return new ResponseEntity<>(addons, HttpStatus.OK);
    }

    @PutMapping("/editAddon/{id}")
    public ResponseEntity<AddonDto> updateAddon(@PathVariable("id") int addonId,@RequestBody AddonDto addon){
        return ResponseEntity.ok(addonService.updateAddon(addonId,addon));
    }

    @DeleteMapping("/deleteAddon/{id}")
    public void deleteAddon(@PathVariable("id") int addonId){
        addonService.deleteAddon(addonId);
    }
}
