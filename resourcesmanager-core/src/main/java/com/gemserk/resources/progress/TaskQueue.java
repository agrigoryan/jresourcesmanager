package com.gemserk.resources.progress;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author acoppes
 * Provides a way to process tasks with a progress associated.
 */
public class TaskQueue {

	private final Queue<Runnable> tasks;

	private Progress progress;

	public void setProgress(Progress progress) {
		this.progress = progress;
	}

	public TaskQueue() {
		this(new LinkedList<Runnable>());
	}

	public TaskQueue(Queue<Runnable> tasks) {
		this(tasks, new Progress(tasks.size()));
	}

	public TaskQueue(Queue<Runnable> tasks, Progress progress) {
		this.tasks = tasks;
		this.progress = progress;
	}

	public void add(Runnable task) {
		tasks.add(task);
		progress.setTotal(tasks.size());
	}

	public void processNext() {
		Runnable task = tasks.poll();
		if (task == null)
			return;
		task.run();
		progress.increment();
	}

	public boolean isDone() {
		return tasks.isEmpty();
	}

	public Progress getProgress() {
		return progress;
	}

	public Runnable getCurrentTask() {
		return tasks.peek();
	}

}