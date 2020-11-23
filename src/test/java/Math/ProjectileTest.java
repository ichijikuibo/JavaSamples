package Math;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.cc.math.Projectile;
import com.cc.utilities.Files;
import com.cc.utilities.Text;

public class ProjectileTest {

	@Test
	public void testFromAngleSpeedTime() {
		List<String> tests = Files.openCSV("src/test/resources/projectile.csv");
		for(String test:tests)
		{
			double[] data = Text.parseDoubleArray(test.split(","));
			Projectile result = Projectile.fromAngleSpeedTime(data[0], data[1], data[2]);
			assertEquals(data[0],result.angle,0.00001);
			assertEquals(data[1],result.intitalSpeed,0.00001);
			assertEquals(data[2],result.time1,0.00001);
			assertEquals(data[3],result.horizontalD,0.00001);
			assertEquals(data[4],result.verticalD,0.00001);
		}
	}
	public void testFromHDistanceAngleSpeed() {
		List<String> tests = Files.openCSV("src/test/resources/projectile.csv");
		for(String test:tests)
		{
			double[] data = Text.parseDoubleArray(test.split(","));
			Projectile result = Projectile.fromHDistanceAngleSpeed(data[0], data[1], data[3]);
			assertEquals(data[0],result.angle,0.00001);
			assertEquals(data[1],result.intitalSpeed,0.00001);
			assertEquals(data[2],result.time1,0.00001);
			assertEquals(data[3],result.horizontalD,0.00001);
			assertEquals(data[4],result.verticalD,0.00001);
		}
	}
	public void testFromVDistanceAngleSpeed() {
		List<String> tests = Files.openCSV("src/test/resources/projectile.csv");
		for(String test:tests)
		{
			double[] data = Text.parseDoubleArray(test.split(","));
			Projectile result = Projectile.fromVDistanceAngleSpeed(data[0], data[1], data[4]);
			assertEquals(data[0],result.angle,0.00001);
			assertEquals(data[1],result.intitalSpeed,0.00001);
			assertEquals(data[2],result.time1,0.00001);
			assertEquals(data[3],result.horizontalD,0.00001);
			assertEquals(data[4],result.verticalD,0.00001);
		}
	}

}
