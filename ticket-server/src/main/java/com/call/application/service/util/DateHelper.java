package com.call.application.service.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {
	
	public static SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static SimpleDateFormat DEFAULT_SHORT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd"); 
	
	public static Date addDays(Date date, int amount) {
		Calendar calendar = toCalendar(date);
		calendar.add(Calendar.DATE, amount);
		return calendar.getTime();		
	}
	
	public static Date addDays(int amount) {
		return addDays(now(), amount);
	}
	
	public static Date minusDays(Date date, int amount) {
		return addDays(date, (-1) * amount);
	}
	
	public static Date minusDays(int amount) {
		return minusDays(now(), amount);
	}
	
	public static Date now(){
		return Calendar.getInstance().getTime();
	}
	
	public static Date today() {
	    Calendar calendar = toCalendar(new Date());
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    return calendar.getTime();
	}
	
	public static Date lastMonth() {
		Calendar calendar = toCalendar(new Date());
		calendar.add(Calendar.MONTH, -1);
		return calendar.getTime();
	}
	
	public static Date startOfDay(Date date){
		Calendar calendar = toCalendar(date);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    return calendar.getTime();
	}
	
	public static Date startOfDay() {
		return startOfDay(now());
	}
	
	public static Date endOfDay(Date date) {
		Calendar calendar = toCalendar(date);
	    calendar.set(Calendar.HOUR_OF_DAY, 23);
	    calendar.set(Calendar.MINUTE, 59);
	    calendar.set(Calendar.SECOND, 59);
	    calendar.set(Calendar.MILLISECOND, 999);
	    return calendar.getTime();
	}
	
	public static Date endOfDay() {
		return endOfDay(now());
	}
	
	public static Date firstDayOfMonth(Date date){
		Calendar calendar = toCalendar(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    return calendar.getTime();
	}
	
	public static Date firstDayOfMonth() {
		return firstDayOfMonth(now());
	}
	
	public static Date lastDayOfMonth(Date date){
		Calendar calendar = toCalendar(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    return calendar.getTime();
	}
	
	public static Date lastDayOfMonth() {
		return lastDayOfMonth(now());
	}

	public static Date tomorrow(Date date) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.DATE, 1);
	    return calendar.getTime();
	}
	
	public static Date tomorrow() {
		return tomorrow(now());
	}
	
	public static Date yesterday(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -1);
		return calendar.getTime();
	}
	
	public static Date yesterday() {
		return yesterday(now());
	}
	
	public static String toString(SimpleDateFormat simpleDateFormat, Date date){
		return simpleDateFormat.format(date);
	}
	
	public static String toString(Date date){
		return toString(DEFAULT_DATE_FORMAT, date);
	}
	
	public static Date toDate(SimpleDateFormat simpleDateFormat, String source) throws ParseException{
		return simpleDateFormat.parse(source);
	}
	
	public static Date toDate(String source) throws ParseException {
		return toDate(DEFAULT_DATE_FORMAT, source);
	}
	
	public static Calendar toCalendar(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}
	
}
