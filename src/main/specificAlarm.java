package main;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.*;

/**
The alarm will compare values between current* and set*. The values of current* will be set by
 the system time, and will be compared to the set time.
 If the current time matches the set time, the alarm will go off
 **/
public class specificAlarm extends Alarm {
    int currentYear, currentMonth, currentDay, currentHour, currentMinute, currentSecond;


    LocalDateTime timepoint = LocalDateTime.now();


    public specificAlarm(){
    }


    public int getCurrentYear(){
        int year = timepoint.getYear();
        currentYear = year;
        return currentYear;
    }
    public void setCurrentYear(int year){
        this.currentYear = year;
    }

    public int getCurrentMonth(){
        int month = timepoint.getMonthValue();
        return month;
    }
    public void setCurrentMonth(int month){
        this.currentMonth = month;
    }

    public int getCurrentDay(){
        int day = timepoint.getDayOfMonth();
        return day;
    }
    public void setCurrentDay(int day){
        this.currentDay = day;
    }

    public int getCurrentHour(){
        int hour = timepoint.getHour();
        return hour;
    }
    public void setCurrentHour(int time) {
        this.currentTime = time;
    }

    public int getCurrentMinute(){
        int minute = timepoint.getMinute();
        return minute;
    }
    public void setCurrentMinute(int minute){
        this.currentMinute = minute;
    }

    public int getCurrentSecond(){
        int second = timepoint.getSecond();
        return second;
    }
    public void setCurrentSecond(int second){
        this.currentSecond = second;
    }

    public static void main(String[] args) {
        specificAlarm alarm = new specificAlarm();

        System.out.println(alarm.getCurrentYear());
        System.out.println(alarm.getCurrentMonth());
        System.out.println(alarm.getCurrentDay());
        System.out.println(alarm.getCurrentHour());
        System.out.println(alarm.getCurrentMinute());
        System.out.println(alarm.getCurrentSecond());

    }
}
