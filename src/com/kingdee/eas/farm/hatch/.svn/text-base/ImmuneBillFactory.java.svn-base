package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ImmuneBillFactory
{
    private ImmuneBillFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IImmuneBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IImmuneBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9B67DFB8") ,com.kingdee.eas.farm.hatch.IImmuneBill.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IImmuneBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IImmuneBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9B67DFB8") ,com.kingdee.eas.farm.hatch.IImmuneBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IImmuneBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IImmuneBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9B67DFB8"));
    }
    public static com.kingdee.eas.farm.hatch.IImmuneBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IImmuneBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9B67DFB8"));
    }
}