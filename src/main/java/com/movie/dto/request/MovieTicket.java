package com.movie.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@NoArgsConstructor
public class MovieTicket {
    private UserInfo userInfo;
    private TheatreInfo theatreInfo;
    //private PaymentType paymentType;
}
