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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface ISaleFeeInput extends ICoreBillBase
{
    public SaleFeeInputCollection getSaleFeeInputCollection() throws BOSException;
    public SaleFeeInputCollection getSaleFeeInputCollection(EntityViewInfo view) throws BOSException;
    public SaleFeeInputCollection getSaleFeeInputCollection(String oql) throws BOSException;
    public SaleFeeInputInfo getSaleFeeInputInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SaleFeeInputInfo getSaleFeeInputInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SaleFeeInputInfo getSaleFeeInputInfo(String oql) throws BOSException, EASBizException;
}