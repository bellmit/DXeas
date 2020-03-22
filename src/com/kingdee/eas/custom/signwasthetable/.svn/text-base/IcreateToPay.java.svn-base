package com.kingdee.eas.custom.signwasthetable;

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
import com.kingdee.eas.fi.ap.PayRequestBillInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public interface IcreateToPay extends IBizCtrl
{
    public PayRequestBillInfo createPayReq(ContractInfo model) throws BOSException;
    public PayRequestBillInfo toPayReqFromSignTable(SignWasTheTableInfo model, ArrayList entryList, BOTMappingInfo botMappingInfo) throws BOSException, EASBizException;
    public BOTMappingCollection getCanUsedBotMapping(SignWasTheTableInfo model) throws BOSException, EASBizException;
}