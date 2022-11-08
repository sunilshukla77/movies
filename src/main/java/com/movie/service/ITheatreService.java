package com.movie.service;

import com.movie.dto.request.TheatreRequest;
import com.movie.dto.response.TheatreResponse;

import java.util.List;

public interface ITheatreService {
    TheatreResponse save(TheatreRequest movie);
    int updateMovie(TheatreRequest theatreRequest);
    List<TheatreResponse> getMovieDetail(String cityName, String movieName, String showTime, String showDay);
    public int deleteMovie(TheatreRequest theatreRequest);
}
