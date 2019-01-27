package com.events;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogginPhaseListener implements PhaseListener {

	private final static Logger logger = LoggerFactory.getLogger(LogginPhaseListener.class);

	@Override
	public void afterPhase(PhaseEvent event) {
		logger.info("afterPhase phase " + event.getPhaseId());

	}

	@Override
	public void beforePhase(PhaseEvent event) {
		logger.info("before phase " + event.getPhaseId());
	}

	@Override
	public PhaseId getPhaseId() {
		// TODO Auto-generated method stub
		return PhaseId.ANY_PHASE;
	}

}
