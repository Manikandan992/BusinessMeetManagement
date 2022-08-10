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
@CrossOrigin(origins="http://localhost:4200/")
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    @PostMapping("/addTheme")
    public ResponseEntity<ThemeDto> addTheme(@RequestBody ThemeDto theme){
        return ResponseEntity.ok(themeService.addTheme(theme));
    }

    @GetMapping("/theme/{id}")
    public ResponseEntity<ThemeDto> getTheme(@PathVariable("id") int themeId){
        return ResponseEntity.ok(themeService.getTheme(themeId));
    }

    @GetMapping("/themes")
    public ResponseEntity<List<ThemeDto>> getThemes(){
        List<ThemeDto> themes=themeService.getThemes();
        return new ResponseEntity<>(themes,HttpStatus.OK);
    }

    @PutMapping("/editTheme/{id}")
    public ResponseEntity<ThemeDto> updateTheme(@PathVariable("id") int themeId,@RequestBody ThemeDto theme){
        return ResponseEntity.ok(themeService.updateTheme(themeId,theme));
    }

    @DeleteMapping("/deleteTheme/{id}")
    public void deleteTheme(@PathVariable("id") int themeId){
        themeService.deleteTheme(themeId);
    }
}
