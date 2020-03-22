package com.kingdee.eas.WSInterface;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import java.lang.String;
import com.kingdee.bos.util.*;
import com.kingdee.eas.fi.gl.WSVoucherCollection;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.framework.*;

public interface IWSInterfaceFacade extends IBizCtrl
{
    public String getBaseData(String queryStr) throws BOSException;
    public String importVoucher(WSVoucherCollection col, int isVerify, int isCashflow) throws BOSException;
    public String importBill(String BosType, String BillJSON, int BillStatus) throws BOSException;
    public String getVoucher(String orgNumber, String year, String period, int fromRow, int toRow) throws BOSException;
    public String findVoucher(String orgNumber, int year, int period) throws BOSException;
    public String ImpBaseData(String billType, String JSON, int billStatus) throws BOSException;
    public String getBaseDataByOrgNum(String queryStr) throws BOSException;
    public String getVoucher(String OrgUnitID, String year, String period, String numbers) throws BOSException;
}