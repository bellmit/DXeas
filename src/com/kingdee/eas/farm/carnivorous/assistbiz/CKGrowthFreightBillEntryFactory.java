package com.kingdee.eas.farm.carnivorous.assistbiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CKGrowthFreightBillEntryFactory
{
    private CKGrowthFreightBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.assistbiz.ICKGrowthFreightBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.ICKGrowthFreightBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AEDF8AA6") ,com.kingdee.eas.farm.carnivorous.assistbiz.ICKGrowthFreightBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.assistbiz.ICKGrowthFreightBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.ICKGrowthFreightBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AEDF8AA6") ,com.kingdee.eas.farm.carnivorous.assistbiz.ICKGrowthFreightBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.assistbiz.ICKGrowthFreightBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.ICKGrowthFreightBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AEDF8AA6"));
    }
    public static com.kingdee.eas.farm.carnivorous.assistbiz.ICKGrowthFreightBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.ICKGrowthFreightBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AEDF8AA6"));
    }
}