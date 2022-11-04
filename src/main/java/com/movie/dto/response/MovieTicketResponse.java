package com.movie.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.movie.type.BookStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Accessors(chain = true)
@Setter
@Getter
@NoArgsConstructor
public class MovieTicketResponse implements Serializable {
    private static final long serialVersionUID = -4251977775679179922L;

    private String ticketId;
    private BookStatus bookStatus;
}
