package com.kingdee.eas.custom.taihe.settle;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettleBillFactory
{
    private SettleBillFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.settle.ISettleBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ISettleBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FDFAF775") ,com.kingdee.eas.custom.taihe.settle.ISettleBill.class);
    }
    
    public static com.kingdee.eas.custom.taihe.settle.ISettleBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ISettleBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FDFAF775") ,com.kingdee.eas.custom.taihe.settle.ISettleBill.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.settle.ISettleBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ISettleBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FDFAF775"));
    }
    public static com.kingdee.eas.custom.taihe.settle.ISettleBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ISettleBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FDFAF775"));
    }
}