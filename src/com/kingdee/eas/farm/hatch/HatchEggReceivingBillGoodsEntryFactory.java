package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HatchEggReceivingBillGoodsEntryFactory
{
    private HatchEggReceivingBillGoodsEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IHatchEggReceivingBillGoodsEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchEggReceivingBillGoodsEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FE4D6BF0") ,com.kingdee.eas.farm.hatch.IHatchEggReceivingBillGoodsEntry.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IHatchEggReceivingBillGoodsEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchEggReceivingBillGoodsEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FE4D6BF0") ,com.kingdee.eas.farm.hatch.IHatchEggReceivingBillGoodsEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IHatchEggReceivingBillGoodsEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchEggReceivingBillGoodsEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FE4D6BF0"));
    }
    public static com.kingdee.eas.farm.hatch.IHatchEggReceivingBillGoodsEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchEggReceivingBillGoodsEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FE4D6BF0"));
    }
}