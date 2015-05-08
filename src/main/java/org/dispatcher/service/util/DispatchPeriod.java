package org.dispatcher.service.util;

public class DispatchPeriod {

	public enum Period {
		CUSTOM, TODAY
	}

	// default is today
	private Period dipatchPeriod = Period.TODAY;

	public Period getDipatchPeriod() {
		return dipatchPeriod;
	}

	public void setDipatchPeriod(Period dipatchPeriod) {
		this.dipatchPeriod = dipatchPeriod;
	}
}
