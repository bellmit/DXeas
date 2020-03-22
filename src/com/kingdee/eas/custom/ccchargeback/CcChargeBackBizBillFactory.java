package com.kingdee.eas.custom.ccchargeback;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CcChargeBackBizBillFactory
{
    private CcChargeBackBizBillFactory()
    {
    }
    public static com.kingdee.eas.custom.ccchargeback.ICcChargeBackBizBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.ccchargeback.ICcChargeBackBizBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("42A0B697") ,com.kingdee.eas.custom.ccchargeback.ICcChargeBackBizBill.class);
    }
    
    public static com.kingdee.eas.custom.ccchargeback.ICcChargeBackBizBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.ccchargeback.ICcChargeBackBizBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("42A0B697") ,com.kingdee.eas.custom.ccchargeback.ICcChargeBackBizBill.class, objectCtx);
    }
    public static com.kingdee.eas.custom.ccchargeback.ICcChargeBackBizBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.ccchargeback.ICcChargeBackBizBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("42A0B697"));
    }
    public static com.kingdee.eas.custom.ccchargeback.ICcChargeBackBizBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.ccchargeback.ICcChargeBackBizBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("42A0B697"));
    }
}