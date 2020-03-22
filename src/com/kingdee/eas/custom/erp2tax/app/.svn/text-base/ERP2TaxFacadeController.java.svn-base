package com.kingdee.eas.custom.erp2tax.app;

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

public interface ERP2TaxFacadeController extends BizController
{
    public void execute(Context ctx, String sqlStr) throws BOSException, RemoteException;
    public String exeExport2Tax(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException;
    public String exeSynResult(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException;
    public String ExportWriteBack2Tax(Context ctx, String jsonStr) throws BOSException, EASBizException, RemoteException;
}