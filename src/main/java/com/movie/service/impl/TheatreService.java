package com.movie.service.impl;

import com.movie.dto.request.MovieDto;
import com.movie.dto.request.TheatreRequest;
import com.movie.dto.response.TheatreResponse;
import com.movie.entity.MovieEntity;
import com.movie.entity.TheatreEntity;
import com.movie.exception.ContentNotFoundException;
import com.movie.exception.ErrorMapping;
import com.movie.repository.MovieRepository;
import com.movie.repository.TheatreRepository;
import com.movie.service.ITheatreService;
import lombok.extern.slf4j.Slf4j;
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
    private MovieRepository movieRepository;

    @Override
    public TheatreResponse save(TheatreRequest theatreRequest) {
        TheatreResponse theatreResponse = saveTheatreResponse(theatreRequest);
        return theatreResponse;
    }

    @Override
    public int updateMovie(TheatreRequest theatreRequest) {
        TheatreEntity theatreEntity = theatreRepository.findByCityNameAndTheatreName(theatreRequest.getCityName(), theatreRequest.getTheatreName());
        List<MovieEntity> movieEntityList =null;
        for (MovieDto movieDto: theatreRequest.getMovies()) {
            movieEntityList = theatreEntity.getMovies().stream()
                    .filter(movieEntity -> movieDto.getMovieName().equalsIgnoreCase(movieEntity.getMovieName())
                            && movieDto.getShowDate().equalsIgnoreCase(movieEntity.getShowDate()))
                            //&& movieDto.getShowDate().equalsIgnoreCase(movieEntity.getMovieName()))
                    .collect(Collectors.toList());
            if(movieEntityList.size()>0) {
                for (MovieEntity m : movieEntityList) {
                    m.setAvailableSeat(movieDto.getAvailableSeat());
                    m.setShowTime(movieDto.getShowTime());
                    movieRepository.save(m);
                    log.info("Movie updated in database {}", m);
                }
            }else {
                throw new ContentNotFoundException(HttpStatus.BAD_REQUEST, ErrorMapping.BMS003);
            }
            log.info("Movie need to update {}", movieEntityList);
        }
        return movieEntityList.size();
    }

    private TheatreResponse saveTheatreResponse(TheatreRequest theatreRequest) {
        TheatreEntity theatreEntity = transformDtoToEntity(theatreRequest);
        log.info("Mapping in entity {}", theatreEntity);
        //Save data
        TheatreEntity theatreEntityEntityResponse = theatreRepository.save(theatreEntity);
        //Create Response
        TheatreResponse theatreResponse = new TheatreResponse();
        theatreResponse.setTheatreName(theatreEntityEntityResponse.getTheatreName());
        theatreResponse.setMovieName(theatreEntityEntityResponse.getMovies()
                .stream().map(m -> m.getMovieName()).collect(Collectors.toList()));
        return theatreResponse;
    }

    public void deleteMovie(String movieName, String theatreName, String showTime) {
        //theatreRepository.deleteByMovieName(movieName, theatreName, showTime);
    }

    @Override
    public List<TheatreResponse> getMovieDetail(String cityName, String movieName, String showTime, String showDay) {
        List<TheatreEntity> theaterList = theatreRepository.findByCityName(cityName).stream().collect(Collectors.toList());
        List<TheatreResponse> theatreResponseList = new ArrayList<>();
        TheatreResponse theatreResponse = new TheatreResponse();
        if (theaterList.isEmpty()) {
            for (TheatreEntity te : theaterList) {
                log.info("Theater {} /n/t/t/t ########", te);
                List<MovieEntity> movieEntityList = te.getMovies().stream()
                        .filter(movieEntity -> movieEntity.getMovieName().equalsIgnoreCase(movieName) && showDay.equalsIgnoreCase(movieEntity.getShowDate()))
                        .collect(Collectors.toList());
                log.info("Movie list {} /n/t/t/t *********", movieEntityList);
                if (movieEntityList.isEmpty()) {

                    List<MovieDto> movieDtoList = new ArrayList<>();
                    for (MovieEntity movieE : movieEntityList) {
                        MovieDto movieDto = new MovieDto();
                        movieDto.setMovieName(movieE.getMovieName());
                        movieDto.setShowDate(movieE.getShowDate());
                        movieDto.setShowTime(movieE.getShowTime());
                        movieDto.setAvailableSeat(movieE.getAvailableSeat());
                        movieDtoList.add(movieDto);
                    }
                    theatreResponse.setTheatreName(te.getTheatreName());
                    theatreResponse.setCityName(te.getCityName());
                    theatreResponse.setMovieDtoList(movieDtoList);
                    theatreResponseList.add(theatreResponse);
                } else {
                    throw new ContentNotFoundException(HttpStatus.NO_CONTENT, ErrorMapping.BMS002);
                }
            }
        } else {
            throw new ContentNotFoundException(HttpStatus.NO_CONTENT, ErrorMapping.BMS001);
        }
        return theatreResponseList;
    }


    private TheatreEntity transformDtoToEntity(TheatreRequest tr) {
        TheatreEntity te = new TheatreEntity(tr.getCityName(), tr.getTheatreName());
        List<MovieEntity> me = new ArrayList<>();
        for (MovieDto m : tr.getMovies()) {
            MovieEntity movieE = new MovieEntity(m.getMovieName(), m.getShowDate(), m.getShowTime(), m.getAvailableSeat(), te);
            me.add(movieE);
        }
        te.setMovies(me);
        return te;
    }
}

