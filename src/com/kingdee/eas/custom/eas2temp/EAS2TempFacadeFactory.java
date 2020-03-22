package com.kingdee.eas.custom.eas2temp;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class EAS2TempFacadeFactory
{
    private EAS2TempFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.eas2temp.IEAS2TempFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IEAS2TempFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AAF6567D") ,com.kingdee.eas.custom.eas2temp.IEAS2TempFacade.class);
    }
    
    public static com.kingdee.eas.custom.eas2temp.IEAS2TempFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IEAS2TempFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AAF6567D") ,com.kingdee.eas.custom.eas2temp.IEAS2TempFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.eas2temp.IEAS2TempFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IEAS2TempFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AAF6567D"));
    }
    public static com.kingdee.eas.custom.eas2temp.IEAS2TempFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.eas2temp.IEAS2TempFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AAF6567D"));
    }
}