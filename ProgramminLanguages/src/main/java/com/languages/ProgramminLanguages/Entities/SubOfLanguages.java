package com.languages.ProgramminLanguages.Entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubOfLanguages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="SubOfName")
    private String name;

    @ManyToOne
    @JoinColumn(name = "programmingLanguages_id")
    private ProgrammingLanguages programmingLanguages;

}
