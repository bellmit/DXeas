package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EggSettleBillCompanyEntryFactory
{
    private EggSettleBillCompanyEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettleBillCompanyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettleBillCompanyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("17DF70C2") ,com.kingdee.eas.farm.stocking.hatch.IEggSettleBillCompanyEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettleBillCompanyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettleBillCompanyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("17DF70C2") ,com.kingdee.eas.farm.stocking.hatch.IEggSettleBillCompanyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettleBillCompanyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettleBillCompanyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("17DF70C2"));
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettleBillCompanyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettleBillCompanyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("17DF70C2"));
    }
}