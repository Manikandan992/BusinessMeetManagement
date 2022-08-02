package com.businessmeetmanagement.BusinessMeetManagement.controllers;

import com.businessmeetmanagement.BusinessMeetManagement.models.Theme;
import com.businessmeetmanagement.BusinessMeetManagement.services.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/theme")
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    @PostMapping("/addTheme")
    public ResponseEntity<?> addTheme(@RequestBody Theme theme){
        return ResponseEntity.ok(themeService.addTheme(theme));
    }

    @GetMapping("/getTheme/{themeId}")
    public ResponseEntity<?> getTheme(@PathVariable("themeId") Integer themeId){
        return ResponseEntity.ok(themeService.getTheme(themeId));
    }

    @GetMapping("/getThemes")
    public ResponseEntity<List<Theme>> getThemes(){
        List<Theme> themes=themeService.getThemes();
        return new ResponseEntity<List<Theme>>(themes,HttpStatus.OK);
    }

    @PutMapping("/editTheme/{themeId}")
    public ResponseEntity<?> updateTheme(@PathVariable("themeId") int themeId,@RequestBody Theme theme){
        return ResponseEntity.ok(themeService.updateTheme(themeId,theme));
    }

    @DeleteMapping("/deleteTheme/{themeId}")
    public void deleteTheme(@PathVariable("themeId") int themeId){
        themeService.deleteTheme(themeId);
    }
}
