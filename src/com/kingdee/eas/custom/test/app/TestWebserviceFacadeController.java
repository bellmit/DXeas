package com.kingdee.eas.custom.test.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface TestWebserviceFacadeController extends BizController
{
    public String getData(Context ctx, String jsonStr) throws BOSException, RemoteException;
}