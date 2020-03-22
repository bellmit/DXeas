package com.kingdee.eas.farm.food.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import java.util.ArrayList;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import java.util.HashMap;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface SendCarPlanFacadeController extends BizController
{
    public ArrayList getRowSet(Context ctx, HashMap hashMap) throws BOSException, EASBizException, RemoteException;
    public ArrayList getCCBatchAgeAndQty(Context ctx, Date bizDate, int breedDays, int count) throws BOSException, RemoteException;
}