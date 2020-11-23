package utilities;

import static org.junit.Assert.*;
import org.junit.Test;

import com.cc.utilities.Files;

public class FilesTest {

	@Test
	public void test() {
		String[] data = {"1,2,3","4,5,6","7,8,9"};
		Files.saveCSV("test.csv",data);
		assertArrayEquals(data, Files.openCSV("test.csv").toArray());
	}

}
