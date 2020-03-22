package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CSlaughterBillFactory
{
    private CSlaughterBillFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICSlaughterBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICSlaughterBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5A968454") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICSlaughterBill.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICSlaughterBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICSlaughterBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5A968454") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICSlaughterBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICSlaughterBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICSlaughterBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5A968454"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICSlaughterBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICSlaughterBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5A968454"));
    }
}