package com.kingdee.eas.farm.carnivorous.assistbiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CKGrowthFreightBillFactory
{
    private CKGrowthFreightBillFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.assistbiz.ICKGrowthFreightBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.ICKGrowthFreightBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FA6F692C") ,com.kingdee.eas.farm.carnivorous.assistbiz.ICKGrowthFreightBill.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.assistbiz.ICKGrowthFreightBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.ICKGrowthFreightBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FA6F692C") ,com.kingdee.eas.farm.carnivorous.assistbiz.ICKGrowthFreightBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.assistbiz.ICKGrowthFreightBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.ICKGrowthFreightBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FA6F692C"));
    }
    public static com.kingdee.eas.farm.carnivorous.assistbiz.ICKGrowthFreightBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.ICKGrowthFreightBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FA6F692C"));
    }
}