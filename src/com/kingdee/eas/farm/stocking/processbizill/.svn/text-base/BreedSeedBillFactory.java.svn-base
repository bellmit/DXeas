package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedSeedBillFactory
{
    private BreedSeedBillFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBreedSeedBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBreedSeedBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("896D0067") ,com.kingdee.eas.farm.stocking.processbizill.IBreedSeedBill.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IBreedSeedBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBreedSeedBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("896D0067") ,com.kingdee.eas.farm.stocking.processbizill.IBreedSeedBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBreedSeedBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBreedSeedBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("896D0067"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBreedSeedBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBreedSeedBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("896D0067"));
    }
}