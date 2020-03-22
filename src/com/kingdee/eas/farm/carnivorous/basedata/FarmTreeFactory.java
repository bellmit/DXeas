package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmTreeFactory
{
    private FarmTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A1610496") ,com.kingdee.eas.farm.carnivorous.basedata.IFarmTree.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A1610496") ,com.kingdee.eas.farm.carnivorous.basedata.IFarmTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A1610496"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A1610496"));
    }
}