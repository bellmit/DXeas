package com.kingdee.eas.weighbridge.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface WSWeighbridgeFacadeController extends BizController
{
    public String uploadBill(Context ctx, String billJSON) throws BOSException, RemoteException;
    public boolean isStorageOrgIsFirstIn(Context ctx, String ctrlUnitID, String stoOrgUnitID, Date bizDate) throws BOSException, RemoteException;
}