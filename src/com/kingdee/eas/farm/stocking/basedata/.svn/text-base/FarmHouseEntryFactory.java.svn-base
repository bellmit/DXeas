package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmHouseEntryFactory
{
    private FarmHouseEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFarmHouseEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFarmHouseEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("69E58799") ,com.kingdee.eas.farm.stocking.basedata.IFarmHouseEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IFarmHouseEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFarmHouseEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("69E58799") ,com.kingdee.eas.farm.stocking.basedata.IFarmHouseEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFarmHouseEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFarmHouseEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("69E58799"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFarmHouseEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFarmHouseEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("69E58799"));
    }
}