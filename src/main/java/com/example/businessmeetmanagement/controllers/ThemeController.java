package com.example.businessmeetmanagement.controllers;

import com.example.businessmeetmanagement.dto.ThemeDto;
import com.example.businessmeetmanagement.services.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    @PostMapping("/addTheme")
    public ResponseEntity<ThemeDto> addTheme(@RequestBody ThemeDto theme){
        return ResponseEntity.ok(themeService.addTheme(theme));
    }

    @GetMapping("/theme/{id}")
    public ResponseEntity<ThemeDto> getTheme(@PathVariable("id") int id){
        return ResponseEntity.ok(themeService.getTheme(id));
    }

    @GetMapping("/themes")
    public ResponseEntity<List<ThemeDto>> getThemes(){
        List<ThemeDto> themes=themeService.getThemes();
        return new ResponseEntity<>(themes,HttpStatus.OK);
    }

    @PutMapping("/editTheme/{id}")
    public ResponseEntity<ThemeDto> updateTheme(@PathVariable("id") int id,@RequestBody ThemeDto theme){
        return ResponseEntity.ok(themeService.updateTheme(id,theme));
    }

    @DeleteMapping("/deleteTheme/{id}")
    public void deleteTheme(@PathVariable("id") int id){
        themeService.deleteTheme(id);
    }
}
