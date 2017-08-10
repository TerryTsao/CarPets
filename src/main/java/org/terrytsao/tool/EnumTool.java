package org.terrytsao.tool;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.FatalBeanException;
import org.terrytsao.model.CatVac;
import org.terrytsao.model.DogVac;
import org.terrytsao.model.Species;

public class EnumTool {

	public static <E extends Enum<E>> List<String> getEnumValues(Class<E> enm) {
		E[] consts = enm.getEnumConstants();
		List<String> list = new LinkedList<>();
		for (E val : consts) {
			list.add(val.toString());
		}
		return list;
	}

	public static int[] getEnumInt(Species species, String[] vacs) {
		int[] ret = new int[vacs.length];
		
		for (int i = 0; i < vacs.length; i++) {
			String enumStr = vacs[i];
			int val;

			switch (species) {
				case CAT :
					val = Enum.valueOf(CatVac.class, enumStr).ordinal();
					break;

				case DOG :
					val = Enum.valueOf(DogVac.class, enumStr).ordinal();
					break;

				default :
					throw new FatalBeanException(
							"Fatal in EnumTool.getEnumInt");
			}

			ret[i] = val;
		}
		return ret;
	}
}
