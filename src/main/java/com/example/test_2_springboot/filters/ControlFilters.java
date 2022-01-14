package com.example.test_2_springboot.filters;

import inactiveClasses.DateTest;

import java.util.Date;

public interface ControlFilters {

    public abstract void addData(String date, String name, double temp, double feels_like, double temp_max, double temp_min);

    public abstract void checkData(String date);
}
