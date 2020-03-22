package com.kingdee.eas.custom.lhsm;

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

public interface IGuaranteeApply extends ICoreBillBase
{
    public GuaranteeApplyCollection getGuaranteeApplyCollection() throws BOSException;
    public GuaranteeApplyCollection getGuaranteeApplyCollection(EntityViewInfo view) throws BOSException;
    public GuaranteeApplyCollection getGuaranteeApplyCollection(String oql) throws BOSException;
    public GuaranteeApplyInfo getGuaranteeApplyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public GuaranteeApplyInfo getGuaranteeApplyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public GuaranteeApplyInfo getGuaranteeApplyInfo(String oql) throws BOSException, EASBizException;
}