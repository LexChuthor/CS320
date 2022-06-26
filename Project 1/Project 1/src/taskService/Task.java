package taskService;

public class Task {

	private final String taskId;
	private String name;
	private String description;

	// getters
	public String getTaskId() {
		return this.taskId;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	// setters

	public void setName(String nm) {
		if (nm == null || nm.length() > 20) {
			throw new IllegalArgumentException("Name cannot be null or greater than 20 characters");
		} else {
			this.name = nm;
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
	public Task(String tid, String nm, String desc) {

		if (tid == null || tid.length() > 10) {
			throw new IllegalArgumentException("Task Id cannot be null or greater than 10 characters");
		} else {
			this.taskId = tid;
		}
		setName(nm);
		setDescription(desc);

	}
}
