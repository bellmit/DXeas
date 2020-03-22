package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class InventoryEntryFactory
{
    private InventoryEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.hatch.IInventoryEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IInventoryEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("23B59AE0") ,com.kingdee.eas.farm.stocking.hatch.IInventoryEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.hatch.IInventoryEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IInventoryEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("23B59AE0") ,com.kingdee.eas.farm.stocking.hatch.IInventoryEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.hatch.IInventoryEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IInventoryEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("23B59AE0"));
    }
    public static com.kingdee.eas.farm.stocking.hatch.IInventoryEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IInventoryEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("23B59AE0"));
    }
}