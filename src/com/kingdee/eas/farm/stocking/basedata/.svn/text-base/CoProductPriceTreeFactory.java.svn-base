package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CoProductPriceTreeFactory
{
    private CoProductPriceTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.ICoProductPriceTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ICoProductPriceTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("16E55DF5") ,com.kingdee.eas.farm.stocking.basedata.ICoProductPriceTree.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.ICoProductPriceTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ICoProductPriceTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("16E55DF5") ,com.kingdee.eas.farm.stocking.basedata.ICoProductPriceTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.ICoProductPriceTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ICoProductPriceTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("16E55DF5"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.ICoProductPriceTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ICoProductPriceTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("16E55DF5"));
    }
}