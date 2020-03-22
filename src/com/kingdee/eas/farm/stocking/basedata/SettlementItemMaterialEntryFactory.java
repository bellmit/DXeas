package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettlementItemMaterialEntryFactory
{
    private SettlementItemMaterialEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.ISettlementItemMaterialEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ISettlementItemMaterialEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EC87E71E") ,com.kingdee.eas.farm.stocking.basedata.ISettlementItemMaterialEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.ISettlementItemMaterialEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ISettlementItemMaterialEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EC87E71E") ,com.kingdee.eas.farm.stocking.basedata.ISettlementItemMaterialEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.ISettlementItemMaterialEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ISettlementItemMaterialEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EC87E71E"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.ISettlementItemMaterialEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ISettlementItemMaterialEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EC87E71E"));
    }
}