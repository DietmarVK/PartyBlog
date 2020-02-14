package bl;

import data.PartyBlogEntry;
import db.DBAccess;
import dbconfig.DBManager;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author HEILJulian
 */
public class PartyBlogModel {

    private DBManager dbm = DBManager.getInstance();
    private DBAccess dba = DBAccess.getInstance();

    private PartyBlogModel() {
        this.dbm.loadAndConnect();
    }

    public static PartyBlogModel getInstance() {
        return PartyBlogModel2Holder.INSTANCE;
    }

    private static class PartyBlogModel2Holder {

        private static final PartyBlogModel INSTANCE = new PartyBlogModel();
    }

    public List<PartyBlogEntry> getAllEntries() throws SQLException {
        return this.dba.getAllEntries();
    }

    public void addEntry(PartyBlogEntry entry) throws SQLException {
        this.dba.addEntry(entry);
    }
}
