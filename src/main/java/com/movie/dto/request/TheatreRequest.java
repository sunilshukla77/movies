package com.movie.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Accessors(chain = true)
@Getter
@NoArgsConstructor
public class TheatreRequest implements Serializable {
    private static final long serialVersionUID = 1524680640404367184L;

    String cityName;
    String theatreName;
    private List<MovieDto> movies;
}
