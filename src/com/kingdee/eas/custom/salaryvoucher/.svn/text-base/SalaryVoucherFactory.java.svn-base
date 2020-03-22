package com.kingdee.eas.custom.salaryvoucher;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SalaryVoucherFactory
{
    private SalaryVoucherFactory()
    {
    }
    public static com.kingdee.eas.custom.salaryvoucher.ISalaryVoucher getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.ISalaryVoucher)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9A5BC395") ,com.kingdee.eas.custom.salaryvoucher.ISalaryVoucher.class);
    }
    
    public static com.kingdee.eas.custom.salaryvoucher.ISalaryVoucher getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.ISalaryVoucher)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9A5BC395") ,com.kingdee.eas.custom.salaryvoucher.ISalaryVoucher.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salaryvoucher.ISalaryVoucher getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.ISalaryVoucher)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9A5BC395"));
    }
    public static com.kingdee.eas.custom.salaryvoucher.ISalaryVoucher getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.ISalaryVoucher)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9A5BC395"));
    }
}