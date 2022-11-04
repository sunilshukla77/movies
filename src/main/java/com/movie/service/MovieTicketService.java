package com.movie.service;

import com.movie.dto.request.MovieTicketRequest;
import com.movie.dto.response.MovieTicketResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MovieTicketService implements IMovieTicketService {
    @Override
    public MovieTicketResponse bookMovieTicket(MovieTicketRequest movieTicketRequest) throws Exception {
        return null;
    }
//    private final BookShowSeatRepository bookShowSeatRepository;
//    private final UserRepository userRepository;
//    private final TicketRepository ticketRepository;
}
