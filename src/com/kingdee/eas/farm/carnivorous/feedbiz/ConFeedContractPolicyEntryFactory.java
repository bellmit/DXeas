package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ConFeedContractPolicyEntryFactory
{
    private ConFeedContractPolicyEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IConFeedContractPolicyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IConFeedContractPolicyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BC2964F2") ,com.kingdee.eas.farm.carnivorous.feedbiz.IConFeedContractPolicyEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IConFeedContractPolicyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IConFeedContractPolicyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BC2964F2") ,com.kingdee.eas.farm.carnivorous.feedbiz.IConFeedContractPolicyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IConFeedContractPolicyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IConFeedContractPolicyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BC2964F2"));
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IConFeedContractPolicyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IConFeedContractPolicyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BC2964F2"));
    }
}