package com.cc.utilities;

import java.time.LocalDate;


public class Text {
	/**
	 * Convert a month in number for to a string
	 * @param month the month in number format 1-12
	 * @return A string containing January-December
	 */
	public static String monthString(int month)
	{		
		String monthString = "";
		switch(month)
		{
		case 1: monthString = "January";break;
		case 2: monthString = "February";break;
		case 3: monthString = "March";break;
		case 4: monthString = "April";break;
		case 5: monthString = "May";break;
		case 6: monthString = "June";break;
		case 7: monthString = "July";break;
		case 8: monthString = "August";break;
		case 9: monthString = "September";break;
		case 10: monthString = "October";break;
		case 11: monthString = "November";break;
		case 12: monthString = "December";break;
		default:monthString = "Invalid";break;
		}
		return monthString;
	}
	/**
	 * Convert a month string to its number value
	 * @param month the month string
	 * @return the month number 1-12
	 */
	public static int monthString(String month)
	{		
		int monthNumber = 0;
		switch(month.toLowerCase())
		{
		case "january": monthNumber = 1;break;
		case "february": monthNumber = 2;break;
		case "march": monthNumber = 3;break;
		case "april": monthNumber = 4;break;
		case "may": monthNumber = 5;break;
		case "june": monthNumber = 6;break;
		case "july": monthNumber = 7;break;
		case "august": monthNumber = 8;break;
		case "september": monthNumber = 9;break;
		case "october": monthNumber = 10;break;
		case "november": monthNumber = 11;break;
		case "december": monthNumber = 12;break;
		default:monthNumber = 0;
		}
		return monthNumber;
	}

	/**
	 * Convert a character array to a comma separated string
	 * @param chars the array of characters
	 * @return a comma separated list of chars in string format
	 */
	public static String charArrayToString(char[] chars)
	{
		String output = "";
		for(char c : chars)
		{
			output += c +", ";
		}
		output = output.substring(0,output.lastIndexOf(","));
		return output;

	}
	/**
	 * Centre the a string to the specified length
	 * @param input the String to be centred
	 * @param length the number of characters to centre on
	 * @return a String padded on the left and right to be centred
	 */
	public static String centreString(String input,int length)
	{
		int rightpadding = (length-input.length())/2;
		int leftpadding = rightpadding;
		if(rightpadding+leftpadding+input.length()<length)leftpadding+=1;
		if(leftpadding<0)leftpadding=0;
		if(rightpadding<0)rightpadding=0;
		return " ".repeat(leftpadding) + input + " ".repeat(rightpadding);
	}
	/**
	 * Centre the text of an array of string
	 * @param input the array of strings to be centred
	 * @return a array of string centred
	 */
	public static String[] centreText(String [] input)
	{
		int longest = longest(input)+2;
		String[] output = new String[input.length];
		for(int i =0;i<input.length;i++)
		{
			String s = input[i];
			int padding = longest-s.length();
			for(int j=0;j<padding;j++)
			{
				if(j%2==1)
				{
					s = s+" ";
				}
				else {
					s = " "+s;
				}					
			}
			output[i]=s;
		}
		return output;
	}
	private static int longest(String[] input)
	{
		int longest = 0;
		for(String s : input)
		{
			if(s.length()>longest)longest = s.length();
		}
		return longest;
	}
	/**
	 * Get the day extension e.g. 1 = st
	 * @param day the day of the month
	 * @return st, nd, rd or th
	 */
	public static String getDayExtention(int day)
	{
		if(day<1||day>31)return "Invalid";
		String extention = "th";
		if(day<10||day>20)
		{
			if(day%10==1)extention = "st";
			if(day%10==2)extention = "nd";
			if(day%10==3)extention = "rd";
		}
		return extention;
	}
	/**
	 * Get how many days in a months
	 * @param month the month to evaluate
	 * @return the numbers of days in the specified month 28,30 or 31
	 */
	public static int daysInMonth(int month)
	{
		int numberOfDays =0;
		switch(month)
		{
		case 2:numberOfDays=28;break;
		case 4: case 6: case 9: case 11:
			numberOfDays=30;break;
		case 1: case 3: case 5: case 7: case 8: case 10: case 12: 
			numberOfDays=31;break;
		}
		return numberOfDays;
	}
	/**
	 * Convert a number into a day of the week 
	 * @param dayOfTheWeek the day of the week 1-7
	 * @return the day of the week Monday-Sunday
	 */
	public static String dayOfTheWeekFromNumber(int dayOfTheWeek){
		String day = "";
		switch(dayOfTheWeek)
		{
		case 1:day="Monday";break;
		case 2:day="Tuesday";break;
		case 3:day="Wednesday";break;
		case 4:day="Thursday";break;
		case 5:day="Friday";break;
		case 6:day="Saturday";break;
		case 7:day="Sunday";break;
		default: day="Invalid";
		}
		return day;
	}
	/**
	 * convert a string day of the week into a number
	 * @param dayOfTheWeek the day of the week e.g Monday or tue
	 * @return a number between 1-7
	 */
	public static int dayOfTheWeekFromString(String dayOfTheWeek){
		int day = 0;
		switch(dayOfTheWeek.toLowerCase())
		{
		case "monday": case "mon":
			day=1;break;
		case "tuesday": case "tue": case "tues":
			day=2;break;
		case "wednesday": case "wed": case "wednes":
			day=3;break;
		case "thursday": case "thur": case "thu": case "thurs":
			day=4;break;
		case "friday": case "fri":
			day=5;break;
		case "saturday": case "sat": case "satur":
			day=6;break;
		case "sunday": case "sun":
			day=7;break;
		default: day=0;
		}
		return day;
	}
	/**
	 * Convert a LocalDate to a text string 
	 * @param date a LocalDate with a date that needs converted
	 * @return the long date string e.g Friday 11th January 2019
	 */
	public static String dateToDateString(LocalDate date)
	{
		return String.format("%s %d%s %s %d",	dayOfTheWeekFromNumber(date.getDayOfWeek().getValue()),
				date.getDayOfMonth(),getDayExtention(date.getDayOfMonth()),
				monthString(date.getMonthValue()),
				date.getYear());
	}
	/**
	 * Convert a short date String to a full date String
	 * @param date a string with a date in the format YYYY-MM-DD
	 * @return the long date string e.g Friday 11th January 2019
	 */
	public static String shortDateToDateString(String date)
	{
		try {
			return dateToDateString(LocalDate.parse(date));
		}
		catch(Exception e) {		
			return "Invalid";
		}
	}
	/**
	 * Convert an array of doubles in string format to an array of doubles
	 * @param doubleAS the input string array containing doubles
	 * @return a double array
	 */
	public static double[] parseDoubleArray(String[] doubleAS) 
	{
		double[] doubleA = new double[doubleAS.length];
		for(int i =0;i<doubleAS.length;i++)
		{
			doubleA[i] =  Double.valueOf(doubleAS[i]);  
		}
		return doubleA;
	}
	/**
	 * Convert an array of ints in string format to an array of ints
	 * @param intAS the input string array containing ints
	 * @return a int array
	 */
	public static int[] parseIntArray(String[] intAS) 
	{
		int[] intA = new int[intAS.length];
		for(int i =0;i<intAS.length;i++)
		{
			intA[i] =  Integer.valueOf(intAS[i]);  
		}
		return intA;
	}
}
