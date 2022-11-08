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

    @Override
    public TheatreResponse save(TheatreRequest theatreRequest) {
        TheatreResponse theatreResponse = saveTheatreResponse(theatreRequest);
        return theatreResponse;
    }

    @Override
    public int updateMovie(TheatreRequest theatreRequest) {
        //TheatreEntity theatreEntity = theatreRepository.findByTheatreNameAndMovieName(theatreRequest.getCityName(), theatreRequest.getCityName());

        return 0;
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

    @Override
    public TheatreResponse updateCity(UpdateCity updateCity) {
        TheatreResponse theatreResponse = null;

        if (updateCity.getId() == 2) {
            TheatreEntity theatreEntity = new TheatreEntity(updateCity.getId(), updateCity.getCityName(), updateCity.getTheatreName());
            theatreRepository.save(theatreEntity);
            log.info("Mapping in Request {}", updateCity);
        } else {
            throw new ContentNotFoundException(HttpStatus.NO_CONTENT, ErrorMapping.BMS001);
        }
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
        if(theaterList.isEmpty()) {
            for (TheatreEntity te : theaterList) {
                log.info("Theater {} /n/t/t/t ########", te);
                List<MovieEntity> movieEntityList = te.getMovies().stream()
                        .filter(movieEntity -> movieEntity.getMovieName().equalsIgnoreCase(movieName) && showDay.equalsIgnoreCase(movieEntity.getShowDate()))
                        .collect(Collectors.toList());
                log.info("Movie list {} /n/t/t/t *********", movieEntityList);

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

