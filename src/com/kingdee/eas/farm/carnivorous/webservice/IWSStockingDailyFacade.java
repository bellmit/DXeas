package com.kingdee.eas.farm.carnivorous.webservice;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.custom.commonld.IWebServiceFacade;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public interface IWSStockingDailyFacade extends IWebServiceFacade
{
    public String getDailyInitBillInfo(String param) throws BOSException;
}