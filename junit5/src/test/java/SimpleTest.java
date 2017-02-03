

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

/**
 * The simplest test for JUnit 5. The runner <code>JUnitPlatform</code> is necessary
 * for backward compatibility with STS (IDE).
 *
 * @see http://stackoverflow.com/questions/38402155/eclipse-junit-5-support
 */
@RunWith(JUnitPlatform.class)
public class SimpleTest {

	
	@Test
	void helloWorld() {
		System.out.println("Hello world!");
	}
	
	@Test
	@DisplayName("First real test")
	void firstRealTest(TestInfo testInfo) {
		assertEquals(2, 1 + 1);
		assertEquals("First real test", testInfo.getDisplayName(), "Error message");
	}

}
