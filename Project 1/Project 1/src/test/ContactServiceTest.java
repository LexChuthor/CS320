package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contactService.ContactService;

public class ContactServiceTest {

	@Test
	void testAddContact() {
		ContactService service = new ContactService();
		service.addContact("contact01",  "con01",  "8005556666",  "5555 Example Lane");
		Assertions.assertNotNull(service.getContactList().get(0).getContactId());
		Assertions.assertNotEquals("RandomId", service.getContactList().get(0).getContactId());
	}
	
	@Test
	void testAddContactNullFirst() {
		ContactService service = new ContactService();
		Assertions.assertThrows(IllegalArgumentException.class, ()->service.addContact(null,  "contact01",  "8005556666",  "5555 Example lane"));
	}
	@Test
	void testAddContactNullLast() {
		ContactService service = new ContactService();
		Assertions.assertThrows(IllegalArgumentException.class, ()->service.addContact("contact000001",  null,  "8005556666",  "5555 Example lane"));
	}
	
	@Test
	void testAddContactNullPhoneNum() {
		ContactService service = new ContactService();
		Assertions.assertThrows(IllegalArgumentException.class, ()->service.addContact("contact000001",  "contact01",  null,  "5555 Example lane"));
	}
	
	@Test
	void testAddContactNullAddress() {
		ContactService service = new ContactService();
		Assertions.assertThrows(IllegalArgumentException.class, ()->service.addContact("contact000001",  "contact01",  "8005556666",  null));
	}
	
	@Test
	void testAddContactLongFirst() {
		ContactService service = new ContactService();
		Assertions.assertThrows(IllegalArgumentException.class, ()->service.addContact("contact000001",  "contact01",  "8005556666",  "5555 Example lane"));
	}
	
	@Test
	void testAddContactLongLast() {
		ContactService service = new ContactService();
		Assertions.assertThrows(IllegalArgumentException.class, ()->service.addContact("contact01",  "contact0000001",  "8005556666",  "5555 Example lane"));
	}
	
	@Test
	void testAddContactLongPhoneNum() {
		ContactService service = new ContactService();
		Assertions.assertThrows(IllegalArgumentException.class, ()->service.addContact("contact000001",  "contact01",  "18005556666",  "5555 Example lane"));
	}
	
	@Test
	void testAddContactLongAddress() {
		ContactService service = new ContactService();
		Assertions.assertThrows(IllegalArgumentException.class, ()->service.addContact("contact000001",  "contact01",  "8005556666",  "5555 Example lane, 6666 Example Lane, VA"));
	}
	
	@Test
	void testDeleteContact() throws Exception{
		ContactService service = new ContactService();
		service.addContact("contact01",  "con01",  "8005556666",  "5555 Example Lane");
		assertEquals(1, service.getContactList().size());
		service.deleteContact(service.getContactList().get(0).getContactId());
		assertEquals(0, service.getContactList().size());
	}
	
	@Test
	void testDeleteMissingContact() throws Exception{
		ContactService service = new ContactService();
		service.addContact("contact01",  "con01",  "8005556666",  "5555 Example Lane");
		assertEquals(1, service.getContactList().size());
		assertThrows(Exception.class, ()-> service.deleteContact("randomId"));
		assertEquals(1, service.getContactList().size());
	}
	
	@Test
	void testUpdateFirstName() {
		ContactService service = new ContactService();
		service.addContact("contact01",  "con1",  "8005556666", "5555 Example Lane");
		service.getContactList().get(0).setFirstName("contact02");
		Assertions.assertEquals("contact02",  service.getContactList().get(0).getFirstName());
	}
	
	@Test
	void testUpdateLastName() {
		ContactService service = new ContactService();
		service.addContact("contact01",  "con1",  "8005556666", "5555 Example Lane");
		service.getContactList().get(0).setLastName("con02");
		Assertions.assertEquals("con02",  service.getContactList().get(0).getLastName());
	}
	
	@Test
	void testUpdatePhoneNumber() {
		ContactService service = new ContactService();
		service.addContact("contact01",  "con1",  "8005556666", "5555 Example Lane");
		service.getContactList().get(0).setPhoneNumber("8005557777");
		Assertions.assertEquals("8005557777",  service.getContactList().get(0).getPhoneNumber());
	}
	
	@Test
	void testUpdateAddress() {
		ContactService service = new ContactService();
		service.addContact("contact01",  "con1",  "8005556666", "5555 Example Lane");
		service.getContactList().get(0).setAddress("6666 Example Lane");
		Assertions.assertEquals("6666 Example Lane",  service.getContactList().get(0).getAddress());
	}
	
}
