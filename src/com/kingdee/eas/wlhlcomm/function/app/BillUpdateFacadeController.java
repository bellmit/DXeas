package com.kingdee.eas.wlhlcomm.function.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.util.Map;
import java.util.List;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface BillUpdateFacadeController extends BizController
{
    public List getUserCanEditBills(Context ctx, String userID) throws BOSException, RemoteException;
    public Map getBillEidtFields(Context ctx, String editBillID) throws BOSException, RemoteException;
}