package com.cc.utilities;

import java.util.Scanner;


public class Input {
	public static Scanner input = new Scanner(System.in);
	/**
	 * Get a whole number from console input between 2 values
	 * @param min the minimum value
	 * @param max the maximum value
	 * @return a whole number
	 */
	public static int getInt(int min,int max)
	{
		int enteredInt = 0;
		boolean valid = false;
		String enteredText="";
		do
		{
			enteredText = input.nextLine();
			try
			{
				enteredInt = Integer.parseInt(enteredText);			
				if(enteredInt>max)
				{
					System.out.print("Invalid please enter a number less than or equal to " + max + " > ");
				}
				else if(enteredInt<min)
				{
					System.out.print("Invalid please enter a number greater than or equal to " + min + " > ");
				}
				else 
				{
					valid = true;
				}
			}
			catch(NumberFormatException e)
			{
				System.out.print("Invalid please enter a whole number > ");

			}
		}while(!valid);

		return enteredInt;
	}
	/**
	 * Get a whole number from console input between 2 values displaying a message to the user first
	 * @param min the minimum value
	 * @param max the maximum value
	 * @param message the message to be displayed(max and min will be added)
	 * @return a whole number
	 */
	public static int getInt(int min,int max,String message)
	{
		if(min>Integer.MIN_VALUE&&max<Integer.MAX_VALUE)
			System.out.print(message + "("+min +" - " + max+") > ");
		else if(min>Integer.MIN_VALUE)
			System.out.print(message + "("+min +"+) > ");
		else if(max<Integer.MAX_VALUE)
			System.out.print(message + "(<" + max+") > ");
		return getInt(min,max);
	}

	/**
	 * Get a real number from console input between 2 values
	 * @param min the minimum value
	 * @param max the maximum value
	 * @param message the message to be displayed(max and min will be added)
	 * @return a real number
	 */
	public static double getDouble(double min,double max)// get an double between a minimum or maximum
	{
		double entereDouble = 0;
		boolean valid = false;
		String enteredText="";
		do
		{
			enteredText = input.nextLine();
			try
			{
				entereDouble = Double.parseDouble(enteredText);			
				if(entereDouble>max)
				{
					System.out.print("Invalid please enter a number less than or equal to " + max + " > ");
				}
				else if(entereDouble<min)
				{
					System.out.print("Invalid please enter a number greater than or equal to " + min + " > ");
				}
				else 
				{
					valid = true;
				}
			}
			catch(NumberFormatException e)
			{
				System.out.print("Invalid please enter a number > ");

			}
		}while(!valid);

		return entereDouble;
	}
	/**
	 * Get a real number from console input between 2 values displaying a message to the user first
	 * @param min the minimum value
	 * @param max the maximum value
	 * @param message the message to be displayed(max and min will be added)
	 * @return a whole number
	 */
	public static double getDouble(double min,double max,String message)
	{
		if(min>Double.MIN_VALUE&&max<Double.MAX_VALUE)
			System.out.print(message + "("+min +" - " + max+") > ");
		else if(min>Double.MIN_VALUE)
			System.out.print(message + "("+min +"+) > ");
		else if(max<Double.MAX_VALUE)
			System.out.print(message + "(<" + max+") > ");
		return getDouble(min,max);
	}
	/**
	 * get a single character from the console
	 * @return a lower case character
	 */
	public static char getChar()
	{
		String responseString = input.nextLine().toLowerCase();
		return responseString.charAt(0);
	}
	/**
	 * Display a message asking the user to input a char value that must match the given values
	 * @param options the characters that will be accepted
	 * @param message the message to be displayed to the user
	 * @return a lower case character
	 */
	public static char getChar(String optionsString,String message)
	{
		System.out.print(message + " (" + Text.charArrayToString(optionsString.toCharArray())+") > ");
		return getChar(optionsString);
	}
	/**
	 * get a single character from the console - case insensitive
	 * @param options the characters that will be accepted
	 * @param message the message to be displayed to the user
	 * @return a lower case character
	 */
	public static char getChar(String optionsString)
	{
		char[] options = optionsString.toLowerCase().toCharArray();//+optionsString.toUpperCase()).toCharArray();
		char response = 'x';
		String responseString = "";
		boolean valid = false;
		do
		{
			responseString = input.nextLine().toLowerCase();
			if(responseString.length()==1)
			response = responseString.charAt(0);
			if(options!=null)
			{
				for(char c : options)
				{
					c = Character.toLowerCase(c);
					if(response==c)valid=true;
					
					
				}
			}
			else valid = true;

			if(!valid)
				System.out.print("Invalid selection please enter " + Text.charArrayToString(options)+ " ");
		}while(!valid);
		return response;
	}
	/**
	 * get a string from the console
	 * @return the entered string
	 */
	public static String getString()
	{
		return input.nextLine();
	}
	/**
	 * get a String from the console that matches one of the strings specified in options - case insensitive
	 * @param options the string that will be accepted(, comma separated)
	 * @param message the message to be displayed to the user
	 * @return the entered string
	 */
	public static String getString(String options)
	{
		return getString(options.toLowerCase().split(","));
	}
	/**
	 * get a String from the console that matches one of the strings specified in options - case insensitive
	 * @param options the string that will be accepted
	 * @param message the message to be displayed to the user
	 * @return the entered string
	 */
	public static String getString(String[] options)
	{
		String s = "";
		String[] acceptedStrings = options;
		boolean valid = false;
		do {
			s = getString();
			for(String as :acceptedStrings)
			{
				if(s.equalsIgnoreCase(as))valid = true;
			}
			if(!valid)System.out.print("Please enter a valid option ("+options+") > ");
		}while(!valid);
		return s;
	}
}
