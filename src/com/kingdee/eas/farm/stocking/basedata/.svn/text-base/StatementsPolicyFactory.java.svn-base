package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StatementsPolicyFactory
{
    private StatementsPolicyFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStatementsPolicy getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStatementsPolicy)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1BAC9487") ,com.kingdee.eas.farm.stocking.basedata.IStatementsPolicy.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IStatementsPolicy getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStatementsPolicy)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1BAC9487") ,com.kingdee.eas.farm.stocking.basedata.IStatementsPolicy.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStatementsPolicy getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStatementsPolicy)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1BAC9487"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStatementsPolicy getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStatementsPolicy)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1BAC9487"));
    }
}