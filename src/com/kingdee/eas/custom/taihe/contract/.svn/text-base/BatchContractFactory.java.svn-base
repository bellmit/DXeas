package com.kingdee.eas.custom.taihe.contract;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BatchContractFactory
{
    private BatchContractFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.contract.IBatchContract getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.IBatchContract)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8193F8D0") ,com.kingdee.eas.custom.taihe.contract.IBatchContract.class);
    }
    
    public static com.kingdee.eas.custom.taihe.contract.IBatchContract getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.IBatchContract)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8193F8D0") ,com.kingdee.eas.custom.taihe.contract.IBatchContract.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.contract.IBatchContract getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.IBatchContract)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8193F8D0"));
    }
    public static com.kingdee.eas.custom.taihe.contract.IBatchContract getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.IBatchContract)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8193F8D0"));
    }
}