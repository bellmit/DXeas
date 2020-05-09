package com.kingdee.eas.outinterface.base;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class OutAppInterfaceFactory
{
    private OutAppInterfaceFactory()
    {
    }
    public static com.kingdee.eas.outinterface.base.IOutAppInterface getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.outinterface.base.IOutAppInterface)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("985F78BA") ,com.kingdee.eas.outinterface.base.IOutAppInterface.class);
    }
    
    public static com.kingdee.eas.outinterface.base.IOutAppInterface getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.outinterface.base.IOutAppInterface)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("985F78BA") ,com.kingdee.eas.outinterface.base.IOutAppInterface.class, objectCtx);
    }
    public static com.kingdee.eas.outinterface.base.IOutAppInterface getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.outinterface.base.IOutAppInterface)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("985F78BA"));
    }
    public static com.kingdee.eas.outinterface.base.IOutAppInterface getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.outinterface.base.IOutAppInterface)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("985F78BA"));
    }
}