package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ContractTypeFactory
{
    private ContractTypeFactory()
    {
    }
    public static com.kingdee.eas.custom.signwasthetable.IContractType getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IContractType)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("639C3776") ,com.kingdee.eas.custom.signwasthetable.IContractType.class);
    }
    
    public static com.kingdee.eas.custom.signwasthetable.IContractType getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IContractType)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("639C3776") ,com.kingdee.eas.custom.signwasthetable.IContractType.class, objectCtx);
    }
    public static com.kingdee.eas.custom.signwasthetable.IContractType getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IContractType)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("639C3776"));
    }
    public static com.kingdee.eas.custom.signwasthetable.IContractType getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IContractType)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("639C3776"));
    }
}