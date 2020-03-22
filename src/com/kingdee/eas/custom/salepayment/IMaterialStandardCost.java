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

public interface IMaterialStandardCost extends IDataBase
{
    public MaterialStandardCostInfo getMaterialStandardCostInfo(IObjectPK pk) throws BOSException, EASBizException;
    public MaterialStandardCostInfo getMaterialStandardCostInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public MaterialStandardCostInfo getMaterialStandardCostInfo(String oql) throws BOSException, EASBizException;
    public MaterialStandardCostCollection getMaterialStandardCostCollection() throws BOSException;
    public MaterialStandardCostCollection getMaterialStandardCostCollection(EntityViewInfo view) throws BOSException;
    public MaterialStandardCostCollection getMaterialStandardCostCollection(String oql) throws BOSException;
    public void audit(MaterialStandardCostInfo model) throws BOSException;
    public void unAudit(MaterialStandardCostInfo model) throws BOSException;
}