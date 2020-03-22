package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCarSendBillEntryFactory
{
    private CCarSendBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICCarSendBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICCarSendBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1C76AE15") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICCarSendBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICCarSendBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICCarSendBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1C76AE15") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICCarSendBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICCarSendBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICCarSendBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1C76AE15"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICCarSendBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICCarSendBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1C76AE15"));
    }
}