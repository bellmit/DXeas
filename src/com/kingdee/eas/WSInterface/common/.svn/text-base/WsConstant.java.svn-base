package com.kingdee.eas.WSInterface.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kingdee.eas.basedata.master.account.AccountViewInfo;
import com.kingdee.eas.basedata.master.auxacct.AsstAccountInfo;
import com.kingdee.eas.fi.cas.PaymentBillInfo;
import com.kingdee.eas.fi.cas.ReceivingBillInfo;
import com.kingdee.eas.scm.cal.CostAdjustBillInfo;

public class WsConstant
{

    public WsConstant()
    {
    }

    public static final Map getBasedateType()
    {
        Map map = new HashMap();
        map.put("001", "C79FC042");
        map.put("002", "4409E7F0");
        map.put("003", "7A2569A2");
        map.put("004", "BF0C040E");
        map.put("005", "7A2569A2");
        map.put("006", "37C67DFC");
        map.put("007", "80EF7DED");
        map.put("008", "13B7DE7F");
        map.put("810", "2665126B");
        map.put("811", "0C5DD6B6");
        map.put("812", "818DCAFB");
        map.put("813", "0C5D0DD8");
        map.put("814", "1C2AC868");
        map.put("815", "5B825C57");
        map.put("816", "CCE7AED4");
        map.put("currency", "±Ò±ð");
        return map;
    }

    public static final Map getbilldateType()
    {
        Map map = new HashMap();
        map.put("101", "3171BFAD");
        map.put("102", "9757D078");
        map.put("103", "D954830A");
        return map;
    }

    public static final Map getEntryItem()
    {
        Map map = new HashMap();
        map.put("D414BF47", "\u91C7\u8D2D\u8BA2\u5355\u8D39\u7528\u5206\u5F55");
        map.put("99DF069F", "\u8D27\u67DC\u6E05\u5173\u9884\u7B97\u5355\u7269\u6599\u8D39\u7528\u9879\u76EE");
        map.put("E31A6E31", "\u8D27\u67DC\u6E05\u5173\u7ED3\u7B97\u5355\u7269\u6599\u8D39\u7528\u9879\u76EE");
        return map;
    }

    public static final List getEntryList(String BosType)
    {
        List entryList = new ArrayList();
        if(BosType.equals("9757D078") || BosType.equals("D954830A"))
        {
            entryList.add("Entry");
            entryList.add("Goods");
        } else
        if(BosType.equals("3171BFAD"))
            entryList.add("entries");
        else
        if(BosType.equals("BF0C040E"))
            entryList.add("customerGroupDetails");
        else
        if(BosType.equals("37C67DFC"))
            entryList.add("supplierGroupDetails");
        else
        if(BosType.equals("4409E7F0"))
            entryList.add("materialGroupDetails");
        if(BosType.equals( new AsstAccountInfo().getBOSType().toString()))
            entryList.add("asstActGpDt");
        if(BosType.equals( new AccountViewInfo().getBOSType().toString()))
            entryList.add("accountCurrency");
        if(BosType.equals( new ReceivingBillInfo().getBOSType().toString()))
        	entryList.add("entries");	
        	//entryList.add("assItemsEntries");	
        	//entryList.add("assItems");	
    	 if(BosType.equals( new CostAdjustBillInfo().getBOSType().toString()))
             	entryList.add("entry");
    	 if(BosType.equals( new PaymentBillInfo().getBOSType().toString()))
          	entryList.add("entries");
    	//entryList.add("assItemsEntries");	
     	//entryList.add("assItems");
        return entryList;
    }
}