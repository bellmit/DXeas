package com.kingdee.eas.farm.carnivorous.basebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MaiginBillEntryFactory
{
    private MaiginBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IMaiginBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IMaiginBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("590FDA9D") ,com.kingdee.eas.farm.carnivorous.basebiz.IMaiginBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basebiz.IMaiginBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IMaiginBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("590FDA9D") ,com.kingdee.eas.farm.carnivorous.basebiz.IMaiginBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IMaiginBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IMaiginBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("590FDA9D"));
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IMaiginBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IMaiginBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("590FDA9D"));
    }
}