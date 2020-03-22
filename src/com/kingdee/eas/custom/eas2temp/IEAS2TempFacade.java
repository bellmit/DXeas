package com.kingdee.eas.custom.eas2temp;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import java.lang.String;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.framework.*;

public interface IEAS2TempFacade extends IBizCtrl
{
    public String exportBill(String companyID, String jsonStr, int sourceType) throws BOSException;
    public String importBill(String companyID, String jsonStr, int sourceType) throws BOSException;
    public boolean testConn(String companyID, int targetSystem) throws BOSException;
    public String exportBillByID(String companyID, String billID, int sourceType) throws BOSException;
    public void initBarEASRel(String easMaterialID, String storageUnitOrgID) throws BOSException;
    public String deleteBarAndMyData(Object obj) throws BOSException;
    public void retryWeight(String PurId) throws BOSException;
}