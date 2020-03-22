package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MaterialApplyBillFactory
{
    private MaterialApplyBillFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IMaterialApplyBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IMaterialApplyBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1AC0F114") ,com.kingdee.eas.farm.breed.IMaterialApplyBill.class);
    }
    
    public static com.kingdee.eas.farm.breed.IMaterialApplyBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IMaterialApplyBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1AC0F114") ,com.kingdee.eas.farm.breed.IMaterialApplyBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IMaterialApplyBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IMaterialApplyBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1AC0F114"));
    }
    public static com.kingdee.eas.farm.breed.IMaterialApplyBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IMaterialApplyBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1AC0F114"));
    }
}