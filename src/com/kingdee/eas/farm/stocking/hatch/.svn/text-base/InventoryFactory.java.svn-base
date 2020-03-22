package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class InventoryFactory
{
    private InventoryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.hatch.IInventory getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IInventory)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("224A9CB2") ,com.kingdee.eas.farm.stocking.hatch.IInventory.class);
    }
    
    public static com.kingdee.eas.farm.stocking.hatch.IInventory getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IInventory)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("224A9CB2") ,com.kingdee.eas.farm.stocking.hatch.IInventory.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.hatch.IInventory getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IInventory)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("224A9CB2"));
    }
    public static com.kingdee.eas.farm.stocking.hatch.IInventory getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.hatch.IInventory)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("224A9CB2"));
    }
}