package ag.test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class GSAppTest {

	@Parameters	
	public static Collection<Object[]> data() {
    	return Arrays.asList(new Object[][]{
           	{2, 4, 6},
    	});
	}

}
