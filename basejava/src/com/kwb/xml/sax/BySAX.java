package com.kwb.xml.sax;

import com.kwb.xml.Book;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class BySAX {
    private static List<Book> books = null;
    private static SAXParserFactory saxParserFactory = null;
    private static SAXParser sp = null;

    public static List<Book> getBooks(String fileName) throws ParserConfigurationException, SAXException, IOException {
        saxParserFactory = SAXParserFactory.newInstance();
        sp = saxParserFactory.newSAXParser();

        SAXParseHandler spHandler = new SAXParseHandler();
        sp.parse(fileName,spHandler);
        return spHandler.getBooks();
    }

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        books = new BySAX().getBooks("D:\\corejava\\basejava\\src\\com\\kwb\\xml\\MyXML");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
