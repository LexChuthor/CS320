package appointmentService;

import java.util.*;

public class AppointmentService {

	final private List<Appointment> appointmentList = new ArrayList<>();

	private String genAppId() {
		String appId = UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
		return appId;
	}
	
	public void addApointment(Date appDate, String desc) {
		Appointment app = new Appointment(genAppId(), appDate, desc);
		appointmentList.add(app);
	}
	
	public void deleteAppointment(String appId) throws Exception{
		appointmentList.remove(findAppointment(appId));
	}
	
	public List<Appointment> getAppList(){
		return appointmentList;
	}
	
	public Appointment findAppointment(String appId) throws Exception{
		for(int i = 0; i < appointmentList.size(); i++) {
			if(appointmentList.get(i).getAppId().equals(appId)) {
				return appointmentList.get(i);
			}
		}
		throw new Exception("This appointment does not exist");
	}
}
