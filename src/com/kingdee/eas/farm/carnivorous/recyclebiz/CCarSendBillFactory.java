package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCarSendBillFactory
{
    private CCarSendBillFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICCarSendBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICCarSendBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EC5D9C5D") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICCarSendBill.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICCarSendBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICCarSendBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EC5D9C5D") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICCarSendBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICCarSendBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICCarSendBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EC5D9C5D"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICCarSendBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICCarSendBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EC5D9C5D"));
    }
}