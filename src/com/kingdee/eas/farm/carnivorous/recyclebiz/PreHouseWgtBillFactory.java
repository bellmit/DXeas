package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PreHouseWgtBillFactory
{
    private PreHouseWgtBillFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.IPreHouseWgtBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.IPreHouseWgtBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CF04EA91") ,com.kingdee.eas.farm.carnivorous.recyclebiz.IPreHouseWgtBill.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.IPreHouseWgtBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.IPreHouseWgtBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CF04EA91") ,com.kingdee.eas.farm.carnivorous.recyclebiz.IPreHouseWgtBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.IPreHouseWgtBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.IPreHouseWgtBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CF04EA91"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.IPreHouseWgtBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.IPreHouseWgtBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CF04EA91"));
    }
}