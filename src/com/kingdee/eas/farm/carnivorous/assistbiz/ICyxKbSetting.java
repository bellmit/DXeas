package com.kingdee.eas.farm.carnivorous.assistbiz;

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

public interface ICyxKbSetting extends IDataBase
{
    public CyxKbSettingInfo getCyxKbSettingInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CyxKbSettingInfo getCyxKbSettingInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CyxKbSettingInfo getCyxKbSettingInfo(String oql) throws BOSException, EASBizException;
    public CyxKbSettingCollection getCyxKbSettingCollection() throws BOSException;
    public CyxKbSettingCollection getCyxKbSettingCollection(EntityViewInfo view) throws BOSException;
    public CyxKbSettingCollection getCyxKbSettingCollection(String oql) throws BOSException;
    public void audit(CyxKbSettingInfo model) throws BOSException, EASBizException;
    public void unAudit(CyxKbSettingInfo model) throws BOSException, EASBizException;
}