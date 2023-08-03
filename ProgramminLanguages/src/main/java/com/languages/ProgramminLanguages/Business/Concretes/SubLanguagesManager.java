package com.languages.ProgramminLanguages.Business.Concretes;

import com.languages.ProgramminLanguages.Business.Abstract.SubLanguagesService;
import com.languages.ProgramminLanguages.Business.Request.CreateSubLanguageRequest;
import com.languages.ProgramminLanguages.Business.Request.UpdateSubLanguageRequest;
import com.languages.ProgramminLanguages.Business.Response.GetAllSubLanguagesResponse;
import com.languages.ProgramminLanguages.DataAccess.Abstract.ProgrammingLanguagesDAO;
import com.languages.ProgramminLanguages.DataAccess.Abstract.SubLanguagesDAO;
import com.languages.ProgramminLanguages.Entities.SubOfLanguages;
import com.languages.ProgramminLanguages.Mapper.ModelMapperManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubLanguagesManager extends SubLanguagesService {
    private final ModelMapperManager modelMapperManager;

    private final SubLanguagesDAO subLanguagesDAO;

    @Autowired
    public SubLanguagesManager(ModelMapperManager modelMapperManager, SubLanguagesDAO subLanguagesDAO) {
        this.modelMapperManager = modelMapperManager;
        this.subLanguagesDAO = subLanguagesDAO;
    }

    @Override
    public void addSub(CreateSubLanguageRequest createSubLanguageRequest) {
        SubOfLanguages subOfLanguages=this.modelMapperManager.forRequest().map(createSubLanguageRequest,SubOfLanguages.class);
        this.subLanguagesDAO.save(subOfLanguages);
    }

    @Override
    public void deleteSub(int id) {
        this.subLanguagesDAO.deleteById(id);
    }

    @Override
    public void updateSub(UpdateSubLanguageRequest updateSubLanguageRequest) {
        SubOfLanguages subOfLanguages=this.modelMapperManager.forRequest()
                .map(updateSubLanguageRequest,SubOfLanguages.class);

        this.subLanguagesDAO.save(subOfLanguages);
    }


    @Override
    public List<GetAllSubLanguagesResponse> getAllSubLanguagesResponses() {
        List<SubOfLanguages> subOfLanguages=this.subLanguagesDAO.findAll();

        List<GetAllSubLanguagesResponse> getAllSubLanguagesResponses1=subOfLanguages.stream()
                .map(sOf->this.modelMapperManager.forResponse().map(sOf,GetAllSubLanguagesResponse.class))
                .collect(Collectors.toList());

        return getAllSubLanguagesResponses1;
    }




}
