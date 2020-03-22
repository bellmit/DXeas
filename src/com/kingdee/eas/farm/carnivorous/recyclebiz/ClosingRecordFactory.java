package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ClosingRecordFactory
{
    private ClosingRecordFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.IClosingRecord getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.IClosingRecord)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C9486FE9") ,com.kingdee.eas.farm.carnivorous.recyclebiz.IClosingRecord.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.IClosingRecord getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.IClosingRecord)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C9486FE9") ,com.kingdee.eas.farm.carnivorous.recyclebiz.IClosingRecord.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.IClosingRecord getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.IClosingRecord)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C9486FE9"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.IClosingRecord getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.IClosingRecord)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C9486FE9"));
    }
}