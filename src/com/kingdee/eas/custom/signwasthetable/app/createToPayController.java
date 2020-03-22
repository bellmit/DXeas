package com.kingdee.eas.custom.signwasthetable.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import java.util.ArrayList;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.bos.metadata.bot.BOTMappingInfo;
import com.kingdee.eas.custom.signwasthetable.ContractInfo;
import com.kingdee.eas.fi.ap.PayRequestBillInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface createToPayController extends BizController
{
    public PayRequestBillInfo createPayReq(Context ctx, ContractInfo model) throws BOSException, RemoteException;
    public PayRequestBillInfo toPayReqFromSignTable(Context ctx, SignWasTheTableInfo model, ArrayList entryList, BOTMappingInfo botMappingInfo) throws BOSException, EASBizException, RemoteException;
    public BOTMappingCollection getCanUsedBotMapping(Context ctx, SignWasTheTableInfo model) throws BOSException, EASBizException, RemoteException;
}