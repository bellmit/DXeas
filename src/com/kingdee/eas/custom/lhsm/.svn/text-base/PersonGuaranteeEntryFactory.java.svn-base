package com.kingdee.eas.custom.lhsm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PersonGuaranteeEntryFactory
{
    private PersonGuaranteeEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.lhsm.IPersonGuaranteeEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.IPersonGuaranteeEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3DEC846C") ,com.kingdee.eas.custom.lhsm.IPersonGuaranteeEntry.class);
    }
    
    public static com.kingdee.eas.custom.lhsm.IPersonGuaranteeEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.IPersonGuaranteeEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3DEC846C") ,com.kingdee.eas.custom.lhsm.IPersonGuaranteeEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.lhsm.IPersonGuaranteeEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.IPersonGuaranteeEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3DEC846C"));
    }
    public static com.kingdee.eas.custom.lhsm.IPersonGuaranteeEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.IPersonGuaranteeEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3DEC846C"));
    }
}