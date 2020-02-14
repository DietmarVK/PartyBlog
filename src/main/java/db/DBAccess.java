package db;

import data.PartyBlogEntry;
import dbconfig.DBManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sql.SQLStatements;

/**
 *
 * @author HEILJulian
 */
public class DBAccess {

    private final DBManager dbm = DBManager.getInstance();

    public static DBAccess getInstance() {
        return DBAccessHolder.INSTANCE;
    }

    private static class DBAccessHolder {

        private static final DBAccess INSTANCE = new DBAccess();
    }

    public List<PartyBlogEntry> getAllEntries() throws SQLException {
        List<PartyBlogEntry> entries = new ArrayList();
        PreparedStatement prstmt = dbm.createPreparedStatement(SQLStatements.STMT_GET_ALL_ENTRIES.getSql(), Statement.RETURN_GENERATED_KEYS);
        ResultSet resultSet = prstmt.executeQuery();
        while (resultSet.next()) {
            PartyBlogEntry entry = new PartyBlogEntry();
            entry.setNickname(resultSet.getString("nickname"));
            entry.seteMail(resultSet.getString("eMail"));
            entry.setComment(resultSet.getString("comment"));
            entry.setRate(resultSet.getInt("rate"));
            entries.add(entry);
        }

        prstmt.close();
        resultSet.close();
        return entries;
    }

    public void addEntry(PartyBlogEntry entry) throws SQLException {
        PreparedStatement prstmt = dbm.createPreparedStatement(SQLStatements.STMT_ADD_ENTRY.getSql(), Statement.RETURN_GENERATED_KEYS);
        prstmt.setString(1, entry.getNickname());
        prstmt.setString(2, entry.geteMail());
        prstmt.setString(3, entry.getComment());
        prstmt.setInt(4, entry.getRate());
        int m = prstmt.executeUpdate();
        System.out.println("ADD: " + m);
        prstmt.close();
    }
}
