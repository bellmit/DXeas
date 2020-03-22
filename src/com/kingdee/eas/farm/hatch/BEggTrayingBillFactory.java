package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BEggTrayingBillFactory
{
    private BEggTrayingBillFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IBEggTrayingBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggTrayingBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("92957B02") ,com.kingdee.eas.farm.hatch.IBEggTrayingBill.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IBEggTrayingBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggTrayingBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("92957B02") ,com.kingdee.eas.farm.hatch.IBEggTrayingBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IBEggTrayingBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggTrayingBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("92957B02"));
    }
    public static com.kingdee.eas.farm.hatch.IBEggTrayingBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IBEggTrayingBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("92957B02"));
    }
}