package com.hortelreservationsystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;

/**
 * This class contains method to add hotel into hotel ArrayList
 * 
 * @author Moinuddin
 *
 */
public class HotelReservation {
	/**
	 * hotelName - Name of the hotel. rating - Rating of Hotel. regularCustomerRate
	 * - Rate for regular customers.
	 */
	String hotelName;
	int rating;
	double regularCustomerRate;
	Scanner sc = new Scanner(System.in);
	/**
	 * Creating ArrayList of Hotel named hotelList of Hotel type
	 */
	ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
	/**
	 * hotel - Instance (object) of Hotel Class
	 */
	Hotel hotel;

	/**
	 * Method to add new hotel to hotel list First Taking user input for Hotel Name,
	 * Rating and Regular Customer Rate. Than providing all the inputs to hotel
	 * object Calling inbuilt add method for array list to add new hotel to the
	 * hotelList. return - boolean value for addition of new Hotel to the ArrayList
	 * hotelList
	 */
	public boolean addHotel() {

		System.out.println("Enter hotel name:");
		hotelName = sc.next();
		System.out.println("Enter hotel rating:");
		rating = sc.nextInt();
		System.out.println("Enter regular customer rate:");
		regularCustomerRate = sc.nextDouble();
		hotel = new Hotel(hotelName, rating, regularCustomerRate);
		return hotelList.add(hotel);
	}

	/**
	 * Method to Print ArrayList hotelList
	 */
	public void printHotelList() {
		System.out.println(hotelList);
	}
	/**
	 * Method to find the cheapest hotel. 
	 * Using ChromoUnit to get the date
	 * Comparing the regular cost of the hotel using comparator and finding the cheapest hotel using .min
	 * @param startDate - Check in date to hotel
	 * @param endDate - Check out date from hotel
	 * @return -  Hotel with the cheapest rate: sortedHotelList
	 */
	public Hotel getCheapestHotel(LocalDate startDate, LocalDate endDate) {


		Optional<Hotel> sortedHotelList = hotelList.stream().min(Comparator.comparing(Hotel::getRegularCustomerRate));
		return sortedHotelList.get();
	}
}
