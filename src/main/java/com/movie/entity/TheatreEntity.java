package com.movie.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "theatre")
public class TheatreEntity implements Serializable {
    private static final long serialVersionUID = -4486847918204156897L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theatreId;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "theatre_name")
    private String theatreName;

    @OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY )
    private List<MovieEntity> movies;

    public TheatreEntity(String cityName, String theatreName) {
        this.theatreName = theatreName;
        this.cityName = cityName;
    }

    public TheatreEntity(Long id, String cityName, String theatreName) {
        this.theatreId = id;
        this.theatreName = theatreName;
        this.cityName = cityName;
    }



}
