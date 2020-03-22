package com.kingdee.eas.custom.eas2wincos.app;

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

public interface EAS2WinCosFacadeController extends BizController
{
    public String importBill(Context ctx, String companyID, String jsonStr, int sourceType) throws BOSException, EASBizException, RemoteException;
    public String exportBill(Context ctx, String companyID, String jsonStr, int sourceType) throws BOSException, EASBizException, RemoteException;
}