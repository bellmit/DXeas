package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CKPECostbillFactory
{
    private CKPECostbillFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKPECostbill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKPECostbill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E6FEEDCE") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKPECostbill.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKPECostbill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKPECostbill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E6FEEDCE") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKPECostbill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKPECostbill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKPECostbill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E6FEEDCE"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKPECostbill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKPECostbill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E6FEEDCE"));
    }
}