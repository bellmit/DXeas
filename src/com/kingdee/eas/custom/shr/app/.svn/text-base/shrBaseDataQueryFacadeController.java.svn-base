package com.kingdee.eas.custom.shr.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import java.util.ArrayList;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface shrBaseDataQueryFacadeController extends BizController
{
    public ArrayList queryForBusList(Context ctx, String queryStr) throws BOSException, RemoteException;
    public ArrayList queryForStopList(Context ctx, String sqlStopList) throws BOSException, RemoteException;
    public void excuteBusAndStop(Context ctx, String excuteStr) throws BOSException, RemoteException;
    public ArrayList queryForEmpInfo(Context ctx, String sqlPerson) throws BOSException, RemoteException;
    public String queryForOtherPerson(Context ctx, String updateDate) throws BOSException, RemoteException;
}