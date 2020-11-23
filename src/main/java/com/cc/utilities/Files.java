package com.cc.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Files {
	/**
	 * Open a CSV file and create a String List with the contents
	 * @param path The path of the file
	 * @return A String for each line of the file in a String List
	 */
	public static List<String> openCSV(String path)
	{
		List<String> content = new ArrayList<String>();
		Scanner file;
		try {
			file = new Scanner(new File(path));
		} catch (FileNotFoundException e) {
			return null;
		}
		boolean reading = true;
		do
		{
			String s = file.nextLine();
			content.add(s);
			if(!file.hasNextLine())reading=false;
			
		}while(reading);
		file.close();
		return content;
	}	
	/**
	 * Save a List of Strings to a CSV file
	 * @param path The full path file to save
	 * @param content A list of strings to save to the file
	 * @return true if the save is successful false if unsuccessful
	 */
	public static boolean saveCSV(String path,List<String> content)
	{
		return saveCSV(path,(String[])content.toArray());
	}
	/**
	 * Save an Array of Strings to a CSV file
	 * @param path The full path file to save
	 * @param content An array of strings to save to the file
	 * @return true if the save is successful false if unsuccessful
	 */
	public static boolean saveCSV(String path,String[] content)
	{
		File csvFile = new File(path);
		PrintStream stream;
		try {
			stream = new PrintStream(csvFile);
			for(String s : content)
			{
				stream.println(s);
			}
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
			return false;
		}
		stream.close();
		return true;


	}	
}
