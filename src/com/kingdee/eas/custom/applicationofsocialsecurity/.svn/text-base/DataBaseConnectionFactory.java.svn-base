package com.kingdee.eas.custom.applicationofsocialsecurity;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DataBaseConnectionFactory
{
    private DataBaseConnectionFactory()
    {
    }
    public static com.kingdee.eas.custom.applicationofsocialsecurity.IDataBaseConnection getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.applicationofsocialsecurity.IDataBaseConnection)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("38328C78") ,com.kingdee.eas.custom.applicationofsocialsecurity.IDataBaseConnection.class);
    }
    
    public static com.kingdee.eas.custom.applicationofsocialsecurity.IDataBaseConnection getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.applicationofsocialsecurity.IDataBaseConnection)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("38328C78") ,com.kingdee.eas.custom.applicationofsocialsecurity.IDataBaseConnection.class, objectCtx);
    }
    public static com.kingdee.eas.custom.applicationofsocialsecurity.IDataBaseConnection getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.applicationofsocialsecurity.IDataBaseConnection)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("38328C78"));
    }
    public static com.kingdee.eas.custom.applicationofsocialsecurity.IDataBaseConnection getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.applicationofsocialsecurity.IDataBaseConnection)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("38328C78"));
    }
}