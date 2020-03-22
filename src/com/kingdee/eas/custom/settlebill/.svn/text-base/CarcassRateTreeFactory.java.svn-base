package com.kingdee.eas.custom.settlebill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CarcassRateTreeFactory
{
    private CarcassRateTreeFactory()
    {
    }
    public static com.kingdee.eas.custom.settlebill.ICarcassRateTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ICarcassRateTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B3F85BBF") ,com.kingdee.eas.custom.settlebill.ICarcassRateTree.class);
    }
    
    public static com.kingdee.eas.custom.settlebill.ICarcassRateTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ICarcassRateTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B3F85BBF") ,com.kingdee.eas.custom.settlebill.ICarcassRateTree.class, objectCtx);
    }
    public static com.kingdee.eas.custom.settlebill.ICarcassRateTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ICarcassRateTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B3F85BBF"));
    }
    public static com.kingdee.eas.custom.settlebill.ICarcassRateTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ICarcassRateTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B3F85BBF"));
    }
}