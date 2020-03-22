package com.kingdee.eas.farm.feemanager.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DriverTreeFactory
{
    private DriverTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.feemanager.basedata.IDriverTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.IDriverTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D38E5C92") ,com.kingdee.eas.farm.feemanager.basedata.IDriverTree.class);
    }
    
    public static com.kingdee.eas.farm.feemanager.basedata.IDriverTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.IDriverTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D38E5C92") ,com.kingdee.eas.farm.feemanager.basedata.IDriverTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feemanager.basedata.IDriverTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.IDriverTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D38E5C92"));
    }
    public static com.kingdee.eas.farm.feemanager.basedata.IDriverTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.IDriverTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D38E5C92"));
    }
}