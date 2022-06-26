package appointmentService;

import java.util.*;

public class Appointment {
	private final String appId;
	private Date appDate;
	private String description;

	// getters
	public String getAppId() {
		return this.appId;
	}

	public Date getappDate() {
		return this.appDate;
	}

	public String getDescription() {
		return this.description;
	}

	// setters
	public void setAppDate(Date appDate) {
		Date today = new Date(2022, Calendar.JUNE, 5);
		if (appDate.before(today)) {
			throw new IllegalArgumentException("Date cannot be null or a past date");
		} else {
			this.appDate = appDate;
		}
	}

	public void setDescription(String desc) {
		if (desc == null || desc.length() > 50) {
			throw new IllegalArgumentException("Description cannot be null or greater than 50 characters");
		} else {
			this.description = desc;
		}
	}

	// constructor

	public Appointment(String appId, Date appDate, String description) {
		if (appId == null || appId.length() > 10) {
			throw new IllegalArgumentException("App Id cannot be null or greater than 10 characters");
		} else {
			this.appId = appId;
		}
		
		setAppDate(appDate);
		setDescription(description);
	}
}
