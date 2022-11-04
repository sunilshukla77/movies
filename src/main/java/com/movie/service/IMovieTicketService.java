package com.movie.service;


import com.movie.dto.request.MovieTicketRequest;
import com.movie.dto.response.MovieTicketResponse;

public interface IMovieTicketService {
    MovieTicketResponse bookMovieTicket(MovieTicketRequest movieTicketRequest) throws Exception;
}
