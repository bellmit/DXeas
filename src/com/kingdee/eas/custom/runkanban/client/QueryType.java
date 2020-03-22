/**
 * output package name
 */
package com.kingdee.eas.custom.runkanban.client;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class QueryType extends StringEnum
{
    public static final String 养殖场商品鸡场全部数据_VALUE = "FFCCAD";//alias=FFCCAD
    public static final String 养殖场种鸡场全部数据_VALUE = "FFBHAD";//alias=FFBHAD
    public static final String 养殖场孵化场全部数据_VALUE = "FFHAD";//alias=FFHAD
    public static final String 食品厂全部数据_VALUE = "FFAD";//alias=FFAD
    public static final String 饲料厂全部数据_VALUE = "FMAD";//alias=FMAD
    public static final String 养殖场商品鸡场各场存栏量明细_VALUE = "FFCCBSD";//alias=FFCCBSD
    public static final String 养殖场商品鸡本月截止到今天的出栏数量汇总_VALUE = "CCMonthMarketSummary";//alias=CCMonthMarketSummary
    public static final String 养殖场商品鸡批次汇总全部数据_VALUE = "BreedBatchSummaryAllData";//alias=BreedBatchSummaryAllData
    public static final String 鸡场养殖只数统计_出栏数据统计_VALUE = "farmBreedQtyStatistic";//alias=farmBreedQtyStatistic
    public static final String 育成存栏与初始入栏母鸡批次汇总_VALUE = "HatchFactoryDetailsData";//alias=HatchFactoryDetailsData
    public static final String 产蛋数据按年月日统计批次汇总_VALUE = "LayEggsFactoryDetailsData";//alias=LayEggsFactoryDetailsData
    public static final String 食品厂库存冷冻冰鲜汇总_VALUE = "foodInventorySummary";//alias=foodInventorySummary
    public static final String 食品厂库存明细分类合计_VALUE = "foodInventoryDetails";//alias=foodInventoryDetails
    public static final String 食品厂月销量统计按物料大类_VALUE = "foodMonthSaleSummary";//alias=foodMonthSaleSummary
    public static final String 食品厂月销量统计按物料小类_VALUE = "foodMonthSaleDetails";//alias=foodMonthSaleDetails

    public static final QueryType 养殖场商品鸡场全部数据 = new QueryType("养殖场商品鸡场全部数据", 养殖场商品鸡场全部数据_VALUE);
    public static final QueryType 养殖场种鸡场全部数据 = new QueryType("养殖场种鸡场全部数据", 养殖场种鸡场全部数据_VALUE);
    public static final QueryType 养殖场孵化场全部数据 = new QueryType("养殖场孵化场全部数据", 养殖场孵化场全部数据_VALUE);
    public static final QueryType 食品厂全部数据 = new QueryType("食品厂全部数据", 食品厂全部数据_VALUE);
    public static final QueryType 饲料厂全部数据 = new QueryType("饲料厂全部数据", 饲料厂全部数据_VALUE);
    public static final QueryType 养殖场商品鸡场各场存栏量明细 = new QueryType("养殖场商品鸡场各场存栏量明细", 养殖场商品鸡场各场存栏量明细_VALUE);
    public static final QueryType 养殖场商品鸡本月截止到今天的出栏数量汇总 = new QueryType("养殖场商品鸡本月截止到今天的出栏数量汇总", 养殖场商品鸡本月截止到今天的出栏数量汇总_VALUE);
    public static final QueryType 养殖场商品鸡批次汇总全部数据 = new QueryType("养殖场商品鸡批次汇总全部数据", 养殖场商品鸡批次汇总全部数据_VALUE);
    public static final QueryType 鸡场养殖只数统计_出栏数据统计 = new QueryType("鸡场养殖只数统计_出栏数据统计", 鸡场养殖只数统计_出栏数据统计_VALUE);
    public static final QueryType 育成存栏与初始入栏母鸡批次汇总 = new QueryType("育成存栏与初始入栏母鸡批次汇总", 育成存栏与初始入栏母鸡批次汇总_VALUE);
    public static final QueryType 产蛋数据按年月日统计批次汇总 = new QueryType("产蛋数据按年月日统计批次汇总", 产蛋数据按年月日统计批次汇总_VALUE);
    public static final QueryType 食品厂库存冷冻冰鲜汇总 = new QueryType("食品厂库存冷冻冰鲜汇总", 食品厂库存冷冻冰鲜汇总_VALUE);
    public static final QueryType 食品厂库存明细分类合计 = new QueryType("食品厂库存明细分类合计", 食品厂库存明细分类合计_VALUE);
    public static final QueryType 食品厂月销量统计按物料大类 = new QueryType("食品厂月销量统计按物料大类", 食品厂月销量统计按物料大类_VALUE);
    public static final QueryType 食品厂月销量统计按物料小类 = new QueryType("食品厂月销量统计按物料小类", 食品厂月销量统计按物料小类_VALUE);

    /**
     * construct function
     * @param String queryType
     */
    private QueryType(String name, String queryType)
    {
        super(name, queryType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static QueryType getEnum(String queryType)
    {
        return (QueryType)getEnum(QueryType.class, queryType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(QueryType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(QueryType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(QueryType.class);
    }
}