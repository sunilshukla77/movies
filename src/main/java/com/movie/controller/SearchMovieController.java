package com.movie.controller;

import com.movie.dto.response.MovieDetailResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
Browse theatres currently running the show (movie selected) in the town,
including show timing by a chosen date
 */
@Slf4j
@RestController
@RequestMapping("/search")
public class SearchMovieController {



    @GetMapping("/cities/{cityName}/theatres/{theatreName}/movies/{movieName}/shows/{showTime}/showDays/{showDay}/seats")
    public ResponseEntity<MovieDetailResponse> getAvailableSeats(@PathVariable("cityName") String cityName,
                                                                 @PathVariable("movieName") String movieName,
                                                                 @PathVariable("showTime") String showTime,
                                                                 @PathVariable("showDay") String showDay) throws InstantiationException, IllegalAccessException {

        //Validation Layer
        //ValidationUtility.validate(servletRequest);

        /*return ResponseEntity
                .ok().body(theatreService.getAvailableSeats(cityName.toUpperCase(), theatreName.toUpperCase(),
                        movieName.toUpperCase(), showTime.toUpperCase(), showDay));*/

        return null;
    }

}