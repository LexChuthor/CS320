package contactService;

import java.util.*;

public class ContactService {

	private ArrayList<Contact> contactList;
	
	public ContactService() {
		contactList = new ArrayList();
	}
	
	private String genContactId() {
		String conid = UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
		return conid;
	}
	
	public void addContact(String first, String last, String num, String add) {
		Contact con = new Contact(genContactId(), first, last, num, add);
		contactList.add(con);
	}
	
	public Contact getContact(String conId) throws Exception {
		for( int i = 0; i < contactList.size(); i++) {
			if(conId.equals(contactList.get(i).getContactId())) {
				return contactList.get(i);
			}
		}
		throw new Exception("Contact not found");
	}
	
	public void deleteContact(String conId) throws Exception{
		contactList.remove(getContact(conId));
	}
	
	public void updateFirstName(String conId, String first) throws Exception{
		getContact(conId).setFirstName(first);
	}
	
	public void updateLastName(String conId, String last) throws Exception{
		getContact(conId).setLastName(last);
	}
	
	public void updatePhoneNumber(String conId, String num) throws Exception{
		getContact(conId).setPhoneNumber(num);
	}
	
	public void updateAddress(String conId, String add) throws Exception{
		getContact(conId).setAddress(add);
	}
	
	public List<Contact> getContactList(){return contactList;}
}
