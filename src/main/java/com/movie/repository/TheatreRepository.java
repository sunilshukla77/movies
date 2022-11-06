package com.movie.repository;

import com.movie.entity.TheatreEntity;
import org.springframework.data.repository.CrudRepository;

public interface TheatreRepository extends CrudRepository<TheatreEntity, Long> {
    //boolean findAllByCityNameAndTheatreName(String cityName, String theatreName);

    //boolean findAllByTheatreName(String theatreName);

    //boolean findAllByIdAndTheatreName(Long id, String theatreName);
    //void deleteByMovieName(String movieName, String theatreName);
}
