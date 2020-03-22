package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettlePolicyPriceEntryFactory
{
    private SettlePolicyPriceEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyPriceEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyPriceEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("99E1A308") ,com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyPriceEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyPriceEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyPriceEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("99E1A308") ,com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyPriceEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyPriceEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyPriceEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("99E1A308"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyPriceEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicyPriceEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("99E1A308"));
    }
}