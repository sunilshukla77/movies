package com.movie.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.*;

@Accessors(chain = true)
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "theatre")
public class Theatre {
    private static final long serialVersionUID = -4486847918204156897L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "theatre_name")
    @NaturalId
    private String name;

   // @ManyToMany(mappedBy = "theatres")
   // private Set<City> cities = new HashSet<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Theatre )) return false;
        return id != null && id.equals(((Theatre) o).getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
