package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WageOrganizationFactory
{
    private WageOrganizationFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IWageOrganization getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IWageOrganization)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("41E4A283") ,com.kingdee.eas.custom.wages.IWageOrganization.class);
    }
    
    public static com.kingdee.eas.custom.wages.IWageOrganization getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IWageOrganization)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("41E4A283") ,com.kingdee.eas.custom.wages.IWageOrganization.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IWageOrganization getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IWageOrganization)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("41E4A283"));
    }
    public static com.kingdee.eas.custom.wages.IWageOrganization getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IWageOrganization)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("41E4A283"));
    }
}