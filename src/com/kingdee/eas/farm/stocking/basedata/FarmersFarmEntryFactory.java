package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmersFarmEntryFactory
{
    private FarmersFarmEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFarmersFarmEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFarmersFarmEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D47C2B9D") ,com.kingdee.eas.farm.stocking.basedata.IFarmersFarmEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IFarmersFarmEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFarmersFarmEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D47C2B9D") ,com.kingdee.eas.farm.stocking.basedata.IFarmersFarmEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFarmersFarmEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFarmersFarmEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D47C2B9D"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFarmersFarmEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFarmersFarmEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D47C2B9D"));
    }
}