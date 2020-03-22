package com.kingdee.eas.custom.festival;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MaterialReqBillFacadeFactory
{
    private MaterialReqBillFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.festival.IMaterialReqBillFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IMaterialReqBillFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5B3CC9AD") ,com.kingdee.eas.custom.festival.IMaterialReqBillFacade.class);
    }
    
    public static com.kingdee.eas.custom.festival.IMaterialReqBillFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IMaterialReqBillFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5B3CC9AD") ,com.kingdee.eas.custom.festival.IMaterialReqBillFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.festival.IMaterialReqBillFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IMaterialReqBillFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5B3CC9AD"));
    }
    public static com.kingdee.eas.custom.festival.IMaterialReqBillFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IMaterialReqBillFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5B3CC9AD"));
    }
}