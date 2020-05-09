package com.kingdee.eas.outinterface.base;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class OutInterfaceDynamicBillFacadeFactory
{
    private OutInterfaceDynamicBillFacadeFactory()
    {
    }
    public static com.kingdee.eas.outinterface.base.IOutInterfaceDynamicBillFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.outinterface.base.IOutInterfaceDynamicBillFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EA163209") ,com.kingdee.eas.outinterface.base.IOutInterfaceDynamicBillFacade.class);
    }
    
    public static com.kingdee.eas.outinterface.base.IOutInterfaceDynamicBillFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.outinterface.base.IOutInterfaceDynamicBillFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EA163209") ,com.kingdee.eas.outinterface.base.IOutInterfaceDynamicBillFacade.class, objectCtx);
    }
    public static com.kingdee.eas.outinterface.base.IOutInterfaceDynamicBillFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.outinterface.base.IOutInterfaceDynamicBillFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EA163209"));
    }
    public static com.kingdee.eas.outinterface.base.IOutInterfaceDynamicBillFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.outinterface.base.IOutInterfaceDynamicBillFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EA163209"));
    }
}