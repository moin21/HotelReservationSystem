package com.hortelreservationsystem;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 * Class with Main method.
 * 
 * @author Moinuddin
 *
 */
public class HotelReservationMain {
	public static void main(String[] args) {
		System.out.println(" Welcome To Hotel Reservation System");
		/**
		 * Creating instance of Hotel Reservation - hotelReservation Calling method
		 * addHotel for this instance(hotelReservation) Calling method printHotelList to
		 * print created hotelList
		 */
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel();
		hotelReservation.addHotel();
		hotelReservation.addHotel();
		hotelReservation.printHotelList();
		/**
		 * Defining Start Date and End Date
		 */
		LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 10);
		LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 11);
		/**
		 * Calling method getCheapestBestRatedHotel with start and end dates as params
		 * Printing the result: Hotel name
		 */
		Hotel hotelName = hotelReservation.getCheapestBestRatedHotel(startDate, endDate);
		System.out.println("The cheapest hotel is : \n " + hotelName);
		/**
		 * Calling method get getBestRatedHotel with start and end dates as params
		 * Printing the result: bestRatedHotel
		 */
		Hotel bestRatedHotel = hotelReservation.getBestRatedHotel(startDate, endDate);
		System.out.println("The best rated hotel is : \n " + bestRatedHotel);
		/**
		 * Calling method getCheapestBestRatedHotelForRewardCustomer with start and end
		 * dates as params Printing the result: rewardHotelName
		 */
		ArrayList<Hotel> rewardHotelName = hotelReservation.getCheapestBestRateHotelForRewardCustomer(startDate,
				endDate);
		System.out.println("The cheapest hotel is : \n " + rewardHotelName);
	}
}
