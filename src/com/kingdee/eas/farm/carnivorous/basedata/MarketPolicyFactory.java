package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MarketPolicyFactory
{
    private MarketPolicyFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IMarketPolicy getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IMarketPolicy)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("837DB730") ,com.kingdee.eas.farm.carnivorous.basedata.IMarketPolicy.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IMarketPolicy getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IMarketPolicy)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("837DB730") ,com.kingdee.eas.farm.carnivorous.basedata.IMarketPolicy.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IMarketPolicy getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IMarketPolicy)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("837DB730"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IMarketPolicy getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IMarketPolicy)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("837DB730"));
    }
}