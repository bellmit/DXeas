package com.kingdee.eas.custom.wages;

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

public interface IMonthlysalarybill extends ICoreBillBase
{
    public MonthlysalarybillCollection getMonthlysalarybillCollection() throws BOSException;
    public MonthlysalarybillCollection getMonthlysalarybillCollection(EntityViewInfo view) throws BOSException;
    public MonthlysalarybillCollection getMonthlysalarybillCollection(String oql) throws BOSException;
    public MonthlysalarybillInfo getMonthlysalarybillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public MonthlysalarybillInfo getMonthlysalarybillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public MonthlysalarybillInfo getMonthlysalarybillInfo(String oql) throws BOSException, EASBizException;
    public void audit(MonthlysalarybillInfo model) throws BOSException;
    public void unaudit(MonthlysalarybillInfo model) throws BOSException;
    public void getPerson(MonthlysalarybillInfo model) throws BOSException;
    public void wagecalculation(MonthlysalarybillInfo model) throws BOSException;
}