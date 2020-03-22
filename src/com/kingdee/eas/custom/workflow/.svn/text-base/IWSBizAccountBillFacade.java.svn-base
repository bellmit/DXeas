package com.kingdee.eas.custom.workflow;

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

public interface IWSBizAccountBillFacade extends IBizCtrl
{
    public String importBizAccountBill(String dataXml) throws BOSException;
    public String getOrgInfoByUser(String user) throws BOSException;
    public String getOrgListByUser(String userId) throws BOSException;
    public String getDeptListByCompany(String company) throws BOSException;
    public String getBizType(String userId) throws BOSException;
    public String getExpTypeByBizType(String bizType, String userNumber) throws BOSException;
    public String getBizAccountBillByAssignId(String assignId) throws BOSException;
    public String getBizAccountBillList(String dataJson) throws BOSException;
}