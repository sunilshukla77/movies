package com.movie.controller;

import com.movie.dto.request.MovieTicketRequest;
import com.movie.dto.response.MovieTicketResponse;
import com.movie.service.IMovieTicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@Validated
@RequestMapping("/bookmyshow")
public class MovieTicketController {

    private final IMovieTicketService bookMovieTicketService;

    public MovieTicketController(IMovieTicketService bookMovieTicketService) {
        this.bookMovieTicketService = bookMovieTicketService;
    }

    @PutMapping("/ext/v1/theatre/auditorium/movie/seats")
    public ResponseEntity<MovieTicketResponse> bookMovieTicket(
            @Valid @NotNull @RequestBody MovieTicketRequest movieTicketRequest) throws Exception {
        return ResponseEntity
                .accepted().body(bookMovieTicketService.bookMovieTicket(movieTicketRequest));
    }
}
