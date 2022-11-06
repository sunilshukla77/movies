package com.movie.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Accessors(chain = true)
@Getter
@NoArgsConstructor
public class UpdateCity implements Serializable {
    private static final long serialVersionUID = 1524680640404367184L;

    long id;
    String cityName;
    String theatreName;
}