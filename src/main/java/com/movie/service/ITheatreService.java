package com.movie.service;

import com.movie.dto.request.TheatreRequest;
import com.movie.dto.request.UpdateCity;
import com.movie.dto.response.TheatreResponse;

import java.util.List;

public interface ITheatreService {
    TheatreResponse save(TheatreRequest movie);
    int updateMovie(TheatreRequest theatreRequest);
    TheatreResponse updateCity(UpdateCity movie);
    List<TheatreResponse> getMovieDetail(String cityName, String movieName, String showTime, String showDay);
}
