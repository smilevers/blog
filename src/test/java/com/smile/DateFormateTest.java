package com.smile;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author: smile
 * @Date: 2020/1/22
 */
public class DateFormateTest {
    
//    @JsonFormat( pattern = "yyyy年MM月dd日  HH:mm:ss" )
    @DateTimeFormat(pattern = "yyyy年MM月dd日")
    private LocalDate date;
    
    private String name;
    
    public DateFormateTest(LocalDate date, String name) {
        this.date = date;
        this.name = name;
    }
    
    
    public LocalDate getDate() {
        return date;
    }
    
    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "DateFormateTest{" +
                "date=" + date +
                ", name='" + name + '\'' +
                '}';
    }
}
