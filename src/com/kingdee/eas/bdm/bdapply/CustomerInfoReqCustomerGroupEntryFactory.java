package com.kingdee.eas.bdm.bdapply;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CustomerInfoReqCustomerGroupEntryFactory
{
    private CustomerInfoReqCustomerGroupEntryFactory()
    {
    }
    public static com.kingdee.eas.bdm.bdapply.ICustomerInfoReqCustomerGroupEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.bdm.bdapply.ICustomerInfoReqCustomerGroupEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("81D90D0C") ,com.kingdee.eas.bdm.bdapply.ICustomerInfoReqCustomerGroupEntry.class);
    }
    
    public static com.kingdee.eas.bdm.bdapply.ICustomerInfoReqCustomerGroupEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.bdm.bdapply.ICustomerInfoReqCustomerGroupEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("81D90D0C") ,com.kingdee.eas.bdm.bdapply.ICustomerInfoReqCustomerGroupEntry.class, objectCtx);
    }
    public static com.kingdee.eas.bdm.bdapply.ICustomerInfoReqCustomerGroupEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.bdm.bdapply.ICustomerInfoReqCustomerGroupEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("81D90D0C"));
    }
    public static com.kingdee.eas.bdm.bdapply.ICustomerInfoReqCustomerGroupEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.bdm.bdapply.ICustomerInfoReqCustomerGroupEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("81D90D0C"));
    }
}