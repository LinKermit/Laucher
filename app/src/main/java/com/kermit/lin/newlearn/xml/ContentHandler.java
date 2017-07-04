package com.kermit.lin.newlearn.xml;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Lin on 2017/7/4.
 * SAX解析
 */

public class ContentHandler extends DefaultHandler{
    private String nameCode;
    private StringBuilder id;
    private StringBuilder name;
    private StringBuilder version;

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        id = new StringBuilder();
        name = new StringBuilder();
        version = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        //记录当前节点名
        nameCode = localName;
    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if("id".equals(nameCode)){
            id.append(ch,start,length);
        }else if("name".equals(nameCode)){
            name.append(ch,start,length);
        }else if("version".equals(nameCode)){
            version.append(ch,start,length);
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if ("app".equals(localName)){

            Log.e("sax",id.toString().trim() + name.toString().trim() +version.toString().trim());
            id.setLength(0);
            name.setLength(0);
            version.setLength(0);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }


}
