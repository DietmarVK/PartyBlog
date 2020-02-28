package blogTests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author HEILJulian
 */
public class ConnectTest {

    private Connection con;

    @Test
    public void tester() {
        try {
            con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/PartyBlog", "postgres", "jJ18102000");
            Assert.assertNotNull("Verbindung ok", con);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
