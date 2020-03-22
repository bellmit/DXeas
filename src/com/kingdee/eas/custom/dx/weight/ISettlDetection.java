package com.kingdee.eas.custom.dx.weight;

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

public interface ISettlDetection extends IWlhlBillBase
{
    public SettlDetectionCollection getSettlDetectionCollection() throws BOSException;
    public SettlDetectionCollection getSettlDetectionCollection(EntityViewInfo view) throws BOSException;
    public SettlDetectionCollection getSettlDetectionCollection(String oql) throws BOSException;
    public SettlDetectionInfo getSettlDetectionInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SettlDetectionInfo getSettlDetectionInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SettlDetectionInfo getSettlDetectionInfo(String oql) throws BOSException, EASBizException;
}