package Math;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.cc.math.Triangle;
import com.cc.utilities.Files;
import com.cc.utilities.Text;

public class TriangleTest {

	@Test
	public void testFrom2Angles()  {
		List<String> tests = Files.openCSV("src/test/resources/triangle.csv");
		for(String test:tests)
		{
			double[] data = Text.parseDoubleArray(test.split(","));
			Triangle tri = Triangle.fromABa(data[3], data[0], data[4]);
			assertTriangle(data,tri);
		}
	}

	@Test
	public void testFrom2Sides()  {
		List<String> tests = Files.openCSV("src/test/resources/triangle.csv");
		for(String test:tests)
		{
			double[] data = Text.parseDoubleArray(test.split(","));
			Triangle tri = Triangle.fromAab(data[3], data[0], data[1]);
			assertTriangle(data,tri);

		}
	}
	@Test
	public void testFromAbc()  {
		List<String> tests = Files.openCSV("src/test/resources/triangle.csv");
		for(String test:tests)
		{
			double[] data = Text.parseDoubleArray(test.split(","));
			Triangle tri = Triangle.fromaBC(data[3], data[1], data[2]);
			assertTriangle(data,tri);

		}
	}
	@Test
	public void testFromabc()  {
		List<String> tests = Files.openCSV("src/test/resources/triangle.csv");
		for(String test:tests)
		{
			double[] data = Text.parseDoubleArray(test.split(","));
			Triangle tri = Triangle.fromabc(data[0], data[1], data[2]);
			assertTriangle(data,tri);

		}
	}
	public void assertTriangle(double[] data,Triangle tri )
	{
		assertEquals(data[0],tri.sideA,0.00001);
		assertEquals(data[1],tri.sideB,0.00001);
		assertEquals(data[2],tri.sideC,0.00001);
		assertEquals(data[3],tri.angleA,0.00001);
		assertEquals(data[4],tri.angleB,0.00001);
		assertEquals(data[5],tri.angleC,0.00001);		

	}

}
