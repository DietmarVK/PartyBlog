package dbconfig;

/**
 *
 * @author HEILJulian
 */
public enum DBProperties {
    
    DB_DRIVER("org.postgresql.Driver"),
    DB_URL("jdbc:postgresql://127.0.0.1:5432/PartyBlog"),
    DB_USERNAME("postgres"),
    DB_PASSWORD("jJ18102000");
    
    private String text;

    private DBProperties(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
    
}
