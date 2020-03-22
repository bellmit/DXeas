package com.kingdee.eas.farm.feemanager.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class OilPriceTreeFactory
{
    private OilPriceTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.feemanager.basedata.IOilPriceTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.IOilPriceTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9FE66081") ,com.kingdee.eas.farm.feemanager.basedata.IOilPriceTree.class);
    }
    
    public static com.kingdee.eas.farm.feemanager.basedata.IOilPriceTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.IOilPriceTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9FE66081") ,com.kingdee.eas.farm.feemanager.basedata.IOilPriceTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feemanager.basedata.IOilPriceTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.IOilPriceTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9FE66081"));
    }
    public static com.kingdee.eas.farm.feemanager.basedata.IOilPriceTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.IOilPriceTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9FE66081"));
    }
}