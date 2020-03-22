package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MaterialApplyBillEntryFactory
{
    private MaterialApplyBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IMaterialApplyBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IMaterialApplyBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("034EB3BE") ,com.kingdee.eas.farm.breed.IMaterialApplyBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.IMaterialApplyBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IMaterialApplyBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("034EB3BE") ,com.kingdee.eas.farm.breed.IMaterialApplyBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IMaterialApplyBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IMaterialApplyBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("034EB3BE"));
    }
    public static com.kingdee.eas.farm.breed.IMaterialApplyBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IMaterialApplyBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("034EB3BE"));
    }
}