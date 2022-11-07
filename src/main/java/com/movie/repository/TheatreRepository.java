package com.movie.repository;

import com.movie.entity.TheatreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepository extends JpaRepository<TheatreEntity, Long> {
    boolean findAllByCityNameAndTheatreName(String cityName, String theatreName);
    boolean findAllByTheatreName(String theatreName);

    //@Query(value = "Select * from Theatre t where t.id= ?1 and t.theatreName= ?2", nativeQuery = true)
    //boolean findAllByTheatreIdAndTheatreName(Long id, String theatreName);
    //void deleteByMovieName(String movieName, String theatreName);
}
