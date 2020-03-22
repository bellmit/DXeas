package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class InsteadSeedPriceDataTreeFactory
{
    private InsteadSeedPriceDataTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IInsteadSeedPriceDataTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IInsteadSeedPriceDataTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0EDCE10F") ,com.kingdee.eas.farm.stocking.basedata.IInsteadSeedPriceDataTree.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IInsteadSeedPriceDataTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IInsteadSeedPriceDataTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0EDCE10F") ,com.kingdee.eas.farm.stocking.basedata.IInsteadSeedPriceDataTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IInsteadSeedPriceDataTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IInsteadSeedPriceDataTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0EDCE10F"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IInsteadSeedPriceDataTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IInsteadSeedPriceDataTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0EDCE10F"));
    }
}