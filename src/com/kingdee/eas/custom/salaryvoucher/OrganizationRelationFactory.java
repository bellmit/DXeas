package com.kingdee.eas.custom.salaryvoucher;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class OrganizationRelationFactory
{
    private OrganizationRelationFactory()
    {
    }
    public static com.kingdee.eas.custom.salaryvoucher.IOrganizationRelation getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.IOrganizationRelation)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D616851E") ,com.kingdee.eas.custom.salaryvoucher.IOrganizationRelation.class);
    }
    
    public static com.kingdee.eas.custom.salaryvoucher.IOrganizationRelation getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.IOrganizationRelation)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D616851E") ,com.kingdee.eas.custom.salaryvoucher.IOrganizationRelation.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salaryvoucher.IOrganizationRelation getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.IOrganizationRelation)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D616851E"));
    }
    public static com.kingdee.eas.custom.salaryvoucher.IOrganizationRelation getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.IOrganizationRelation)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D616851E"));
    }
}