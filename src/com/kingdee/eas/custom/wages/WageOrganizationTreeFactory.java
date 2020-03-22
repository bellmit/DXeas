package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WageOrganizationTreeFactory
{
    private WageOrganizationTreeFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IWageOrganizationTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IWageOrganizationTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A22190C1") ,com.kingdee.eas.custom.wages.IWageOrganizationTree.class);
    }
    
    public static com.kingdee.eas.custom.wages.IWageOrganizationTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IWageOrganizationTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A22190C1") ,com.kingdee.eas.custom.wages.IWageOrganizationTree.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IWageOrganizationTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IWageOrganizationTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A22190C1"));
    }
    public static com.kingdee.eas.custom.wages.IWageOrganizationTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IWageOrganizationTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A22190C1"));
    }
}