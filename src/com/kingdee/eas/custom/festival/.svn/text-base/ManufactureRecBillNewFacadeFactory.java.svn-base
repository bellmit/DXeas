package com.kingdee.eas.custom.festival;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ManufactureRecBillNewFacadeFactory
{
    private ManufactureRecBillNewFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.festival.IManufactureRecBillNewFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IManufactureRecBillNewFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("67D94759") ,com.kingdee.eas.custom.festival.IManufactureRecBillNewFacade.class);
    }
    
    public static com.kingdee.eas.custom.festival.IManufactureRecBillNewFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IManufactureRecBillNewFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("67D94759") ,com.kingdee.eas.custom.festival.IManufactureRecBillNewFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.festival.IManufactureRecBillNewFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IManufactureRecBillNewFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("67D94759"));
    }
    public static com.kingdee.eas.custom.festival.IManufactureRecBillNewFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IManufactureRecBillNewFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("67D94759"));
    }
}