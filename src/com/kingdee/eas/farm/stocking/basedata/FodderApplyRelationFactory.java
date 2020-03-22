package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FodderApplyRelationFactory
{
    private FodderApplyRelationFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFodderApplyRelation getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFodderApplyRelation)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8297D2C3") ,com.kingdee.eas.farm.stocking.basedata.IFodderApplyRelation.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IFodderApplyRelation getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFodderApplyRelation)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8297D2C3") ,com.kingdee.eas.farm.stocking.basedata.IFodderApplyRelation.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFodderApplyRelation getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFodderApplyRelation)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8297D2C3"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFodderApplyRelation getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFodderApplyRelation)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8297D2C3"));
    }
}