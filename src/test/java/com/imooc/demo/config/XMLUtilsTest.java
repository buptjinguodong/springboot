package com.imooc.demo.config;

import com.google.gson.Gson;
import com.imooc.demo.utils.ComFun;
import com.imooc.frame.util.XMLUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class XMLUtilsTest {

    Document document = null;

    @Before
    public void setUp() throws IOException {
        Resource resource = new ClassPathResource("/application/flowctrl.xml");
        InputStream is = resource.getInputStream();
        document = XMLUtils.getDocument(is);
    }

    @Test
    public void test4getResource() throws IOException {
        ComFun.log(document.getXmlEncoding());
        ComFun.log(document.toString());
        document.getChildNodes();
        XMLUtils.deepPrintDocument(document);
    }

    @Test
    public void test4getNodeAttributeValue() {
        List<Node> nodeList = XMLUtils.childNodeList(document);
        String isctrl = XMLUtils.getNodeAttributeValue(nodeList.get(0), "isctrl");
        assert isctrl.equals("0");

        List<Node> subNodeList = XMLUtils.childNodeList(nodeList.get(0), "ctrlpoint");
        List<Node> pointNodeList = XMLUtils.childNodeList(subNodeList.get(0), "point");

        assert XMLUtils.getNodeAttributeValue(pointNodeList.get(0), "id").equals("req");
        assert XMLUtils.getNodeAttributeValue(pointNodeList.get(1), "id").equals("out");
        assert XMLUtils.getNodeAttributeValue(pointNodeList.get(0), "value").equals("3");
        assert XMLUtils.getNodeAttributeValue(pointNodeList.get(1), "value").equals("3");
    }

    @Test
    public void test4childNodeList() {
        List<Node> nodeList = XMLUtils.childNodeList(document);
        assert nodeList.size() == 1;

        nodeList = XMLUtils.childNodeList(document.getDocumentElement(), "resgroup");
        assert nodeList.size() == 1;
    }

}
