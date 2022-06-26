package taskService;

import java.util.*;

public class TaskService {

	private final List<Task> taskList = new ArrayList<>();
	
	private String genTaskId() {
		String tid = UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
		return tid;
	}
	
	private Task getTask(String tid) throws Exception{
		for (int i = 0; i < taskList.size(); i++) {
			if(tid.equals(taskList.get(i).getTaskId())) {
				return taskList.get(i);
			}
		}
		throw new Exception("Task not found");
	}
	
	public void addTask(String nm, String desc) {
		Task task = new Task(genTaskId(), nm, desc);
		taskList.add(task);
	}
	
	public void deleteTask(String tid) throws Exception{
		taskList.remove(getTask(tid));
	}
	
	public void updateName(String tid, String nm) throws Exception {
		getTask(tid).setName(nm);
	}
	
	public void updateDesc(String tid, String desc) throws Exception {
		getTask(tid).setDescription(desc);
	}
	
	public List<Task> getTaskList(){return taskList;}
}
