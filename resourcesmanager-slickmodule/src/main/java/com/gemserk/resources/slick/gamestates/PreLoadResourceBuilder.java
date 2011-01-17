package com.gemserk.resources.slick.gamestates;

import com.gemserk.resources.ResourceManager;
import com.gemserk.resources.resourceloaders.ResourceLoader;

@SuppressWarnings("unchecked")
public class PreLoadResourceBuilder {

	ResourceManager resourceManager;

	TaskQueue taskQueue;

	public PreLoadResourceBuilder(ResourceManager resourceManager, TaskQueue taskQueue) {
		this.resourceManager = resourceManager;
		this.taskQueue = taskQueue;
	}

	public void resource(Object id, ResourceLoader resourceLoader) {
		resourceManager.add(id, resourceLoader);
		taskQueue.add(new PreLoadResourceRunnable(resourceManager, id));
	}

}