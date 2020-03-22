package com.kingdee.eas.farm.carnivorous.assistbiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MonthFreightCalBillFactory
{
    private MonthFreightCalBillFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.assistbiz.IMonthFreightCalBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.IMonthFreightCalBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A2E4E9C3") ,com.kingdee.eas.farm.carnivorous.assistbiz.IMonthFreightCalBill.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.assistbiz.IMonthFreightCalBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.IMonthFreightCalBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A2E4E9C3") ,com.kingdee.eas.farm.carnivorous.assistbiz.IMonthFreightCalBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.assistbiz.IMonthFreightCalBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.IMonthFreightCalBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A2E4E9C3"));
    }
    public static com.kingdee.eas.farm.carnivorous.assistbiz.IMonthFreightCalBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.IMonthFreightCalBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A2E4E9C3"));
    }
}