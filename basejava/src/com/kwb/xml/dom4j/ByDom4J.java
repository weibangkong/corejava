package com.kwb.xml.dom4j;


import com.kwb.xml.Book;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ByDom4J {
    private static List<Book> books = null;
    private static Book book = null;
    public static List<Book> getBooks(String fileName){
        SAXReader saxReader = new SAXReader();
        try {
            Document doc = saxReader.read(new File(fileName));
            Element bookStore = doc.getRootElement();
            Iterator storeit = bookStore.elementIterator();
            books = new ArrayList<>();
            //先遍历根节点的子元素
            while (storeit.hasNext()) {
                book = new Book();
                Element bookElement = (Element) storeit.next();
                List<Attribute> attributes = bookElement.attributes();
                for (Attribute attribute : attributes) {
                    if ("id".equals(attribute.getName())) {
                        book.setId(Integer.parseInt(attribute.getValue()));
                    }
                }

                Iterator bookit = bookElement.elementIterator();
                //便利一级节点的子元素
                while (bookit.hasNext()) {
                    Element child = (Element) bookit.next();
                    String tagName = child.getName();
                    if ("name".equals(tagName)) {
                        book.setName(child.getStringValue());
                    } else if ("author".equals(tagName)) {
                        book.setAuthor(child.getStringValue());
                    } else if ("year".equals(tagName)) {
                        book.setYear(Integer.parseInt(child.getStringValue()));
                    } else if ("price".equals(tagName)) {
                        book.setPrice(Integer.parseInt(child.getStringValue()));
                    }
                }
                books.add(book);
                book = null;
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return books;
    }

}
