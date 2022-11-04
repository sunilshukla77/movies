package com.movie.dto.response;

import com.movie.type.SeatType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Setter
@Getter
@NoArgsConstructor
public class SeatInfo {
    private String seatName;
    private SeatType seatType;
}
