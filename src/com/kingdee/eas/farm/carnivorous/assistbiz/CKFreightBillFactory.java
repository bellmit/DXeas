package com.kingdee.eas.farm.carnivorous.assistbiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CKFreightBillFactory
{
    private CKFreightBillFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.assistbiz.ICKFreightBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.ICKFreightBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A9165033") ,com.kingdee.eas.farm.carnivorous.assistbiz.ICKFreightBill.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.assistbiz.ICKFreightBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.ICKFreightBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A9165033") ,com.kingdee.eas.farm.carnivorous.assistbiz.ICKFreightBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.assistbiz.ICKFreightBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.ICKFreightBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A9165033"));
    }
    public static com.kingdee.eas.farm.carnivorous.assistbiz.ICKFreightBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.ICKFreightBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A9165033"));
    }
}