package com.languages.ProgramminLanguages.Entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammingLanguages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="NameOfLanguage")
    private String language;

    @Column(name="OOP or NOT")
    private Boolean OOP;

    @Column(name="UserNumber")
    private int userNumber;

    @OneToMany(mappedBy = "programmingLanguages")
    private List<SubOfLanguages> subOfLanguages;
}
