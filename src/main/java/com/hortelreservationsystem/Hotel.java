package com.hortelreservationsystem;

public class Hotel {
	/**
	 * hotelName - Name of the hotel. rating - Rating of Hotel. regularCustomerRate
	 * - Rate for regular customers. weekendRegularCustomerRate - Rate for regular
	 * customers on weekend.
	 */
	private String hotelName;
	private int rating;
	private double regularCustomerRate;
	private double weekendRegularCustomerRate;
	private double rewardCustomerRate;
	private double weekendRewardCustomerRate;

	/**
	 * Default Constructor
	 */
	public Hotel() {
	}

	/**
	 * Constructor
	 * 
	 * @param hotelName                  - Name of the hotel.
	 * @param rating                     - Rating for the hotel.
	 * @param regularCustomerRate        - Rate for regular customers on weekdays.
	 * @param weekendRegularCustomerRate - Rate for regular customer on weekends.
	 * @param rewardCustomerRate         - Rate for reward customers on weekdays.
	 * @param weekendRewardCustomerRate  - Rate for reward customers on weekends.
	 */
	public Hotel(String hotelName, int rating, double regularCustomerRate, double weekendRegularCustomerRate,
			double rewardCustomerRate, double weekendRewardCustomerRate) {
		this.hotelName = hotelName;
		this.rating = rating;
		this.regularCustomerRate = regularCustomerRate;
		this.weekendRegularCustomerRate = weekendRegularCustomerRate;
		this.rewardCustomerRate = rewardCustomerRate;
		this.weekendRewardCustomerRate = weekendRewardCustomerRate;
	}

	/**
	 * Getters and Setters for hotelName, rating and regualrCustomerRate,
	 * weekendRegularCustomerRate, rewardCustomerRate, weekendRewardCustomerRate
	 * 
	 */
	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRating() {
		return rating;
	}

	public void setRate(int rating) {
		this.rating = rating;
	}

	public double getRegularCustomerRate() {
		return regularCustomerRate;
	}

	public void setRegularCustomerRate(double regularCustomerRate) {
		this.regularCustomerRate = regularCustomerRate;
	}

	public double getWeekendRegularCustomerRate() {
		return weekendRegularCustomerRate;
	}

	public void setWeekendRegularCustomerRate(double weekendRegularCustomerRate) {
		this.weekendRegularCustomerRate = weekendRegularCustomerRate;
	}

	public double getRewardCustomerRate() {
		return rewardCustomerRate;
	}

	public void setRewardCustomerRate(double rewardCustomerRate) {
		this.rewardCustomerRate = rewardCustomerRate;
	}

	public double getWeekendRewardCustomerRate() {
		return weekendRewardCustomerRate;
	}

	public void setWeekendRewardCustomerRate(double weekendRewardCustomerRate) {
		this.weekendRewardCustomerRate = weekendRewardCustomerRate;
	}

	/**
	 * toSring Method to make list of hotels to String form for printing.
	 */
	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", rating=" + rating + ", regularCustomerRate=" + regularCustomerRate
				+ ", weekendRegularCustomerRate=" + weekendRegularCustomerRate + ", rewardCustomerRate="
				+ rewardCustomerRate + ", weekendRewardCustomerRate=" + weekendRewardCustomerRate + "]";
	}

}