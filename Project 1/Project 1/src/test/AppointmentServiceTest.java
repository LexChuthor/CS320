package test;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import appointmentService.AppointmentService;

public class AppointmentServiceTest {

	@SuppressWarnings("deprecation")
	public Date today = new Date(2022, Calendar.JUNE, 5);
	@SuppressWarnings("deprecation")
	public Date futureDate = new Date(2023, Calendar.JANUARY, 1);
	@SuppressWarnings("deprecation")
	public Date pastDate = new Date(2022, Calendar.JANUARY, 1);
	
	@Test
	void testAddAppointment() {
		AppointmentService service = new AppointmentService();
		service.addApointment(today, "appointment 1");
		assertNotNull(service.getAppList());
		assertEquals("appointment 1", service.getAppList().get(0).getDescription());
	}
	
	@Test
	void testGetAppointmentList() {
		AppointmentService service = new AppointmentService();
		service.addApointment(today, "appointment 1");
		assertNotNull(service.getAppList());
	}
	
	@Test
	void testFindAppointment() throws Exception {
		AppointmentService service = new AppointmentService();
		service.addApointment(today, "appointment 1");
		assertEquals("appointment 1", service.findAppointment(service.getAppList().get(0).getAppId()).getDescription());
	}
	
	@Test
	void testDeleteAppointment() throws Exception{
		AppointmentService service = new AppointmentService();
		service.addApointment(today, "appointment 1");
		service.deleteAppointment(service.getAppList().get(0).getAppId());
		assertEquals(0, service.getAppList().size());
	}
	


}
