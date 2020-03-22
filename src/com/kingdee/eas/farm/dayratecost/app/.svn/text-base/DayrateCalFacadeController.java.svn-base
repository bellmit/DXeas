package com.kingdee.eas.farm.dayratecost.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface DayrateCalFacadeController extends BizController
{
    public Object exeCalDayrate(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException;
    public void exeClose(Context ctx, String companyID, String periodID) throws BOSException, EASBizException, RemoteException;
    public void exeUnClose(Context ctx, String companyID, String periodID) throws BOSException, EASBizException, RemoteException;
}