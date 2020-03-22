package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TheLifeFeeOfFemaleDuckFactory
{
    private TheLifeFeeOfFemaleDuckFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITheLifeFeeOfFemaleDuck getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITheLifeFeeOfFemaleDuck)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("56FE1CDA") ,com.kingdee.eas.farm.stocking.processbizill.ITheLifeFeeOfFemaleDuck.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.ITheLifeFeeOfFemaleDuck getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITheLifeFeeOfFemaleDuck)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("56FE1CDA") ,com.kingdee.eas.farm.stocking.processbizill.ITheLifeFeeOfFemaleDuck.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITheLifeFeeOfFemaleDuck getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITheLifeFeeOfFemaleDuck)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("56FE1CDA"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITheLifeFeeOfFemaleDuck getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITheLifeFeeOfFemaleDuck)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("56FE1CDA"));
    }
}