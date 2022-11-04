package com.movie.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Accessors(chain = true)
@Getter
@NoArgsConstructor
public class TheatreInfo {
    @NotEmpty
    private String cityName;
    @NotEmpty
    private String theatreName;
    @NotEmpty
    private String movieName;
    @NotEmpty
    private String showDay;
    @NotEmpty
    private String showTime;
    @NotNull
    private List<String> requestedSeatList;
}
