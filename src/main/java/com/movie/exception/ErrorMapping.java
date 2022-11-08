package com.movie.exception;

import lombok.Getter;

@Getter
public enum ErrorMapping {
    BMS001("BMS001", "No theatre is present for given city"),
    BMS002("BMS002", "No theatre is present for given city and movie combination"),
    BMS003("BMS012", "Movie Name is either null/empty"),
    BMS004("BMS013", "Theatre Name is either null/empty"),
    BMS005("BMS014", "Show Time is either null/empty"),
    BMS006("BMS015", "Show Day is either null/empty"),
    BMS007("BMS018", "No seat left as per the user's seat combination request");

    private final String code;
    private final String message;

    ErrorMapping(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
