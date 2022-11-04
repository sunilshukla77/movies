package com.movie.controller;

import com.movie.dto.response.AvailableSeatResponse;
import com.movie.dto.response.RunningShowResponse;
import com.movie.dto.response.TheatreResponse;
import com.movie.service.TheatreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/movies")
public class MoviesController{

    @Autowired
    TheatreService theatreService;

    @GetMapping("/cities/{cityName}")
    public ResponseEntity<TheatreResponse> getTheatresByCity(@PathVariable("cityName") String cityName) throws InstantiationException, IllegalAccessException {
        //Validation Layer
        //ValidationUtility.validate(servletRequest);

        return ResponseEntity
                .ok().body(theatreService.getTheatresByCity(cityName.toUpperCase()));
    }

    @GetMapping("/cities/{cityName}/movies/{movieName}")
    public ResponseEntity<TheatreResponse> getTheatresByCityAndMovie(@PathVariable("cityName") String cityName,
                                                                     @PathVariable("movieName") String movieName) throws InstantiationException, IllegalAccessException {
        //Validation Layer
        //ValidationUtility.validate(servletRequest);

        return ResponseEntity
                .ok().body(theatreService.getTheatresByCityAndMovie(cityName.toUpperCase(), movieName.toUpperCase()));
    }

    @GetMapping("/cities/{cityName}/theatres/{theatreName}")
    public ResponseEntity<RunningShowResponse> getShowsByTheatreAndCity(@PathVariable("cityName") String cityName,
                                                                        @PathVariable("theatreName") String theatreName) throws InstantiationException, IllegalAccessException {
        //Validation Layer
        //ValidationUtility.validate(servletRequest);

        return ResponseEntity
                .ok().body(theatreService.getShowsByTheatreAndCity(theatreName.toUpperCase(), cityName.toUpperCase()));
    }

    @GetMapping("/cities/{cityName}/theatres/{theatreName}/movies/{movieName}/shows/{showTime}/showDays/{showDay}/seats")
    public ResponseEntity<AvailableSeatResponse> getAvailableSeats(@PathVariable("cityName") String cityName,
                                                                   @PathVariable("theatreName") String theatreName,
                                                                   @PathVariable("movieName") String movieName,
                                                                   @PathVariable("showTime") String showTime,
                                                                   @PathVariable("showDay") String showDay) throws InstantiationException, IllegalAccessException {

        //Validation Layer
        //ValidationUtility.validate(servletRequest);

        return ResponseEntity
                .ok().body(theatreService.getAvailableSeats(cityName.toUpperCase(), theatreName.toUpperCase(),
                        movieName.toUpperCase(), showTime.toUpperCase(), showDay));
    }

}