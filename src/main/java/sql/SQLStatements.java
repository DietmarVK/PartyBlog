package sql;

/**
 *
 * @author Julian Heil
 */
public enum SQLStatements {
    STMT_GET_ALL_ENTRIES("SELECT * FROM BlogEntry;"),
    STMT_ADD_ENTRY("INSERT INTO BlogEntry (nickname,eMail,comment,rate) VALUES (?,?,?,?);");

    private String sql;

    private SQLStatements(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }
}
