package com.kwb.xml.sax;

import com.kwb.xml.Book;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SAXParseHandler extends DefaultHandler {
    private List<Book> books;
    private Book book;

    private String content;

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        books = new ArrayList<>();
        System.out.println("-----------------start----------------------");
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("------------------stop----------------------");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (qName.equals("book")) {
            book = new Book();
            book.setId(Integer.parseInt(attributes.getValue("id")));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if("name".equals(qName)){
            book.setName(content);
        }else if ("author".equals(qName)) {
            book.setAuthor(content);
        }else if ("year".equals(qName)) {
            book.setYear(Integer.parseInt(content));
        }else if ("price".equals(qName)) {
            book.setPrice(Integer.parseInt(content));
        }else if ("book".equals(qName)) {
            books.add(book);
            book = null;
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        content = new String(ch, start, length);
    }

    public List<Book> getBooks() {
        return books;
    }
}
