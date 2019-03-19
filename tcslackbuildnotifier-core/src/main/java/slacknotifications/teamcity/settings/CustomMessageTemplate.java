package slacknotifications.teamcity.settings;

import org.jdom.Element;

class CustomMessageTemplate {
    private String templateType;
    private String templateText;
    private boolean isEnabled;

    private static final String XML_ELEMENT_NAME = "custom-template";
    static final String TYPE = "type";
    static final String TEMPLATE = "template";
    static final String ENABLED = "isEnabled";

    static CustomMessageTemplate create(String templateType, String template, boolean enabled) {
        CustomMessageTemplate t = new CustomMessageTemplate();
        t.templateType = templateType;
        t.templateText = template;
        t.isEnabled = enabled;
        return t;
    }

    Element getAsElement() {
        Element e = new Element(XML_ELEMENT_NAME);
        e.setAttribute(TYPE, this.templateType);
        e.setAttribute(TEMPLATE, this.templateText);
        e.setAttribute(ENABLED, String.valueOf(this.isEnabled));
        return e;
    }
}