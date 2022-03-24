package com.hortelreservationsystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

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
	double weekendRegularCustomerRate;
	double rewardCustomerRate;
	double weekendRewardCustomerRate;

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
		System.out.println("Enter regular customer rate on weekdays :");
		regularCustomerRate = sc.nextDouble();
		System.out.println("Enter regular customer rate on weekends :");
		weekendRegularCustomerRate = sc.nextDouble();
		System.out.println("Enter reward customer rate on weekdays :");
		rewardCustomerRate = sc.nextDouble();
		System.out.println("Enter reward customer rate on weekends :");
		weekendRewardCustomerRate = sc.nextDouble();
		hotel = new Hotel(hotelName, rating, regularCustomerRate, weekendRegularCustomerRate, rewardCustomerRate,
				weekendRewardCustomerRate);
		return hotelList.add(hotel);
	}

	/**
	 * Method to Print ArrayList hotelList
	 */
	public void printHotelList() {
		System.out.println(hotelList);
	}

	/**
	 * Method to find the cheapest hotel. Using ChromoUnit to get the dates Finding
	 * no. of weekdays and weekends using switch cases on DAY_OF_WEEK. Comparing the
	 * rate by formula(weekdays*week days rate)+(weekends*weekend rates)
	 * 
	 * @param startDate - Check in date to hotel
	 * @param endDate   - Check out date from hotel
	 * @return - Hotel with the cheapest rate: sortedHotelList
	 */
	public ArrayList<Hotel> getCheapestHotel(LocalDate startDate, LocalDate endDate) {

		int numberOfDays = (int) ChronoUnit.DAYS.between(startDate, endDate);
		int weekends = 0;

		while (startDate.compareTo(endDate) != 0) {
			switch (DayOfWeek.of(startDate.get(ChronoField.DAY_OF_WEEK))) {
			case SATURDAY:
				++weekends;
				break;
			case SUNDAY:
				++weekends;
				break;
			case FRIDAY:
				break;
			case MONDAY:
				break;
			case THURSDAY:
				break;
			case TUESDAY:
				break;
			case WEDNESDAY:
				break;
			default:
				break;
			}
		}
		/**
		 * Defining week days and weekends
		 */
		final int weekdaysNumber = numberOfDays - weekends;
		final int weekendsNumber = weekends;
		/**
		 * Calculating cheapest rate (weekdays*week days rate)+(weekends*weekend rates)
		 */
		final double cheapestPrice = hotelList.stream()
				.mapToDouble(hotel -> ((hotel.getWeekendRegularCustomerRate() * weekendsNumber)
						+ hotel.getRegularCustomerRate() * weekdaysNumber))
				.min().orElse(Double.MAX_VALUE);
		/**
		 * Filtering and collecting hotel with cheapest rate
		 */
		ArrayList<Hotel> cheapestHotel = hotelList.stream()
				.filter(hotel -> (hotel.getWeekendRegularCustomerRate() * weekendsNumber
						+ hotel.getRegularCustomerRate() * weekdaysNumber) == cheapestPrice)
				.collect(Collectors.toCollection(ArrayList::new));

		if (cheapestPrice != Double.MAX_VALUE) {

			System.out.println(
					"Cheapest Hotel : \n" + cheapestHotel.get(0).getHotelName() + ", Total Rates: " + cheapestPrice);
			return cheapestHotel;
		}
		return null;
	}

	/**
	 * Creating arrayList of cheapest hotels by calling getCheapestHotel method:
	 * cheapestHotels Now filter this arraylist with max rating. Print the Hotel:
	 * SortedHotelList
	 * 
	 * @param startDate - Check in date to hotel
	 * @param endDate   - Check out date from hotel
	 * @return - Hotel with the cheapest rate and best rate: sortedHotelList
	 */
	public Hotel getCheapestBestRatedHotel(LocalDate startDate, LocalDate endDate) {

		ArrayList<Hotel> cheapestHotels = getCheapestHotel(startDate, endDate);
		Optional<Hotel> sortedHotelList = hotelList.stream().max(Comparator.comparing(Hotel::getRating));
		System.out.println("Cheapest Best Rated Hotel : \n" + sortedHotelList.get().getHotelName());
		return sortedHotelList.get();
	}

	/**
	 * Method to find best rated hotel Using stream .max method to find Hotel with
	 * best rating.
	 * 
	 * @param startDate - Check in date to hotel
	 * @param endDate   - Check out date from hotel
	 * @return - Hotel with the best rating: sortedHotelList
	 */
	public Hotel getBestRatedHotel(LocalDate startDate, LocalDate endDate) {

		Optional<Hotel> sortedHotelList = hotelList.stream().max(Comparator.comparing(Hotel::getRating));
		return sortedHotelList.get();
	}

	/**
	 * Method to find the cheapest hotel for reward customer. Using ChromoUnit to
	 * get the dates Finding no. of weekdays and weekends using switch cases on
	 * DAY_OF_WEEK. Comparing the rate by formula(weekdays*week days
	 * rate)+(weekends*weekend rates)
	 * 
	 * @param startDate - Check in date to hotel
	 * @param endDate   - Check out date from hotel
	 * @return - Hotel with the cheapest rate: sortedHotelList
	 */
	public ArrayList<Hotel> getCheapestBestRateHotelForRewardCustomer(LocalDate startDate, LocalDate endDate) {

		int numberOfDays = (int) ChronoUnit.DAYS.between(startDate, endDate);
		int weekends = 0;

		while (startDate.compareTo(endDate) != 0) {
			switch (DayOfWeek.of(startDate.get(ChronoField.DAY_OF_WEEK))) {
			case SATURDAY:
				++weekends;
				break;
			case SUNDAY:
				++weekends;
				break;
			case FRIDAY:
				break;
			case MONDAY:
				break;
			case THURSDAY:
				break;
			case TUESDAY:
				break;
			case WEDNESDAY:
				break;
			default:
				break;
			}
		}
		/**
		 * Defining week days and weekends
		 */
		final int weekdaysNumber = numberOfDays - weekends;
		final int weekendsNumber = weekends;
		/**
		 * Calculating cheapest rate (weekdays*week days rate)+(weekends*weekend rates)
		 */
		final double cheapestPrice = hotelList.stream()
				.mapToDouble(hotel -> ((hotel.getWeekendRewardCustomerRate() * weekendsNumber)
						+ hotel.getRewardCustomerRate() * weekdaysNumber))
				.min().orElse(Double.MAX_VALUE);
		/**
		 * Filtering and collecting hotel with cheapest rate
		 */
		ArrayList<Hotel> cheapestHotel = hotelList.stream()
				.filter(hotel -> (hotel.getWeekendRewardCustomerRate() * weekendsNumber
						+ hotel.getRewardCustomerRate() * weekdaysNumber) == cheapestPrice)
				.collect(Collectors.toCollection(ArrayList::new));

		if (cheapestPrice != Double.MAX_VALUE) {

			System.out.println(
					"Cheapest Hotel : \n" + cheapestHotel.get(0).getHotelName() + ", Total Rates: " + cheapestPrice);
			return cheapestHotel;
		}
		return null;
	}
}
