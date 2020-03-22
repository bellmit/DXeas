package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SubsidyFactory
{
    private SubsidyFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.ISubsidy getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ISubsidy)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E924533A") ,com.kingdee.eas.farm.stocking.basedata.ISubsidy.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.ISubsidy getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ISubsidy)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E924533A") ,com.kingdee.eas.farm.stocking.basedata.ISubsidy.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.ISubsidy getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ISubsidy)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E924533A"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.ISubsidy getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ISubsidy)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E924533A"));
    }
}