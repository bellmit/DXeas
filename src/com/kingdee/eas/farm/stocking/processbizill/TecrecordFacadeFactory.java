package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TecrecordFacadeFactory
{
    private TecrecordFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITecrecordFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITecrecordFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("334DEB58") ,com.kingdee.eas.farm.stocking.processbizill.ITecrecordFacade.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.ITecrecordFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITecrecordFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("334DEB58") ,com.kingdee.eas.farm.stocking.processbizill.ITecrecordFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITecrecordFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITecrecordFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("334DEB58"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITecrecordFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITecrecordFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("334DEB58"));
    }
}