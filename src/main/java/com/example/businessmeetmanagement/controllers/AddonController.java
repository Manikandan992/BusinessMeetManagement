package com.example.businessmeetmanagement.controllers;

import com.example.businessmeetmanagement.dto.AddonDto;
import com.example.businessmeetmanagement.services.AddonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AddonController {

    @Autowired
    private AddonService addonService;

    @PostMapping("/addAddon")
    public ResponseEntity<AddonDto> addAddon(@RequestBody AddonDto addon){
        return ResponseEntity.ok(addonService.addAddon(addon));
    }

    @GetMapping("/addon/{id}")
    public ResponseEntity<AddonDto> getAddon(@PathVariable("id") Integer id){
        return ResponseEntity.ok(addonService.getAddon(id));
    }

    @GetMapping("/addons")
    public ResponseEntity<List<AddonDto>> getAddons(){
        List<AddonDto> addons=addonService.getAddons();
        return new ResponseEntity<>(addons, HttpStatus.OK);
    }

    @PutMapping("/editAddon/{id}")
    public ResponseEntity<AddonDto> updateAddon(@PathVariable("id") int id,@RequestBody AddonDto addon){
        return ResponseEntity.ok(addonService.updateAddon(id,addon));
    }

    @DeleteMapping("/deleteAddon/{id}")
    public void deleteAddon(@PathVariable("id") int id){
        addonService.deleteAddon(id);
    }
}
