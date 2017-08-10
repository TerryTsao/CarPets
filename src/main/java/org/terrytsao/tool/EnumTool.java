package org.terrytsao.tool;

import java.util.LinkedList;
import java.util.List;

public class EnumTool {

	public static <E extends Enum<E>> List<String> getEnumValues(Class<E> enm) {
		E[] consts = enm.getEnumConstants();
		List<String> list = new LinkedList<>();
		for (E val : consts) {
			list.add(val.toString());
		}
		return list;
	}
}
