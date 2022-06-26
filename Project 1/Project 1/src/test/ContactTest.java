package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contactService.Contact;

public class ContactTest {

	//getters
	@Test
	void testGetContactId() {
		Contact contact = new Contact("contact001", "contact01", "con1", "8005556666", "5555 Example Lane");
		Assertions.assertEquals("contact001",  contact.getContactId());
	}
	@Test
	void testGetFirstName() {
		Contact contact = new Contact("contact001", "contact01", "con1", "8005556666", "5555 Example Lane");
		Assertions.assertEquals("contact01",  contact.getFirstName());
	}
	@Test
	void testGetLastName() {
		Contact contact = new Contact("contact001", "contact01", "con1", "8005556666", "5555 Example Lane");
		Assertions.assertEquals("con1",  contact.getLastName());
	}
	@Test
	void testGetPhoneNumber() {
		Contact contact = new Contact("contact001", "contact01", "con1", "8005556666", "5555 Example Lane");
		Assertions.assertEquals("8005556666",  contact.getPhoneNumber());
	}
	@Test
	void testGetAddress() {
		Contact contact = new Contact("contact001", "contact01", "con1", "8005556666", "5555 Example Lane");
		Assertions.assertEquals("5555 Example Lane",  contact.getAddress());
	}
	//setters
	@Test
	void testSetFirstName() {
		Contact contact = new Contact("contact001", "contact01", "con1", "8005556666", "5555 Example Lane");
		contact.setFirstName("contact02");
		Assertions.assertEquals("contact02",  contact.getFirstName());
	}
	
	@Test
	void testSetLastName() {
		Contact contact = new Contact("contact001", "contact01", "con1", "8005556666", "5555 Example Lane");
		contact.setLastName("con02");
		Assertions.assertEquals("con02",  contact.getLastName());
	}
	@Test
	void testSetPhoneNumber() {
		Contact contact = new Contact("contact001", "contact01", "con1", "8005556666", "5555 Example Lane");
		contact.setPhoneNumber("8005557777");
		Assertions.assertEquals("8005557777",  contact.getPhoneNumber());
	}
	@Test
	void testSetAddress() {
		Contact contact = new Contact("contact001", "contact01", "con1", "8005556666", "5555 Example Lane");
		contact.setAddress("6666 Example Lane");
		Assertions.assertEquals("6666 Example Lane",  contact.getAddress());
	}
	
	//nulls
	@Test
	void testNullId() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> new Contact(null, "contact01", "con1", "8005556666", "5555 Example Lane"));
	}
	@Test
	void testNullFirstName() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> new Contact("contact001", null, "con1", "8005556666", "5555 Example Lane"));
	}
	@Test
	void testNullLastName() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> new Contact("contact001", "contact01", null, "8005556666", "5555 Example Lane"));
	}
	@Test
	void testPhoneNumber() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> new Contact("contact001", "contact01", "con1", null, "5555 Example Lane"));
	}
	@Test
	void testNullAddress() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> new Contact("contact001", "contact01", "con1", "8005556666", null));
	}
	
	//too long
	@Test
	void testLongId() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> new Contact("contact000001", "contact01", "con1", "8005556666", "5555 Example Lane"));
	}
	@Test
	void testLongFirstName() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> new Contact("contact001", "contact00000001", "con1", "8005556666", "5555 Example Lane"));
	}
	@Test
	void testLongLastName() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> new Contact("contact001", "contact01", "con1_toolong", "8005556666", "5555 Example Lane"));
	}
	@Test
	void testLongPhoneNumber() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> new Contact("contact001", "contact01", "con1", "18005556666", "5555 Example Lane"));
	}
	@Test
	void testLongAddress() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> new Contact("contact001", "contact01", "con1", "8005556666", "5555 Example Lane, 1111 Example Lane, VA"));
	}
	
	
}
