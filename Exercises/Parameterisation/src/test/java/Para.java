import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Para {
	
	@Parameters //This basically will call the constructor automatically for each object set as long as we have a collection<object[]> data
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {{"first","second",3, true}, {"third","fourth",8, false}});
	}
	
	private String a;
	private String b;
	private int c;
	private boolean d;
	
	public Para(String a, String b, int c, boolean d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	@Test
	public void test() {
		System.out.println(a + " " + b +" "+ c +" "+ d);
	}
}
