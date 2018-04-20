package me.notechus.poo.lista4.zad4;

import org.junit.Test;

/**
 * @author Sebastian Paulus
 */
public class TagBuilderTest {

    @Test
    public void tagBuilderTest() {
        TagBuilder builder = new TagBuilder();
        builder.setIndented(true);
        builder.setIndentation(4);

        builder.startTag("parent")
                .addAttribute("parentproperty1", "true")
                .addAttribute("parentproperty2", "5")
                .startTag("child1")
                .addAttribute("childproperty1", "c")
                .addContent("childbody")
                .endTag()
                .startTag("child2")
                .addAttribute("childproperty2", "c")
                .addContent("childbody")
                .endTag()
                .endTag()
                .startTag("script")
                .addContent("$.scriptbody();")
                .endTag();

        System.out.println(builder.build());
    }

}