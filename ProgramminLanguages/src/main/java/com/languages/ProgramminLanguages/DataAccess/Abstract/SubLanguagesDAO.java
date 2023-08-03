package com.languages.ProgramminLanguages.DataAccess.Abstract;

import com.languages.ProgramminLanguages.Entities.SubOfLanguages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubLanguagesDAO extends JpaRepository<SubOfLanguages, Integer> {

}
