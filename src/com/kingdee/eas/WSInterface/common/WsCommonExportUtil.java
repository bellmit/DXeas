package com.kingdee.eas.WSInterface.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemCollection;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.PropertyContainer;
//import com.kingdee.eas.scm.ws.SCMWebServiceFacadeFactory;

// Referenced classes of package com.kingdee.eas.wmWs.app.common:
//            WsCommonXMLUtil, WsCommonUtil, WsCommonImportUtil, WsConstant

public class WsCommonExportUtil
{

    static final Logger logger = Logger.getLogger("com.kingdee.eas.custom.WSInterface.common.WSCommonExportUtil");
    public WsCommonExportUtil()
    {
    }

    public static List getBaseDataXml(Context ctx, AbstractObjectCollection coreBaseCollection, Map headMap, Map entryMap, String entryName)
        throws Exception
    {
        if(coreBaseCollection == null || coreBaseCollection.size() <= 0)
            return null;
        StringBuffer jsonBuffer = new StringBuffer();
        jsonBuffer.append("[");
        for(int nIndex = 0; nIndex < coreBaseCollection.size(); nIndex++)
        {
            com.kingdee.bos.dao.IObjectValue objectValue = coreBaseCollection.getObject(nIndex);
            String objectValueJson = JSONUtils.convertObjectToJson(ctx, objectValue);
            jsonBuffer.append(objectValueJson);
            if(nIndex < coreBaseCollection.size() - 1)
                jsonBuffer.append(",");
        }

        jsonBuffer.append("]");
        System.out.println(jsonBuffer);
        List list = new ArrayList();
        CoreBaseInfo coreBaseInfo = null;
        int i = 0;
        for(int count = coreBaseCollection.size(); i < count; i++)
        {
            coreBaseInfo = (CoreBaseInfo)coreBaseCollection.getObject(i);
            Map billHead = getBaseDataHeadMap(ctx, coreBaseInfo, headMap);
            List entiesList = getBaseDataEnitesMap(ctx, coreBaseInfo, entryMap, entryName);
            billHead.put(entryName, entiesList);
            JSONObject jsonObject1 = JSONObject.fromObject(billHead);
            System.out.println(jsonObject1);
            //SCMWebServiceFacadeFactory.getLocalInstance(ctx).importBill("002", jsonObject1.toString(), 1);
            String baseDataXml = WsCommonXMLUtil.buildBaseDataXml(billHead, entiesList);
            list.add(coreBaseInfo);
            JSONArray jsonArray = JSONArray.fromObject(list);
            System.out.println(jsonArray.toString());
            JSONObject jsonObject2 = JSONObject.fromObject(coreBaseInfo);
            System.out.println(jsonObject1);
        }

        return list;
    }

