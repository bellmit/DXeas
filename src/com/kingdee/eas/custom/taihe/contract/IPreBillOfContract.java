package com.kingdee.eas.custom.taihe.contract;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlBillBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IPreBillOfContract extends IWlhlBillBase
{
    public PreBillOfContractCollection getPreBillOfContractCollection() throws BOSException;
    public PreBillOfContractCollection getPreBillOfContractCollection(EntityViewInfo view) throws BOSException;
    public PreBillOfContractCollection getPreBillOfContractCollection(String oql) throws BOSException;
    public PreBillOfContractInfo getPreBillOfContractInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PreBillOfContractInfo getPreBillOfContractInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PreBillOfContractInfo getPreBillOfContractInfo(String oql) throws BOSException, EASBizException;
}