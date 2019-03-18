package com.kwb.xml.jdom;

import com.kwb.xml.Book;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ByJDom  {
    private static List<Book> books = null;
    private static Book book = null;

    public  static List<Book> getBooks(String fileName) {
        SAXBuilder saxBuilder = new SAXBuilder();
        try {
            Document doc = saxBuilder.build(new FileInputStream(fileName));
            Element rootElement = doc.getRootElement();
            //处理book节点
            List<Element> bookList = rootElement.getChildren();
            books = new ArrayList<>();
            for (Element bookElement : bookList) {
                book = new Book();
                List<Attribute> bookAttributes = bookElement.getAttributes();
                for (Attribute bookAttribute : bookAttributes) {
                    if ("id".equals(bookAttribute.getName())) {
                        book.setId(Integer.parseInt(bookAttribute.getValue()));
                    }
                }

                //处理子节点book属性
                List<Element> childs = bookElement.getChildren();
                for (Element child : childs) {
                    if ("name".equals(child.getName())) {
                        book.setName(child.getValue());
                    }else if("author".equals(child.getName())){
                        book.setAuthor(child.getValue());
                    }else if("year".equals(child.getName())){
                        book.setYear(Integer.parseInt(child.getValue()));
                    }else if("price".equals(child.getName())){
                        book.setPrice(Integer.parseInt(child.getValue()));
                    }
                }
                books.add(book);
                book = null;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JDOMException e) {
            e.printStackTrace();
        }
        return books;
    }
}
