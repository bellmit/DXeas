package com.kingdee.eas.custom.eas2temp;

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

public interface IBillDeafultSetting extends IDataBase
{
    public BillDeafultSettingInfo getBillDeafultSettingInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BillDeafultSettingInfo getBillDeafultSettingInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BillDeafultSettingInfo getBillDeafultSettingInfo(String oql) throws BOSException, EASBizException;
    public BillDeafultSettingCollection getBillDeafultSettingCollection() throws BOSException;
    public BillDeafultSettingCollection getBillDeafultSettingCollection(EntityViewInfo view) throws BOSException;
    public BillDeafultSettingCollection getBillDeafultSettingCollection(String oql) throws BOSException;
}