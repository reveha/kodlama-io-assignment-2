package com.languages.ProgramminLanguages.WebAPI.Controllers;


import com.languages.ProgramminLanguages.Business.Abstract.ProgrammingLanguagesService;
import com.languages.ProgramminLanguages.Business.Request.CreateProgrammingLanguageRequest;
import com.languages.ProgramminLanguages.Business.Request.UpdateProgrammingLanguageRequest;
import com.languages.ProgramminLanguages.Business.Response.GetAllProgrammingLangueagesResponse;
import com.languages.ProgramminLanguages.Business.Response.GetByIdProgrammingLangueagesResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //Annotation -> Bilgilendirme for SpringFrameWork
@RequestMapping("/api/programming-languages") //Bu adresimizi belirler, tarayici icin.

public class LanguageController {

    private ProgrammingLanguagesService programmingLanguagesService;

    @Autowired
    public LanguageController(ProgrammingLanguagesService pls){
        this.programmingLanguagesService=pls;
    }

    @PostMapping("/add")
    public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest){
        this.programmingLanguagesService.add(createProgrammingLanguageRequest);
    }

    @PutMapping("/update")
    public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest){
        this.programmingLanguagesService.update(updateProgrammingLanguageRequest);
    }

    @GetMapping("/getall")
    public List<GetAllProgrammingLangueagesResponse> getAll(){
        return this.programmingLanguagesService.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public GetByIdProgrammingLangueagesResponse getByIdProgrammingLangueagesResponse(@PathVariable int id){
        return this.programmingLanguagesService.getById(id);
    }

    @DeleteMapping("/deletebyid/{id}")
    public void delete(@PathVariable int id){
        this.programmingLanguagesService.delete(id);
    }
}
