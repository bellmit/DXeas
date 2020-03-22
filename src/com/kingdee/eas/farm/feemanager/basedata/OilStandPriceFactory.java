package com.kingdee.eas.farm.feemanager.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class OilStandPriceFactory
{
    private OilStandPriceFactory()
    {
    }
    public static com.kingdee.eas.farm.feemanager.basedata.IOilStandPrice getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.IOilStandPrice)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6738DE59") ,com.kingdee.eas.farm.feemanager.basedata.IOilStandPrice.class);
    }
    
    public static com.kingdee.eas.farm.feemanager.basedata.IOilStandPrice getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.IOilStandPrice)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6738DE59") ,com.kingdee.eas.farm.feemanager.basedata.IOilStandPrice.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feemanager.basedata.IOilStandPrice getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.IOilStandPrice)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6738DE59"));
    }
    public static com.kingdee.eas.farm.feemanager.basedata.IOilStandPrice getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.IOilStandPrice)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6738DE59"));
    }
}