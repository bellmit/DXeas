package com.kingdee.eas.custom.taihe.contract;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SuccessiveContractFactory
{
    private SuccessiveContractFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.contract.ISuccessiveContract getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.ISuccessiveContract)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6C7F3E43") ,com.kingdee.eas.custom.taihe.contract.ISuccessiveContract.class);
    }
    
    public static com.kingdee.eas.custom.taihe.contract.ISuccessiveContract getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.ISuccessiveContract)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6C7F3E43") ,com.kingdee.eas.custom.taihe.contract.ISuccessiveContract.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.contract.ISuccessiveContract getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.ISuccessiveContract)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6C7F3E43"));
    }
    public static com.kingdee.eas.custom.taihe.contract.ISuccessiveContract getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.ISuccessiveContract)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6C7F3E43"));
    }
}