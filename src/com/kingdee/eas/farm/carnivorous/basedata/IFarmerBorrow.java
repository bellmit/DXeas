package com.kingdee.eas.farm.carnivorous.basedata;

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

public interface IFarmerBorrow extends IDataBase
{
    public FarmerBorrowInfo getFarmerBorrowInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FarmerBorrowInfo getFarmerBorrowInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FarmerBorrowInfo getFarmerBorrowInfo(String oql) throws BOSException, EASBizException;
    public FarmerBorrowCollection getFarmerBorrowCollection() throws BOSException;
    public FarmerBorrowCollection getFarmerBorrowCollection(EntityViewInfo view) throws BOSException;
    public FarmerBorrowCollection getFarmerBorrowCollection(String oql) throws BOSException;
    public void audit(FarmerBorrowInfo model) throws BOSException, EASBizException;
    public void unAudit(FarmerBorrowInfo model) throws BOSException, EASBizException;
    public void voucher(FarmerBorrowInfo model) throws BOSException;
}