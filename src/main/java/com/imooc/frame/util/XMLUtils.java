package com.imooc.frame.util;

import com.imooc.demo.utils.ComFun;
import com.imooc.frame.flowctrl.config.XmlFlowctrlConfigParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.w3c.dom.*;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XMLUtils {

    private static final Logger log = LoggerFactory.getLogger(XmlFlowctrlConfigParser.class);

    private static String log001 = "";

    public static final DummyErrorHandler DUMMY_ERROR_HANDLER = new DummyErrorHandler();

    public static class DummyErrorHandler implements ErrorHandler {

        @Override
        public void warning(SAXParseException exception) throws SAXException {
            throw exception;
        }

        @Override
        public void error(SAXParseException exception) throws SAXException {
            throw exception;
        }

        @Override
        public void fatalError(SAXParseException exception) throws SAXException {
            throw exception;
        }
    }

    public static Document getDocument(File f, boolean validate) {
        Document doc = null;
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setValidating(validate);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            documentBuilder.setErrorHandler(DUMMY_ERROR_HANDLER);
            doc = documentBuilder.parse(f);
            doc.getDocumentElement().normalize();
        } catch (Exception err) {
            log.error(log001, err, f.getName());
        }
        return doc;
    }

    public static Document getDocument(File f) {
        return getDocument(f, true);
    }

    public static Document getDocument(InputStream is) {
        return getDocument(new InputSource(is));
    }

    private static Document getDocument(InputSource inputSource) {
        return getDocument(inputSource, false);
    }
    private static Document getDocument(InputSource is, boolean validate) {
        Document doc = null;
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setValidating(validate);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            documentBuilder.setErrorHandler(DUMMY_ERROR_HANDLER);
            doc = documentBuilder.parse(is);
            doc.getDocumentElement().normalize();
        } catch (Exception err) {
            log.error(log001, err);
        }
        return doc;
    }

    /**
     * 深度遍历打印XML配置文件
     * @param document
     */
    public static void deepPrintDocument(Document document) {
        ComFun.log("Start DeepPrint Document");
        XMLUtils.deepPrintDocument(document.getFirstChild(), 0);
    }

    private static void deepPrintDocument(Node node, int depth) {

        // 当前节点为#test节点
        if (node.getNodeType() == Node.TEXT_NODE) {
            return ;
        }

        // 当前节点信息
        String nodeName = node.getNodeName();
//        ComFun.logDepth(nodeName, depth);
        String nodeAllStr = "";
        nodeAllStr = "<" + nodeName;
        // 当前节点属性信息
        NamedNodeMap namedNodeMap = node.getAttributes();
        if (namedNodeMap != null) {
            for (int i=0; i<namedNodeMap.getLength(); i++) {
                if (namedNodeMap.item(i).getNodeType() != Node.ATTRIBUTE_NODE) {
                    // 如果不是元素节点，则跳过
                    continue;
                }
                Node attrNode = namedNodeMap.item(i);
                nodeName = attrNode.getNodeName();
                String nodeValue = attrNode.getNodeValue();
//                ComFun.logDepth("Attr:" + nodeName + "; Value:" + nodeValue, depth);
                nodeAllStr = nodeAllStr + " " + nodeName + "=\"" + nodeValue + "\"";
            }
        }
        nodeAllStr = nodeAllStr + ">";

        ComFun.logDepth(nodeAllStr, depth);

        // 子节点信息
        NodeList nodeList = node.getChildNodes();
        for (int i=0; i<nodeList.getLength(); i++) {
            Node subNode = nodeList.item(i);
//            ComFun.logDepth("Sub:" + subNode.getNodeName(), depth);
            deepPrintDocument(subNode, depth + 1);
        }

        ComFun.logDepth("</" + node.getNodeName() + ">", depth);
    }

    public static String getNodeAttributeValue(Node node, String attrId) {
        NamedNodeMap attributes = node.getAttributes();
        Node attrItemNode = attributes.getNamedItem(attrId);
        if (attrItemNode == null) {
            return null;
        } else {
            return attrItemNode.getNodeValue();
        }
    }

    /**
     * 得到XML文件中某个Node下的所有child节点，限定名字为给定的名字
     *
     * @param node
     * @param nodeId
     * @return
     */
    public static List<Node> childNodeList(Node node, String nodeId) {
        if (node == null || !StringUtils.hasText(nodeId)) {
            return null;
        }
        List<Node> nodeList = new ArrayList<Node>();
        Node childNode = node.getFirstChild();
        if (childNode != null) {
            do {
                if (childNode.getNodeType() == Node.ELEMENT_NODE
                        && nodeId.equals(childNode.getNodeName())) {
                    nodeList.add(childNode);
                }
            } while ((childNode = childNode.getNextSibling()) != null);
        }
        return nodeList;
    }

    public static List<Node> childNodeList(Node node) {
        if (node == null) {
            return null;
        }
        List<Node> nodeList = new ArrayList<>();
        Node childNode = node.getFirstChild();
        if (childNode != null) {
            do {
                if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                    nodeList.add(childNode);
                }
            } while ((childNode = childNode.getNextSibling()) != null);
        }
        return nodeList;
    }

}
