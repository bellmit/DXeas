package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MaterialApplyBillEntryHenhouseEntryFactory
{
    private MaterialApplyBillEntryHenhouseEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IMaterialApplyBillEntryHenhouseEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IMaterialApplyBillEntryHenhouseEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8F6E77E5") ,com.kingdee.eas.farm.breed.IMaterialApplyBillEntryHenhouseEntry.class);
    }
    
    public static com.kingdee.eas.farm.breed.IMaterialApplyBillEntryHenhouseEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IMaterialApplyBillEntryHenhouseEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8F6E77E5") ,com.kingdee.eas.farm.breed.IMaterialApplyBillEntryHenhouseEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IMaterialApplyBillEntryHenhouseEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IMaterialApplyBillEntryHenhouseEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8F6E77E5"));
    }
    public static com.kingdee.eas.farm.breed.IMaterialApplyBillEntryHenhouseEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IMaterialApplyBillEntryHenhouseEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8F6E77E5"));
    }
}