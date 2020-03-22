package com.kingdee.eas.custom.tocloud.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASAppException;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface DataSynPlateformFacadeController extends BizController
{
    public String login(Context ctx) throws BOSException, RemoteException;
    public String getBillList(Context ctx, String param) throws BOSException, EASBizException, RemoteException;
    public String getBillHeader(Context ctx, String param) throws BOSException, EASBizException, RemoteException;
    public String synData(Context ctx, String jsonParam) throws BOSException, EASAppException, RemoteException;
}