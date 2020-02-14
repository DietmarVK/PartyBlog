package data;

import java.util.Objects;

/**
 *
 * @author HEILJulian
 */
public class PartyBlogEntry {

    private String nickname;
    private String eMail;
    private String comment;
    private int rate;
    private String rateStars;

    public PartyBlogEntry(String nickname, String eMail, String comment, int rate) {
        this.nickname = nickname;
        this.eMail = eMail;
        this.comment = comment;
        this.rate = rate;
        this.rateStars = "";
    }

    public PartyBlogEntry() {
    }

    public String getNickname() {
        return nickname;
    }

    public String geteMail() {
        return eMail;
    }

    public String getComment() {
        return comment;
    }

    public int getRate() {
        return rate;
    }

    public String getRateStars() {
        return rateStars;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setRateStars(String rateStars) {
        this.rateStars = rateStars;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.nickname);
        hash = 23 * hash + Objects.hashCode(this.eMail);
        hash = 23 * hash + Objects.hashCode(this.comment);
        hash = 23 * hash + this.rate;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PartyBlogEntry other = (PartyBlogEntry) obj;
        if (this.rate != other.rate) {
            return false;
        }
        if (!Objects.equals(this.nickname, other.nickname)) {
            return false;
        }
        if (!Objects.equals(this.eMail, other.eMail)) {
            return false;
        }
        if (!Objects.equals(this.comment, other.comment)) {
            return false;
        }
        return true;
    }

    public String transformRateToStars() {
        for (int i = this.rate; i > 0; i--) {
            this.rateStars += "*";
        }
        return this.rateStars;
    }

    public String toHTMLString() {
        String htmlString
                = String.format("<p><b><i>%s</i></b> (%s) says:</p>"
                        + "<p>%s</p>"
                        + "<p>%s</p>", this.nickname, this.eMail, this.comment, this.transformRateToStars());
        return htmlString;
    }

    @Override
    public String toString() {
        return "PartyBlogEntry{" + "nickname=" + nickname + ", eMail=" + eMail + ", comment=" + comment + ", rate=" + rate + '}';
    }
}
