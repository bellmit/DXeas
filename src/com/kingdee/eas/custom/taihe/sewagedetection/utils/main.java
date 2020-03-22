package com.kingdee.eas.custom.taihe.sewagedetection.utils;

import java.util.List;


public class main {

	public static void main(String[] args) {
		new main().getDatasByClass();
	}
	public void getDatasByClass()  
    {  
        Rule rule = new Rule(  
                "http://61.133.63.5:8405/showdatac.aspx",  
        new String[] { "subid","uid" }, new String[] { "2750","1" },  
                "realdata", Rule.AttributeValue, Rule.GET);  
//        List extracts = ExtractService.extract(rule);  
//        printf(extracts);  
    }  
	 public void printf(List<String> datas)  
	    {  
	        for (String dataStr : datas)  
	        {  
	            System.out.println(dataStr);  
	            System.out.println("***********************************");  
	        }  
	  
	    }  
}
