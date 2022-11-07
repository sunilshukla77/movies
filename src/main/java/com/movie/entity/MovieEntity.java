package com.movie.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "MOVIE")
public class MovieEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "MOVIE_NAME")
    private String movieName;
    @Column(name = "SHOW_DATE")
    private String showDate;
    @Column(name = "SHOW_TIME")
    private String showTime;
    @Column(name = "AVAILABLE_SEAT")
    private int availableSeat;

    @ManyToOne
    @JoinColumn(name = "theatreId")
    @ToString.Exclude
    private TheatreEntity theatreEntity;

    public MovieEntity(String movieName, String showDate, String showTime, int availableSeat,TheatreEntity theatreEntity) {
        this.movieName = movieName;
        this.showDate = showDate;
        this.showTime = showTime;
        this.availableSeat = availableSeat;
        this.theatreEntity= theatreEntity;
    }

}
