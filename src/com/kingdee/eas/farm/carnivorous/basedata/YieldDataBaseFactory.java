package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class YieldDataBaseFactory
{
    private YieldDataBaseFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBase getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBase)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("393F91E6") ,com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBase.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBase getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBase)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("393F91E6") ,com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBase.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBase getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBase)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("393F91E6"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBase getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBase)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("393F91E6"));
    }
}