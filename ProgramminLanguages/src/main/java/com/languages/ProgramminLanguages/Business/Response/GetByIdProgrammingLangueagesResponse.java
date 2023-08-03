package com.languages.ProgramminLanguages.Business.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdProgrammingLangueagesResponse {
    private int id;
    private String language;
    private boolean OOP;
}
