package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EggSettleBillCompanyFactory
{
    private EggSettleBillCompanyFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettleBillCompany getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettleBillCompany)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("72272190") ,com.kingdee.eas.farm.stocking.hatch.IEggSettleBillCompany.class);
    }
    
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettleBillCompany getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettleBillCompany)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("72272190") ,com.kingdee.eas.farm.stocking.hatch.IEggSettleBillCompany.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettleBillCompany getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettleBillCompany)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("72272190"));
    }
    public static com.kingdee.eas.farm.stocking.hatch.IEggSettleBillCompany getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IEggSettleBillCompany)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("72272190"));
    }
}