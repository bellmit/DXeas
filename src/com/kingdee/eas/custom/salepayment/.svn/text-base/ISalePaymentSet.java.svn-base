package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface ISalePaymentSet extends IDataBase
{
    public SalePaymentSetInfo getSalePaymentSetInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SalePaymentSetInfo getSalePaymentSetInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SalePaymentSetInfo getSalePaymentSetInfo(String oql) throws BOSException, EASBizException;
    public SalePaymentSetCollection getSalePaymentSetCollection() throws BOSException;
    public SalePaymentSetCollection getSalePaymentSetCollection(EntityViewInfo view) throws BOSException;
    public SalePaymentSetCollection getSalePaymentSetCollection(String oql) throws BOSException;
}