package com.pancakesunlimited.pancakesunlimited.models.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data
public class OrderPRequest {

    private String description;
    @NotNull
    private String time;

}
