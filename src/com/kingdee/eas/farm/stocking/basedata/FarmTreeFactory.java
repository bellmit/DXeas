package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmTreeFactory
{
    private FarmTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFarmTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFarmTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EDE9CF45") ,com.kingdee.eas.farm.stocking.basedata.IFarmTree.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IFarmTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFarmTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EDE9CF45") ,com.kingdee.eas.farm.stocking.basedata.IFarmTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFarmTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFarmTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EDE9CF45"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFarmTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFarmTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EDE9CF45"));
    }
}