package com.languages.ProgramminLanguages.WebAPI.Controllers;

import com.languages.ProgramminLanguages.Business.Abstract.SubLanguagesService;
import com.languages.ProgramminLanguages.Business.Request.CreateSubLanguageRequest;
import com.languages.ProgramminLanguages.Business.Request.UpdateSubLanguageRequest;
import com.languages.ProgramminLanguages.Business.Response.GetAllSubLanguagesResponse;
import com.languages.ProgramminLanguages.Entities.SubOfLanguages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sub-languages")
public class SubLanguagesController {
    private SubLanguagesService subLanguagesService;

    @Autowired
    public SubLanguagesController(SubLanguagesService subLanguagesService){
        this.subLanguagesService=subLanguagesService;
    }
    @PostMapping("/addSub")
    public void addSub(CreateSubLanguageRequest createSubLanguageRequest){
        this.subLanguagesService.addSub(createSubLanguageRequest);
    }

    @DeleteMapping("/deleteSub")
    public void deleteSub(int id){
        this.subLanguagesService.deleteSub(id);
    }

    @PutMapping("/updateSub")
    public void updateSub(UpdateSubLanguageRequest updateSubLanguageRequest){
        this.subLanguagesService.updateSub(updateSubLanguageRequest);
    }

    @GetMapping("/gettAllSub")
    public List<GetAllSubLanguagesResponse> getAllSub(){
        return this.subLanguagesService.getAllSubLanguagesResponses();
    }




}
