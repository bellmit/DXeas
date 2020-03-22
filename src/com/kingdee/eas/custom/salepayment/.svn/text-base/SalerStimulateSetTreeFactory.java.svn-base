package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SalerStimulateSetTreeFactory
{
    private SalerStimulateSetTreeFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.ISalerStimulateSetTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISalerStimulateSetTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("67DBC681") ,com.kingdee.eas.custom.salepayment.ISalerStimulateSetTree.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.ISalerStimulateSetTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISalerStimulateSetTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("67DBC681") ,com.kingdee.eas.custom.salepayment.ISalerStimulateSetTree.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.ISalerStimulateSetTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISalerStimulateSetTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("67DBC681"));
    }
    public static com.kingdee.eas.custom.salepayment.ISalerStimulateSetTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISalerStimulateSetTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("67DBC681"));
    }
}