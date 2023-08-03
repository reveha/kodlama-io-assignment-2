package com.languages.ProgramminLanguages.Mapper;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    public ModelMapper forResponse();

    public ModelMapper forRequest();
}
