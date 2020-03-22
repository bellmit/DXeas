package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmersTreeFactory
{
    private FarmersTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFarmersTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFarmersTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BFB8653D") ,com.kingdee.eas.farm.stocking.basedata.IFarmersTree.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IFarmersTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFarmersTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BFB8653D") ,com.kingdee.eas.farm.stocking.basedata.IFarmersTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFarmersTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFarmersTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BFB8653D"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFarmersTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFarmersTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BFB8653D"));
    }
}