package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class InjuryinsuranceEntryFactory
{
    private InjuryinsuranceEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IInjuryinsuranceEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IInjuryinsuranceEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AC88BCF7") ,com.kingdee.eas.custom.wages.IInjuryinsuranceEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.IInjuryinsuranceEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IInjuryinsuranceEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AC88BCF7") ,com.kingdee.eas.custom.wages.IInjuryinsuranceEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IInjuryinsuranceEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IInjuryinsuranceEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AC88BCF7"));
    }
    public static com.kingdee.eas.custom.wages.IInjuryinsuranceEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IInjuryinsuranceEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AC88BCF7"));
    }
}