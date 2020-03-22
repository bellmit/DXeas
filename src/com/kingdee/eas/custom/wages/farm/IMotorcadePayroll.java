package com.kingdee.eas.custom.wages.farm;

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

public interface IMotorcadePayroll extends ICoreBillBase
{
    public MotorcadePayrollCollection getMotorcadePayrollCollection() throws BOSException;
    public MotorcadePayrollCollection getMotorcadePayrollCollection(EntityViewInfo view) throws BOSException;
    public MotorcadePayrollCollection getMotorcadePayrollCollection(String oql) throws BOSException;
    public MotorcadePayrollInfo getMotorcadePayrollInfo(IObjectPK pk) throws BOSException, EASBizException;
    public MotorcadePayrollInfo getMotorcadePayrollInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public MotorcadePayrollInfo getMotorcadePayrollInfo(String oql) throws BOSException, EASBizException;
    public void audit(MotorcadePayrollInfo model) throws BOSException;
    public void unaudit(MotorcadePayrollInfo model) throws BOSException;
}