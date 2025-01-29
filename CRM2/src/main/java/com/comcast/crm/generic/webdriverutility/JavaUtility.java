package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	/*
	 * Returns a random number between 1 and 99999
	 */
	public int getRandomNumber() {
		Random r = new Random();
		return r.nextInt(99999);
	}

	/*
	 * Returns the date in `YYYY-MM-DD` format
	 */
	public String getSystemDateYYYYMMDD() {
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		return sim.format(date);
	}

	/*
	 * Returns the date from the system date to `days`
	 */
	public String getRequiredDate(int days) {
	    SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
	    // Create a new Calendar instance
	    Calendar cal = Calendar.getInstance();
	    // Add the specified number of days
	    cal.add(Calendar.DAY_OF_MONTH, days);
	    // Format and return the adjusted date
	    return sim.format(cal.getTime());
	}

}
