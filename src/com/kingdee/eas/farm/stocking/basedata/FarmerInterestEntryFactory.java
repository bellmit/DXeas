package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmerInterestEntryFactory
{
    private FarmerInterestEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFarmerInterestEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFarmerInterestEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BCD62DD4") ,com.kingdee.eas.farm.stocking.basedata.IFarmerInterestEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IFarmerInterestEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFarmerInterestEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BCD62DD4") ,com.kingdee.eas.farm.stocking.basedata.IFarmerInterestEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFarmerInterestEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFarmerInterestEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BCD62DD4"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFarmerInterestEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFarmerInterestEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BCD62DD4"));
    }
}