package com.movie.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.movie.dto.request.MovieDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Accessors(chain = true)
@Setter
@Getter
@NoArgsConstructor
public class TheatreResponse implements Serializable {
    private static final long serialVersionUID = -4167846641836693299L;
    String theatreName;
    String cityName;
    List<String> movieName;
    List<MovieDto> movieDtoList;
}
