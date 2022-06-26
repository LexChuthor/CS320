package contactService;

public class Contact {

		private final String contactId;
		private String firstName;
		private String lastName;
		private String phoneNumber;
		private String address;
		
		//getters
		public String getContactId() {
			return this.contactId;
		}
		
		public String getFirstName() {
			return this.firstName;
		}
		
		public String getLastName() {
			return this.lastName;
		}
		
		public String getPhoneNumber() {
			return this.phoneNumber;
		}
		
		public String getAddress() {
			return this.address;
		}
		
		//setters
		public void setFirstName(String first) {
			if (first == null || first.length() > 10) {
				throw new IllegalArgumentException("First Name cannot be null or greater than 10 characters");
			} else {
				this.firstName = first;
			}
		}
		
		public void setLastName(String last) {
			if (last == null ||last.length() > 10) {
				throw new IllegalArgumentException("Last Name cannot be null or greater than 10 characters");
			} else {
				this.lastName = last;
			}
		}
		
		public void setPhoneNumber(String num) {
			if (num == null || num.length() > 10) {
				throw new IllegalArgumentException("Phone Number cannot be null or greater than 10 characters");
			} else {
				this.phoneNumber = num;
			}
		}
		
		public void setAddress(String add) {
			if (add == null || add.length() > 30) {
				throw new IllegalArgumentException("Address cannot be null or greater than 30 characters");
			} else {
				this.address = add;
			}
		}
		
		//constructor
		public Contact(String conId, String first, String last, String num, String add) {

			if (conId == null || conId.length() > 10) {
				throw new IllegalArgumentException("Contact Id cannot be null or greater than 10 characters");
			} else {
				this.contactId = conId;
			}
			setFirstName(first);
			setLastName(last);
			setPhoneNumber(num);
			setAddress(add);
		}
}
