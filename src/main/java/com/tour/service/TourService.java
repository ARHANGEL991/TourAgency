package com.tour.service;

import com.tour.model.Tour;

import java.util.Date;
import java.util.List;

public interface TourService {


    Tour saveTour(Tour tour);

    Tour addNewTour(Tour tour);

    void deleteTour(Tour tour);

    void deleteTourById(long id);

    List<Tour> getToursByByDate(Date byDate);

    List<Tour> getToursByFromDate(Date fromDate);

    List<Tour> getToursByByDateAndFromDate(Date byDate, Date fromDate);

    List<Tour> getToursByStatus(Tour.TourStatus status);

    List<Tour> getAllTours();

    Tour getTourById(long id);

    void deleteAll();


}