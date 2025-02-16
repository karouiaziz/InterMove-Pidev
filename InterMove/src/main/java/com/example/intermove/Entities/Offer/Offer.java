package com.example.intermove.Entities.Offer;

import com.example.intermove.Entities.CandidatesAndCourses.Candidacy;
import com.example.intermove.Entities.CandidatesAndCourses.Tags;
import com.example.intermove.Entities.Domain;
import com.example.intermove.Entities.User.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Offer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idoffre;
    private String titre;
    private String description ;
    private Date datedebut ;
    private Date datefin ;
    private Boolean historique;
    private Boolean restaurer;


    @Enumerated(EnumType.STRING)
    Domain domain;
    @OneToMany(mappedBy="offers")
    @JsonIgnore
    private Set<User> user;
    @OneToMany(mappedBy = "offer",cascade = CascadeType.ALL )
    List<Candidacy> candidacies;

    @ManyToMany
    List<Tags> tags;


}
