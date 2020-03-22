package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCLeaveBillEntryFactory
{
    private CCLeaveBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.business.ICCLeaveBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICCLeaveBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C0DDEF62") ,com.kingdee.eas.farm.breed.business.ICCLeaveBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.business.ICCLeaveBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICCLeaveBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C0DDEF62") ,com.kingdee.eas.farm.breed.business.ICCLeaveBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.business.ICCLeaveBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICCLeaveBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C0DDEF62"));
    }
    public static com.kingdee.eas.farm.breed.business.ICCLeaveBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICCLeaveBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C0DDEF62"));
    }
}