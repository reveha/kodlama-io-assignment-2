package com.languages.ProgramminLanguages.Business.Response;


import com.languages.ProgramminLanguages.Entities.SubOfLanguages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProgrammingLangueagesResponse {

    private int id;
    private String language;
    private boolean OOP;


}
