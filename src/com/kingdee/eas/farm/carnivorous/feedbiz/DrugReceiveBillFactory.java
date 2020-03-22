package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DrugReceiveBillFactory
{
    private DrugReceiveBillFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IDrugReceiveBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IDrugReceiveBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0E74B6E6") ,com.kingdee.eas.farm.carnivorous.feedbiz.IDrugReceiveBill.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IDrugReceiveBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IDrugReceiveBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0E74B6E6") ,com.kingdee.eas.farm.carnivorous.feedbiz.IDrugReceiveBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IDrugReceiveBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IDrugReceiveBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0E74B6E6"));
    }
    public static com.kingdee.eas.farm.carnivorous.feedbiz.IDrugReceiveBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.IDrugReceiveBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0E74B6E6"));
    }
}