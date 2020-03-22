package com.kingdee.eas.farm.feemanager.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class OilStandPriceTreeFactory
{
    private OilStandPriceTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.feemanager.basedata.IOilStandPriceTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.IOilStandPriceTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("48A7F197") ,com.kingdee.eas.farm.feemanager.basedata.IOilStandPriceTree.class);
    }
    
    public static com.kingdee.eas.farm.feemanager.basedata.IOilStandPriceTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.IOilStandPriceTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("48A7F197") ,com.kingdee.eas.farm.feemanager.basedata.IOilStandPriceTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feemanager.basedata.IOilStandPriceTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.IOilStandPriceTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("48A7F197"));
    }
    public static com.kingdee.eas.farm.feemanager.basedata.IOilStandPriceTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.IOilStandPriceTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("48A7F197"));
    }
}