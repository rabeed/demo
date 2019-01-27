package com.events;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named
@ApplicationScoped
public class LoggingEventHandlers {

	private final static Logger logger = LoggerFactory.getLogger(LoggingEventHandlers.class);

	public void valueChanged(ValueChangeEvent e) {
		logger.debug("value of component " + e.getComponent().getId()+ " was changed " + e.getOldValue() + " new vlue " + e.getNewValue());
	}
	
	public void actionPerformed(ActionEvent e) {
		logger.debug("actionPerformed "+ e.getComponent().getId() + e.getComponent());
	}
	
	public void beforeValidation(ComponentSystemEvent e) {
		logger.debug("beforeValidation "+ e.getComponent().getId() +e.getComponent());
	}
}
