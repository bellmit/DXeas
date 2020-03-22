package com.kingdee.eas.farm.food;

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

public interface IWSFoodFacade extends IBizCtrl
{
    public String uploadBill(String jsonString) throws BOSException;
    public String getBaseData(String jsonStr) throws BOSException;
    public String getBillList(String jsonString) throws BOSException;
    public String getBillInfo(String jsonString) throws BOSException;
}