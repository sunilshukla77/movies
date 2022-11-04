package com.movie.service;

import com.movie.dto.response.AvailableSeatResponse;
import com.movie.dto.response.RunningShowResponse;
import com.movie.dto.response.TheatreResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class TheatreService implements ITheatreService{
    /**
     * @param cityName get detail of theatre for specific city
     * @return TheatreResponse
     */
    @Override
    public TheatreResponse getTheatresByCity(String cityName) {
        TheatreResponse theatreResponse = new TheatreResponse().setTheatres(Stream.of("PVR", "INOX").collect(Collectors.toList()));
        log.info("List of Theater {} by city {}", theatreResponse, cityName);
        return theatreResponse;
    }

    @Override
    public TheatreResponse getTheatresByCityAndMovie(String cityName, String movieName) {

        TheatreResponse theatreResponse = new TheatreResponse().setTheatres(Stream.of("PVR", "INOX").collect(Collectors.toList()));
        log.info("List of Theater By City And Movie {}", theatreResponse);
        return theatreResponse;
    }

    @Override
    public RunningShowResponse getShowsByTheatreAndCity(String theatreName, String cityName) {
        log.info("Get Shows By Theatre and City ");
        return null;
    }

    @Override
    public AvailableSeatResponse getAvailableSeats(String cityName, String theatreName, String movieName, String showTime, String showDay) {
        log.info("Available Seats {} By City And Movie {}", "100");
        return null;
    }
}

