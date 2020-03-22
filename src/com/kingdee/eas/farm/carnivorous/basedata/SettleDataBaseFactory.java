package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettleDataBaseFactory
{
    private SettleDataBaseFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISettleDataBase getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISettleDataBase)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("339A0E28") ,com.kingdee.eas.farm.carnivorous.basedata.ISettleDataBase.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.ISettleDataBase getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISettleDataBase)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("339A0E28") ,com.kingdee.eas.farm.carnivorous.basedata.ISettleDataBase.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISettleDataBase getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISettleDataBase)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("339A0E28"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISettleDataBase getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISettleDataBase)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("339A0E28"));
    }
}