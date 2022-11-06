package com.movie.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Accessors(chain = true)
@Getter
@NoArgsConstructor
public class MovieDto implements Serializable {

    private String movieName;
    private String showDate;
    private String showTime;
    private int availableSeat;


}
