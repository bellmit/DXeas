package com.kingdee.eas.custom.echickeninterface.common;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.TreeWalker;
import org.xml.sax.SAXException;

import com.kingdee.bos.Context;
import com.kingdee.eas.basedata.master.cssp.app.DataImportUtils;

public class WsCommonXMLUtil
{

    private static String xmlParserImpl = "org.apache.xerces.jaxp.DocumentBuilderFactoryImpl";
    private static Logger logger = Logger.getLogger("com.kingdee.eas.custom.echickeninterface.common.WsCommonXMLUtil");

    public WsCommonXMLUtil()
    {
    }

    public static String getBaseUnitNumberByXML(Context ctx, String number)
        throws Exception
    {
        try
        {
            Document doc = getDocumentByFile(getFilePath("baseUnitCode.xml"));
            number = getNumberByXML(doc, "baseUnitCodes//baseUnitCode", number);
        }
        catch(Exception e)
        {
            throw new Exception((new StringBuilder(String.valueOf(DataImportUtils.getResource("com.kingdee.eas.basedata.ws.common.WebSericeResource", "READCODEFILEERROR", ctx)))).append(":").append(e.getMessage()).toString());
        }
        return number;
    }

    public static String gePropertyNumberByXML(Context ctx, String number, String filename)
        throws Exception
    {
        try
        {
            Document doc = getDocumentByFile(getFilePath(filename));
            number = getNumberByXML(doc, "Codes//Code", number);
        }
        catch(Exception e)
        {
            throw new Exception((new StringBuilder(String.valueOf(DataImportUtils.getResource("com.kingdee.eas.basedata.ws.common.WebSericeResource", "READCODEFILEERROR", ctx)))).append(":").append(e.getMessage()).toString());
        }
        return number;
    }

    private static String getNumberByXML(Document doc, String xmlTag, String number)
        throws Exception
    {
        if(doc != null)
        {
            ArrayList entiesPro = getBillEntries(doc, xmlTag);
            HashMap codeMap = null;
            int i = 0;
            for(int count = entiesPro.size(); i < count; i++)
            {
                codeMap = null;
                codeMap = (HashMap)entiesPro.get(i);
                if(isFoundNumber(codeMap, number))
                {
                    String tonumber = (String)codeMap.get("to_eas");
                    if(tonumber != null && !"".equals(tonumber))
                        return tonumber;
                }
            }

        }
        return number;
    }

    private static boolean isFoundNumber(HashMap map, String number)
    {
        if(map == null || map.size() <= 0)
            return false;
        String fromNumber = (String)map.get("from_mdm");
        return fromNumber != null && fromNumber.equals(number);
    }

    private static String getFilePath(String fileName)
    {
        File directory = new File("");
        String path = directory.getAbsolutePath().substring(0, directory.getAbsolutePath().toLowerCase().lastIndexOf("eas"));
        path = (new StringBuilder(String.valueOf(path))).append("eas/Server/server/properties/code/").append(fileName).toString();
        return path;
    }

    public static String getCUtNumberByXML(String number)
        throws Exception
    {
        Document doc = getDocumentByFile(getFilePath("cuCode.xml"));
        number = getNumberByXML(doc, "cuCodes//cuCode", number);
        return number;
    }

