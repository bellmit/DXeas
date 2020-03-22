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

public interface IWSSignedBillFacade extends IBizCtrl
{
    public String getBillType(String userNumber) throws BOSException;
    public String importBillInfo(String jsonData) throws BOSException;
    public String getBillList(String userNumber, String fnumber, String dateS, String dateE) throws BOSException;
    public String getBillInfoById(String fid) throws BOSException;
    public String getOrgInfoByUser(String userNumber) throws BOSException;
    public String getOrgListByUser(String userNumber) throws BOSException;
    public String getDeptListByCompany(String company) throws BOSException;
    public String deleteSignBillByFid(String fid) throws BOSException;
    public String getAddressesByName(String param) throws BOSException;
}