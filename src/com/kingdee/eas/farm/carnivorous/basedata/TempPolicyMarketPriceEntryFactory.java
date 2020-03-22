package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TempPolicyMarketPriceEntryFactory
{
    private TempPolicyMarketPriceEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ITempPolicyMarketPriceEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ITempPolicyMarketPriceEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EE036B6D") ,com.kingdee.eas.farm.carnivorous.basedata.ITempPolicyMarketPriceEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.ITempPolicyMarketPriceEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ITempPolicyMarketPriceEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EE036B6D") ,com.kingdee.eas.farm.carnivorous.basedata.ITempPolicyMarketPriceEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ITempPolicyMarketPriceEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ITempPolicyMarketPriceEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EE036B6D"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ITempPolicyMarketPriceEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ITempPolicyMarketPriceEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EE036B6D"));
    }
}