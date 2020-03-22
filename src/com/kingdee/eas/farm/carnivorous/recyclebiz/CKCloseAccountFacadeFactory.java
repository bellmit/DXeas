package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CKCloseAccountFacadeFactory
{
    private CKCloseAccountFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCloseAccountFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCloseAccountFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("05367C94") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCloseAccountFacade.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCloseAccountFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCloseAccountFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("05367C94") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCloseAccountFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCloseAccountFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCloseAccountFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("05367C94"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCloseAccountFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKCloseAccountFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("05367C94"));
    }
}