package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SubsidyTreeFactory
{
    private SubsidyTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.ISubsidyTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ISubsidyTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4C1C0DF8") ,com.kingdee.eas.farm.stocking.basedata.ISubsidyTree.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.ISubsidyTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ISubsidyTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4C1C0DF8") ,com.kingdee.eas.farm.stocking.basedata.ISubsidyTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.ISubsidyTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ISubsidyTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4C1C0DF8"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.ISubsidyTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ISubsidyTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4C1C0DF8"));
    }
}