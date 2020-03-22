package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BatchHouseEntryFactory
{
    private BatchHouseEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBatchHouseEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBatchHouseEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("15216E2A") ,com.kingdee.eas.farm.carnivorous.basedata.IBatchHouseEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IBatchHouseEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBatchHouseEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("15216E2A") ,com.kingdee.eas.farm.carnivorous.basedata.IBatchHouseEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBatchHouseEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBatchHouseEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("15216E2A"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBatchHouseEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBatchHouseEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("15216E2A"));
    }
}