package blogTests.dbconfig;

import dbconfig.DBProperties;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lukas Patter
 */
public class DBPropertiesTest {

    @Test
    public void testDBProperties() {
        System.out.println("*+Test Properties von Lukas Patter **");
        assertEquals("DRIVER:", DBProperties.DB_DRIVER.getText(), 
                DBProperties_Test.DRIVER);
        assertEquals("URL:", DBProperties.DB_URL.getText(), DBProperties_Test.URL);
        assertEquals("USERNAME:", DBProperties.DB_USERNAME.getText(), DBProperties_Test.USERNAME);
        assertEquals("PASSWORD:", DBProperties.DB_PASSWORD.getText(), DBProperties_Test.PASSWORD);
    }
    @Test
    public void testDBPropertiesFail() {
        System.out.println("*+Test Fail **");
        assertEquals("DRIVER:", "XX","YY");
    }
    @Test
    public void testDBPropertiesPass() {
        System.out.println("*+Test Pass **");
        assertEquals("DRIVER:", "XX","XX");
    }    
}
