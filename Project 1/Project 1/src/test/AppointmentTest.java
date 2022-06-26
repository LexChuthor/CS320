package test;


import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import appointmentService.Appointment;
public class AppointmentTest {

	@SuppressWarnings("deprecation")
	public Date today = new Date(2022, Calendar.JUNE, 5);
	@SuppressWarnings("deprecation")
	public Date futureDate = new Date(2023, Calendar.JANUARY, 1);
	@SuppressWarnings("deprecation")
	public Date pastDate = new Date(2020, Calendar.JANUARY, 1);
	
	@Test
	void testGetAppId() {
		Appointment app = new Appointment("appId01", futureDate, "appointment 1");
		assertEquals("appId01", app.getAppId());
	}
	@Test
	void testGetAppDate() {
		Appointment app = new Appointment("appId01", futureDate, "appointment 1");
		assertEquals(futureDate, app.getappDate());
	}
	@Test
	void testGetDescription() {
		Appointment app = new Appointment("appId01", futureDate, "appointment 1");
		assertEquals("appointment 1", app.getDescription());
	}
	
	@Test
	void testSetAppDate() {
		Appointment app = new Appointment("appId01", futureDate, "appointment 1");
		app.setAppDate(futureDate);
		assertEquals(futureDate, app.getappDate());
	}
	
	@Test
	void testSetAppDescription() {
		Appointment app = new Appointment("appId01", futureDate, "appointment 1");
		app.setDescription("appointment 2");;
		assertEquals("appointment 2", app.getDescription());
	}
	
	@Test
	void testAppDatePast() {
		Appointment app = new Appointment("appId01", futureDate, "appointment 1");
		Assertions.assertThrows(IllegalArgumentException.class, ()-> app.setAppDate(pastDate));
	}
	
	@Test
	void testAppDateNull() {
		Assertions.assertThrows(Exception.class, ()-> new Appointment("appId01", null, "appointment 1"));

	}
	
	@Test
	void testAppDescLong() {
		Appointment app = new Appointment("appId01", futureDate, "appointment 1");
		assertThrows(IllegalArgumentException.class, ()-> app.setDescription("appointment 1, appointment 2, appointment 3, appointment 4, appointment 5"));
	}
	
	@Test
	void testAppDescNull() {
		Appointment app = new Appointment("appId01", futureDate, "appointment 1");
		assertThrows(IllegalArgumentException.class, ()-> app.setDescription(null));
	}
	
	
}
