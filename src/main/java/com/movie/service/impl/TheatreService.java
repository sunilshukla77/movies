package com.movie.service.impl;

import com.movie.dto.request.MovieDto;
import com.movie.dto.request.TheatreRequest;
import com.movie.dto.request.UpdateCity;
import com.movie.dto.response.TheatreResponse;
import com.movie.entity.MovieEntity;
import com.movie.entity.TheatreEntity;
import com.movie.exception.ContentNotFoundException;
import com.movie.exception.ErrorMapping;
import com.movie.repository.TheatreRepository;
import com.movie.service.ITheatreService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TheatreService implements ITheatreService {


    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    public TheatreResponse save(TheatreRequest theatreRequest) {

        TheatreResponse theatreResponse = saveTheatreResponse(theatreRequest);
        return theatreResponse;
    }

    private TheatreResponse saveTheatreResponse(TheatreRequest theatreRequest) {
        TheatreEntity theatreEntity = copyRequestToEntity(theatreRequest);
        log.info("Mapping in entity {}", theatreEntity);
        //Save data
        TheatreEntity theatreEntityEntityResponse =  theatreRepository.save(theatreEntity);
        //Create Response
        TheatreResponse theatreResponse = new TheatreResponse();
        theatreResponse.setTheatreName(theatreEntityEntityResponse.getTheatreName());
        theatreResponse.setMovieName(theatreEntityEntityResponse.getMovies()
                .stream().map(m->m.getMovieName()).collect(Collectors.toList()));
        return theatreResponse;
    }

    @Override
    public TheatreResponse updateCity(UpdateCity updateCity) {
        TheatreResponse theatreResponse = null;
        if(updateCity.getId()==2){
            TheatreEntity theatreEntity = new TheatreEntity(updateCity.getId(), updateCity.getTheatreName(), updateCity.getCityName());
            theatreRepository.save(theatreEntity);
            log.info("Mapping in Request {}", updateCity);
        }else {
            throw new ContentNotFoundException(HttpStatus.NO_CONTENT, ErrorMapping.BMS001);
        }
        return theatreResponse;
    }
    private TheatreEntity copyRequestToEntity(TheatreRequest tr) {
        TheatreEntity te= new TheatreEntity(tr.getCityName(), tr.getTheatreName());
        List<MovieEntity> me= new ArrayList<>();
        for (MovieDto m: tr.getMovies()) {
            MovieEntity movieE= new MovieEntity(m.getMovieName(),m.getShowDate(),m.getShowTime(), m.getAvailableSeat(),te);
            me.add(movieE);
        }
        te.setMovies(me);
        return te;
    }

    @Override
    public void deleteMovie(String movieName, String theatreName) {

        //theatreRepository.deleteByMovieName(movieName, theatreName);
    }
}

