package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BorrowDayRateTreeFactory
{
    private BorrowDayRateTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBorrowDayRateTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBorrowDayRateTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9E3B19C3") ,com.kingdee.eas.farm.carnivorous.basedata.IBorrowDayRateTree.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IBorrowDayRateTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBorrowDayRateTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9E3B19C3") ,com.kingdee.eas.farm.carnivorous.basedata.IBorrowDayRateTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBorrowDayRateTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBorrowDayRateTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9E3B19C3"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBorrowDayRateTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBorrowDayRateTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9E3B19C3"));
    }
}