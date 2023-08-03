package com.languages.ProgramminLanguages.Business.Abstract;

import com.languages.ProgramminLanguages.Business.Request.CreateProgrammingLanguageRequest;
import com.languages.ProgramminLanguages.Business.Request.CreateSubLanguageRequest;
import com.languages.ProgramminLanguages.Business.Request.UpdateProgrammingLanguageRequest;
import com.languages.ProgramminLanguages.Business.Response.GetAllProgrammingLanguagesWithSubLanguagesResponse;
import com.languages.ProgramminLanguages.Business.Response.GetAllProgrammingLangueagesResponse;
import com.languages.ProgramminLanguages.Business.Response.GetAllSubLanguagesResponse;
import com.languages.ProgramminLanguages.Business.Response.GetByIdProgrammingLangueagesResponse;
import com.languages.ProgramminLanguages.Entities.ProgrammingLanguages;

import java.util.List;

public abstract class ProgrammingLanguagesService {
    public abstract void delete(int id);
    public abstract List<GetAllProgrammingLangueagesResponse> getAll();
    public abstract GetByIdProgrammingLangueagesResponse getById(int id);
    public abstract void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest);
    public abstract void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest);


}
