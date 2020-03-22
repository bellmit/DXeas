package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SubsidyPolicyFactory
{
    private SubsidyPolicyFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISubsidyPolicy getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISubsidyPolicy)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8850865B") ,com.kingdee.eas.farm.carnivorous.basedata.ISubsidyPolicy.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.ISubsidyPolicy getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISubsidyPolicy)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8850865B") ,com.kingdee.eas.farm.carnivorous.basedata.ISubsidyPolicy.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISubsidyPolicy getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISubsidyPolicy)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8850865B"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISubsidyPolicy getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISubsidyPolicy)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8850865B"));
    }
}