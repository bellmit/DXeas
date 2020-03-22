package com.kingdee.eas.custom.festival;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class OtherBillNewFacadeFactory
{
    private OtherBillNewFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.festival.IOtherBillNewFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IOtherBillNewFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B1F9A42E") ,com.kingdee.eas.custom.festival.IOtherBillNewFacade.class);
    }
    
    public static com.kingdee.eas.custom.festival.IOtherBillNewFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IOtherBillNewFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B1F9A42E") ,com.kingdee.eas.custom.festival.IOtherBillNewFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.festival.IOtherBillNewFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IOtherBillNewFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B1F9A42E"));
    }
    public static com.kingdee.eas.custom.festival.IOtherBillNewFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IOtherBillNewFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B1F9A42E"));
    }
}