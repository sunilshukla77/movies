package com.movie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name = "theatre")
public class TheatreEntity implements Serializable {
    private static final long serialVersionUID = -4486847918204156897L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theatre_id;

    @Column(name = "theatre_name")
    private String theatreName;

    @Column(name = "city_name")
    private String cityName;


    @OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY )
    private List<MovieEntity> movies;

    public TheatreEntity(String theatreName, String cityName) {
        this.theatreName = theatreName;
        this.cityName = cityName;
    }

    public TheatreEntity(Long id, String theatreName, String cityName) {
        this.theatre_id = id;
        this.theatreName = theatreName;
        this.cityName = cityName;
    }



}
