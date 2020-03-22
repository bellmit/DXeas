package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCLeaveBillFactory
{
    private CCLeaveBillFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.business.ICCLeaveBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICCLeaveBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("607BFEF0") ,com.kingdee.eas.farm.breed.business.ICCLeaveBill.class);
    }
    
    public static com.kingdee.eas.farm.breed.business.ICCLeaveBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICCLeaveBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("607BFEF0") ,com.kingdee.eas.farm.breed.business.ICCLeaveBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.business.ICCLeaveBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICCLeaveBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("607BFEF0"));
    }
    public static com.kingdee.eas.farm.breed.business.ICCLeaveBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICCLeaveBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("607BFEF0"));
    }
}