package com.kingdee.eas.wlhlcomm.function;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TobeUpdateBillsPersonEntryFactory
{
    private TobeUpdateBillsPersonEntryFactory()
    {
    }
    public static com.kingdee.eas.wlhlcomm.function.ITobeUpdateBillsPersonEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.wlhlcomm.function.ITobeUpdateBillsPersonEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7F8D2817") ,com.kingdee.eas.wlhlcomm.function.ITobeUpdateBillsPersonEntry.class);
    }
    
    public static com.kingdee.eas.wlhlcomm.function.ITobeUpdateBillsPersonEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.wlhlcomm.function.ITobeUpdateBillsPersonEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7F8D2817") ,com.kingdee.eas.wlhlcomm.function.ITobeUpdateBillsPersonEntry.class, objectCtx);
    }
    public static com.kingdee.eas.wlhlcomm.function.ITobeUpdateBillsPersonEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.wlhlcomm.function.ITobeUpdateBillsPersonEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7F8D2817"));
    }
    public static com.kingdee.eas.wlhlcomm.function.ITobeUpdateBillsPersonEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.wlhlcomm.function.ITobeUpdateBillsPersonEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7F8D2817"));
    }
}