package com.deloitte.utils;

import java.util.Collection;
import java.util.Map;

/**
 * @author jaimahaprabhua
 *
 */
public class ServiceUtils {

	private ServiceUtils() {
	}

	public static boolean isNullOrEmpty(Object object) {
		if (object == null) {
			return true;
		}
		if (object instanceof String && ((String) object).trim().length() == 0) {
			return true;
		}
		if (object instanceof Collection<?> && ((Collection<?>) object).isEmpty()) {
			return true;
		}
		return (object instanceof Map<?, ?> && ((Map<?, ?>) object).isEmpty());
	}

	public static boolean isNotNullOrEmpty(Object object) {
		return !isNullOrEmpty(object);
	}

	public static boolean isNullOrEmpty(Object[] objArr) {
		return (objArr == null || objArr.length == 0);
	}

	public static boolean isNotNullOrEmpty(Object[] objArr) {
		return !isNullOrEmpty(objArr);
	}

//	/**
//	 * @param obj
//	 * @return
//	 */
//	public static String convertDate(String obj) {
//		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-mm-yyyy");
//		return dateFormatter.format(LocalDate.parse(obj.subSequence(0, obj.length())));
//	}
}
