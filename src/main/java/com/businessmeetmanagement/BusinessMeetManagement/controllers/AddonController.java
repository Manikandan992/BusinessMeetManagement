package com.businessmeetmanagement.BusinessMeetManagement.controllers;

import com.businessmeetmanagement.BusinessMeetManagement.models.Addon;
import com.businessmeetmanagement.BusinessMeetManagement.services.AddonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/addon")
public class AddonController {

    @Autowired
    private AddonService addonService;

    @PostMapping("/addAddon")
    public ResponseEntity<Addon> addAddon(@RequestBody Addon addon){
        return ResponseEntity.ok(addonService.addAddon(addon));
    }

    @GetMapping("/getAddon/{addonId}")
    public ResponseEntity<Addon> getAddon(@PathVariable("addonId") Integer addonId){
        return ResponseEntity.ok(addonService.getAddon(addonId));
    }

    @GetMapping("/getAddons")
    public ResponseEntity<List<Addon>> getAddons(){
        List<Addon> addons=addonService.getAddons();
        return new ResponseEntity<>(addons, HttpStatus.OK);
    }

    @PutMapping("/editAddon/{addonId}")
    public ResponseEntity<Addon> updateAddon(@PathVariable("addonId") int addonId,@RequestBody Addon addon){
        return ResponseEntity.ok(addonService.updateAddon(addonId,addon));
    }

    @DeleteMapping("/deleteAddon/{addonId}")
    public void deleteAddon(@PathVariable("addonId") int addonId){
        addonService.deleteAddon(addonId);
    }
}
