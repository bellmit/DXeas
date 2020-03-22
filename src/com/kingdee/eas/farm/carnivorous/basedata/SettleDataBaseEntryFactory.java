package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettleDataBaseEntryFactory
{
    private SettleDataBaseEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISettleDataBaseEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISettleDataBaseEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("28C0A32A") ,com.kingdee.eas.farm.carnivorous.basedata.ISettleDataBaseEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.ISettleDataBaseEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISettleDataBaseEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("28C0A32A") ,com.kingdee.eas.farm.carnivorous.basedata.ISettleDataBaseEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISettleDataBaseEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISettleDataBaseEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("28C0A32A"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISettleDataBaseEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISettleDataBaseEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("28C0A32A"));
    }
}