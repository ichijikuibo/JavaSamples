package utilities;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cc.utilities.Text;

public class TextTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMonthStringInt() {
		int[] input = {1,2,3,4,5,6,7,8,9,10,11,12,-1,0,13};
		String[] output = {"January","February","March","April","May","June","July","August","September","October","November","December","Invalid","Invalid","Invalid"};
		for(int i=0;i<input.length;i++)
		{
			assertEquals(output[i],Text.monthString(input[i]));
		}
	}

	@Test
	public void testMonthStringString() {
		int[] output = {1,2,3,4,5,6,7,8,9,10,11,12,0,0,0};
		String[] input = {"january","February","MaRcH","apriL","MAY","june","JuLY","August","September","OCtober","noVeMber","decembER","Janary","Monday","DECMBER"};
		for(int i=0;i<input.length;i++)
		{
			assertEquals(output[i],Text.monthString(input[i]));
		}
	}

	@Test
	public void testCharArrayToString() {
		String[] input = {"YN","ABCD","12345","$£€","+-*/"};
		String[] output = {"Y, N","A, B, C, D","1, 2, 3, 4, 5","$, £, €","+, -, *, /"};
		for(int i=0;i<input.length;i++)
		{
			assertEquals(output[i],Text.charArrayToString(input[i].toCharArray()));
		}
	}

	@Test
	public void testCentreText() {
		String[] input = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		String[] output = {	"  January  ","  February ","   March   ","   April   ","    May    ","    June   ","    July   ","   August  ",
							" September ","  October  ","  November ","  December "};
		assertArrayEquals(output,Text.centreText(input));
		input = new String[] {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
		output =new String[] {	"   Monday  ","  Tuesday  "," Wednesday ","  Thursday ","   Friday  ","  Saturday ","   Sunday  "};
		assertArrayEquals(output,Text.centreText(input));
		
		input = new String[] {" ","   ","     ","       ","     ","   "," "};
		output =new String[] {"         ","         ","         ","         ","         ","         ","         "};
		assertArrayEquals(output,Text.centreText(input));
	}
	@Test
	public void testGetDayExtention()
	{
		int[] input = {1,2,3,4,13,22,31};
		String[] output = {"st","nd","rd","th","th","nd","st"};
		for(int i=0;i<input.length;i++)
		{
			assertEquals(output[i],Text.getDayExtention(input[i]));
		}
	}
	@Test
	public void testdaysInMonth()
	{
		int[] input = {1,2,3,4,5,6,7,8,9,10,11,12};
		int[] output = {31,28,31,30,31,30,31,31,30,31,30,31};
		for(int i=0;i<input.length;i++)
		{
			assertEquals(output[i],Text.daysInMonth(input[i]));
		}
	}
	@Test
	public void testDayOfTheWeekFromNumber() {
		int[] input = {1,2,3,4,5,6,7,-1,0,13};
		String[] output = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday","Invalid","Invalid","Invalid"};
		for(int i=0;i<input.length;i++)
		{
			assertEquals(output[i],Text.dayOfTheWeekFromNumber(input[i]));
		}
	}

	@Test
	public void testDayOfTheWeekFromString() {
		int[] output = {1,2,3,4,5,6,7,0,0,0};
		String[] input = {"monday","TUESDAY","WEdnesday","Thur","Friday","sat","SUN","Invalid","Invalid","Invalid"};
		for(int i=0;i<input.length;i++)
		{
			assertEquals(output[i],Text.dayOfTheWeekFromString(input[i]));
		}
	}
	@Test
	public void testshortDateToDateString()
	{
		String[] input = {"1900-01-01","2200-12-31","2000-11-19","2020-02-29","2050-06-22","2019-01-11"};
		String[] output = {"Monday 1st January 1900","Wednesday 31st December 2200",
				"Sunday 19th November 2000","Saturday 29th February 2020",
				"Wednesday 22nd June 2050","Friday 11th January 2019"};
		for(int i=0;i<input.length;i++)
		{
			assertEquals(output[i],Text.shortDateToDateString(input[i]));
		}
	}
	@Test
	public void testParseDoubleArray()
	{
		String[] input = { "2.2250738585072014E-308","2.2250738585072014E-308","1.7976931348623157E308","-1.7976931348623157E308","0","-1","1","9999999999","0.9999999"};
		double[] output = { 2.2250738585072014E-308,2.2250738585072014E-308,1.7976931348623157E308,-1.7976931348623157E308,0,-1,1,9999999999.0,0.9999999};
		double[] result = Text.parseDoubleArray(input);
		for(int i=0;i<input.length;i++)
		{
			assertEquals(output[i],result[i],0);
		}
	}
	@Test
	public void testParseIntegerArray()
	{
		String[] input = { "2147483647","-2147483648","0","1","-1","99999","-99999","100","1000000000"};
		double[] output = { 2147483647,-2147483648,0,1,-1,99999,-99999,100,1000000000};
		int[] result = Text.parseIntArray(input);
		for(int i=0;i<input.length;i++)
		{
			assertEquals(output[i],result[i],0);
		}
	}
}
