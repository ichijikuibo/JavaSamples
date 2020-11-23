package Math;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.cc.math.Quadratic;
import com.cc.utilities.Files;
import com.cc.utilities.Text;

public class QuadraticTest {

	@Test
	public void testQuadratic() {

			List<String> tests = Files.openCSV("src/test/resources/quadratic.csv");
			for(String test:tests)
			{
				double[] data = Text.parseDoubleArray(test.split(","));
				Quadratic result = new Quadratic(data[0], data[1], data[2]);
				assertEquals(data[0],result.a,0.00001);
				assertEquals(data[1],result.b,0.00001);
				assertEquals(data[2],result.c,0.00001);
				assertEquals(data[3],result.positiveResult,0.00001);
				assertEquals(data[4],result.negativeResult,0.00001);
			}
		
	}

}
