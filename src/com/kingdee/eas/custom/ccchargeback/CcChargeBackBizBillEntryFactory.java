package com.kingdee.eas.custom.ccchargeback;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CcChargeBackBizBillEntryFactory
{
    private CcChargeBackBizBillEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.ccchargeback.ICcChargeBackBizBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.ccchargeback.ICcChargeBackBizBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F90CE81B") ,com.kingdee.eas.custom.ccchargeback.ICcChargeBackBizBillEntry.class);
    }
    
    public static com.kingdee.eas.custom.ccchargeback.ICcChargeBackBizBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.ccchargeback.ICcChargeBackBizBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F90CE81B") ,com.kingdee.eas.custom.ccchargeback.ICcChargeBackBizBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.ccchargeback.ICcChargeBackBizBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.ccchargeback.ICcChargeBackBizBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F90CE81B"));
    }
    public static com.kingdee.eas.custom.ccchargeback.ICcChargeBackBizBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.ccchargeback.ICcChargeBackBizBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F90CE81B"));
    }
}