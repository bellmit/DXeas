package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SzCountPositionSetMaterialEntryFactory
{
    private SzCountPositionSetMaterialEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.szcount.ISzCountPositionSetMaterialEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ISzCountPositionSetMaterialEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("4E23C5CF") ,com.kingdee.eas.custom.szcount.ISzCountPositionSetMaterialEntry.class);
    }
    
    public static com.kingdee.eas.custom.szcount.ISzCountPositionSetMaterialEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ISzCountPositionSetMaterialEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("4E23C5CF") ,com.kingdee.eas.custom.szcount.ISzCountPositionSetMaterialEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.szcount.ISzCountPositionSetMaterialEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ISzCountPositionSetMaterialEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("4E23C5CF"));
    }
    public static com.kingdee.eas.custom.szcount.ISzCountPositionSetMaterialEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.ISzCountPositionSetMaterialEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("4E23C5CF"));
    }
}