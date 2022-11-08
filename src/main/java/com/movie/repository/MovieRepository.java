package com.movie.repository;

import com.movie.entity.MovieEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<MovieEntity, Integer> {


    @Modifying
    void deleteById(Long id);
}
