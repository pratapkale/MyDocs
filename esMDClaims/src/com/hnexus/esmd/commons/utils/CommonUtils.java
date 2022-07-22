/**
 * 
 */
package com.hnexus.esmd.commons.utils;

import java.util.UUID;

/**
 * @author user
 *
 */
public class CommonUtils {
	public static String generateUUID() {
		String uuid = UUID.randomUUID().toString().replaceAll("-", ".");
		return uuid;
	}
	
	public static boolean isNotNull(final String string) {
		return string != null && !string.isEmpty() && !string.trim().isEmpty();
	}
}
