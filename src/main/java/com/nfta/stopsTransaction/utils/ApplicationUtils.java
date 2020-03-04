package com.nfta.stopsTransaction.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ApplicationUtils {
	
	private static String convertDate(String date) {
		// TODO Auto-generated method stub
		long dateL = Long.valueOf(date);
		Date dateTo = new Date(dateL);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		String formatted = format.format(dateTo);
		System.out.println("Date formatted: " + formatted);
		return formatted;
	}

}
