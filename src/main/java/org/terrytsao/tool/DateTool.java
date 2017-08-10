package org.terrytsao.tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTool {
	public static Date isDateFormatted(String dateString) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
			sdf.setLenient(false);
			date = sdf.parse(dateString);
			if (!dateString.equals(sdf.format(date))) {
				date = null;
			}
		} catch (ParseException ex) {
		}
		return date;
	}
}
