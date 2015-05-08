package org.dispatcher.service.util;

/**
 * I assume, courier services providers expose rest services to give unique
 * number. Instead if they provide any other means those should be implemented
 * in this method.
 * 
 * @param url
 * @return
 */
public class ConsigmentNumberProvider {

	public String getUniqueConsigmentNumber(String url) {

		String uniqueNumber = null;

		// TODO connect to rest service
		return uniqueNumber;
	}
}
