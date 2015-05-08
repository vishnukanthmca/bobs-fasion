package org.dispatcher.core.service;

import org.dispatcher.persistence.domain.DataTransfer;

public interface MessagingService {

	public void sendMessage(DataTransfer dataTransfer);
}
