package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CKWeightBillFactory
{
    private CKWeightBillFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CEF5DA24") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBill.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CEF5DA24") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CEF5DA24"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CEF5DA24"));
    }
}