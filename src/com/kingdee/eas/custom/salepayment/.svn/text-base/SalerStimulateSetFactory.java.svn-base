package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SalerStimulateSetFactory
{
    private SalerStimulateSetFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.ISalerStimulateSet getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISalerStimulateSet)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AA9FB843") ,com.kingdee.eas.custom.salepayment.ISalerStimulateSet.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.ISalerStimulateSet getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISalerStimulateSet)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AA9FB843") ,com.kingdee.eas.custom.salepayment.ISalerStimulateSet.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.ISalerStimulateSet getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISalerStimulateSet)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AA9FB843"));
    }
    public static com.kingdee.eas.custom.salepayment.ISalerStimulateSet getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISalerStimulateSet)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AA9FB843"));
    }
}