    private static Map getBaseDataHeadMap(Context ctx, PropertyContainer coreBaseInfo, Map headMap)
        throws BOSException
    {
        if(headMap == null || headMap.size() <= 0)
            return null;
        Map billHeadMap = new HashMap();
        try
        {
            for(Iterator strit = headMap.entrySet().iterator(); strit.hasNext();)
            {
                java.util.Map.Entry et = (java.util.Map.Entry)strit.next();
                String propertyName = et.getKey().toString();
                Object value = et.getValue();
                if(value instanceof EntityObjectInfo)
                    billHeadMap.put(propertyName, WsCommonUtil.getLinkProperties(ctx, coreBaseInfo, propertyName, (EntityObjectInfo)value));
                else
                if(value.toString().equals("Date"))
                    billHeadMap.put(propertyName, WsCommonUtil.getDateProperties(coreBaseInfo, propertyName));
                else
                if(value.toString().equals("TimeStamp"))
                    billHeadMap.put(propertyName, WsCommonUtil.getTimeStatmpProperties(coreBaseInfo, propertyName));
                else
                if(value.toString().equals("Integer"))
                    billHeadMap.put(propertyName, Integer.valueOf(WsCommonUtil.getIntProperties(coreBaseInfo, propertyName)));
                else
                if(value.toString().equals("BigDecimal"))
                    billHeadMap.put(propertyName, WsCommonUtil.getDeciamlProperties(coreBaseInfo, propertyName));
                else
                if(value.toString().equals("Boolean"))
                    billHeadMap.put(propertyName, Integer.valueOf(WsCommonUtil.getBooleanProperties(coreBaseInfo, propertyName)));
                else
                if(value.toString().equals("String"))
                    billHeadMap.put(propertyName, WsCommonUtil.getStrProperties(coreBaseInfo, propertyName));
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return billHeadMap;
    }

    private static List getBaseDataEnitesMap(Context ctx, PropertyContainer coreBaseInfo, Map entiesMap, String entisName)
    {
        if(entisName == null || "".equals(entisName))
            return null;
        Object obj = coreBaseInfo.get(entisName);
        if(obj == null)
            return null;
        AbstractObjectCollection coll = null;
        if(obj instanceof AbstractObjectCollection)
            coll = (AbstractObjectCollection)obj;
        if(coll == null || coll.size() <= 0)
            return null;
        List list = new ArrayList();
        try
        {
            int i = 0;
            for(int count = coll.size(); i < count; i++)
            {
                PropertyContainer pInfo = (PropertyContainer)coll.getObject(i);
                list.add(getBaseDataHeadMap(ctx, pInfo, entiesMap));
            }

        }
        catch(Exception e)
        {
            logger.error(e);
        }
        return list;
    }

    private static String getStringInSql(IRowSet set)
        throws SQLException
    {
        StringBuffer result = new StringBuffer("");
        if(set != null && set.size() > 0)
        {
            String str = "";
            Vector stringVector = new Vector();
            while(set.next()) 
            {
                str = set.getString("fid");
                if(!"".equals(str) && !"NULL".equals(str.toUpperCase()) && !stringVector.contains(str))
                {
                    result.append((new StringBuilder("'")).append(str).append("',").toString());
                    stringVector.add(str);
                }
            }
        }
        if(result.length() > 0)
            return result.toString().substring(0, result.length() - 1);
        else
            return "";
    }

    public static List buildBillXml(Context ctx, String bostype, String entryName, int start, int rows, int flag)
        throws Exception
    {
        EntityObjectInfo eo = WsCommonUtil.getEntityObjectInfo(ctx, bostype);
        if(eo != null)
        {
            Map headMap = WsCommonImportUtil.getBillHeadProperties(eo);
            Map entryMap = null;
            if(entryName != null && !"".equals(entryName))
                entryMap = WsCommonImportUtil.getBillEntiesProperties(ctx, entryName, eo);
            String tableName = eo.getTable().getName();
            ICoreBase iLinkCoreBase = null;
            iLinkCoreBase = WsCommonUtil.getLocalInstance(ctx, eo);
            String ids = getids(ctx, tableName, start, rows);
            if(ids != null && !"".equals(ids))
            {
                EntityViewInfo view = new EntityViewInfo();
                FilterInfo filter = new FilterInfo();
                FilterItemCollection fic = filter.getFilterItems();
                fic.add(new FilterItemInfo("id", "Q/IAAAAPD34xcb+t"));
                view.setFilter(filter);
                CoreBaseCollection coreBaseCollection = iLinkCoreBase.getCollection(view);
                StringBuffer jsonBuffer = new StringBuffer();
                jsonBuffer.append("[");
                for(int nIndex = 0; nIndex < coreBaseCollection.size(); nIndex++)
                {
                    com.kingdee.bos.dao.IObjectValue objectValue = coreBaseCollection.getObject(nIndex);
                    String objectValueJson = JSONUtils.convertObjectToJson(ctx, objectValue);
                    jsonBuffer.append(objectValueJson);
                    if(nIndex < coreBaseCollection.size() - 1)
                        jsonBuffer.append(",");
                }

                jsonBuffer.append("]");
                System.out.println(jsonBuffer);
                Object infos = null;
                infos = JSONUtils.convertJsonToObject(ctx, jsonBuffer.toString(), com.kingdee.eas.scm.sm.pur.PurOrderCollection.class);
                AbstractObjectCollection objCol = new CoreBillBaseCollection();
                if(infos instanceof AbstractObjectCollection)
                    objCol = (AbstractObjectCollection)infos;
                System.out.println(objCol);
            }
        }
        return null;
    }

    public static List buildBillXmlByCssp(Context ctx, String bostype, String groupStandard, int start, int rows, int flag)
        throws Exception
    {
        EntityObjectInfo eo = WsCommonUtil.getEntityObjectInfo(ctx, bostype);
        if(eo != null)
        {
            Map headMap = WsCommonImportUtil.getBillHeadProperties(eo);
            String tableName = eo.getTable().getName();
            ICoreBase iLinkCoreBase = null;
            iLinkCoreBase = WsCommonUtil.getLocalInstance(ctx, eo);
            String ids = getidsByCssp(ctx, tableName, groupStandard, start, rows);
            if(ids != null && !"".equals(ids))
            {
                EntityViewInfo view = new EntityViewInfo();
                FilterInfo filter = new FilterInfo();
                FilterItemCollection fic = filter.getFilterItems();
                fic.add(new FilterItemInfo("id", "Q/IAAAAPD34xcb+t"));
                view.setFilter(filter);
                CoreBaseCollection coreBaseCollection = iLinkCoreBase.getCollection(view);
                StringBuffer jsonBuffer = new StringBuffer();
                jsonBuffer.append("[");
                for(int nIndex = 0; nIndex < coreBaseCollection.size(); nIndex++)
                {
                    com.kingdee.bos.dao.IObjectValue objectValue = coreBaseCollection.getObject(nIndex);
                    String objectValueJson = JSONUtils.convertObjectToJson(ctx, objectValue);
                    jsonBuffer.append(objectValueJson);
                    if(nIndex < coreBaseCollection.size() - 1)
                        jsonBuffer.append(",");
                }

                jsonBuffer.append("]");
                System.out.println(jsonBuffer);
                if(coreBaseCollection != null && coreBaseCollection.size() > 0)
                    return getBaseDataXml(ctx, coreBaseCollection, headMap, null, "");
            }
        }
        return null;
    }

    public static EntityViewInfo getQueryView(Map headMap, String ids, Map entryMap, String entryName, int flag)
    {
        EntityViewInfo view = new EntityViewInfo();
        FilterInfo filter = new FilterInfo();
        FilterItemCollection fic = filter.getFilterItems();
        fic.add(new FilterItemInfo("id", "Q/IAAAAPLrgxcb+t"));
        SelectorItemCollection sic = view.getSelector();
        if(flag == 0)
        {
            WsCommonUtil.setHeadSelectorItem(sic, headMap);
            if(entryMap != null && entryMap.size() > 0)
                WsCommonUtil.setEntrySelectorItem(sic, entryName, entryMap);
        } else
        if(flag == 1)
            sic.add(new SelectorItemInfo("*"));
        view.setFilter(filter);
        return view;
    }

    public static EntityViewInfo getQueryView(Context ctx, Map headMap, String ids, String BosType, EntityObjectInfo eo, int flag)
    {
        EntityViewInfo view = new EntityViewInfo();
        FilterInfo filter = new FilterInfo();
        FilterItemCollection fic = filter.getFilterItems();
        fic.add(new FilterItemInfo("id", ids, CompareType.INNER));
        SelectorItemCollection sic = view.getSelector();
        if(flag == 0)
        {
            WsCommonUtil.setHeadSelectorItem(sic, headMap);
            List entryList = WsConstant.getEntryList(BosType);
            for(int i = 0; i < entryList.size(); i++)
            {
                String entryName = (String)entryList.get(i);
                if(entryName != null)
                {
                    Map entryMap = WsCommonImportUtil.getBillEntiesProperties(ctx, entryName, eo);
                    if(entryMap != null && entryMap.size() > 0)
                        WsCommonUtil.setEntrySelectorItem(sic, entryName, entryMap);
                }
            }

        } else
        if(flag == 1)
            sic.add(new SelectorItemInfo("*"));
        view.setFilter(filter);
        return view;
    }

    public static String getids(Context ctx, String tableName, int start, int rows)
        throws BOSException, SQLException
    {
        String ids = "";
        String sql = (new StringBuilder("select fid from ")).append(tableName).toString();
        IRowSet set = DbUtil.executeQuery(ctx, sql, start, rows);
        ids = getStringInSql(set);
        return ids;
    }

    public static String getids(Context ctx, String tableName, String dateStr)
        throws BOSException, SQLException
    {
        String ids = "";
        String sql = (new StringBuilder("select fid from ")).append(tableName).append(" where FLastUpdateTime >={ts'").append(dateStr).append("'}").toString();//FCreateTime
        IRowSet set = DbUtil.executeQuery(ctx, sql);
        ids = getStringInSql(set);
        return ids;
    }
    public static String getIDsByOrg(Context ctx, String tableName, String orgID,String dateStr)
    throws BOSException, SQLException
{
    String ids = "";
    StringBuffer sql=new StringBuffer();
    sql.append(" select t1.fid from ").append(tableName).append(" t1");
    sql.append(" inner join T_ORG_BaseUnit t2 on t2.fid=t1.FControlUnitID");
    sql.append(" where t1.FLastUpdateTime >={ts'").append(dateStr).append("'}");//FCreateTime
    sql.append(" and t2.FID='").append(orgID).append("'");
    IRowSet set = DbUtil.executeQuery(ctx, sql.toString());
    ids = getStringInSql(set);
    return ids;
}
    
    public static String getIDsByOrgNum(Context ctx, String tableName, String orgID,String dateStr)
    throws BOSException, SQLException
{
    String ids = "";
    StringBuffer sql=new StringBuffer();
    sql.append(" select t1.fid from ").append(tableName).append(" t1");
    sql.append(" inner join T_ORG_BaseUnit t2 on t2.fid=t1.FControlUnitID");
    sql.append(" where t1.FBizDate >={ts'").append(dateStr).append("'}");//FCreateTime
    sql.append(" and t2.FNumber='").append(orgID).append("'");
    IRowSet set = DbUtil.executeQuery(ctx, sql.toString());
    ids = getStringInSql(set);
    return ids;
}
    
    public static String getAccountBankIDsByFICompany(Context ctx, String tableName, String orgID,String dateStr)
    throws BOSException, SQLException
{
    String ids = "";
    StringBuffer sql=new StringBuffer();
    sql.append(" select distinct fid from (");
    sql.append(" select t1.fid from ").append(tableName).append(" t1");
    sql.append(" inner join T_ORG_BaseUnit t2 on t2.fid=t1.FCompanyID");
    sql.append(" where t1.FLastUpdateTime >={ts'").append(dateStr).append("'}");//FCreateTime
    sql.append(" and t2.FID='").append(orgID).append("'");
    sql.append(" union all");
    sql.append(" select ta.FBankAccountID FID");
    sql.append(" from T_BD_SharedAcct ta");
    sql.append(" inner join T_BD_SharedAcctEntries te on te.fparentid=ta.fid");
    sql.append(" where te.FSharedCompanyID='").append(orgID).append("'");
    sql.append( " ) tt");
    IRowSet set = DbUtil.executeQuery(ctx, sql.toString());
    ids = getStringInSql(set);
    return ids;
}

    public static String getidsByCssp(Context ctx, String tableName, String groupStandard, String dateStr)
        throws BOSException, SQLException
    {
        String ids = "";
        String sql = (new StringBuilder("select fid from ")).append(tableName).append(" where  FCreateTime >={ts'").append(dateStr).append("'} AND FCSSPGroupStandardID in (select fid from T_BD_CSSPGroupStandard where fnumber ='").append(groupStandard).append("')").toString();
        IRowSet set = DbUtil.executeQuery(ctx, sql);
        ids = getStringInSql(set);
        return ids;
    }

    public static String getidsByCssp(Context ctx, String tableName, String groupStandard, int start, int rows)
        throws BOSException, SQLException
    {
        String ids = "";
        String sql = (new StringBuilder("select fid from ")).append(tableName).append(" where  FCSSPGroupStandardID in (select fid from T_BD_CSSPGroupStandard where fnumber ='").append(groupStandard).append("')").toString();
        IRowSet set = DbUtil.executeQuery(ctx, sql, start, rows);
        ids = getStringInSql(set);
        return ids;
    }
}
