/**
 * 
 */
package platform.cloud.fileservice.api;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ConstantsTest {

	@Test
	public void testConstructor() {
		Constants constants = new Constants();
		assertNotNull("constants can not be null", constants);
	}
}
