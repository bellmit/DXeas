package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class InjuryinsuranceFactory
{
    private InjuryinsuranceFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IInjuryinsurance getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IInjuryinsurance)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7C52483B") ,com.kingdee.eas.custom.wages.IInjuryinsurance.class);
    }
    
    public static com.kingdee.eas.custom.wages.IInjuryinsurance getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IInjuryinsurance)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7C52483B") ,com.kingdee.eas.custom.wages.IInjuryinsurance.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IInjuryinsurance getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IInjuryinsurance)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7C52483B"));
    }
    public static com.kingdee.eas.custom.wages.IInjuryinsurance getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IInjuryinsurance)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7C52483B"));
    }
}