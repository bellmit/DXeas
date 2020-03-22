package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SecondAllotFactory
{
    private SecondAllotFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.hatch.ISecondAllot getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.ISecondAllot)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E44F1D08") ,com.kingdee.eas.farm.stocking.hatch.ISecondAllot.class);
    }
    
    public static com.kingdee.eas.farm.stocking.hatch.ISecondAllot getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.ISecondAllot)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E44F1D08") ,com.kingdee.eas.farm.stocking.hatch.ISecondAllot.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.hatch.ISecondAllot getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.ISecondAllot)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E44F1D08"));
    }
    public static com.kingdee.eas.farm.stocking.hatch.ISecondAllot getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.ISecondAllot)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E44F1D08"));
    }
}