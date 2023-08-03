package com.languages.ProgramminLanguages.Business.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProgrammingLanguageRequest {
    private int id;
    private String language;
    private boolean OOP;
    private int userNumber;


}
