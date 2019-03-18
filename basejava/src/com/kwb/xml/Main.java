package com.kwb.xml;

import com.kwb.xml.dom.ByDom;
import com.kwb.xml.dom4j.ByDom4J;
import com.kwb.xml.jdom.ByJDom;
import com.kwb.xml.sax.BySAX;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //DOM解析
//       List<Book> books =  ByDom.getBooks("D:\\corejava\\basejava\\src\\com\\kwb\\xml\\MyXML");
        //SAX解析
//        List<Book> books = null;
//        try {
//            books = new BySAX().getBooks("D:\\corejava\\basejava\\src\\com\\kwb\\xml\\MyXML");
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        } catch (SAXException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //JDOM解析
//        List<Book> books = ByJDom.getBooks("D:\\corejava\\basejava\\src\\com\\kwb\\xml\\MyXML");
        //DOM4J解析
        List<Book> books = ByDom4J.getBooks("D:\\corejava\\basejava\\src\\com\\kwb\\xml\\MyXML");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