    public static Document getDocumentByFile(String file)
        throws Exception
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = factory.newDocumentBuilder();
        File files = new File(file);
        Document doc = null;
        if(files != null)
            doc = db.parse(files);
        return doc;
    }

    public static String getAttributeValue(Document doc, String attributeName)
    {
        Element rootElement = doc.getDocumentElement();
        if(rootElement != null)
            return rootElement.getAttribute(attributeName);
        else
            return null;
    }

    public static void validateRootElement(Document doc, String rootTagName)
        throws Exception
    {
        Element rootElement = doc.getDocumentElement();
        if(!rootElement.getTagName().equals(rootTagName))
            throw new Exception("BillXmlFormat IS ERROR!");
        else
            return;
    }

    public static DocumentBuilderFactory getDocumentBuilderFactory()
    {
        ClassLoader oldCL = Thread.currentThread().getContextClassLoader();
        DocumentBuilderFactory documentbuilderfactory;
        String oldDocBuilderFactory = null;
        DocumentBuilderFactory factory = null;
        try
        {
            Thread.currentThread().setContextClassLoader(org.apache.xerces.jaxp.DocumentBuilderFactoryImpl.class.getClassLoader());
            oldDocBuilderFactory = System.getProperty("javax.xml.parsers.DocumentBuilderFactory");
            if(!xmlParserImpl.equals(oldDocBuilderFactory))
                System.setProperty("javax.xml.parsers.DocumentBuilderFactory", xmlParserImpl);
            factory = DocumentBuilderFactory.newInstance();
        }
        catch(SecurityException se)
        {
            logger.error(se);
            se.printStackTrace();
        }
        if(oldDocBuilderFactory != null)
            System.setProperty("javax.xml.parsers.DocumentBuilderFactory", oldDocBuilderFactory);
        factory = factory;
        documentbuilderfactory = factory;
        try
        {
            Thread.currentThread().setContextClassLoader(oldCL);
        }
        catch(SecurityException se)
        {
            logger.error(se);
            se.printStackTrace();
        }
        try
        {
            Thread.currentThread().setContextClassLoader(oldCL);
        }
        catch(SecurityException se)
        {
            logger.error(se);
            se.printStackTrace();
        }
        return documentbuilderfactory;
    }

    public static Document builderDocument()
        throws ParserConfigurationException
    {
        DocumentBuilderFactory factory = getDocumentBuilderFactory();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.newDocument();
    }

    public static Document builderDocumentFromFile(String filePath)
        throws SAXException, IOException, ParserConfigurationException
    {
        DocumentBuilderFactory factory = getDocumentBuilderFactory();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(filePath);
    }

    public static Document builderDocument(String xmlContent)
        throws SAXException, IOException, ParserConfigurationException
    {
        DocumentBuilderFactory builder = getDocumentBuilderFactory();
        ByteArrayInputStream input = new ByteArrayInputStream(xmlContent.getBytes("UTF-8"));
        DocumentBuilder parser = builder.newDocumentBuilder();
        return parser.parse(input);
    }

    public static HashMap getBillHead(Document doc, String headName)
    {
        if(doc == null)
            return null;
        HashMap headMap = null;
        NodeList childs = doc.getElementsByTagName(headName);
        String value = null;
        if(childs != null && childs.getLength() > 0)
        {
            headMap = new HashMap();
            NodeList subChilds = childs.item(0).getChildNodes();
            for(int i = 0; subChilds != null && i < subChilds.getLength(); i++)
                if(subChilds.item(i).getNodeType() == 1)
                {
                    Element subElement = (Element)subChilds.item(i);
                    Node subChild = subElement.getFirstChild();
                    if(subChild != null)
                    {
                        value = subChild.getNodeValue();
                        if(value != null)
                            headMap.put(subElement.getTagName(), value.trim());
                    }
                }

        }
        return headMap;
    }

    public static ArrayList getBillEntries(Document doc, String xpath)
        throws TransformerException
    {
        if(doc == null)
            return null;
        NodeList subChilds = getNodeListFromXpath(doc, xpath);
        ArrayList entries = new ArrayList();
        HashMap entryMap = null;
        String value = null;
        for(int i = 0; subChilds != null && i < subChilds.getLength(); i++)
            if(subChilds.item(i).getNodeType() == 1)
            {
                entryMap = new HashMap();
                Element entryElement = (Element)subChilds.item(i);
                if(entryElement != null)
                {
                    NodeList entryChildList = entryElement.getChildNodes();
                    for(int j = 0; entryChildList != null && j < entryChildList.getLength(); j++)
                        if(entryChildList.item(j).getNodeType() == 1)
                        {
                            Node subChild = entryChildList.item(j);
                            if(subChild != null && subChild.getNodeType() == 1)
                            {
                                Node textNode = getChildTextNode(subChild);
                                if(textNode != null)
                                {
                                    value = textNode.getNodeValue();
                                    if(value != null)
                                        entryMap.put(subChild.getNodeName(), value.trim());
                                }
                            }
                        }

                }
                entries.add(entryMap);
            }

        return entries;
    }

    public static Node getChildTextNode(Node ele)
    {
        if(ele != null)
        {
            Document doc = ele.getOwnerDocument();
            DOMImplementation domImpl = doc.getImplementation();
            if(domImpl.hasFeature("Traversal", "2.0"))
            {
                DocumentTraversal traversal = (DocumentTraversal)doc;
                int whatToShow = -1;
                TextFilter filter = new TextFilter();
                TreeWalker tree = traversal.createTreeWalker(ele, whatToShow, filter, false);
                return tree.firstChild();
            }
        }
        return null;
    }

    public static NodeList getNodeListFromXpath(Node node, String partern)
        throws TransformerException
    {
        if(partern != null && partern.lastIndexOf("/") > 0)
        {
            String elementTag = partern.substring(partern.lastIndexOf("/") + 1);
            if(elementTag != null)
            {
                if(node.getNodeType() == 1)
                    return ((Element)node).getElementsByTagName(elementTag);
                if(node.getNodeType() == 9)
                    return ((Document)node).getElementsByTagName(elementTag);
            }
        }
        return null;
    }

    public static final synchronized boolean writeXmlFile(String fileName, Document document)
        throws Exception
    {
        DOMSource doms = new DOMSource(document);
        File file = new File(fileName);
        StreamResult result = new StreamResult(file);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        Properties properties = transformer.getOutputProperties();
        properties.setProperty("encoding", "UTF-8");
        properties.setProperty("method", "xml");
        properties.setProperty("indent", "yes");
        transformer.setOutputProperties(properties);
        transformer.transform(doms, result);
        return true;
    }

    public static final String domToString(Document document)
        throws Exception
    {
        DOMSource doms = new DOMSource(document);
        StringWriter strWriter = new StringWriter();
        StreamResult result = new StreamResult(strWriter);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        Properties properties = transformer.getOutputProperties();
        properties.setProperty("encoding", "UTF-8");
        properties.setProperty("method", "xml");
        properties.setProperty("indent", "yes");
        transformer.setOutputProperties(properties);
        transformer.transform(doms, result);
        return strWriter.toString();
    }

    public static Date convertStrToDate(String strDate, String parttern)
        throws ParseException
    {
        if(strDate != null)
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat(parttern);
            return dateFormat.parse(strDate);
        } else
        {
            return null;
        }
    }

    public static Document buildDocument(InputStream in)
        throws ParserConfigurationException, SAXException, IOException
    {
        DocumentBuilderFactory factory = getDocumentBuilderFactory();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(in);
    }

    public static String buildResultXml(String retstatusValue, String number, String Messages)
    {
        ArrayList list = new ArrayList();
        HashMap errorMessage = new HashMap();
        if(Messages != null && !"".equals(Messages))
        {
            list.add(number);
            errorMessage.put(number, Messages);
        }
        return buildResultXml(retstatusValue, list, errorMessage);
    }

    public static String buildResultXml(String retstatusValue, ArrayList numberlist, HashMap Messages)
    {
        String resultXml = "";
        try{
	        Document doc = builderDocument();
	        Element root = doc.createElement("Result");
	        Element retstatus = doc.createElement("retstatus");
	        retstatus.appendChild(doc.createTextNode(retstatusValue));
	        Element errorMessages = doc.createElement("errorMessages");
	        String number = null;
	        int i = 0;
	        for(int count = numberlist.size(); i < count; i++)
	        {
	            number = (String)numberlist.get(i);
	            Element errorMessage = doc.createElement("errorMessage");
	            errorMessage.setAttribute("number", number);
	            Object obj = Messages.get(number);
	            String message = "";
	            if(obj != null)
	                message = obj.toString();
	            errorMessage.appendChild(doc.createTextNode(message));
	            errorMessages.appendChild(errorMessage);
	        }
	
	        root.appendChild(retstatus);
	        root.appendChild(errorMessages);
	        doc.appendChild(root);
	        resultXml = domToString(doc);
	        return resultXml;
        }catch(Exception e){
	        resultXml = "000";
	        logger.error(e);
	        return resultXml;
        }
    }

    public static String buildBaseDataXml(Map headmap, List entiesList)
        throws Exception
    {
        Document doc = builderDocument();
        Element root = doc.createElement("DataInfo");
        Element dataHead = doc.createElement("DataHead");
        Element headPropery;
        for(Iterator strit = headmap.entrySet().iterator(); strit.hasNext(); dataHead.appendChild(headPropery))
        {
            java.util.Map.Entry et = (java.util.Map.Entry)strit.next();
            String key = et.getKey().toString();
            Object value = et.getValue();
            headPropery = doc.createElement(key);
            String textValue = "";
            if(value != null)
                textValue = value.toString();
            headPropery.appendChild(doc.createTextNode(textValue));
        }

        root.appendChild(dataHead);
        if(entiesList != null && entiesList.size() > 0)
        {
            Element dataEntries = doc.createElement("DataEntries");
            int i = 0;
            for(int count = entiesList.size(); i < count; i++)
            {
                Element entry = doc.createElement("entry");
                Map map = (Map)entiesList.get(i);
                Element entryPropery;
                for(Iterator entryit = map.entrySet().iterator(); entryit.hasNext(); entry.appendChild(entryPropery))
                {
                    java.util.Map.Entry et = (java.util.Map.Entry)entryit.next();
                    String key = et.getKey().toString();
                    Object value = et.getValue();
                    entryPropery = doc.createElement(key);
                    String textValue = "";
                    if(value != null)
                        textValue = value.toString();
                    entryPropery.appendChild(doc.createTextNode(textValue));
                }

                dataEntries.appendChild(entry);
            }

            root.appendChild(dataEntries);
        }
        doc.appendChild(root);
        return domToString(doc);
    }


}
