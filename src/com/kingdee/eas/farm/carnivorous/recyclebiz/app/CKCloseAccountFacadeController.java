package com.kingdee.eas.farm.carnivorous.recyclebiz.app;

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

public interface CKCloseAccountFacadeController extends BizController
{
    public boolean checkIsClosed(Context ctx, String companyID, String periodID) throws BOSException, EASBizException, RemoteException;
    public void closeAccount(Context ctx, String companyID, String periodID) throws BOSException, EASBizException, RemoteException;
    public void unCloseAccount(Context ctx, String companyID, String periodID) throws BOSException, EASBizException, RemoteException;
}