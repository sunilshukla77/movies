package com.movie.type;

import lombok.Getter;

@Getter
public enum SeatType {
    SILVER(200),
    GOLD(300),
    PLATINUM(500);

    private final double price;

    SeatType(double price) {
        this.price = price;
    }
}
