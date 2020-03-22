package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CustomerViewTypeFactory
{
    private CustomerViewTypeFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ICustomerViewType getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ICustomerViewType)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("23F8171F") ,com.kingdee.eas.farm.carnivorous.basedata.ICustomerViewType.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.ICustomerViewType getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ICustomerViewType)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("23F8171F") ,com.kingdee.eas.farm.carnivorous.basedata.ICustomerViewType.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ICustomerViewType getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ICustomerViewType)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("23F8171F"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.ICustomerViewType getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ICustomerViewType)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("23F8171F"));
    }
}