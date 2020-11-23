package utilities;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cc.utilities.Input;

public class InputTest {
	private ByteArrayOutputStream byteArrayOutputStream;

	private PrintStream console;
	InputStream old;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
        byteArrayOutputStream = new ByteArrayOutputStream();
        console = System.out;
        System.setOut(new PrintStream(byteArrayOutputStream));
        old = System.in;
	}

	@After
	public void tearDown() throws Exception {
		System.setOut(console);
		System.setIn(old);
	}

	@Test
	public void testGetIntIntInt() {

		int[] positiveTests = {0,1,50,99,100};
		String negativeTests = "\n-1\n101\n5O\n\n \n";
		InputStream input = new ByteArrayInputStream((intArrayToString(positiveTests)+negativeTests).getBytes());
		System.setIn(input);
		Input.input = new Scanner(System.in);
		for(int num:positiveTests)
		{
			try {				
				int result = Input.getInt(0, 100);
				assertEquals(num,result);
			}
			catch(NoSuchElementException e)
			{
				fail("input not acccepted");
			} 
		}
		try {	
			int result = Input.getInt(0, 100);
			fail("negative input accepted - " + result);
		}
		catch(NoSuchElementException e)
		{
			return;
		} 

	}
	public String intArrayToString(int[] nums)
	{
		String inputString = "";
		for(int num:nums)
			inputString+=num+"\n";
		return inputString;
	}
	@Test
	public void testGetIntIntIntString() {
		int[] positiveTests = {10,11,15,19,20};
		String negativeTests = "\n9\n21\n2O\n\n \n";
		InputStream input = new ByteArrayInputStream((intArrayToString(positiveTests)+negativeTests).getBytes());
		System.setIn(input);
		Input.input = new Scanner(System.in);
		for(int num:positiveTests)
		{
			try {				
				int result = Input.getInt(10, 20,"test");
				assertEquals(num,result);
			}
			catch(NoSuchElementException e)
			{
				fail("input not acccepted");
			} 
		}
		try {	
			int result = Input.getInt(10, 20,"test");
			fail("negative input accepted"+result);
		}
		catch(NoSuchElementException e)
		{
			return;
		} 
	}

	@Test
	public void testGetDoubleDoubleDouble() {
		double[] positiveTests = {0.000000000001,0.999999999,0,1,0.5};
		String negativeTests = "\n-0.00000000001\n1.0000000001\nO.000001\n\n \n";
		InputStream input = new ByteArrayInputStream((doubleArrayToString(positiveTests)+negativeTests).getBytes());
		System.setIn(input);
		Input.input = new Scanner(System.in);
		for(double num:positiveTests)
		{
			try {				
				double result = Input.getDouble(0, 1);
				assertEquals(num,result, 0);
			}
			catch(NoSuchElementException e)
			{
				fail("input not acccepted");
			} 
		}
		try {	
			double result = Input.getDouble(0, 1);
			fail("negative input accepted"+result);
		}
		catch(NoSuchElementException e)
		{
			return;
		} 
	}
	public String doubleArrayToString(double[] nums)
	{
		String inputString = "";
		for(double num:nums)
			inputString+=num+"\n";
		return inputString;
	}
	@Test
	public void testGetDoubleDoubleDoubleString() {
		double[] positiveTests = {10.01,99.99,10,99,50.50};
		String negativeTests = "\n9.99\n100\n10.OO\n\n \n";
		InputStream input = new ByteArrayInputStream((doubleArrayToString(positiveTests)+negativeTests).getBytes());
		System.setIn(input);
		Input.input = new Scanner(System.in);
		for(double num:positiveTests)
		{
			try {				
				double result = Input.getDouble(10.00, 99.99,"test");
				assertEquals(num,result, 0);
			}
			catch(NoSuchElementException e)
			{
				fail("input not acccepted");
			} 
		}
		try {	
			double result = Input.getDouble(0, 1,"test");
			fail("negative input accepted"+result);
		}
		catch(NoSuchElementException e)
		{
			return;
		} 
	}

	@Test
	public void testGetChar() {
		char[] positiveTests = {'a','Z','5','@',' '};
		String negativeTests = "";
		InputStream input = new ByteArrayInputStream((charArrayToString(positiveTests)+negativeTests).getBytes());
		System.setIn(input);
		Input.input = new Scanner(System.in);
		for(char character:positiveTests)
		{
			try {				
				char result = Input.getChar();
				assertEquals((String.valueOf(character)).toLowerCase().charAt(0),result );
			}
			catch(NoSuchElementException e)
			{
				fail("input not acccepted");
			} 
		}
		try {	
			char result = Input.getChar();
			fail("negative input accepted"+result);
		}
		catch(NoSuchElementException e)
		{
			return;
		} 
	}
	public String charArrayToString(char[] nums)
	{
		String inputString = "";
		for(char num:nums)
			inputString+=num+"\n";
		return inputString;
	}
	@Test
	public void testGetCharStringString() {
		char[] positiveTests = {'Y','N','y','n'};
		String negativeTests = "\nm\nYN\nYes\n9\n\n \n\t\n";
		InputStream input = new ByteArrayInputStream((charArrayToString(positiveTests)+negativeTests).getBytes());
		System.setIn(input);
		Input.input = new Scanner(System.in);
		for(char character:positiveTests)
		{
			try {				
				char result = Input.getChar("YN","Test");
				assertEquals((String.valueOf(character)).toLowerCase().charAt(0),result);
			}
			catch(NoSuchElementException e)
			{
				fail("input not acccepted");
			} 
		}
		try {	
			char result = Input.getChar("YN","Test");
			fail("negative input accepted"+result);
		}
		catch(NoSuchElementException e)
		{
			return;
		} 
	}

	@Test
	public void testGetCharString() {
		char[] positiveTests = {'A','B','C','D','a','b','c','d'};
		String negativeTests = "\nAB\nYes\n9\n\n \n\t\n";
		InputStream input = new ByteArrayInputStream((charArrayToString(positiveTests)+negativeTests).getBytes());
		System.setIn(input);
		Input.input = new Scanner(System.in);
		for(char character:positiveTests)
		{
			try {				
				char result = Input.getChar("ABCD");
				assertEquals((String.valueOf(character)).toLowerCase().charAt(0),result );
			}
			catch(NoSuchElementException e)
			{
				fail("input not acccepted");
			} 
		}
		try {	
			char result = Input.getChar("ABCD");
			fail("negative input accepted"+result);
		}
		catch(NoSuchElementException e)
		{
			return;
		} 
	}

	@Test
	public void testGetString() {
		String[] positiveTests = {"Yes","no","A*","3482"};
		String negativeTests = "";
		InputStream input = new ByteArrayInputStream((String.join("\n", positiveTests)+negativeTests).getBytes());
		System.setIn(input);
		Input.input = new Scanner(System.in);
		for(String text:positiveTests)
		{
			try {				
				String result = Input.getString();
				assertEquals(text,result);
			}
			catch(NoSuchElementException e)
			{
				fail("input not acccepted");
			} 
		}
		try {	
			String result = Input.getString();
			fail("negative input accepted"+result);
		}
		catch(NoSuchElementException e)
		{
			return;
		} 
	}

	@Test
	public void testGetStringString() {
		String[] positiveTests = {"Yes","no","nO","YES"};
		String negativeTests = "\nn0\nDon't Know\n\n \nnaw\naye\ny\nn\n";
		InputStream input = new ByteArrayInputStream((String.join("\n", positiveTests)+negativeTests).getBytes());
		System.setIn(input);
		Input.input = new Scanner(System.in);
		for(String text:positiveTests)
		{
			try {				
				String result = Input.getString("yes,no");
				assertEquals(text,result);
			}
			catch(NoSuchElementException e)
			{
				fail("input not acccepted");
			} 
		}
		try {	
			String result = Input.getString("yes,no");
			fail("negative input accepted"+result);
		}
		catch(NoSuchElementException e)
		{
			return;
		} 
	}

	@Test
	public void testGetStringStringArray() {
		String[] positiveTests = {"h1","O2","d*","A*"};
		String negativeTests = "\nH4\n02\n\n \n**\nb\nB\nDon't Know\n";
		InputStream input = new ByteArrayInputStream((String.join("\n", positiveTests)+negativeTests).getBytes());
		System.setIn(input);
		Input.input = new Scanner(System.in);
		for(String text:positiveTests)
		{
			try {				
				String result = Input.getString("H1,O2,D*,A*".split(","));
				assertEquals(text,result );
			}
			catch(NoSuchElementException e)
			{
				fail("input not acccepted");
			} 
		}
		try {	
			String result = Input.getString("H1,O2,D*,A*".split(","));
			fail("negative input accepted"+result);
		}
		catch(NoSuchElementException e)
		{
			return;
		} 
	}

}
