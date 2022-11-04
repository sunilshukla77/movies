package com.movie.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Accessors(chain = true)
@Setter
@Getter
@NoArgsConstructor
public class TicketInfo {
    private String theatreName;
    private String movieName;
    private String auditoriumName;
    private String ticketId;
    private double ticketAmount;
    private String showDay;
    private String showTime;
    private List<SeatInfo> seatInfoList;
}
