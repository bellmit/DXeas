package com.kingdee.eas.custom.lhsm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PersonGuaranteeFactory
{
    private PersonGuaranteeFactory()
    {
    }
    public static com.kingdee.eas.custom.lhsm.IPersonGuarantee getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.IPersonGuarantee)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3B72EBA6") ,com.kingdee.eas.custom.lhsm.IPersonGuarantee.class);
    }
    
    public static com.kingdee.eas.custom.lhsm.IPersonGuarantee getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.IPersonGuarantee)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3B72EBA6") ,com.kingdee.eas.custom.lhsm.IPersonGuarantee.class, objectCtx);
    }
    public static com.kingdee.eas.custom.lhsm.IPersonGuarantee getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.IPersonGuarantee)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3B72EBA6"));
    }
    public static com.kingdee.eas.custom.lhsm.IPersonGuarantee getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.IPersonGuarantee)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3B72EBA6"));
    }
}