package com.test.hotelreservationsytem;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import com.hortelreservationsystem.HotelReservation;

public class HotelReservationSystemTest {
	@Test
	public void givenHotelDetails_WhenCreated_ShouldReturnTrue() {
		HotelReservation hotelReservation = new HotelReservation();
		boolean result = hotelReservation.addHotel();
		Assert.assertEquals(true, result);
	}
}
