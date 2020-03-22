package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TheLifeFeeOfFemaleDuckEntryFactory
{
    private TheLifeFeeOfFemaleDuckEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITheLifeFeeOfFemaleDuckEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITheLifeFeeOfFemaleDuckEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9773F3B8") ,com.kingdee.eas.farm.stocking.processbizill.ITheLifeFeeOfFemaleDuckEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.ITheLifeFeeOfFemaleDuckEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITheLifeFeeOfFemaleDuckEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9773F3B8") ,com.kingdee.eas.farm.stocking.processbizill.ITheLifeFeeOfFemaleDuckEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITheLifeFeeOfFemaleDuckEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITheLifeFeeOfFemaleDuckEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9773F3B8"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITheLifeFeeOfFemaleDuckEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITheLifeFeeOfFemaleDuckEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9773F3B8"));
    }
}