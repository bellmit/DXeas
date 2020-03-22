package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class YieldDataBaseEntryFactory
{
    private YieldDataBaseEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBaseEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBaseEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B14DC62C") ,com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBaseEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBaseEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBaseEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B14DC62C") ,com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBaseEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBaseEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBaseEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B14DC62C"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBaseEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IYieldDataBaseEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B14DC62C"));
    }
}