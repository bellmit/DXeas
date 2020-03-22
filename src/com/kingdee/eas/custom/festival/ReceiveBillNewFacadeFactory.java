package com.kingdee.eas.custom.festival;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ReceiveBillNewFacadeFactory
{
    private ReceiveBillNewFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.festival.IReceiveBillNewFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IReceiveBillNewFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D001187B") ,com.kingdee.eas.custom.festival.IReceiveBillNewFacade.class);
    }
    
    public static com.kingdee.eas.custom.festival.IReceiveBillNewFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IReceiveBillNewFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D001187B") ,com.kingdee.eas.custom.festival.IReceiveBillNewFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.festival.IReceiveBillNewFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IReceiveBillNewFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D001187B"));
    }
    public static com.kingdee.eas.custom.festival.IReceiveBillNewFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IReceiveBillNewFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D001187B"));
    }
}