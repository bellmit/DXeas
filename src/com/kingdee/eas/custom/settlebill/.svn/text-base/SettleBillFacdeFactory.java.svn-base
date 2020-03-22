package com.kingdee.eas.custom.settlebill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettleBillFacdeFactory
{
    private SettleBillFacdeFactory()
    {
    }
    public static com.kingdee.eas.custom.settlebill.ISettleBillFacde getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ISettleBillFacde)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6D7814A6") ,com.kingdee.eas.custom.settlebill.ISettleBillFacde.class);
    }
    
    public static com.kingdee.eas.custom.settlebill.ISettleBillFacde getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ISettleBillFacde)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6D7814A6") ,com.kingdee.eas.custom.settlebill.ISettleBillFacde.class, objectCtx);
    }
    public static com.kingdee.eas.custom.settlebill.ISettleBillFacde getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ISettleBillFacde)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6D7814A6"));
    }
    public static com.kingdee.eas.custom.settlebill.ISettleBillFacde getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ISettleBillFacde)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6D7814A6"));
    }
}