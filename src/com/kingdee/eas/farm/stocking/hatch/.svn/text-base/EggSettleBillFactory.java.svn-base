package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EggSettleBillFactory
{
    private EggSettleBillFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettleBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettleBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7DD0D62D") ,com.kingdee.eas.farm.stocking.hatch.IEggSettleBill.class);
    }
    
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettleBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettleBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7DD0D62D") ,com.kingdee.eas.farm.stocking.hatch.IEggSettleBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettleBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettleBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7DD0D62D"));
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettleBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettleBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7DD0D62D"));
    }
}