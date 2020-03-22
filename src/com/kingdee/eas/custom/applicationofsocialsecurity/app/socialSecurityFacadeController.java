package com.kingdee.eas.custom.applicationofsocialsecurity.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import java.util.ArrayList;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import java.util.Date;
import com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionInfo;
import com.kingdee.bos.framework.*;
import java.util.HashMap;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface socialSecurityFacadeController extends BizController
{
    public HashMap getInfoOfPersonBaseOnNumberOrName(Context ctx, String personNum, String personName, DataBaseConnectionInfo dataBaseConnectionIngfo) throws BOSException, EASBizException, RemoteException;
    public ArrayList getSHRSIStatus(Context ctx, DataBaseConnectionInfo dataBaseConnectionIngfo) throws BOSException, EASBizException, RemoteException;
    public String getSIStatusIDBaseOnHisName(Context ctx, String SIStatusName, DataBaseConnectionInfo dataBaseConnectionIngfo) throws BOSException, EASBizException, RemoteException;
    public String updateSIStatusBaseOnPersonNumAndSIStatusID(Context ctx, String SIStatusID, String personNum, DataBaseConnectionInfo dataBaseConnectionIngfo) throws BOSException, EASBizException, RemoteException;
    public ArrayList getCompanyNameFromSHR(Context ctx, DataBaseConnectionInfo dataBaseConnectionIngfo) throws BOSException, EASBizException, RemoteException;
    public ArrayList getPersonInfoByFilterItem(Context ctx, Date dateBegin, Date dateEnd, DataBaseConnectionInfo dataBaseConnectionInfo, boolean isIn, String company, String SIStatus, String personName, String personNum) throws BOSException, EASBizException, RemoteException;
}