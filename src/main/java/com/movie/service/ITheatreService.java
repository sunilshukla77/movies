package com.movie.service;

import com.movie.dto.response.AvailableSeatResponse;
import com.movie.dto.response.RunningShowResponse;
import com.movie.dto.response.TheatreResponse;

public interface ITheatreService {
    TheatreResponse getTheatresByCity(String cityName);
    TheatreResponse getTheatresByCityAndMovie(String cityName, String movieName);
    RunningShowResponse getShowsByTheatreAndCity(String theatreName, String cityName);
    AvailableSeatResponse getAvailableSeats(String cityName, String theatreName, String movieName, String showTime, String showDay);
}
