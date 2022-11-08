package com.movie.repository;

import com.movie.entity.TheatreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface TheatreRepository extends JpaRepository<TheatreEntity, Long> {

    //@Query(value = "Select * from Theatre t where t.id= ?1 and t.theatreName= ?2", nativeQuery = true)
    //void deleteByMovieName(@Param("movieName") String movieName, @Param("theatreName")String theatreName, @Param("showTime")String showTime);

    //@Query("SELECT t FROM TheatreEntity t inner join t.movies m WHERE t.cityName =:cityName and t.theatreName = :theatreName and m.movieName = :movieName")
    //Collection<TheatreEntity> findByTheatreNameAndMovieName(String cityName, String theatreName);

    List<TheatreEntity> findByTheatreName(String theaterName);

    Collection<TheatreEntity> findByCityName(String cityName);

    TheatreEntity findByCityNameAndTheatreName(String cityName, String theaterName);

    //@Query("select c from Customer c inner join c.orders o where c.id = :customerId and o.id = :orderId")
    //Optional<Customer> findCustomerByOrderId(long orderId, long customerId);


}
