package com.kingdee.eas.WSInterface.common;

import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;



public class JSONWithXML {
    
	public static final String STR_JSON = "{\"name\":\"Michael\",\"address\":{\"city\":\"Suzou\",\"street\":\" Changjiang Road \",\"postcode\":100025},\"blog\":\"http://www.ij2ee.com\"}";
    public static String xml2JSON(String xml){
    	XMLSerializer xmls = new XMLSerializer();
    	xmls.setTrimSpaces(false);
        return xmls.read(xml).toString();
    }
     
    public static String json2XML(String json,String billType){
        JSONObject jobj = JSONObject.fromObject(json);
        XMLSerializer xmls = new XMLSerializer();
        xmls.setRootName(billType);//"ReceivingBill"
        xmls.setTrimSpaces(false);
        xmls.setTypeHintsEnabled(false);
        //xmls.setArrayName(arrayName)
        String xml =xmls.write(jobj, "UTF-8");
        return xml;
    }
     
    public static void main(String[] args) {
        String xml = json2XML(STR_JSON,null);
        System.out.println("xml = "+xml);
        String json = xml2JSON(xml);
        System.out.println("json="+json);
    }

}
