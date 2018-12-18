package org.jboss.quickstarts.fuse.sap_trfc_destination_spring_boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class RegisterOSLibrary implements ApplicationContextAware {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		log.info("======================================================");
		log.info("======================================================");
    	System.setProperty("java.library.path","/opt/app-root/src/bin");
    	log.info(String.format("java.library.path: %s", System.getProperty("java.library.path")));
    	log.info("======================================================");
    	log.info("======================================================");
		

	}

}
