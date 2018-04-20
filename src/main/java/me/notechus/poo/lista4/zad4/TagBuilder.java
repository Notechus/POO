package me.notechus.poo.lista4.zad4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sebastian Paulus
 */
public class TagBuilder {

    private String tagName;
    private TagBuilder parent;
    private StringBuilder body = new StringBuilder();
    private Map<String, String> attributes = new HashMap<>();
    private boolean isIndented = false;
    private int indentation;
    private int thisIndent = 0;

    public TagBuilder() {

    }

    public TagBuilder(String tagName, TagBuilder parent) {
        this.tagName = tagName;
        this.parent = parent;
        this.isIndented = parent.isIndented;
        this.indentation = parent.indentation;

        if (!this.isFirstTag()) {
            this.thisIndent = parent.thisIndent + this.indentation;
        }
    }

    public TagBuilder addContent(String content) {
        body.append(content);
        return this;
    }

    public TagBuilder addContentFormat(String format, Object... args) {
        body.append(String.format(format, args));
        return this;
    }

    public TagBuilder startTag(String tagName) {
        return new TagBuilder(tagName, this);
    }

    public TagBuilder endTag() {
        parent.addContent(this.build());
        return parent;
    }

    public TagBuilder addAttribute(String name, String value) {
        attributes.put(name, value);
        return this;
    }

    private boolean isFirstTag() {
        return this.parent != null && this.parent.parent == null;
    }

    private boolean isNonBlank(String str) {
        return str != null && str.trim().length() != 0;
    }

    public String build() {
        StringBuilder tag = new StringBuilder();

        if (this.isIndented) {
            tag.append(String.join("", Collections.nCopies(this.thisIndent, " ")));
        }
        if (isNonBlank(this.tagName)) {
            tag.append("<").append(tagName);
        }
        if (attributes.size() > 0) {
            attributes.forEach((k, v) -> tag.append(" ").append(k).append("='").append(v).append("'"));
        }

        // body/ending
        if (body.length() > 0) {
            if (isNonBlank(this.tagName) || this.attributes.size() > 0) {
                tag.append(">");
            }

            boolean hasTagsInside = body.toString().contains("<");   // multi-line tag
            if (this.isIndented && hasTagsInside) {
                tag.append("\n");
            }

            tag.append(body.toString()); // body

            if (isNonBlank(this.tagName)) {
                if (this.isIndented && hasTagsInside) {
                    tag.append(String.join("", Collections.nCopies(this.thisIndent, " ")));
                }
                tag.append("</").append(this.tagName).append(">");

                if (this.isIndented) {
                    tag.append("\n");
                }
            }
        } else {
            if (isNonBlank(this.tagName)) {
                tag.append("/>");
            }

            if (this.isIndented) {
                tag.append("\n");
            }
        }
        return tag.toString();
    }

    public boolean isIndented() {
        return isIndented;
    }

    public void setIndented(boolean indented) {
        isIndented = indented;
    }

    public void setIndentation(int indentation) {
        this.indentation = indentation;
    }
}
