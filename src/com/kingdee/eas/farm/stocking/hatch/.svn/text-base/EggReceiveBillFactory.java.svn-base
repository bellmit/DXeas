package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EggReceiveBillFactory
{
    private EggReceiveBillFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggReceiveBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggReceiveBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("38D35EAF") ,com.kingdee.eas.farm.stocking.hatch.IEggReceiveBill.class);
    }
    
    public static com.kingdee.eas.farm.stocking.hatch.IEggReceiveBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggReceiveBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("38D35EAF") ,com.kingdee.eas.farm.stocking.hatch.IEggReceiveBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggReceiveBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggReceiveBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("38D35EAF"));
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggReceiveBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggReceiveBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("38D35EAF"));
    }
}