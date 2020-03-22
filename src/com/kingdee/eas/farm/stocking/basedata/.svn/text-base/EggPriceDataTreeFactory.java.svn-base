package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EggPriceDataTreeFactory
{
    private EggPriceDataTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IEggPriceDataTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IEggPriceDataTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F201801D") ,com.kingdee.eas.farm.stocking.basedata.IEggPriceDataTree.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IEggPriceDataTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IEggPriceDataTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F201801D") ,com.kingdee.eas.farm.stocking.basedata.IEggPriceDataTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IEggPriceDataTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IEggPriceDataTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F201801D"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IEggPriceDataTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IEggPriceDataTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F201801D"));
    }
}