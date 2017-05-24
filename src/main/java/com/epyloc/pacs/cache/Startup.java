package com.epyloc.pacs.cache;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Startup {

	@EventListener(ContextRefreshedEvent.class)
	void loadOnStartup() {
		PACSCacheSingleton.getInstance();
	}

}
