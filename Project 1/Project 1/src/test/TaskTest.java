package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import taskService.Task;

public class TaskTest {

	//getters
	@Test
	void testGetTaskId() {
		Task task = new Task("task000001", "checkTask1", "Task 1 description");
		Assertions.assertEquals("task000001", task.getTaskId());
	}
	
	@Test
	void testGetName() {
		Task task = new Task("task000001", "checkTask1", "Task 1 description");
		Assertions.assertEquals("checkTask1", task.getName());
	}
	
	@Test
	void testGetDescription() {
		Task task = new Task("task000001", "checkTask1", "Task 1 description");
		Assertions.assertEquals("Task 1 description", task.getDescription());
	}
	
	//setters
	@Test
	void testSetName() {
		Task task = new Task("task000001", "checkTask1", "Task 1 description");
		task.setName("checktask2");
		Assertions.assertEquals("checktask2", task.getName());
	}
	
	@Test
	void testSetDescription() {
		Task task = new Task("task000001", "checkTask1", "Task 2 description");
		Assertions.assertEquals("Task 2 description", task.getDescription());
	}
	
	@Test
	void testLongTaskId() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> new Task("task0000001", "checkTask1", "Task 1 description"));
	}
	
	@Test
	void testLongName() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> new Task("task000001", "checkTask00000000000001", "Task 1 description"));	
	}
	
	@Test
	void testLongDescription() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> new Task("task000001", "checkTask1", "Task 1 description, Task 2 description, Task 3 description"));
	}
	
	@Test
	void testNullId() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> new Task(null, "checkTask1", "Task 1 description"));

	}
	
	@Test
	void testNullName() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> new Task("task000001", null, "Task 1 description"));	
	}
	
	@Test
	void testNullDescription() {
		Assertions.assertThrows(IllegalArgumentException.class,  () -> new Task("task000001", "checkTask1", null));
	}
	
}
