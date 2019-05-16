import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculatorTest {
 
	private Calculator cal = new Calculator();
	int x, y, res;
 
	@Parameters	
	public static Collection<Object[]> data() {
    	return Arrays.asList(new Object[][]{
           	{2, 4, 6},
           	{0, 0, 0},
           	{-3, 9, 6},
           	{-3, 9, 6},
           	{-3, 9, 4},
           	{-3, 9, 2},
           	{-3, 9, 3},
    	});
	}
 
	public CalculatorTest(int x, int y, int res) {
		this.x = x;
		this.y = y;
		this.res = res;
	}
 
	@Test
	public void testAdd() {
		assertEquals(res, cal.add(x, y));
	}
 
}
