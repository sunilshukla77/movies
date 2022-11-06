package com.movie.service;

import com.movie.dto.request.TheatreRequest;
import com.movie.dto.request.UpdateCity;
import com.movie.dto.response.TheatreResponse;

public interface ITheatreService {
    TheatreResponse save(TheatreRequest movie);

    TheatreResponse updateCity(UpdateCity movie);
    void deleteMovie(String movieName, String theatreName);
}
