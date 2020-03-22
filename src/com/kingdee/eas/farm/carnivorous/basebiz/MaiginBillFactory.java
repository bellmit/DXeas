package com.kingdee.eas.farm.carnivorous.basebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MaiginBillFactory
{
    private MaiginBillFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IMaiginBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IMaiginBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AB4CBAD5") ,com.kingdee.eas.farm.carnivorous.basebiz.IMaiginBill.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basebiz.IMaiginBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IMaiginBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AB4CBAD5") ,com.kingdee.eas.farm.carnivorous.basebiz.IMaiginBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IMaiginBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IMaiginBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AB4CBAD5"));
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IMaiginBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IMaiginBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AB4CBAD5"));
    }
}