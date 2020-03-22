package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmerFarmEntryFactory
{
    private FarmerFarmEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmerFarmEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmerFarmEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3E0B37D7") ,com.kingdee.eas.farm.carnivorous.basedata.IFarmerFarmEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmerFarmEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmerFarmEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3E0B37D7") ,com.kingdee.eas.farm.carnivorous.basedata.IFarmerFarmEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmerFarmEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmerFarmEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3E0B37D7"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmerFarmEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmerFarmEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3E0B37D7"));
    }
}