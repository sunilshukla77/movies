package com.movie.controller;


import com.movie.dto.request.TheatreRequest;
import com.movie.dto.request.UpdateCity;
import com.movie.dto.response.TheatreResponse;
import com.movie.service.impl.TheatreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Theatres can create, update, and delete shows for the day.
 */
@CrossOrigin(origins = "http://localhost:9001")
@Slf4j
@RestController
@RequestMapping("/theatre")
public class TheaterController {

    @Autowired
    private TheatreService theatreService;

    @PostMapping(path = "/addMovie")
    public ResponseEntity<TheatreResponse> addMovieInTheater(@RequestBody TheatreRequest theatreRequest){
        log.info("Need to Add movie in theatre: {}, Movie Detail {} ",theatreRequest.getTheatreName(), theatreRequest);
        TheatreResponse theatreResponse= theatreService.save(theatreRequest);
        return new ResponseEntity<>(theatreResponse, HttpStatus.CREATED);
    }

    @PutMapping(path ="/updateCity")
    public ResponseEntity<TheatreResponse> updateCityInTheatre(@RequestBody UpdateCity updateCity){
        log.info("Update city in theatre: {}, update Detail {} ",updateCity.getTheatreName(), updateCity);
        TheatreResponse theatreResponse = theatreService.updateCity(updateCity);
        return new ResponseEntity<>(theatreResponse, HttpStatus.OK);
    }

    @PutMapping(path ="/updateMovie")
    public ResponseEntity<Integer> updateMovieInTheatre(@RequestBody TheatreRequest theatreRequest){
        log.info("Update Movie in theatre: {}, update Detail {} ",theatreRequest.getTheatreName(), theatreRequest);
        int moviesUpdated = theatreService.updateMovie(theatreRequest);
        return new ResponseEntity<>(moviesUpdated, HttpStatus.OK);
    }

    @DeleteMapping(path = "/deleteMovie")
    public ResponseEntity deleteShowFromTheatre(@RequestParam String moviename, @RequestParam String theatreName, @PathVariable("showTime") String showTime){
        theatreService.deleteMovie(moviename, theatreName, showTime);
        return null;
    }


    @GetMapping("/listTheater")
    public ResponseEntity<List<TheatreResponse>> getListOfTheaterDetail(@RequestParam("cityName") String cityName,
                                                        @RequestParam("movieName") String movieName,
                                                        @RequestParam("showTime") String showTime,
                                                        @RequestParam("showDay") String showDay) throws InstantiationException, IllegalAccessException {

        List<TheatreResponse> movies= theatreService.getMovieDetail(cityName,
                movieName, showTime, showDay);
        return ResponseEntity.ok().body(movies);
    }
}
