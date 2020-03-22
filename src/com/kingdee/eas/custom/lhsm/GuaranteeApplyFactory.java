package com.kingdee.eas.custom.lhsm;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class GuaranteeApplyFactory
{
    private GuaranteeApplyFactory()
    {
    }
    public static com.kingdee.eas.custom.lhsm.IGuaranteeApply getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.IGuaranteeApply)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1ADA8673") ,com.kingdee.eas.custom.lhsm.IGuaranteeApply.class);
    }
    
    public static com.kingdee.eas.custom.lhsm.IGuaranteeApply getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.IGuaranteeApply)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1ADA8673") ,com.kingdee.eas.custom.lhsm.IGuaranteeApply.class, objectCtx);
    }
    public static com.kingdee.eas.custom.lhsm.IGuaranteeApply getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.IGuaranteeApply)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1ADA8673"));
    }
    public static com.kingdee.eas.custom.lhsm.IGuaranteeApply getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.lhsm.IGuaranteeApply)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1ADA8673"));
    }
}