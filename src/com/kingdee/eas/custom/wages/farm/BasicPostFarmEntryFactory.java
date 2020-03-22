package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BasicPostFarmEntryFactory
{
    private BasicPostFarmEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.farm.IBasicPostFarmEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IBasicPostFarmEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D850FD38") ,com.kingdee.eas.custom.wages.farm.IBasicPostFarmEntry.class);
    }
    
    public static com.kingdee.eas.custom.wages.farm.IBasicPostFarmEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IBasicPostFarmEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D850FD38") ,com.kingdee.eas.custom.wages.farm.IBasicPostFarmEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.farm.IBasicPostFarmEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IBasicPostFarmEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D850FD38"));
    }
    public static com.kingdee.eas.custom.wages.farm.IBasicPostFarmEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.farm.IBasicPostFarmEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D850FD38"));
    }
}