package com.languages.ProgramminLanguages.Business.Abstract;

import com.languages.ProgramminLanguages.Business.Request.CreateSubLanguageRequest;
import com.languages.ProgramminLanguages.Business.Request.UpdateSubLanguageRequest;
import com.languages.ProgramminLanguages.Business.Response.GetAllProgrammingLanguagesWithSubLanguagesResponse;
import com.languages.ProgramminLanguages.Business.Response.GetAllSubLanguagesResponse;

import java.util.List;

public abstract class SubLanguagesService {
    public abstract void addSub(CreateSubLanguageRequest createSubLanguageRequest);

    public abstract void deleteSub(int id);

    public abstract void updateSub(UpdateSubLanguageRequest updateSubLanguageRequest);

    public abstract List<GetAllSubLanguagesResponse> getAllSubLanguagesResponses();



}
