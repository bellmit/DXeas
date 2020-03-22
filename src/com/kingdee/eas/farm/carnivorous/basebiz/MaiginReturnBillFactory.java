package com.kingdee.eas.farm.carnivorous.basebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MaiginReturnBillFactory
{
    private MaiginReturnBillFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IMaiginReturnBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IMaiginReturnBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("244581A5") ,com.kingdee.eas.farm.carnivorous.basebiz.IMaiginReturnBill.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basebiz.IMaiginReturnBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IMaiginReturnBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("244581A5") ,com.kingdee.eas.farm.carnivorous.basebiz.IMaiginReturnBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IMaiginReturnBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IMaiginReturnBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("244581A5"));
    }
    public static com.kingdee.eas.farm.carnivorous.basebiz.IMaiginReturnBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.IMaiginReturnBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("244581A5"));
    }
}