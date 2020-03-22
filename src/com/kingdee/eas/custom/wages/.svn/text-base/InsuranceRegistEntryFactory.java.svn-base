package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class InsuranceRegistEntryFactory
{
    private InsuranceRegistEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IInsuranceRegistEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IInsuranceRegistEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FE46476A") ,com.kingdee.eas.custom.wages.IInsuranceRegistEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.IInsuranceRegistEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IInsuranceRegistEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FE46476A") ,com.kingdee.eas.custom.wages.IInsuranceRegistEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IInsuranceRegistEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IInsuranceRegistEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FE46476A"));
    }
    public static com.kingdee.eas.custom.wages.IInsuranceRegistEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IInsuranceRegistEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FE46476A"));
    }
}