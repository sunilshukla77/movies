package com.movie.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;

@Accessors(chain = true)
@Getter
@NoArgsConstructor
public class UserInfo {
    @NotEmpty
    private String name;
    @NotEmpty
    private String email;
    @NotEmpty
    private String mobileNumber;
}