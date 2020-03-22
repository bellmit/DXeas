package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmHouseEntryFactory
{
    private FarmHouseEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmHouseEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmHouseEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CF39BC2A") ,com.kingdee.eas.farm.carnivorous.basedata.IFarmHouseEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmHouseEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmHouseEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CF39BC2A") ,com.kingdee.eas.farm.carnivorous.basedata.IFarmHouseEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmHouseEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmHouseEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CF39BC2A"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmHouseEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmHouseEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CF39BC2A"));
    }
}