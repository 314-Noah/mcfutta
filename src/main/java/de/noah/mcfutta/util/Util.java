package de.noah.mcfutta.util;

import java.lang.reflect.Array;
import java.util.List;

public class Util {

	public static <T> T[] asArray(List<T> list) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) Array.newInstance(list.get(0).getClass(), list.size());
		
		for (int i = 0; i < array.length; i++) {
			array[i] = list.get(i);
		}
		return array;
	}
	
}
