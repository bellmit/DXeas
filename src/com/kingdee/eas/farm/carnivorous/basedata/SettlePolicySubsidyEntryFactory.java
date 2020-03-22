package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettlePolicySubsidyEntryFactory
{
    private SettlePolicySubsidyEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicySubsidyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicySubsidyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2B9FEA26") ,com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicySubsidyEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicySubsidyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicySubsidyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2B9FEA26") ,com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicySubsidyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicySubsidyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicySubsidyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2B9FEA26"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicySubsidyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ISettlePolicySubsidyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2B9FEA26"));
    }
}