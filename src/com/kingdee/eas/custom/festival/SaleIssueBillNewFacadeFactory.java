package com.kingdee.eas.custom.festival;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SaleIssueBillNewFacadeFactory
{
    private SaleIssueBillNewFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.festival.ISaleIssueBillNewFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.festival.ISaleIssueBillNewFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("95C4642C") ,com.kingdee.eas.custom.festival.ISaleIssueBillNewFacade.class);
    }
    
    public static com.kingdee.eas.custom.festival.ISaleIssueBillNewFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.ISaleIssueBillNewFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("95C4642C") ,com.kingdee.eas.custom.festival.ISaleIssueBillNewFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.festival.ISaleIssueBillNewFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.ISaleIssueBillNewFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("95C4642C"));
    }
    public static com.kingdee.eas.custom.festival.ISaleIssueBillNewFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.ISaleIssueBillNewFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("95C4642C"));
    }
}