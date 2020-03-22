package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StatementsPolicyTreeFactory
{
    private StatementsPolicyTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("92D8E0C5") ,com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyTree.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("92D8E0C5") ,com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("92D8E0C5"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStatementsPolicyTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("92D8E0C5"));
    }
}