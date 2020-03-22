package com.kingdee.eas.farm.feemanager.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class carfacadeFactory
{
    private carfacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.feemanager.basedata.Icarfacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.Icarfacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C52FEB62") ,com.kingdee.eas.farm.feemanager.basedata.Icarfacade.class);
    }
    
    public static com.kingdee.eas.farm.feemanager.basedata.Icarfacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.Icarfacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C52FEB62") ,com.kingdee.eas.farm.feemanager.basedata.Icarfacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feemanager.basedata.Icarfacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.Icarfacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C52FEB62"));
    }
    public static com.kingdee.eas.farm.feemanager.basedata.Icarfacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.Icarfacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C52FEB62"));
    }
}