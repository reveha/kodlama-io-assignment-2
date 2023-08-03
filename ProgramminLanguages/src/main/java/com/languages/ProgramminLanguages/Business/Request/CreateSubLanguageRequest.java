package com.languages.ProgramminLanguages.Business.Request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSubLanguageRequest {


    private String name;
    private int pl_id;
}
