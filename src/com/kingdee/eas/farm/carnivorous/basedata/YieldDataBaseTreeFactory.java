package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class YieldDataBaseTreeFactory
{
    private YieldDataBaseTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBaseTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBaseTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("89E016A4") ,com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBaseTree.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBaseTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBaseTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("89E016A4") ,com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBaseTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBaseTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBaseTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("89E016A4"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBaseTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBaseTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("89E016A4"));
    }
}