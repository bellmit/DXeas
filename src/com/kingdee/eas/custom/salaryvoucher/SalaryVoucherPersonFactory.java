package com.kingdee.eas.custom.salaryvoucher;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SalaryVoucherPersonFactory
{
    private SalaryVoucherPersonFactory()
    {
    }
    public static com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherPerson getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherPerson)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E186874A") ,com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherPerson.class);
    }
    
    public static com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherPerson getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherPerson)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E186874A") ,com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherPerson.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherPerson getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherPerson)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E186874A"));
    }
    public static com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherPerson getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.ISalaryVoucherPerson)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E186874A"));
    }
}