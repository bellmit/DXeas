package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmerconfirmFactory
{
    private FarmerconfirmFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IFarmerconfirm getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFarmerconfirm)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C2FFE2B8") ,com.kingdee.eas.farm.stocking.processbizill.IFarmerconfirm.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IFarmerconfirm getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFarmerconfirm)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C2FFE2B8") ,com.kingdee.eas.farm.stocking.processbizill.IFarmerconfirm.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IFarmerconfirm getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFarmerconfirm)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C2FFE2B8"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IFarmerconfirm getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IFarmerconfirm)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C2FFE2B8"));
    }
}