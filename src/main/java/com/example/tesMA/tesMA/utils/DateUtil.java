package com.example.tesMA.tesMA.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DateUtil {
    public static Timestamp getCurrentTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}

	// public static String formatTimestampYMD(Timestamp timestamp) {
	// 	SimpleDateFormat outputDateFormat = new SimpleDateFormat(Constant.FORMAT_DATE_YYMMDD);
	// 	return outputDateFormat.format(timestamp);
	// }
}
