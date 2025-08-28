package com.example.rebound.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@ToString
@NoArgsConstructor
public class ChartDTO {
    String year;
    String month;
    int yearCount;
    int monthCount;
    int subscribeYearCount;
    int subscribeMonthCount;
    int postByYearCount;
    int postByMonthCount;
}
