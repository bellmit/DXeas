package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.fi.ap.PayRequestBillInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public interface IcreateToFacade extends IBizCtrl
{
    public PayRequestBillInfo createTo( ContractInfo model) throws BOSException;
}