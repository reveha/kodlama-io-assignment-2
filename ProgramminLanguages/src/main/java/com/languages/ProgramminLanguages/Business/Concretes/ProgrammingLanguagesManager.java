package com.languages.ProgramminLanguages.Business.Concretes;

import com.languages.ProgramminLanguages.Business.Abstract.ProgrammingLanguagesService;
import com.languages.ProgramminLanguages.Business.Request.CreateProgrammingLanguageRequest;
import com.languages.ProgramminLanguages.Business.Request.UpdateProgrammingLanguageRequest;
import com.languages.ProgramminLanguages.Business.Response.GetAllProgrammingLangueagesResponse;
import com.languages.ProgramminLanguages.Business.Response.GetByIdProgrammingLangueagesResponse;
import com.languages.ProgramminLanguages.DataAccess.Abstract.ProgrammingLanguagesDAO;
import com.languages.ProgramminLanguages.Entities.ProgrammingLanguages;
import com.languages.ProgramminLanguages.Mapper.ModelMapperManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProgrammingLanguagesManager extends ProgrammingLanguagesService {

    private final ProgrammingLanguagesDAO programmingLanguagesDAO;
    private final ModelMapperManager modelMapperManager;

    @Autowired
    public ProgrammingLanguagesManager(ProgrammingLanguagesDAO plDAO,ModelMapperManager modelMapperManager){
        this.programmingLanguagesDAO=plDAO;
        this.modelMapperManager=modelMapperManager;
    }

    @Override
    public void delete(int id) {

        this.programmingLanguagesDAO.deleteById(id);
    }

    @Override
    public List<GetAllProgrammingLangueagesResponse> getAll() { // BURAYA BAK LIST OLDUGUNDA IS DEGISIR
        List<ProgrammingLanguages> pl=this.programmingLanguagesDAO.findAll();

        List<GetAllProgrammingLangueagesResponse> getAllProgrammingLangueagesResponses=pl.stream()
                .map(programmingLanguages->this.modelMapperManager.forResponse()
                        .map(programmingLanguages,GetAllProgrammingLangueagesResponse.class))
                .collect(Collectors.toList());


        return getAllProgrammingLangueagesResponses;
    }

    @Override
    public GetByIdProgrammingLangueagesResponse getById(int id) {
        Optional<ProgrammingLanguages> pl= Optional.of(this.programmingLanguagesDAO.findById(id).orElseThrow());

        return this.modelMapperManager
                .forResponse().map(pl,GetByIdProgrammingLangueagesResponse.class);
    }

    @Override
    public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
        ProgrammingLanguages pl=this.modelMapperManager.forResponse()
                .map(updateProgrammingLanguageRequest,ProgrammingLanguages.class);

        this.programmingLanguagesDAO.save(pl);
    }

    @Override
    public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
        for(ProgrammingLanguages pl:this.programmingLanguagesDAO.findAll()){ // Tekrar ayni dili girmek yasak!
            if(pl.getLanguage().equals(createProgrammingLanguageRequest.getLanguage())){
                return;
            }
        }
        if(createProgrammingLanguageRequest.getLanguage().equals("")){ // Checking the language name is nothing or not
            return;
        }
        ProgrammingLanguages pl=this.modelMapperManager.forRequest()
                .map(createProgrammingLanguageRequest,ProgrammingLanguages.class);

        this.programmingLanguagesDAO.save(pl);
    }




}
