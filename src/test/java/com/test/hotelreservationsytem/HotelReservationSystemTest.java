package com.test.hotelreservationsytem;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.hortelreservationsystem.Hotel;
import com.hortelreservationsystem.HotelReservation;

public class HotelReservationSystemTest {
	@Test
	public void givenHotelDetails_WhenCreated_ShouldReturnTrue() {
		HotelReservation hotelReservation = new HotelReservation();
		boolean result = hotelReservation.addHotel();
		Assert.assertEquals(true, result);
	}

	@Test
	public void givenHotelDetails_shouldReturnCheapestHotel() {

		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel();
		hotelReservation.addHotel();
		LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 10);
		LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 11);
		ArrayList<Hotel> hotelName = hotelReservation.getCheapestHotel(startDate, endDate);
		Assert.assertEquals("Lakewood", hotelName);
	}

	@Test
	public void givenHotelDetails_HotelPricesAreSame_shouldReturnHighestRatedHotel() {

		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel();
		hotelReservation.addHotel();
		LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 11);
		LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
		Hotel hotel = hotelReservation.getCheapestBestRatedHotel(startDate, endDate);
		Assert.assertEquals("Bridgewood", hotel.getHotelName());
	}
}
