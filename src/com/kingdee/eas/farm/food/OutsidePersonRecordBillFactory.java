package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class OutsidePersonRecordBillFactory
{
    private OutsidePersonRecordBillFactory()
    {
    }
    public static com.kingdee.eas.farm.food.IOutsidePersonRecordBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.IOutsidePersonRecordBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("590B1908") ,com.kingdee.eas.farm.food.IOutsidePersonRecordBill.class);
    }
    
    public static com.kingdee.eas.farm.food.IOutsidePersonRecordBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IOutsidePersonRecordBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("590B1908") ,com.kingdee.eas.farm.food.IOutsidePersonRecordBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.IOutsidePersonRecordBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IOutsidePersonRecordBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("590B1908"));
    }
    public static com.kingdee.eas.farm.food.IOutsidePersonRecordBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.IOutsidePersonRecordBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("590B1908"));
    }
}