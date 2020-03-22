package com.kingdee.eas.farm.feemanager.basebizbill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MileModifyRecordFactory
{
    private MileModifyRecordFactory()
    {
    }
    public static com.kingdee.eas.farm.feemanager.basebizbill.IMileModifyRecord getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basebizbill.IMileModifyRecord)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1CEF7B06") ,com.kingdee.eas.farm.feemanager.basebizbill.IMileModifyRecord.class);
    }
    
    public static com.kingdee.eas.farm.feemanager.basebizbill.IMileModifyRecord getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basebizbill.IMileModifyRecord)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1CEF7B06") ,com.kingdee.eas.farm.feemanager.basebizbill.IMileModifyRecord.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feemanager.basebizbill.IMileModifyRecord getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basebizbill.IMileModifyRecord)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1CEF7B06"));
    }
    public static com.kingdee.eas.farm.feemanager.basebizbill.IMileModifyRecord getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basebizbill.IMileModifyRecord)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1CEF7B06"));
    }
}