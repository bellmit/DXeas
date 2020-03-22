package com.kingdee.eas.custom.echickeninterface;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public interface IechickeninterfaceFacade extends IBizCtrl
{
    public String importBill(String BosType, String BillJson, int BillStatus) throws BOSException;
    public String getBaseData(String queryStr) throws BOSException;
}