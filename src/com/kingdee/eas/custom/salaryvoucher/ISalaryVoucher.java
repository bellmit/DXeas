package com.kingdee.eas.custom.salaryvoucher;

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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface ISalaryVoucher extends ICoreBillBase
{
    public SalaryVoucherCollection getSalaryVoucherCollection() throws BOSException;
    public SalaryVoucherCollection getSalaryVoucherCollection(EntityViewInfo view) throws BOSException;
    public SalaryVoucherCollection getSalaryVoucherCollection(String oql) throws BOSException;
    public SalaryVoucherInfo getSalaryVoucherInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SalaryVoucherInfo getSalaryVoucherInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SalaryVoucherInfo getSalaryVoucherInfo(String oql) throws BOSException, EASBizException;
    public void toSalaryVoucher(SalaryVoucherInfo model) throws BOSException;
}