package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmerTreeFactory
{
    private FarmerTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmerTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmerTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EA2D1CC3") ,com.kingdee.eas.farm.carnivorous.basedata.IFarmerTree.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmerTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmerTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EA2D1CC3") ,com.kingdee.eas.farm.carnivorous.basedata.IFarmerTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmerTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmerTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EA2D1CC3"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmerTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmerTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EA2D1CC3"));
    }
}