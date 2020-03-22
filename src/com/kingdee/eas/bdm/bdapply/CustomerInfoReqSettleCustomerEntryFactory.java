package com.kingdee.eas.bdm.bdapply;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CustomerInfoReqSettleCustomerEntryFactory
{
    private CustomerInfoReqSettleCustomerEntryFactory()
    {
    }
    public static com.kingdee.eas.bdm.bdapply.ICustomerInfoReqSettleCustomerEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.bdm.bdapply.ICustomerInfoReqSettleCustomerEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2E2139AE") ,com.kingdee.eas.bdm.bdapply.ICustomerInfoReqSettleCustomerEntry.class);
    }
    
    public static com.kingdee.eas.bdm.bdapply.ICustomerInfoReqSettleCustomerEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.bdm.bdapply.ICustomerInfoReqSettleCustomerEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2E2139AE") ,com.kingdee.eas.bdm.bdapply.ICustomerInfoReqSettleCustomerEntry.class, objectCtx);
    }
    public static com.kingdee.eas.bdm.bdapply.ICustomerInfoReqSettleCustomerEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.bdm.bdapply.ICustomerInfoReqSettleCustomerEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2E2139AE"));
    }
    public static com.kingdee.eas.bdm.bdapply.ICustomerInfoReqSettleCustomerEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.bdm.bdapply.ICustomerInfoReqSettleCustomerEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2E2139AE"));
    }
}