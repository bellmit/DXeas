package com.kingdee.eas.custom.festival;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PurInWarehsBillNewFacadeFactory
{
    private PurInWarehsBillNewFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.festival.IPurInWarehsBillNewFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IPurInWarehsBillNewFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4D121344") ,com.kingdee.eas.custom.festival.IPurInWarehsBillNewFacade.class);
    }
    
    public static com.kingdee.eas.custom.festival.IPurInWarehsBillNewFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IPurInWarehsBillNewFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4D121344") ,com.kingdee.eas.custom.festival.IPurInWarehsBillNewFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.festival.IPurInWarehsBillNewFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IPurInWarehsBillNewFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4D121344"));
    }
    public static com.kingdee.eas.custom.festival.IPurInWarehsBillNewFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IPurInWarehsBillNewFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4D121344"));
    }
}