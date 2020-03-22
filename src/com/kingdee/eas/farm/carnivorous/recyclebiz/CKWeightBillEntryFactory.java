package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CKWeightBillEntryFactory
{
    private CKWeightBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8410F4AE") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8410F4AE") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8410F4AE"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8410F4AE"));
    }
}