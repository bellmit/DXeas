package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ConFeedPolicyFactory
{
    private ConFeedPolicyFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IConFeedPolicy getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IConFeedPolicy)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3BB25130") ,com.kingdee.eas.farm.carnivorous.basedata.IConFeedPolicy.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IConFeedPolicy getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IConFeedPolicy)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3BB25130") ,com.kingdee.eas.farm.carnivorous.basedata.IConFeedPolicy.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IConFeedPolicy getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IConFeedPolicy)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3BB25130"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IConFeedPolicy getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IConFeedPolicy)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3BB25130"));
    }
}