package com.kingdee.eas.farm.carnivorous.basebiz;

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

public interface IFarmerGuaranteeBill extends ICoreBillBase
{
    public FarmerGuaranteeBillCollection getFarmerGuaranteeBillCollection() throws BOSException;
    public FarmerGuaranteeBillCollection getFarmerGuaranteeBillCollection(EntityViewInfo view) throws BOSException;
    public FarmerGuaranteeBillCollection getFarmerGuaranteeBillCollection(String oql) throws BOSException;
    public FarmerGuaranteeBillInfo getFarmerGuaranteeBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FarmerGuaranteeBillInfo getFarmerGuaranteeBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FarmerGuaranteeBillInfo getFarmerGuaranteeBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(FarmerGuaranteeBillInfo model) throws BOSException, EASBizException;
    public void unAudit(FarmerGuaranteeBillInfo model) throws BOSException, EASBizException;
}