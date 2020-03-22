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

public interface ISaleForecast extends ICoreBillBase
{
    public SaleForecastCollection getSaleForecastCollection() throws BOSException;
    public SaleForecastCollection getSaleForecastCollection(EntityViewInfo view) throws BOSException;
    public SaleForecastCollection getSaleForecastCollection(String oql) throws BOSException;
    public SaleForecastInfo getSaleForecastInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SaleForecastInfo getSaleForecastInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SaleForecastInfo getSaleForecastInfo(String oql) throws BOSException, EASBizException;
    public void audit(SaleForecastInfo model) throws BOSException, EASBizException;
    public void unAudit(SaleForecastInfo model) throws BOSException, EASBizException;
    public void progressView(SaleForecastInfo model) throws BOSException;
    public void viewPro(SaleForecastInfo model) throws BOSException;
}