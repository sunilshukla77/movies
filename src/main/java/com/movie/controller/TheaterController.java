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

/*
 * Theatres can create, update, and delete shows for the day.
 */
@CrossOrigin(origins = "http://localhost:9001")
@Slf4j
@RestController
@RequestMapping("/theatre")
public class TheaterController {

    @Autowired
    private TheatreService theater;

    @PostMapping(path = "/addMovie")
    public ResponseEntity<TheatreResponse> addMovieInTheater(@RequestBody TheatreRequest theatreRequest){
        log.info("Need to Add movie in theatre: {}, Movie Detail {} ",theatreRequest.getTheatreName(), theatreRequest);
        TheatreResponse theatreResponse=theater.save(theatreRequest);
        return new ResponseEntity<>(theatreResponse, HttpStatus.CREATED);
    }

    @PutMapping(path ="/updateCity")
    public ResponseEntity<TheatreResponse> updateMovieInTheatre(@RequestBody UpdateCity updateCity){
        log.info("Update city in theatre: {}, update Detail {} ",updateCity.getTheatreName(), updateCity);
        TheatreResponse theatreResponse = theater.updateCity(updateCity);
        return new ResponseEntity<>(theatreResponse, HttpStatus.OK);
    }

    @DeleteMapping(path = "/deleteMovie")
    public ResponseEntity deleteMovieInTheatre(@RequestParam String moviename, @RequestParam String theatreName){
        theater.deleteMovie(moviename, theatreName);
        return null;
    }


}
