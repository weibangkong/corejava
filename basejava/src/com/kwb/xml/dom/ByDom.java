package com.kwb.xml.dom;

import com.kwb.xml.Book;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ByDom {
    private static DocumentBuilderFactory dbFactory = null;
    private static DocumentBuilder db = null;
    private static Document doc = null;
    private static List<Book> books = null;

    static{
        dbFactory = DocumentBuilderFactory.newInstance();
        try {
            db = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static List<Book> getBooks(String fileName) {
        try {
            doc = db.parse(fileName);
            NodeList bookList = doc.getElementsByTagName("book");
            books = new ArrayList<>();
            for (int i = 0; i < bookList.getLength(); i++) {
                Book book = new Book();
                Node node = bookList.item(i);
                NamedNodeMap namedNodeMap = node.getAttributes();
//                int id = ;
//                System.out.println(namedNodeMap.getNamedItem("id").getTextContent());
                book.setId(Integer.parseInt(namedNodeMap.getNamedItem("id").getTextContent()));

                NodeList childList = node.getChildNodes();
                List<String> contents = new ArrayList<>();
                //有个标签头还有个标签尾，需要去掉
                for (int i1 = 1; i1 < childList.getLength(); i1+=2) {
                    Node cNode = childList.item(i1);
                    contents.add(cNode.getFirstChild().getTextContent());
                }
                book.setName(contents.get(0));
                book.setAuthor(contents.get(1));
                book.setYear(Integer.parseInt(contents.get(2)));
                book.setPrice(Integer.parseInt(contents.get(3)));
                books.add(book);
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;

    }
}
