package com.movie.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Accessors(chain = true)
@Getter
@ToString
@NoArgsConstructor
public class UpdateCity implements Serializable {
    private static final long serialVersionUID = 1524680640404367184L;

    Long id;
    String cityName;
    String theatreName;
}