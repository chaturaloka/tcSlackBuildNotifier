package slacknotifications;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peter on 3/06/2014.
 */
public class Attachment {
    private String text;
    private String pretext;
    private String color;
    private String footer;
    private String footer_icon;
    private String thumb_url;
    private String image_url;
    private List<Field> fields;
    private String fallback;

    public Attachment(String fallback, String text, String pretext, String color) {
        this.fallback = fallback;
        this.text = text;
        this.pretext = pretext;
        this.color = color;
        this.fields = new ArrayList<Field>();
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public String getFooter_icon() {
        return footer_icon;
    }

    public void setFooter_icon(String footer_icon) {
        this.footer_icon = footer_icon;
    }

    public String getThumb_url() {
        return thumb_url;
    }

    public void setThumb_url(String thumb_url) {
        this.thumb_url = thumb_url;
    }

    public void addField(String title, String value, boolean isShort) {
        this.fields.add(new Field(title, value, isShort));
    }

    public String getFallback() {
        return fallback;
    }

    public String getText() {
        return text;
    }

    public String getPretext() {
        return pretext;
    }

    public String getColor() {
        return color;
    }

    public List<Field> getFields() {
        return fields;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
