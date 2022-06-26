package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import taskService.TaskService;;
public class TaskServiceTest {

	
	@Test
	void testAddTask() {
		TaskService service = new TaskService();
		service.addTask("Task 1", "Task 1 Description");
		Assertions.assertNotNull(service.getTaskList().get(0).getTaskId());
		Assertions.assertNotEquals("RandomId", service.getTaskList().get(0).getTaskId());
	}
	
	@Test
	void testUpdateName() throws Exception{
		TaskService service = new TaskService();
		service.addTask("Task 1", "Task 1 Description");
		service.getTaskList().get(0).setName("Task 2");
		Assertions.assertEquals("Task 2", service.getTaskList().get(0).getName());
	}
	
	@Test
	void testUpdateDescription() throws Exception{
		TaskService service = new TaskService();
		service.addTask("Task 1", "Task 1 Description");
		service.getTaskList().get(0).setDescription("Task 2 Description");
		Assertions.assertEquals("Task 2 Description", service.getTaskList().get(0).getDescription());
	}
	
	@Test
	void testAddTaskLongName() {
		TaskService service = new TaskService();
		Assertions.assertThrows(IllegalArgumentException.class,  ()-> service.addTask("Task000000000000000000000000001", "Task 1 Description"));
	}
	
	@Test
	void testAddTaskLongDescription() {
		TaskService service = new TaskService();
		Assertions.assertThrows(IllegalArgumentException.class,  ()-> service.addTask("Task00001", "Task 1 Description, Task 1 Description, Task 1 Description"));
	}
	
	@Test
	void testAddTaskNullName() {
		TaskService service = new TaskService();
		Assertions.assertThrows(IllegalArgumentException.class,  ()-> service.addTask(null, "Task 1 Description, Task 1 Description, Task 1 Description"));
	}
	
	@Test
	void testAddTaskNullDescription() {
		TaskService service = new TaskService();
		Assertions.assertThrows(IllegalArgumentException.class,  ()-> service.addTask("Task000001", null));
	}
	
	@Test
	void testDeleteTask() throws Exception{
		TaskService service = new TaskService();
		service.addTask("Task 1", "Task 1 Description");
		assertEquals(1, service.getTaskList().size());
		service.deleteTask(service.getTaskList().get(0).getTaskId());
		assertEquals(0, service.getTaskList().size());
	}
	
	@Test
	void testDeleteTaskNoTask() throws Exception{
		TaskService service = new TaskService();
		service.addTask("Task 1", "Task 1 Description");
		assertEquals(1, service.getTaskList().size());
		assertThrows(Exception.class, ()->service.deleteTask("RandomId"));
		assertEquals(1, service.getTaskList().size());
	}
	
}
