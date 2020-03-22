/**
 * output package name
 */
package com.kingdee.eas.custom.szcount.client;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.master.material.IMaterialGroup;
import com.kingdee.eas.basedata.master.material.MaterialGroupFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.szcount.FreshDaily;
import com.kingdee.eas.custom.szcount.FreshDailyFactory;
import com.kingdee.eas.custom.szcount.FreshDailyInfo;
import com.kingdee.eas.custom.szcount.ProductType;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class FreshDailyEditUI extends AbstractFreshDailyEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(FreshDailyEditUI.class);
    private boolean isLoadField=false;
    BigDecimal moneys = null;
    /**
     * output class constructor
     */
    public FreshDailyEditUI() throws Exception
    {
        super();
        setUITitle("生产日报单");
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
    	isLoadField=true;
        super.loadFields();
    	isLoadField=false;
        
    }
    
    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		txtworkTime.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				double a = UIRuleUtil.getDouble(txtworkTime.getText());//;Double.parseDouble(txtworkTime.getText()); 
				if(a>24){
					MsgBox.showWarning("用工时间不得超过24");
					txtworkTime.setValue(24);
				}
			}
		});
		
		this.btnGetData.setIcon(EASResource.getIcon("imgTbtn_get"));
		kdtEntry_detailPanel.getAddNewLineButton().setVisible(false);
		kdtEntry_detailPanel.getInsertLineButton().setVisible(false);
		kdtEntry_detailPanel.getRemoveLinesButton().setVisible(false);
		
		kdtEntry.getStyleAttributes().setLocked(true);
		kdtEntry.getColumn("remark").getStyleAttributes().setLocked(false);
		
		KDBizPromptBox kdtEntry_materialGroup_PromptBox = new KDBizPromptBox();
		kdtEntry_materialGroup_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialGroupAllQuery");
		kdtEntry_materialGroup_PromptBox.setVisible(true);
		kdtEntry_materialGroup_PromptBox.setEditable(true);
		kdtEntry_materialGroup_PromptBox.setDisplayFormat("$number$");
		kdtEntry_materialGroup_PromptBox.setEditFormat("$number$");
		kdtEntry_materialGroup_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtEntry_materialGroup_CellEditor = new KDTDefaultCellEditor(kdtEntry_materialGroup_PromptBox);
        this.kdtEntry.getColumn("materialGroup").setEditor(kdtEntry_materialGroup_CellEditor);
        ObjectValueRender kdtEntry_materialGroup_OVR = new ObjectValueRender();
        kdtEntry_materialGroup_OVR.setFormat(new BizDataFormat("$name$"));
        this.kdtEntry.getColumn("materialGroup").setRenderer(kdtEntry_materialGroup_OVR);
        
		addLisenters();
	}
    
	@Override
	public void actionGetData_actionPerformed(ActionEvent e) throws Exception {
		if(MsgBox.showConfirm2("是否获取数据？")!=MsgBox.YES) {
			return;
		}
		Date date =  (Date) pkBizDate.getValue();
		BOSUuid companyID = ((CompanyOrgUnitInfo)prmtcompany.getValue()).getId();
		if(companyID.toString().equals(("00000000-0000-0000-0000-000000000000CCE7AED4"))){
			MsgBox.showWarning("集团下不能制作日报单");
			return;
		}
	    SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
	    String bizDate = sdf.format(date);
		saveData(bizDate,companyID);
		
		//计算下午宰杀数
		txtmorningQty_Changed();
	}
	//获取总的数据 并且赋值
	private void saveData(String bizDate, BOSUuid companyID) throws BOSException {
		try {
			beforeStoreFields(null);
		} catch (Exception err) {
			handleException(err);
		}
		
		try {
			moneys = new BigDecimal("0");
			//结算胴体重、宰杀只数、结算毛重、实际收购运费、收购金额(结算总金额)、毛鸡成本、毛鸡均价、胴体出成率、本日毛鸡均重
			String sqla = sqla(bizDate,companyID);
			//商品鸡只数、商品鸡均价
			String sqlb = sqlb(bizDate,companyID);
			//市场鸡只数
			String sqlc = sqlc(bizDate,companyID);
			//小鸡重量、胴体折算小鸡重
			String sqld = sqld(bizDate,companyID);
			kdtEntry.removeRows();
			//插入鲜品明细
			insertMainProductDetail(bizDate,companyID);
	        //插入冻品明细
			insertFrozenEntryDetail(bizDate,companyID);
			//插入副产明细
//			insertByProductDetail(bizDate,companyID);
			//插入其他明细
//			insertOtherProductDetail(bizDate,companyID);
			//主产数量
			txtfinishedProductWgt.setValue(txtmainProductQty.getBigDecimalValue().add(txtbyProductQty.getBigDecimalValue()));
			//总金额
			txtallMoney.setValue(txtmainProductAmt.getBigDecimalValue().add(txtbyProductAmt.getBigDecimalValue()));
			//主产售价
			txtmainPrice.setValue(txtmainProductQty.getBigDecimalValue().signum()>0?txtmainProductAmt.getBigDecimalValue().divide(txtmainProductQty.getBigDecimalValue(),3,BigDecimal.ROUND_HALF_UP):BigDecimal.ZERO);
			//副产售价
			txtvicePrice.setValue(txtbyProductQty.getBigDecimalValue().signum()>0?txtbyProductAmt.getBigDecimalValue().divide(txtbyProductQty.getBigDecimalValue(),3,BigDecimal.ROUND_HALF_UP):BigDecimal.ZERO);
	
			//计算综合售价
			calTodayCompreSalePrice();
			
			//出成率常数
			String sqli = sqli(bizDate,companyID);
			//半包产品
			String sqlj = sqlj(bizDate,companyID);
			//鸡毛血肠嗉子杂油单价，吨费用 
			String sqlk = sqlk(companyID);
			IRowSet rsa = SQLExecutorFactory.getRemoteInstance(sqla).executeSQL();
			IRowSet rsb = SQLExecutorFactory.getRemoteInstance(sqlb).executeSQL();
			IRowSet rsc = SQLExecutorFactory.getRemoteInstance(sqlc).executeSQL();
			IRowSet rsd = SQLExecutorFactory.getRemoteInstance(sqld).executeSQL();
			IRowSet rsi = SQLExecutorFactory.getRemoteInstance(sqli).executeSQL();
			IRowSet rsj = SQLExecutorFactory.getRemoteInstance(sqlj).executeSQL();
			IRowSet rsk = SQLExecutorFactory.getRemoteInstance(sqlk).executeSQL();
			if(rsa.next()){
				txtsettlementCarcass.setValue(rsa.getBigDecimal("结算胴体重").setScale(2,BigDecimal.ROUND_HALF_UP));
				txtslaughterAmt.setValue(rsa.getBigDecimal("宰杀只数").intValue());
				//txtsettlementGrossWgt.setValue(rsa.getBigDecimal("结算毛重").setScale(2,BigDecimal.ROUND_HALF_UP));
				txtbuyFreight.setValue(rsa.getBigDecimal("实际收购运费").setScale(2,BigDecimal.ROUND_HALF_UP));
				txtbuyMoney.setValue(rsa.getBigDecimal("收购金额结算总金额").setScale(2,BigDecimal.ROUND_HALF_UP));
				txtGrossChickenCost.setValue(rsa.getBigDecimal("毛鸡成本").setScale(2,BigDecimal.ROUND_HALF_UP));
				txtGrossChickenAPrice.setValue(rsa.getBigDecimal("毛鸡均价").setScale(2,BigDecimal.ROUND_HALF_UP));
				//txtGrossChickenAWgt.setValue(rsa.getBigDecimal("本日毛鸡均重").setScale(2,BigDecimal.ROUND_HALF_UP));
				//结算毛重等于
				BigDecimal blossWgt=UIRuleUtil.getBigDecimal(txtShedBLossGrossWgt.getBigDecimalValue());
				txtsettlementGrossWgt.setValue(rsa.getBigDecimal("结算毛重").setScale(2,BigDecimal.ROUND_HALF_UP).subtract(blossWgt));
				//毛鸡均重
				txtGrossChickenAWgt.setValue(rsa.getBigDecimal("结算毛重").setScale(2,BigDecimal.ROUND_HALF_UP).subtract(blossWgt).divide(rsa.getBigDecimal("宰杀只数"),2,BigDecimal.ROUND_HALF_UP));
				
			}else{
				txtsettlementCarcass.setValue(null);
				txtslaughterAmt.setValue(null);
				txtsettlementGrossWgt.setValue(null);
				txtbuyFreight.setValue(null);
				txtbuyMoney.setValue(null);
				txtGrossChickenCost.setValue(null);
				txtGrossChickenAPrice.setValue(null);
				txtcarcassRatio.setValue(null);
				txtGrossChickenAWgt.setValue(null);
			}
			if(rsb.next()){
				txtcommodityChickenAmt.setValue(rsb.getBigDecimal("商品鸡只数").intValue());
				txtcommodityChickenAPrice.setValue(rsb.getBigDecimal("商品鸡均价").setScale(2, BigDecimal.ROUND_HALF_UP));
			}else{
				txtcommodityChickenAmt.setValue(null);
				txtcommodityChickenAPrice.setValue(null);
			}
			if(rsc.next()){
				txtmarketChickenAmt.setValue(rsc.getBigDecimal("市场鸡只数").intValue());
				txtmarketPrice.setValue(rsc.getBigDecimal("市场价格").setScale(2, BigDecimal.ROUND_HALF_UP));
			}else{
				txtmarketChickenAmt.setValue(null);
				txtmarketPrice.setValue(null);
			}	
			
			if(rsi.next()){
				txtratioConstant.setValue(rsi.getBigDecimal("出成率常数").setScale(2, BigDecimal.ROUND_HALF_UP));
			}else{
				txtratioConstant.setValue(null);
			}
			
			if(rsd.next()){
//				txtSmallChickenWgt.setValue(rsd.getBigDecimal("小鸡重量").setScale(2, BigDecimal.ROUND_HALF_UP));
//				txtCarcassSCWgt.setValue(rsd.getBigDecimal("胴体折算小鸡重").setScale(2, BigDecimal.ROUND_HALF_UP));
				if(UIRuleUtil.getBigDecimal(txtratioConstant.getBigDecimalValue()).signum()>0) {
					txtSmallChickenWgt.setValue(rsd.getBigDecimal("小鸡重量").divide(txtratioConstant.getBigDecimalValue(),2,BigDecimal.ROUND_HALF_UP));
				}else {
					txtSmallChickenWgt.setValue(BigDecimal.ZERO);
				}
				txtCarcassSCWgt.setValue(rsd.getBigDecimal("小鸡重量").setScale(2, BigDecimal.ROUND_HALF_UP));
				txtheadQty.setValue(rsd.getBigDecimal("鸡头重量").setScale(2, BigDecimal.ROUND_HALF_UP));
			}else{
				txtSmallChickenWgt.setValue(null);
				txtCarcassSCWgt.setValue(null);
				txtheadQty.setValue(BigDecimal.ZERO);
			}
			
		
			//取消半包
			/*if(rsj.next()){
				txthalfAPackProduct.setValue(rsj.getBigDecimal("鲜品半包").setScale(2, BigDecimal.ROUND_HALF_UP));
			}else{
				txthalfAPackProduct.setValue(null);
			}*/
			
			
			if(rsk.next()){
				txtchickenPeatherPrice.setValue(rsk.getBigDecimal("鸡毛单价"));//.setScale(2, BigDecimal.ROUND_HALF_UP));
				txtchickenBloodPrice.setValue(rsk.getBigDecimal("鸡血单价"));//.setScale(2, BigDecimal.ROUND_HALF_UP));
				txtchickenIntestinePrice.setValue(rsk.getBigDecimal("鸡肠单价"));//.setScale(2, BigDecimal.ROUND_HALF_UP));
				txtchickenCropPrice.setValue(rsk.getBigDecimal("鸡嗉子单价"));//.setScale(2, BigDecimal.ROUND_HALF_UP));
				txtmixedOilPrice.setValue(rsk.getBigDecimal("杂油单价"));//setScale(2, BigDecimal.ROUND_HALF_UP));
				txttonPrice.setValue(rsk.getBigDecimal("吨费用"));//.setScale(2, BigDecimal.ROUND_HALF_UP));
			}else{
				txtchickenPeatherPrice.setValue(null);
				txtchickenBloodPrice.setValue(null);
				txtchickenIntestinePrice.setValue(null);
				txtchickenCropPrice.setValue(null);
				txtmixedOilPrice.setValue(null);
				txttonPrice.setValue(null);
			}
			//计算总毛重
			calTotailGrossWgt();
			//计算主产出成
			calMainRatio();
			//计算副产出成
			calViceRatio();
			//计算主产分割出成	
			calMainDivisionRatio();
			//计算分割出成
			calDivisionRatio();
			//计算综合出成
			calcomprehensiveRatio();
			//鸡毛血肠嗉子杂油事件
			chickenmxcsz();
			//计算吨利润
	        calTonGrossProfit();
	        //计算纯利
	        calTodayNetProfit();
	        //计算保本价
	        calCostPrice();
	        //计算人均效率
	        calPersonRate();
	        // 胴体出成率
	        calCarcassRate();
	        //计算吸水率
	        calWaterRate();
	        //计算分录出成
	        calEntryCCRate();
	        //如果当日本公司有鲜品表，自动带入冻品
	        freshToFinished(bizDate,companyID);
	        getTheSameFreshData(bizDate,companyID.toString());
	        
		} catch (Exception err) {
			handleException(err);
		} 
	}
	private void freshToFinished(String bizDate, BOSUuid companyID) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		String sp = "\n";
		sb.append("/*dialect*/").append(sp);
		sb.append("select ").append(sp);
		sb.append("nvl(CFtonProductWater,0)		吨产品用水,").append(sp);
		sb.append("nvl(CFtonProductCoal,0)		吨产品用煤,").append(sp);
		sb.append("nvl(CFtonProductColdEle,0)		吨产品制冷用电,").append(sp);
		sb.append("nvl(CFtonProductionEle,0)		吨产品生产用电,").append(sp);
		sb.append("nvl(CFtonAllEle,0)				吨总量用电,").append(sp);
		sb.append("nvl(CFtonPackingCost,0)			吨包装费用").append(sp);
		sb.append("from CT_SZC_FreshDaily where to_char(fbizDate,'yyyy-MM-dd') = '").append(bizDate).append("'").append(sp);
		sb.append("and CFCompanyID = '").append(companyID).append("' and FProductType = '0'").append(sp);
		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			if(rs.next()){
				txttonProductWater.setValue(rs.getBigDecimal("吨产品用水"));
				txttonProductCoal.setValue(rs.getBigDecimal("吨产品用煤"));
				txttonProductColdEle.setValue(rs.getBigDecimal("吨产品制冷用电"));
				txttonProductionEle.setValue(rs.getBigDecimal("吨产品生产用电"));
				txttonAllEle.setValue(rs.getBigDecimal("吨总量用电"));
				txttonPackingCost.setValue(rs.getBigDecimal("吨包装费用"));
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 获取冻品明细
	 * @throws BOSException 
	 */
	private void insertFrozenEntryDetail(String bizDate, BOSUuid companyID) throws BOSException {
		if(!productType.getSelectedItem().equals(ProductType.freeze)) {
    		return;
    	}
		
		//上一天日期
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(bizDate));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		cal.add(Calendar.DAY_OF_MONTH, -1);//由日期-1改为日期+1 modify180508
		String perBizDate=sdf.format(cal.getTime());
		
		cal.add(Calendar.DAY_OF_MONTH, 2);
		String nextBizDate=sdf.format(cal.getTime());
		cal.add(Calendar.DAY_OF_MONTH, -2);
		
		//今日数据
		StringBuffer sql=new StringBuffer();
		sql.append(" /*dialect*/ select tt2.FMaterialID,tt2.FMaterialName,tt2.FMaterialNum,tt2.FModel,")
		.append(" tt2.FWeight,tt2.FMaterialGroupID,tt2.FGroupNum,FBaseGroupNum,tseentry.fprice,nvl(tseentry.fprice,0)*tt2.FWeight FAmount")
		.append(" from (")
		.append(" select FMaterialID,FMaterialName,FMaterialNum,FModel,")
		.append(" sum(Fweight) FWeight,FMaterialGroupID,FGroupNum,FBaseGroupNum")
		.append(" from (")
		;
		sql.append(" select ")
		.append(" tm.fid				FMaterialID,")
		.append(" tm.FName_l2			FMaterialName,")
		.append(" tm.Fnumber 			FMaterialNum,")
		.append(" tm.FModel 			FModel,")
//		.append(" nvl(round(case when tentry.CFFINISHEDPRODUCTTYPE='返车间' then (-1)*tentry.CFWeight else tentry.CFWeight end,2),0)  Fweight,")
		.append(" round(nvl(tentry.CFWeight,0),2)  Fweight,")
		.append(" tg.fid			FMaterialGroupID,tg.fnumber FGroupNum,tmg.fnumber FBaseGroupNum")
		.append(" from CT_SZC_SzsemiProduct tmain")
		.append(" inner join CT_SZC_SzsemiProductEntry tentry on tentry.fparentid=tmain.fid")
		.append(" inner join T_BD_Material			tm	on tm.FID = tentry.CFMaterialID")
		.append(" inner join t_bd_materialGroup tmg on tmg.fid=tm.fmaterialgroupID")
		.append(" inner join T_BD_MaterialGroupDetial		tmgd	on tmgd.FMaterialID = tm.FID")
		.append(" inner join T_BD_MaterialGroup		tg	on tg.FID = tmgd.FMaterialGroupID")
		.append(" where tmain.CFCount = '1'")//成品
		.append(" and to_char(tmain.CFProductionDate,'yyyy-mm-dd')  ='").append(bizDate).append("'")//生产日期
//		.append(" and tg.FNumber = '00201'")//冻品
		.append(" and (tg.FNumber = '00501' or tg.FNumber='00502' or tg.FNumber = '00503' or tg.fnumber='00504')")
		.append(" and tmain.CFCompanyID = '").append(companyID).append("'");
			//昨日数据
		int a = 0;
		while(true){
			if(a>99){
				sql.append(" union all")
				.append(" select ")
				.append(" tm.fid				FMaterialID,")
				.append(" tm.FName_l2			FMaterialName,")
				.append(" tm.Fnumber 			FMaterialNum,")
				.append(" tm.FModel 			FModel,")
				.append(" nvl(round((-1)*tentry.CFWeight,2),0)			Fweight,")
				.append(" tg.fid			FMaterialGroupID,tg.fnumber FGroupNum,tmg.fnumber FBaseGroupNum")
				.append(" from CT_SZC_SzsemiProduct tmain")
				.append(" inner join CT_SZC_SzsemiProductEntry tentry on tentry.fparentid=tmain.fid")
				.append(" inner join T_BD_Material			tm	on tm.FID = tentry.CFMaterialID")
				.append(" inner join t_bd_materialGroup tmg on tmg.fid=tm.fmaterialgroupID")
				.append(" inner join T_BD_MaterialGroupDetial		tmgd	on tmgd.FMaterialID = tm.FID")
				.append(" inner join T_BD_MaterialGroup		tg	on tg.FID = tmgd.FMaterialGroupID")
				.append(" where tmain.CFCount = '1'")//成品
				.append(" and to_char(tmain.CFProductionDate,'yyyy-mm-dd')  ='").append(123).append("'")//生产日期
				//.append(" and tg.FNumber = '00201'")//冻品
				.append(" and (tg.FNumber = '00501' or tg.FNumber='00502' or tg.FNumber = '00503' or tg.fnumber='00504')")
				.append(" and tmain.CFCompanyID = '").append(companyID).append("'")
				.append(" and (tentry.CFFINISHEDPRODUCTTYPE='半件' or tentry.CFFINISHEDPRODUCTTYPE='未冻好' or tentry.CFFINISHEDPRODUCTTYPE='返车间')")
				;
				sql.append(" ) tt1 group by FMaterialID,FMaterialName,FMaterialNum,FModel,FMaterialGroupID,FGroupNum,FBaseGroupNum")
				.append(" ) tt2")
				.append(" left join T_STO_SalesPriceEntry		tseentry	on tseentry.FMaterialID = tt2.FMaterialID and rownum=1 and tseentry.forgunitid='").append(companyID).append("'")
				.append(" and to_char(tseentry.FBizDate,'yyyy-mm-dd')  ='").append(nextBizDate).append("'")
				.append(" order by FGroupNum,FMaterialNum")
				.append(" ");
				break;
			}
			StringBuffer sb = new StringBuffer();
			String sp = "\n";
			sb.append("select * from CT_SZC_FreshDaily ").append(sp);
			sb.append("where CFCompanyID='").append(companyID).append("' ").append(sp);
			sb.append("and to_char(fbizdate,'yyyy-MM-dd')='").append(sdf.format(cal.getTime())).append("'").append(sp);
			sb.append("and FProductType='").append(((ProductType)productType.getSelectedItem()).getValue()).append("'").append(sp);
			IRowSet sbRs;
			sbRs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			try {
				if(sbRs.next()){
					sql.append(" union all")
					.append(" select ")
					.append(" tm.fid				FMaterialID,")
					.append(" tm.FName_l2			FMaterialName,")
					.append(" tm.Fnumber 			FMaterialNum,")
					.append(" tm.FModel 			FModel,")
					.append(" nvl(round((-1)*tentry.CFWeight,2),0)			Fweight,")
					.append(" tg.fid			FMaterialGroupID,tg.fnumber FGroupNum,tmg.fnumber FBaseGroupNum")
					.append(" from CT_SZC_SzsemiProduct tmain")
					.append(" inner join CT_SZC_SzsemiProductEntry tentry on tentry.fparentid=tmain.fid")
					.append(" inner join T_BD_Material			tm	on tm.FID = tentry.CFMaterialID")
					.append(" inner join t_bd_materialGroup tmg on tmg.fid=tm.fmaterialgroupID")
					.append(" inner join T_BD_MaterialGroupDetial		tmgd	on tmgd.FMaterialID = tm.FID")
					.append(" inner join T_BD_MaterialGroup		tg	on tg.FID = tmgd.FMaterialGroupID")
					.append(" where tmain.CFCount = '1'")//成品
					.append(" and to_char(tmain.CFProductionDate,'yyyy-mm-dd')  ='").append(sdf.format(cal.getTime())).append("'")//生产日期
					//.append(" and tg.FNumber = '00201'")//冻品
					.append(" and (tg.FNumber = '00501' or tg.FNumber='00502' or tg.FNumber = '00503' or tg.fnumber='00504')")
					.append(" and tmain.CFCompanyID = '").append(companyID).append("'")
					.append("and (tentry.CFFINISHEDPRODUCTTYPE='半件' or tentry.CFFINISHEDPRODUCTTYPE='未冻好' or tentry.CFFINISHEDPRODUCTTYPE='返车间')")
					;
					sql.append(" ) tt1 group by FMaterialID,FMaterialName,FMaterialNum,FModel,FMaterialGroupID,FGroupNum,FBaseGroupNum")
					.append(" ) tt2")
					.append(" left join T_STO_SalesPriceEntry	tseentry on tseentry.FMaterialID = tt2.FMaterialID and rownum=1 and tseentry.forgunitid='").append(companyID).append("'")
					.append(" and to_char(tseentry.FBizDate,'yyyy-mm-dd')  ='").append(nextBizDate).append("'")
					.append(" order by FGroupNum,FMaterialNum")
					.append(" ");
					break;
				}else{
					cal.add(Calendar.DAY_OF_MONTH, -1);
				}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				a++;
			}
				
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		try {
			IRow row;
			MaterialInfo mInfo;
			IMaterialGroup imgs=MaterialGroupFactory.getRemoteInstance();
			BigDecimal sumMainQty=BigDecimal.ZERO;
        	BigDecimal sumMainAmt=BigDecimal.ZERO;
        	
        	BigDecimal sumByQty=BigDecimal.ZERO;
        	BigDecimal sumByAmt=BigDecimal.ZERO;
        	
        	BigDecimal sumSuetQty=BigDecimal.ZERO;
			while(rs.next()) {
				if(rs.getBigDecimal("Fweight").compareTo(BigDecimal.ZERO)!=0){
					moneys = moneys.add(rs.getBigDecimal("FAmount"));
					row=kdtEntry.addRow();
					mInfo=new MaterialInfo();
					mInfo.setId(BOSUuid.read(rs.getString("FMaterialID")));
					mInfo.setNumber(rs.getString("FMaterialNum"));
					mInfo.setName(rs.getString("FMaterialName"));
					mInfo.setModel(rs.getString("Fmodel"));
					
					row.getCell("materialNum").setValue(mInfo);
					row.getCell("materialName").setValue(mInfo.getName());
					row.getCell("model").setValue(mInfo.getModel());
					row.getCell("qty").setValue(rs.getBigDecimal("Fweight"));
					row.getCell("price").setValue(rs.getBigDecimal("FPrice"));
					row.getCell("amount").setValue(rs.getBigDecimal("FAmount"));
					row.getCell("materialGroup").setValue(imgs.getMaterialGroupInfo(new ObjectUuidPK(rs.getString("FMaterialGroupID"))));
				}

				if(rs.getString("FGroupNum").equals("00501")) {
					sumMainQty=sumMainQty.add(rs.getBigDecimal("Fweight"));
					sumMainAmt=sumMainAmt.add(rs.getBigDecimal("FAmount"));
				}
				if(rs.getString("FGroupNum").equals("00502")) {
					sumByQty=sumByQty.add(rs.getBigDecimal("Fweight"));
					sumByAmt=sumByAmt.add(rs.getBigDecimal("FAmount"));
				}
				
				//板油
				if(rs.getString("FBaseGroupNum").equals("01010509")) {  //板油数量原（01010701）
					sumSuetQty=sumSuetQty.add(rs.getBigDecimal("Fweight"));
				}
			}
			txtmainProductQty.setValue(sumMainQty);
			txtmainProductAmt.setValue(sumMainAmt);
			
			txtbyProductQty.setValue(sumByQty);
			txtbyProductAmt.setValue(sumByAmt);
			
			txtsuetQty.setValue(sumSuetQty);
		} catch (Exception e) {
			throw new BOSException(e);
		}
	}

	/**
	 * 计算综合出成
	 * 综合出成=(成品重+今日半包-昨日半包)/总毛重*100
	 */
	private void calcomprehensiveRatio() {
		 //综合出成率=本日成品重/总毛重*100
		BigDecimal gorssWgt=UIRuleUtil.getBigDecimal(txtallGrossWgt.getBigDecimalValue());
		if(gorssWgt.signum()>0){
			BigDecimal finishedProductWgt = UIRuleUtil.getBigDecimal(txtfinishedProductWgt.getBigDecimalValue());
			BigDecimal halfBag= UIRuleUtil.getBigDecimal(txthalfAPackProduct.getBigDecimalValue());
			BigDecimal lastDayHalfBag=getLastDayHalfBag();
			System.out.print(lastDayHalfBag);
			txtcomprehensiveRatio.setValue(finishedProductWgt.add(halfBag).subtract(lastDayHalfBag).multiply(new BigDecimal(100)).divide(gorssWgt,2,BigDecimal.ROUND_HALF_UP));
		}else{
			txtcomprehensiveRatio.setValue(BigDecimal.ZERO);
		}
	}
	/**
	 * 获取昨日半包
	 * @return
	 */
	private BigDecimal getLastDayHalfBag() {
		if(prmtcompany.getValue()!=null&&pkBizDate.getValue()!=null&&productType.getSelectedItem()!=null) {
			String companyID=((IObjectValue) prmtcompany.getValue()).getString("id");
			Calendar cal=Calendar.getInstance();
			cal.setTime((Date) pkBizDate.getValue());
			cal.add(Calendar.DAY_OF_MONTH, -1);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			int a = 0;
			while(true){
				if(a>99){
					break;
				}
				StringBuffer sb = new StringBuffer();
				String sp = "\n";
				sb.append("select * from CT_SZC_FreshDaily ").append(sp);
				sb.append("where CFCompanyID='").append(companyID).append("' ").append(sp);
				sb.append("and to_char(fbizdate,'yyyy-MM-dd')='").append(sdf.format(cal.getTime())).append("'").append(sp);
				sb.append("and FProductType='").append(((ProductType)productType.getSelectedItem()).getValue()).append("'").append(sp);
				IRowSet sbRs;
				try {
					sbRs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
					if(sbRs.next()){
						StringBuffer sql=new StringBuffer();
						sql.append(" select isnull(CFHalfAPackProduct,0) CFHalfAPackProduct from CT_SZC_FreshDaily ")
						.append(" where CFCompanyID='").append(companyID).append("' and to_char(fbizdate,'yyyy-MM-dd')='").append(sdf.format(cal.getTime())).append("'")
						.append(" and FProductType='").append(((ProductType)productType.getSelectedItem()).getValue()).append("'");
						
						IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
						if(rs.next()) {
							return rs.getBigDecimal("CFHalfAPackProduct");
						}else{
							return BigDecimal.ZERO;
						}
					}else{
						cal.add(Calendar.DAY_OF_MONTH, -1);
					}
				} catch (BOSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				a++;
			}
		}
		return BigDecimal.ZERO;
			
		
	}
	
	/**
	 * 计算主产出成
	 * 主产出成=主产品数量/(结算毛重+（按胴体结算小鸡重+按胴体核算残鸡重）/出成率常数/2)*100
	 * 
	 */
	private void calMainRatio() {
		BigDecimal rate=UIRuleUtil.getBigDecimal(txtratioConstant.getBigDecimalValue());
		//结算毛重
		BigDecimal settleGorssWgt=UIRuleUtil.getBigDecimal(txtsettlementGrossWgt.getBigDecimalValue());
		if(rate.signum()>0&&settleGorssWgt.signum()>0) {
			//主产数量
			BigDecimal mainQty=txtmainProductQty.getBigDecimalValue();
			
			//小鸡胴体结算重量
//			BigDecimal smallChickenWgt=UIRuleUtil.getBigDecimal(txtSmallChickenWgt.getBigDecimalValue());//txtCarcassSCWgt
			BigDecimal smallChickenWgt=UIRuleUtil.getBigDecimal(txtCarcassSCWgt.getBigDecimalValue());//
			//结算残鸡重
			BigDecimal settlecjWgt=UIRuleUtil.getBigDecimal(txtCarcassRCWgt.getBigDecimalValue());
			
			settleGorssWgt=settleGorssWgt.add(smallChickenWgt.add(settlecjWgt).divide(new BigDecimal(2).multiply(rate),10,BigDecimal.ROUND_HALF_UP));
			mainQty=mainQty.multiply(new BigDecimal(100)).divide(settleGorssWgt,2,BigDecimal.ROUND_HALF_UP);
			txtmainRatio.setValue(mainQty);
			
		}else {
			txtmainRatio.setValue(BigDecimal.ZERO);
		}
	}
	
	/**
	 * 计算分录出成
	 * 重量/总毛重*100
	 */
	private void calEntryCCRate() {
		//总毛重
		BigDecimal gorssWgt=UIRuleUtil.getBigDecimal(txtallGrossWgt.getBigDecimalValue());
		if(gorssWgt.signum()>0) {
			
			BigDecimal qty;
			for(int rowIndex=0;rowIndex<kdtEntry.getRowCount();rowIndex++) {
				qty=UIRuleUtil.getBigDecimal(kdtEntry.getCell(rowIndex,"qty").getValue());
				qty=qty.multiply(new BigDecimal(100)).divide(gorssWgt,2,BigDecimal.ROUND_HALF_UP);
				kdtEntry.getCell(rowIndex,"ccRate").setValue(qty);
			}
		}
	}
	
	/**
	 * 计算副产出成
	 * 副产出成=副产品数量/(结算毛重+（按胴体结算小鸡重+按胴体核算残鸡重）/出成率常数/2)*100
	 * 
	 */
	private void calViceRatio() {
		BigDecimal rate=UIRuleUtil.getBigDecimal(txtratioConstant.getBigDecimalValue());
		//结算毛重
		BigDecimal settleGorssWgt=UIRuleUtil.getBigDecimal(txtsettlementGrossWgt.getBigDecimalValue());
		if(rate.signum()>0&&settleGorssWgt.signum()>0) {
			//副产数量
			BigDecimal byQty=txtbyProductQty.getBigDecimalValue();
			
			//小鸡胴体结算重量
//			BigDecimal smallChickenWgt=UIRuleUtil.getBigDecimal(txtSmallChickenWgt.getBigDecimalValue());//txtCarcassSCWgt
			BigDecimal smallChickenWgt=UIRuleUtil.getBigDecimal(txtCarcassSCWgt.getBigDecimalValue());//
			//结算残鸡重
			BigDecimal settlecjWgt=UIRuleUtil.getBigDecimal(txtCarcassRCWgt.getBigDecimalValue());
			
			settleGorssWgt=settleGorssWgt.add(smallChickenWgt.add(settlecjWgt).divide(new BigDecimal(2).multiply(rate),2,BigDecimal.ROUND_HALF_UP));
			byQty=byQty.multiply(new BigDecimal(100)).divide(settleGorssWgt,2,BigDecimal.ROUND_HALF_UP);
			txtviceRatio.setValue(byQty);
			
		}else {
			txtviceRatio.setValue(BigDecimal.ZERO);
		}
	}
	
	/**
	 * 计算总毛重
	 * 12、	总毛重=结算毛重+按胴体核算小鸡重/出成率常数/2-（残鸡重-按胴体核算残鸡重）/出成率常数
	 */
	private void calTotailGrossWgt() {
		//出成率常数
		BigDecimal rate=UIRuleUtil.getBigDecimal(txtratioConstant.getBigDecimalValue());
		//结算毛重
		BigDecimal settleGorssWgt=UIRuleUtil.getBigDecimal(txtsettlementGrossWgt.getBigDecimalValue());
		if(rate.signum()>0&&settleGorssWgt.signum()>0) {
			//小鸡胴体结算重量=小鸡重量/2
//			BigDecimal smallChickenWgt=UIRuleUtil.getBigDecimal(txtSmallChickenWgt.getBigDecimalValue());//txtCarcassSCWgt
			BigDecimal smallChickenWgt=UIRuleUtil.getBigDecimal(txtCarcassSCWgt.getBigDecimalValue());//
			//残鸡重
			BigDecimal cjWgt=UIRuleUtil.getBigDecimal(txtResidualChickenWgt.getBigDecimalValue());
			//结算残鸡重
			BigDecimal settlecjWgt=UIRuleUtil.getBigDecimal(txtCarcassRCWgt.getBigDecimalValue());
			
			BigDecimal qty=smallChickenWgt.divide(new BigDecimal(2).multiply(rate),10,BigDecimal.ROUND_HALF_UP).add(settleGorssWgt);
			qty=qty.subtract(cjWgt.subtract(settlecjWgt).divide(rate,10,BigDecimal.ROUND_HALF_UP));
			//总毛重等于
			BigDecimal blossWgt=BigDecimal.ZERO;//UIRuleUtil.getBigDecimal(txtShedBLossGrossWgt.getBigDecimalValue());
			txtallGrossWgt.setValue(qty.setScale(2,BigDecimal.ROUND_HALF_UP).subtract(blossWgt));
		}else {
			txtallGrossWgt.setValue(BigDecimal.ZERO);
		}
		
	}
	
	/**
	 * 胴体出成率
	 * 14、	胴体出成率=（结算胴体重-小鸡1/2）/结算毛重*100
	 */
	private	void calCarcassRate(){
		//结算毛重
		BigDecimal settleGorssWgt=UIRuleUtil.getBigDecimal(txtsettlementGrossWgt.getBigDecimalValue());
		if(settleGorssWgt.signum()>0) {
			//结算胴体重
			BigDecimal carcassWgt=UIRuleUtil.getBigDecimal(txtsettlementCarcass.getBigDecimalValue());
			//小鸡胴体结算重量
			BigDecimal smallChickenWgt=UIRuleUtil.getBigDecimal(txtCarcassSCWgt.getBigDecimalValue());//txtCarcassSCWgt
			//小鸡胴体结算重量1/2
			BigDecimal smallChickenWgthalf=smallChickenWgt.divide(new BigDecimal(2),10,BigDecimal.ROUND_HALF_UP);
			//小鸡重量1/2
			BigDecimal SmallChickenWgt = UIRuleUtil.getBigDecimal(txtSmallChickenWgt.getBigDecimalValue().divide(new BigDecimal(2),10,BigDecimal.ROUND_HALF_UP));
			//结算毛重-棚前-小鸡重量1/2
			BigDecimal settleGorssChickWgt = settleGorssWgt.subtract(SmallChickenWgt);
			txtcarcassRatio.setValue(carcassWgt.subtract(smallChickenWgthalf).multiply(new BigDecimal(100)).divide(settleGorssChickWgt,2,BigDecimal.ROUND_HALF_UP));
		}else {
			txtcarcassRatio.setValue(BigDecimal.ZERO);
		}
	}
	
	/**
	 * 计算副产分割出成率
	 * (主产类+鸡头)/（结算胴体重）*100
	 */
	private void calDivisionRatio() {
		/*//结算胴体重
		BigDecimal carcassWgt=UIRuleUtil.getBigDecimal(txtsettlementCarcass.getBigDecimalValue());
		if(carcassWgt.signum()>0) {
			BigDecimal txtfi=UIRuleUtil.getBigDecimal(txtmainProductQty.getBigDecimalValue());
			BigDecimal headQty=UIRuleUtil.getBigDecimal(txtheadQty.getBigDecimalValue());
			txtdivisionRatio.setValue(txtfi.add(headQty).multiply(new BigDecimal(100)).divide(carcassWgt,2,BigDecimal.ROUND_HALF_UP));
		}else {
			txtdivisionRatio.setValue(BigDecimal.ZERO);
		}*/
		//结算胴体重
		BigDecimal carcassWgt=UIRuleUtil.getBigDecimal(txtsettlementCarcass.getBigDecimalValue());
		if(carcassWgt.signum()>0) {
			//小鸡胴体结算重量
			BigDecimal smallChickenWgt=UIRuleUtil.getBigDecimal(txtCarcassSCWgt.getBigDecimalValue());//txtCarcassSCWgt
			//小鸡胴体结算重量1/2
			smallChickenWgt=smallChickenWgt.divide(new BigDecimal(2),10,BigDecimal.ROUND_HALF_UP);
			//成品重
			BigDecimal finishedProductWgt=UIRuleUtil.getBigDecimal(txtfinishedProductWgt.getBigDecimalValue());
			//结算胴体+按胴体核算小鸡重/2
			BigDecimal settleGorssChickWgt = carcassWgt.add(smallChickenWgt);
			txtdivisionRatio.setValue(finishedProductWgt.multiply(new BigDecimal(100)).divide(settleGorssChickWgt,2,BigDecimal.ROUND_HALF_UP));
		}else{
			txtdivisionRatio.setValue(BigDecimal.ZERO);
		}
		
		
	}

	/**
	 * 主产分割出成率
	 * 主产分割出成=主产产量/（结算胴体重）*100
	 */
	private	void calMainDivisionRatio(){
		//结算胴体重
		BigDecimal carcassWgt=UIRuleUtil.getBigDecimal(txtsettlementCarcass.getBigDecimalValue());
		if(carcassWgt.signum()>0) {
			BigDecimal txtfi=UIRuleUtil.getBigDecimal(txtmainProductQty.getBigDecimalValue());
			//txtmainDivisionRatio.setValue(txtfi.multiply(new BigDecimal(100)).divide(carcassWgt,2,BigDecimal.ROUND_HALF_UP));
			txtmainDivisionRatio.setValue(txtfi.multiply(new BigDecimal(100)).divide(carcassWgt.add(UIRuleUtil.getBigDecimal(txtCarcassSCWgt.getBigDecimalValue()).divide(new BigDecimal("2"))),2,BigDecimal.ROUND_HALF_UP));
		}else {
			txtmainDivisionRatio.setValue(BigDecimal.ZERO);
		}
	}
	/**
	 * 设置鲜品数据
	 */
	private void getTheSameFreshData(String dateStr,String companyId) {
		if(StringUtils.isBlank(companyId)||StringUtils.isBlank(dateStr)) {
			return;
		}
		if(productType.getSelectedItem()!=null&&productType.getSelectedItem().equals(ProductType.fresh)) {
			return;
		}
		
		StringBuffer sql=new StringBuffer();
		sql.append(" select top 1 fid from CT_SZC_FreshDaily where CFCompanyID='").append(companyId).append("'")
		.append(" and to_char(fbizdate,'yyyy-MM-dd')='").append(dateStr).append("'")
		.append(" order by fcreatetime desc");
		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			if(rs.next()) {
				FreshDailyInfo freshInfo = FreshDailyFactory.getRemoteInstance().getFreshDailyInfo(new ObjectUuidPK(rs.getString("fid")));
				txtallPeople.setValue(freshInfo.getAllPeople());
				txtattendancePeople.setValue(freshInfo.getAttendancePeople());
				txtworkTime.setValue(freshInfo.getWorkTime());
				txtperCatipaEfficiency.setValue(freshInfo.getPerCatipaEfficiency());
				txtmorningQty.setValue(freshInfo.getMorningQty());
				txtafternoonQty.setValue(freshInfo.getAfternoonQty());
				chkhalfWorkDay.setSelected(freshInfo.isHalfWorkDay());
			}
		}catch(Exception err) {
			handleException(err);
		}
	}
	
	/**
	 * 增加控件监听
	 */
	private void addLisenters() {
		//日期加监听
        pkBizDate.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				if(isLoadField) {
					return;
				}
				// TODO Auto-generated method stub
				if(pkBizDate.getValue()!=null&&prmtcompany.getValue()!=null){
					Date date =  (Date) pkBizDate.getValue();
					BOSUuid companyID = ((CompanyOrgUnitInfo)prmtcompany.getValue()).getId();
			        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
			        String bizDate = sdf.format(date);
			        if(companyID.toString().equals(("00000000-0000-0000-0000-000000000000CCE7AED4"))){
			        	MsgBox.showWarning("集团下不能制作日报单");
						return;
					}
					try {
						saveData(bizDate,companyID);
					} catch (BOSException err) {
						handleException(err);
					}
				}else{
					txtsettlementCarcass.setValue(null);
					txtslaughterAmt.setValue(null);
					txtsettlementGrossWgt.setValue(null);
					txtbuyFreight.setValue(null);
					txtbuyMoney.setValue(null);
					txtGrossChickenCost.setValue(null);
					txtGrossChickenAPrice.setValue(null);
					txtcarcassRatio.setValue(null);
					txtGrossChickenAWgt.setValue(null);
					txtcommodityChickenAmt.setValue(null);
					txtcommodityChickenAPrice.setValue(null);
					txtmarketChickenAmt.setValue(null);
					txtmarketPrice.setValue(null);
					txtSmallChickenWgt.setValue(null);
					txtCarcassSCWgt.setValue(null);
					txtmainPrice.setValue(null);
					txtvicePrice.setValue(null);
					txtallMoney.setValue(null);
					txtfinishedProductWgt.setValue(null);
				}
			}
        });
        //公司加监听
        prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				if(isLoadField) {
					return;
				}
				// TODO Auto-generated method stub
				if(pkBizDate.getValue()!=null&&prmtcompany.getValue()!=null){
					Date date =  (Date) pkBizDate.getValue();
					BOSUuid companyID = ((CompanyOrgUnitInfo)prmtcompany.getValue()).getId();
			        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
			        String bizDate = sdf.format(date);
					System.out.print(bizDate);
					System.out.print(companyID);
					if(companyID.toString().equals(("00000000-0000-0000-0000-000000000000CCE7AED4"))){
						MsgBox.showWarning("集团下不能制作日报单");
						return;
					}
					try {
						saveData(bizDate,companyID);
					} catch (BOSException err) {
						handleException(err);
					}
				}else{
					txtsettlementCarcass.setValue(null);
					txtslaughterAmt.setValue(null);
					txtsettlementGrossWgt.setValue(null);
					txtbuyFreight.setValue(null);
					txtbuyMoney.setValue(null);
					txtGrossChickenCost.setValue(null);
					txtGrossChickenAPrice.setValue(null);
					txtcarcassRatio.setValue(null);
					txtGrossChickenAWgt.setValue(null);
					txtcommodityChickenAmt.setValue(null);
					txtcommodityChickenAPrice.setValue(null);
					txtmarketChickenAmt.setValue(null);
					txtmarketPrice.setValue(null);
					txtSmallChickenWgt.setValue(null);
					txtCarcassSCWgt.setValue(null);
					txtmainPrice.setValue(null);
					txtvicePrice.setValue(null);
					txtallMoney.setValue(null);
					txtfinishedProductWgt.setValue(null);
				}
			}
        	
        });
        //残鸡结算重量监听
        txtResidualChickenWgt.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				if(isLoadField) {
					return;
				}
				// TODO Auto-generated method stub
				if(txtResidualChickenWgt.getBigDecimalValue()!=null){
					txtCarcassRCWgt.setValue(txtResidualChickenWgt.getBigDecimalValue());
				}
			}
        	
        });
        //鸡毛血肠嗉子杂油监听
        txtchickenPeatherPrice.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {
				// TODO Auto-generated method stub
				if(isLoadField) {
					return;
				}
				chickenmxcsz();
			}
        });
        txtchickenBloodPrice.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {
				// TODO Auto-generated method stub
				if(isLoadField) {
					return;
				}
				chickenmxcsz();
			}
        });
        txtchickenIntestinePrice.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {
				// TODO Auto-generated method stub
				if(isLoadField) {
					return;
				}
				chickenmxcsz();
			}
        });
        txtchickenCropPrice.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {
				// TODO Auto-generated method stub
				if(isLoadField) {
					return;
				}
				chickenmxcsz();
			}
        });
        txtmixedOilPrice.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {
				// TODO Auto-generated method stub
				if(isLoadField) {
					return;
				}
				chickenmxcsz();
			}
        });
        //毛鸡均价
        txtGrossChickenAPrice.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				//计算保本价
				calCostPrice();
			}});
      //吨费用
        txttonPrice.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				//计算保本价
				calCostPrice();
			}});
      //吨毛利
        txttonGrossProfit.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				//计算保本价
				calCostPrice();
			}});
      //综合出成率
        txtcomprehensiveRatio.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				//计算保本价
				calCostPrice();
			}});
        
      //当日宰杀数
        txtslaughterAmt.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				//计算人均效率
				calPersonRate();
			}}
        );
        
      //当日出勤人数
        txtattendancePeople.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				//计算人均效率
				calPersonRate();
			}});
        //本日产品总金额
        txtallMoney.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				//计算综合售价
				calTodayCompreSalePrice();
				//计算吨利润
		        calTonGrossProfit();
			}});
        //本日成品重
        txtfinishedProductWgt.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				//计算综合售价
				calTodayCompreSalePrice();
				//计算吨利润
		        calTonGrossProfit();
			}});
        //板油数量
        txtsuetQty.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
		        //计算吸水率
		        calWaterRate();
			}});
      //后区板油产量
        txtbackAreaLeafFatYield.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
		        //计算吸水率
		        calWaterRate();
			}});
      //鸡头数量
        txtheadQty.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
		        //计算吸水率
		        calWaterRate();
			}});
        //半包
        txthalfAPackProduct.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
		        //综合出成率
				calcomprehensiveRatio();
			}});
	}
	
	/**
	 * 计算保本价
	 * 保本价=本日毛鸡均价-（（吨费用-吨毛利）*综合出成率[小数]/2）/1000
	 */
	private void calCostPrice() {
		if(isLoadField) {
			return;
		}
		BigDecimal price=UIRuleUtil.getBigDecimal(txtGrossChickenAPrice.getBigDecimalValue());
		BigDecimal tonFee=UIRuleUtil.getBigDecimal(txttonPrice.getBigDecimalValue());
		BigDecimal tonProfit=UIRuleUtil.getBigDecimal(txttonGrossProfit.getBigDecimalValue());
		BigDecimal compreRate=UIRuleUtil.getBigDecimal(txtcomprehensiveRatio.getBigDecimalValue());
		price=price.subtract(tonFee.subtract(tonProfit).multiply(compreRate).divide(new BigDecimal(2*100*1000))).setScale(2,BigDecimal.ROUND_HALF_UP);
		txtcostPrice.setValue(price);
	}
	
	/**
	 * 计算吨利润
	 * 吨毛利润=（（产品总金额+毛血肠嗉子杂油金额+下脚料金额+残鸡金额）/1.11（1.1）—毛鸡成本）/当日成品重*1000
	 */
	private void calTonGrossProfit() {
		if(isLoadField) {
			return;
		}
		//成品重
		BigDecimal finishedProductWgt=UIRuleUtil.getBigDecimal(txtfinishedProductWgt.getBigDecimalValue());
		if(finishedProductWgt.signum()>0) {
			
			//产品总金额
			//BigDecimal amount=UIRuleUtil.getBigDecimal(txtallMoney.getBigDecimalValue());
			BigDecimal amount= moneys;
			//鸡毛
			BigDecimal Peather=UIRuleUtil.getBigDecimal(txtchickenPeatherMoney.getBigDecimalValue());
			//鸡血
			BigDecimal Blood=UIRuleUtil.getBigDecimal(txtchickenBloodMoney.getBigDecimalValue());
			//鸡肠
			BigDecimal Intestine=UIRuleUtil.getBigDecimal(txtchickenIntestineMoney.getBigDecimalValue());
			//鸡嗉子
			BigDecimal Crop=UIRuleUtil.getBigDecimal(txtchickenCropMoney.getBigDecimalValue());
			//杂油
			BigDecimal mixedOil=UIRuleUtil.getBigDecimal(txtmixedOilMoney.getBigDecimalValue());
			
		/*	//下脚料
			BigDecimal xjl=BigDecimal.ZERO;
			//残鸡金额
			BigDecimal cj=BigDecimal.ZERO;*/
			//毛鸡成本
			BigDecimal GrossChickenCost=UIRuleUtil.getBigDecimal(txtGrossChickenCost.getBigDecimalValue());
			
			amount=amount.add(Peather).add(Blood).add(Intestine).add(Crop).add(mixedOil);
			//税率调整
			//amount=amount.divide(new BigDecimal(1.11),10,BigDecimal.ROUND_HALF_UP).subtract(GrossChickenCost);
			amount=amount.divide(new BigDecimal(1.1),10,BigDecimal.ROUND_HALF_UP).subtract(GrossChickenCost);

			amount=amount.multiply(new BigDecimal(1000)).divide(finishedProductWgt,2,BigDecimal.ROUND_HALF_UP);
			
			txttonGrossProfit.setValue(amount);
		}else {
			txttonGrossProfit.setValue(BigDecimal.ZERO);
		}
	}
	/**
	 * 计算本日纯利
	 * 15、	本日纯利（元）=（吨毛利-吨费用）*成品重/1000
	 */
	private void calTodayNetProfit() {
		BigDecimal tonGrossProfit=UIRuleUtil.getBigDecimal(txttonGrossProfit.getBigDecimalValue());
		BigDecimal tonFee=UIRuleUtil.getBigDecimal(txttonPrice.getBigDecimalValue());
		BigDecimal wgt=UIRuleUtil.getBigDecimal(txtfinishedProductWgt.getBigDecimalValue());
		wgt=tonGrossProfit.subtract(tonFee).multiply(wgt).divide(new BigDecimal(1000),2,BigDecimal.ROUND_HALF_UP);
		txttodayNetProfit.setValue(wgt);
	}
	
	/**
	 * 计算吸水率 
	 * 吸水率=(主产品产量+板油数量+后区加到混合油内板油产量)/(结算胴体重 -鸡头数量)*100					（原）
	 * 吸水率=(主产品产量+板油数量+后区加到混合油内板油产量)/(结算胴体重 + 小鸡胴体重/2 -鸡头数量)*100	（改）
	 * 吸水率=(主产品产量-板油类产品重量)/(结算胴体重 + 小鸡胴体重/2 -鸡头数量)*100	（工艺修改2018-1-23夏平）
	 */
	private void calWaterRate() {
		if(isLoadField) {
			return;
		}
		//结算胴体重
		BigDecimal settleCrassWgt=UIRuleUtil.getBigDecimal(txtsettlementCarcass.getBigDecimalValue());
		//鸡头重量
		BigDecimal headQty=UIRuleUtil.getBigDecimal(txtheadQty.getBigDecimalValue());
		if(settleCrassWgt.subtract(headQty).signum()>0) {
			//主产产量
			BigDecimal mainQty=UIRuleUtil.getBigDecimal(txtmainProductQty.getBigDecimalValue());
			//板油数量
			BigDecimal suetQty=UIRuleUtil.getBigDecimal(txtsuetQty.getBigDecimalValue());
			//后区加到混合油内板油产量
			BigDecimal backAreaLeafFatYield=UIRuleUtil.getBigDecimal(txtbackAreaLeafFatYield.getBigDecimalValue());
			//小鸡胴体重/2
			BigDecimal carcassSCWgt=UIRuleUtil.getBigDecimal(txtCarcassSCWgt.getBigDecimalValue()).divide(new BigDecimal(2),3,BigDecimal.ROUND_HALF_UP);
			
			
			mainQty=mainQty.subtract(suetQty).multiply(new BigDecimal(100)).divide(settleCrassWgt.add(carcassSCWgt).subtract(headQty),2,BigDecimal.ROUND_HALF_UP);
			
			txtwaterAbsorption.setValue(mainQty);
		}else {
			txtwaterAbsorption.setValue(BigDecimal.ZERO);
		}
		
	}
	/**
	 * 计算本日综合售价
	 * 本日综合售价=本日产品总金额/本日成品重    （不包含下脚料）
	 */
	private void calTodayCompreSalePrice() {
		if(isLoadField) {
			return;
		}
		BigDecimal amount=UIRuleUtil.getBigDecimal(txtallMoney.getBigDecimalValue());
		BigDecimal wgt=UIRuleUtil.getBigDecimal(txtfinishedProductWgt.getBigDecimalValue());
		if(wgt.signum()>0) {
			txtcomprehensivePrice.setValue(amount.divide(wgt,2,BigDecimal.ROUND_HALF_UP));
		}else {
			txtcomprehensivePrice.setValue(BigDecimal.ZERO);
		}
	}
	
	/**
	 * 计算人均效率
	 * 4、	人均效率=当日宰杀只数/当日出勤人数
	 */
	private void calPersonRate() {
		BigDecimal slaugherAmt=UIRuleUtil.getBigDecimal(txtslaughterAmt.getBigDecimalValue());
		BigDecimal pepleQty=UIRuleUtil.getBigDecimal(txtattendancePeople.getBigDecimalValue());
		if(pepleQty.signum()>0) {
			txtperCatipaEfficiency.setValue(slaugherAmt.divide(pepleQty,2,BigDecimal.ROUND_HALF_UP));
		}else {
			txtperCatipaEfficiency.setValue(null);
		}
	}
	
	/**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
        
    }
    private String sqla(String bizDate, BOSUuid companyID){
    	String sp = "\n";
    	StringBuffer sqla = new StringBuffer();
		sqla.append("/*dialect*/").append(sp);
		sqla.append("select").append(sp);
		sqla.append("to_char(FBizDate,'yyyy-mm-dd')	业务日期,").append(sp);
		sqla.append("nvl(sum(CFCarcasssettlewgt),0)	结算胴体重,").append(sp);
		sqla.append("nvl(sum(CFTotalsettleWGT),0)	结算毛重,").append(sp);
		sqla.append("nvl(sum(CFQTY),0)			宰杀只数,").append(sp);
		sqla.append("nvl(sum(CFActulsettlefreAmt),0)	实际收购运费,").append(sp);
		sqla.append("nvl(sum(CFTotalsettleAmt),0)	收购金额结算总金额,").append(sp);
		//修改税率
		//sqla.append("nvl(sum(CFTotalsettleAmt),0)/1.11 + nvl(sum(CFActulsettlefreAmt),0)/1.11	毛鸡成本,	").append(sp);
		sqla.append("nvl(sum(CFTotalsettleAmt),0)/1.1 + nvl(sum(CFActulsettlefreAmt),0)/1.1	毛鸡成本,	").append(sp);

		sqla.append("case when nvl(sum(CFTotalsettleWGT),0)>0 then (nvl(sum(CFTotalsettleAmt),0)+nvl(sum(CFActulsettlefreAmt),0))/nvl(sum(CFTotalsettleWGT),0)/2 else 0 end	毛鸡均价,").append(sp);
		sqla.append("case when nvl(sum(CFTotalsettleWGT),0)>0 then nvl(sum(CFCarcasssettlewgt),0)/nvl(sum(CFTotalsettleWGT),0)	else 0 end	胴体出成率,").append(sp);
		sqla.append("case when nvl(sum(CFQTY),0)>0 then nvl(sum(CFTotalsettleWGT),0)/nvl(sum(CFQTY),0)	else 0 end	本日毛鸡均重").append(sp);
		sqla.append(" from CT_SET_SettleBill ").append(sp);
		sqla.append("where to_char(fbizDate,'yyyy-mm-dd') = '").append(bizDate).append("'").append(sp);
		sqla.append("and CFCompanyID = '").append(companyID).append("'").append(sp);
		sqla.append("and (FBillStatus = '4' or FBillStatus='2')").append(sp);
		sqla.append("group by to_char(fbizDate,'yyyy-mm-dd')").append(sp);
		sqla.append("-- 毛鸡成本 = 收购金额*0.89 + 收购运费").append(sp);
		sqla.append("-- 毛鸡均价 = （收购金额+收购运费）/结算毛重/2").append(sp);
		sqla.append("-- 胴体出成率 = 结算胴体重/结算毛重").append(sp);
		sqla.append("-- 本日毛鸡均重 = 结算毛重/宰杀只数").append(sp);
		return sqla.toString();
    	
    }
	private String sqlb(String bizDate, BOSUuid companyID) {
		// TODO Auto-generated method stub
		String sp = "\n";
		StringBuffer sqlb = new StringBuffer();
		sqlb.append("/*dialect*/").append(sp);
		sqlb.append("select ").append(sp);
		sqlb.append("to_char(fbizDate,'yyyy-mm-dd')	日期,").append(sp);
		sqlb.append("nvl(sum(CFQTY),0)		商品鸡只数,").append(sp);
		sqlb.append("nvl(sum(CFTotalsettleWGT),0)	结算毛重,").append(sp);
		sqlb.append("nvl(sum(FPurchasesettleAmt),0)	收购金额,").append(sp);
		sqlb.append("case when nvl(sum(CFTotalsettleWGT),0)>0 then (nvl(sum(CFtotalSettleAmt),0)+nvl(sum(CFactulSettleFreAmt),0))/nvl(sum(CFTotalsettleWGT),0)/2 else 0 end 商品鸡均价").append(sp);
		sqlb.append("from CT_SET_SettleBill ").append(sp);
		sqlb.append("where to_char(fbizDate,'yyyy-mm-dd') = '").append(bizDate).append("'").append(sp);
		sqlb.append("and CFCompanyID = '").append(companyID).append("'").append(sp);
		sqlb.append("and (FBillStatus = '4' or FBillStatus='2')").append(sp);
		sqlb.append("and CFPurchaseType = '1'").append(sp);
		sqlb.append("group by to_char(fbizDate,'yyyy-mm-dd')").append(sp);
		sqlb.append("--商品鸡只数").append(sp);
		sqlb.append("--商品鸡均价 = （收购总金额+运费）/结算毛重").append(sp);
		return sqlb.toString();
	}
    private String sqlc(String bizDate, BOSUuid companyID) {
		// TODO Auto-generated method stub
    	String sp = "\n";
    	StringBuffer sqlc = new StringBuffer();
		sqlc.append("/*dialect*/").append(sp);
		sqlc.append("select ").append(sp);
		sqlc.append("to_char(fbizDate,'yyyy-mm-dd')	日期,").append(sp);
		sqlc.append("nvl(sum(CFQTY),0)		市场鸡只数,").append(sp);
		sqlc.append("nvl(sum(CFTotalsettleWGT),0)	结算毛重,").append(sp);
		sqlc.append("nvl(sum(FPurchasesettleAmt),0)	收购金额,").append(sp);
//		sqlc.append("nvl(sum(FPurchasesettleAmt),0)/nvl(sum(CFTotalsettleWGT),0)  市场价格").append(sp);
//		sqlc.append("avg(nvl(CFMarketPrice,0)) 市场价格").append(sp);
		sqlc.append("case when nvl(sum(CFTotalsettleWGT),0)>0 then  (nvl(sum(CFtotalSettleAmt),0)+nvl(sum(CFactulSettleFreAmt),0))/nvl(sum(CFTotalsettleWGT),0)/2 else 0 end	市场价格").append(sp);
		sqlc.append("from CT_SET_SettleBill  ").append(sp);
		sqlc.append("where to_char(fbizDate,'yyyy-mm-dd') = '").append(bizDate).append("'").append(sp);
		sqlc.append("and CFCompanyID = '").append(companyID).append("'").append(sp);
		sqlc.append("and (FBillStatus = '4' or FBillStatus='2')").append(sp);
		sqlc.append("and CFPurchaseType = '2'").append(sp);
		sqlc.append("group by to_char(fbizDate,'yyyy-mm-dd')").append(sp);
		sqlc.append("--市场鸡只数").append(sp);
		
		return sqlc.toString();
	}
    private String sqld(String bizDate, BOSUuid companyID) {
    	// TODO Auto-generated method stub
    	String sp = "\n";
    	StringBuffer sqld = new StringBuffer();
    	sqld.append("/*dialect*/").append(sp);
    	sqld.append("select ").append(sp);
    	sqld.append("to_char(t1.fbizDate,'yyyy-mm-dd')	日期,").append(sp);
    	sqld.append("nvl(sum(case when t2.CFWgtType = '1' then t2.CFwgt else 0 end),0)				小鸡重量,").append(sp);
    	sqld.append("nvl(sum(case when t2.CFWgtType = '1' then t2.CFWgtafterdis else 0 end),0)		胴体折算小鸡重,").append(sp);
    	sqld.append("nvl(sum(case when t2.CFWgtType = '2' then t2.CFWgtafterdis else 0 end),0)				鸡头重量").append(sp);
    	sqld.append("from").append(sp);
    	sqld.append(" CT_SET_SettleBill		t1	").append(sp);
    	sqld.append("inner join CT_SET_SettleBillAssEntry	t2	on t2.FParentID = t1.FID  ").append(sp);
    	sqld.append("where to_char(t1.fbizDate,'yyyy-mm-dd') = '").append(bizDate).append("'").append(sp);
    	sqld.append("and t1.CFCompanyID = '").append(companyID).append("'").append(sp);
    	sqld.append("and (t1.FBillStatus = '4' or FBillStatus='2')").append(sp);
    	sqld.append("and (t2.CFWgtType = '1' or t2.CFWgtType = '2')").append(sp);//小鸡、鸡头
    	sqld.append("group by to_char(t1.fbizDate,'yyyy-mm-dd')").append(sp);
    	sqld.append("--小鸡重量").append(sp);
    	sqld.append("--胴体折算小鸡重").append(sp);
		return sqld.toString();
    }
    private String sqle(String bizDate, BOSUuid companyID) {
		// TODO Auto-generated method stub
    	String sp = "\n";
    	StringBuffer sqle = new StringBuffer();
    	sqle.append("/*dialect*/").append(sp);
    	sqle.append("select nvl(sum(price),0)		后区总价  ,nvl(sum(weight),0)		后区总数量  from").append(sp);
    	sqle.append("(").append(sp);
    	sqle.append("select ").append(sp);
    	sqle.append("to_char(t1.FBizDate,'yyyy-mm-dd')	BizDate,").append(sp);
    	sqle.append("t3.FName_l2			物料名称,").append(sp);
    	sqle.append("t3.Fnumber 			物料编码,").append(sp);
    	sqle.append("sum(round(case when t2.CFFINISHEDPRODUCTTYPE='退车间' then (-1)*t2.CFWeight else t2.CFWeight end,2))			weight,").append(sp);
    	sqle.append("t6.FPrice			单价,").append(sp);
    	sqle.append("sum(round(case when t2.CFFINISHEDPRODUCTTYPE='退车间' then (-1)*t2.CFWeight else t2.CFWeight end,2))*t6.FPrice		price").append(sp);
    	sqle.append("from").append(sp);
    	sqle.append("CT_SZC_SzsemiProduct					t1").append(sp);
    	sqle.append("inner join CT_SZC_SzsemiProductEntry 	t2	on t2.FParentID = t1.FID").append(sp);
    	sqle.append("inner join T_BD_Material			t3	on t3.FID = t2.CFMaterialID").append(sp);
    	sqle.append("inner join T_BD_MaterialGroupDetial		t4	on t4.FMaterialID = t3.FID").append(sp);
    	sqle.append("inner join T_BD_MaterialGroup		t5	on t5.FID = t4.FMaterialGroupID").append(sp);
    	sqle.append("left join T_STO_SalesPriceEntry		t6	on t6.FMaterialID = t3.FID and t6.forgunitid=t1.cfcompanyid").append(sp);
//    	sqle.append("inner join T_STO_SalesPrice			t7	on t7.FID = t6.FParentID").append(sp);
    	sqle.append("and to_char(t6.FBizDate,'yyyy-mm-dd')  ='").append(bizDate).append("'").append(sp);
//    	sqle.append("inner join t_org_baseUnit 			t8 	on t8.fid=t6.forgunitid").append(sp);
    	sqle.append("where t1.CFCount = '0'").append(sp);
    	sqle.append("and to_char(t1.FBizDate,'yyyy-mm-dd')  ='").append(bizDate).append("'").append(sp);
    	sqle.append("and t5.FNumber = '00501'--后区产品（前区00502）").append(sp);
    	sqle.append("and t1.CFCompanyID = '").append(companyID).append("'").append(sp);
//    	sqle.append("and t8.FID = '").append(companyID).append("'").append(sp);
    	sqle.append("group by to_char(t1.FBizDate,'yyyy-MM-dd'),t3.FName_l2,t3.Fnumber,t6.FPrice").append(sp);
    	sqle.append("order by t3.Fnumber").append(sp);
    	sqle.append(")").append(sp);
		return sqle.toString();
	}
    
    /**
     * 插入主产品明细
     * @throws BOSException 
     */
    private void insertMainProductDetail(String bizDate, BOSUuid companyID) throws BOSException {
    	if(!productType.getSelectedItem().equals(ProductType.fresh)) {
    		return;
    	}
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	Calendar cal=Calendar.getInstance();
    	try {
			cal.setTime(sdf.parse(bizDate));
		} catch (ParseException err) {
			handleException(err);
		}
    	cal.add(Calendar.DAY_OF_MONTH, 1);
    	//下一天的日期
    	String nextDateStr=sdf.format(cal.getTime());
    	
    	String sp = "\n";  
    	StringBuffer sqle = new StringBuffer(); 
    	/*//原来戴哥
    	sqle.append("/*dialect").append(sp);
    	sqle.append("select ").append(sp);
    	sqle.append("to_char(t1.FBizDate,'yyyy-mm-dd')	BizDate,").append(sp);
    	sqle.append("t3.fid			FMaterialID,").append(sp);
    	sqle.append("t3.FName_l2			FMaterialName,").append(sp);
    	sqle.append("t3.Fnumber 			FMaterialNum,").append(sp);
    	sqle.append("t3.FModel 			FModel,").append(sp);
    	sqle.append("sum(round(case when t2.CFFINISHEDPRODUCTTYPE='退车间' then (-1)*t2.CFWeight else t2.CFWeight end,2))			Fweight,").append(sp);
    	sqle.append("t6.FPrice			FPrice,").append(sp);
    	sqle.append("nvl(sum(round(case when t2.CFFINISHEDPRODUCTTYPE='退车间' then (-1)*t2.CFWeight else t2.CFWeight end,2))*t6.FPrice,0)		FAmount,").append(sp);
    	sqle.append("t5.fid			FMaterialGroupID,t5.fnumber FGroupNum,tmg.fnumber FBaseGroupNum").append(sp);
    	sqle.append("from").append(sp);
    	sqle.append("CT_SZC_SzsemiProduct					t1").append(sp);
    	sqle.append("inner join CT_SZC_SzsemiProductEntry 	t2	on t2.FParentID = t1.FID").append(sp);
    	sqle.append("inner join T_BD_Material			t3	on t3.FID = t2.CFMaterialID").append(sp);
    	sqle.append("inner join t_bd_materialGroup tmg on tmg.fid=t3.fmaterialgroupID").append(sp);
    	sqle.append("inner join T_BD_MaterialGroupDetial		t4	on t4.FMaterialID = t3.FID").append(sp);
    	sqle.append("inner join T_BD_MaterialGroup		t5	on t5.FID = t4.FMaterialGroupID").append(sp);
    	sqle.append("left join T_STO_SalesPriceEntry		t6	on t6.FMaterialID = t3.FID and t6.forgunitid=t1.cfcompanyid and rownum=1").append(sp);
//    	sqle.append("inner join T_STO_SalesPrice			t7	on t7.FID = t6.FParentID").append(sp);
    	sqle.append("and to_char(t6.FBizDate,'yyyy-mm-dd')  ='").append(bizDate).append("'").append(sp);
//    	sqle.append("inner join t_org_baseUnit 			t8 	on t8.fid=t6.forgunitid").append(sp);
    	sqle.append("where t1.CFCount = '0'").append(sp);
    	sqle.append("and to_char(t1.FBizDate,'yyyy-mm-dd')  ='").append(bizDate).append("'").append(sp);
    	sqle.append("and (t5.FNumber = '00501' or t5.FNumber='00502' or t5.FNumber = '00503' or t5.fnumber='00504')").append(sp);
    	sqle.append("and t1.CFCompanyID = '").append(companyID).append("'").append(sp);
//    	sqle.append("and t8.FID = '").append(companyID).append("'").append(sp);
    	sqle.append("group by to_char(t1.FBizDate,'yyyy-mm-dd'),t3.fid,t3.FName_l2,t3.Fnumber,t3.fmodel,t6.FPrice,t5.fid,t5.fnumber,tmg.fnumber").append(sp);
    	sqle.append("order by t5.fnumber,tmg.fnumber,t3.Fnumber").append(sp);
    	IRowSet rs = SQLExecutorFactory.getRemoteInstance(sqle.toString()).executeSQL();*/
    	

    	sqle.append(" /*dialect*/").append(sp);
    	sqle.append("select").append(sp);
    	sqle.append("distinct  tt1.BizDate,tt1.FMaterialID,tt1.FMaterialName,tt1.FMaterialNum,tt1.FModel,tt1.FMaterialGroupID,tt1.FGroupNum,tt1.FBaseGroupNum,tt2.Fprice,tt1.Fweight,").append(sp);
    	sqle.append("nvl((tt1.Fweight*tt2.FPrice),0)		FAmount").append(sp);
    	sqle.append("from ").append(sp);
    	sqle.append("(").append(sp);
    	sqle.append("select ").append(sp);
    	sqle.append("to_char(t1.FBizDate,'yyyy-mm-dd')	BizDate,").append(sp);
    	sqle.append("t3.fid				FMaterialID,").append(sp);
    	sqle.append("t3.FName_l2			FMaterialName,").append(sp);
    	sqle.append("t3.Fnumber 			FMaterialNum,").append(sp);
    	sqle.append("t3.FModel 			FModel,").append(sp);
    	sqle.append("sum(round(case when t2.CFFINISHEDPRODUCTTYPE='退车间' then (-1)*t2.CFWeight else t2.CFWeight end,2))			Fweight,").append(sp);
    	sqle.append("t5.fid				FMaterialGroupID,t5.fnumber FGroupNum,tmg.fnumber FBaseGroupNum,").append(sp);
    	sqle.append("t1.cfcompanyid company").append(sp);
    	sqle.append("from").append(sp);
    	sqle.append("CT_SZC_SzsemiProduct					t1").append(sp);
    	sqle.append("inner join CT_SZC_SzsemiProductEntry 	t2	on t2.FParentID = t1.FID").append(sp);
    	sqle.append("inner join T_BD_Material			t3	on t3.FID = t2.CFMaterialID").append(sp);
    	sqle.append("inner join t_bd_materialGroup tmg on tmg.fid=t3.fmaterialgroupID").append(sp);
    	sqle.append("inner join T_BD_MaterialGroupDetial		t4	on t4.FMaterialID = t3.FID").append(sp);
    	sqle.append("inner join T_BD_MaterialGroup		t5	on t5.FID = t4.FMaterialGroupID").append(sp);
    	sqle.append("where t1.CFCount = '0'").append(sp);
    	sqle.append("and to_char(t1.FBizDate,'yyyy-mm-dd')  ='").append(bizDate).append("'").append(sp);
    	sqle.append("and (t5.FNumber = '00501' or t5.FNumber='00502' or t5.FNumber = '00503' or t5.fnumber='00504')").append(sp);
    	sqle.append("and t1.CFCompanyID = '").append(companyID).append("'").append(sp);
    	sqle.append("group by to_char(t1.FBizDate,'yyyy-mm-dd'),t3.fid,t3.FName_l2,t3.Fnumber,t3.fmodel,t5.fid,t5.fnumber,tmg.fnumber,t1.cfcompanyid").append(sp);
    	sqle.append("order by t5.fnumber,tmg.fnumber,t3.Fnumber").append(sp);
    	sqle.append(")				tt1").append(sp);
    	sqle.append("left join T_STO_SalesPriceEntry	tt2	on	tt2.FMaterialID = tt1.FMaterialID ").append(sp);
    	sqle.append("and to_char(tt2.FBizDate,'yyyy-MM-dd')  ='").append(nextDateStr).append("'").append(sp);
    	sqle.append("inner join T_STO_SalesPrice	tt3		on tt2.FParentID = tt3.FID").append(sp);
    	sqle.append("where tt2.forgunitid=tt1.company ").append(sp);
    	
    	IRowSet rs = SQLExecutorFactory.getRemoteInstance(sqle.toString()).executeSQL();
    	
    	try {
    		IRow row;
    		MaterialInfo mInfo;
    		IMaterialGroup imgs=MaterialGroupFactory.getRemoteInstance();
        	BigDecimal sumMainQty=BigDecimal.ZERO;
        	BigDecimal sumMainAmt=BigDecimal.ZERO;
        	
        	BigDecimal sumByQty=BigDecimal.ZERO;
        	BigDecimal sumByAmt=BigDecimal.ZERO;
        	
        	BigDecimal sumSuetQty=BigDecimal.ZERO;
        	
			while(rs.next()) {
				
				if(rs.getBigDecimal("Fweight").compareTo(BigDecimal.ZERO)!=0){
					moneys = moneys.add(rs.getBigDecimal("FAmount"));
					row=kdtEntry.addRow();
					mInfo=new MaterialInfo();
					mInfo.setId(BOSUuid.read(rs.getString("FMaterialID")));
					mInfo.setNumber(rs.getString("FMaterialNum"));
					mInfo.setName(rs.getString("FMaterialName"));
					mInfo.setModel(rs.getString("Fmodel"));
					
					row.getCell("materialNum").setValue(mInfo);
					row.getCell("materialName").setValue(mInfo.getName());
					row.getCell("model").setValue(mInfo.getModel());
					row.getCell("qty").setValue(rs.getBigDecimal("Fweight"));
					row.getCell("price").setValue(rs.getBigDecimal("FPrice"));
					row.getCell("amount").setValue(rs.getBigDecimal("FAmount"));
					row.getCell("materialGroup").setValue(imgs.getMaterialGroupInfo(new ObjectUuidPK(rs.getString("FMaterialGroupID"))));
				}
				if(rs.getString("FGroupNum").equals("00501")) {
					sumMainQty=sumMainQty.add(rs.getBigDecimal("Fweight"));
					sumMainAmt=sumMainAmt.add(rs.getBigDecimal("FAmount"));
				}
				if(rs.getString("FGroupNum").equals("00502")) {
					sumByQty=sumByQty.add(rs.getBigDecimal("Fweight"));
					sumByAmt=sumByAmt.add(rs.getBigDecimal("FAmount"));
				}
				
				//板油
				if(rs.getString("FBaseGroupNum").equals("01010509")) {  //板油数量原（01010701）
					sumSuetQty=sumSuetQty.add(rs.getBigDecimal("Fweight"));
				}
				
			}
			txtmainProductQty.setValue(sumMainQty);
			txtmainProductAmt.setValue(sumMainAmt);
			
			txtbyProductQty.setValue(sumByQty);
			txtbyProductAmt.setValue(sumByAmt);
			
			txtsuetQty.setValue(sumSuetQty);
		} catch (Exception e) {
			throw new BOSException(e);
		}
    }
    
    private String sqlf(String bizDate, BOSUuid companyID) {
		// TODO Auto-generated method stub
    	String sp = "\n";
    	StringBuffer sqlf = new StringBuffer();
    	sqlf.append("/*dialect*/").append(sp);
    	sqlf.append("select nvl(sum(price),0)		前区总价 ,nvl(sum(weight),0)		前区总数量   from").append(sp);
    	sqlf.append("(").append(sp);
    	sqlf.append("select ").append(sp);
    	sqlf.append("to_char(t1.FBizDate,'yyyy-mm-dd')	BizDate,").append(sp);
    	sqlf.append("t3.FName_l2			物料名称,").append(sp);
    	sqlf.append("t3.Fnumber 			物料编码,").append(sp);
    	sqlf.append("sum(round(case when t2.CFFINISHEDPRODUCTTYPE='退车间' then (-1)*t2.CFWeight else t2.CFWeight end,2))			weight,").append(sp);
    	sqlf.append("t6.FPrice			单价,").append(sp);
    	sqlf.append("nvl(sum(round(case when t2.CFFINISHEDPRODUCTTYPE='退车间' then (-1)*t2.CFWeight else t2.CFWeight end,2))*t6.FPrice,0)		price").append(sp);
    	sqlf.append("from").append(sp);
    	sqlf.append("CT_SZC_SzsemiProduct					t1").append(sp);
    	sqlf.append("inner join CT_SZC_SzsemiProductEntry 	t2	on t2.FParentID = t1.FID").append(sp);
    	sqlf.append("inner join T_BD_Material			t3	on t3.FID = t2.CFMaterialID").append(sp);
    	sqlf.append("inner join T_BD_MaterialGroupDetial		t4	on t4.FMaterialID = t3.FID").append(sp);
    	sqlf.append("inner join T_BD_MaterialGroup		t5	on t5.FID = t4.FMaterialGroupID").append(sp);
    	sqlf.append("left join T_STO_SalesPriceEntry		t6	on t6.FMaterialID = t3.FID and t6.forgunitid=t1.cfcompanyid").append(sp);
//    	sqlf.append("inner join T_STO_SalesPrice			t7	on t7.FID = t6.FParentID").append(sp);
    	sqlf.append("and to_char(t6.FBizDate,'yyyy-mm-dd')  ='").append(bizDate).append("'").append(sp);
//    	sqlf.append("inner join t_org_baseUnit 			t8 	on t8.fid=t6.forgunitid").append(sp);
    	sqlf.append("where t1.CFCount = '0'").append(sp);
    	sqlf.append("and to_char(t1.FBizDate,'yyyy-mm-dd')  ='").append(bizDate).append("'").append(sp);
    	sqlf.append("and t5.FNumber = '00502'--前区产品（后区00501）").append(sp);
    	sqlf.append("and t1.CFCompanyID = '").append(companyID).append("'").append(sp);
//    	sqlf.append("and t8.FID = '").append(companyID).append("'").append(sp);
    	sqlf.append("group by to_char(t1.FBizDate,'yyyy-mm-dd'),t3.FName_l2,t3.Fnumber,t6.FPrice").append(sp);
    	sqlf.append("order by t3.Fnumber").append(sp);
    	sqlf.append(")").append(sp);
		return sqlf.toString();
	}
    
    /**
     * 插入副产明细
     * @throws BOSException 
     */
    private void insertByProductDetail(String bizDate, BOSUuid companyID) throws BOSException {
    	String sp = "\n";
    	StringBuffer sqlf = new StringBuffer();
      	sqlf.append("/*dialect*/").append(sp);
    	sqlf.append("select ").append(sp);
    	sqlf.append("to_char(t1.FBizDate,'yyyy-mm-dd')	BizDate,").append(sp);
    	sqlf.append("t3.fid			FMaterialID,").append(sp);
    	sqlf.append("t3.FName_l2			FMaterialName,").append(sp);
    	sqlf.append("t3.Fnumber 			FMaterialNum,").append(sp);
    	sqlf.append("t3.FModel 			FModel,").append(sp);
    	sqlf.append("sum(round(case when t2.CFFINISHEDPRODUCTTYPE='退车间' then (-1)*t2.CFWeight else t2.CFWeight end,2))			Fweight,").append(sp);
    	sqlf.append("t6.FPrice			FPrice,").append(sp);
    	sqlf.append("nvl(sum(round(case when t2.CFFINISHEDPRODUCTTYPE='退车间' then (-1)*t2.CFWeight else t2.CFWeight end,2))*t6.FPrice,0)	FAmount,").append(sp);
    	sqlf.append("t5.fid			FMaterialGroupID").append(sp);
    	sqlf.append("from").append(sp);
    	sqlf.append("CT_SZC_SzsemiProduct					t1").append(sp);
    	sqlf.append("inner join CT_SZC_SzsemiProductEntry 	t2	on t2.FParentID = t1.FID").append(sp);
    	sqlf.append("inner join T_BD_Material			t3	on t3.FID = t2.CFMaterialID").append(sp);
    	sqlf.append("inner join T_BD_MaterialGroupDetial		t4	on t4.FMaterialID = t3.FID").append(sp);
    	sqlf.append("inner join T_BD_MaterialGroup		t5	on t5.FID = t4.FMaterialGroupID").append(sp);
    	sqlf.append("left join T_STO_SalesPriceEntry		t6	on t6.FMaterialID = t3.FID and t6.forgunitid=t1.cfcompanyid").append(sp);
//    	sqlf.append("inner join T_STO_SalesPrice			t7	on t7.FID = t6.FParentID").append(sp);
    	sqlf.append("and to_char(t6.FBizDate,'yyyy-mm-dd')  ='").append(bizDate).append("'").append(sp);
    	sqlf.append("inner join t_org_baseUnit 			t8 	on t8.fid=t6.forgunitid").append(sp);
    	sqlf.append("where t1.CFCount = '0'").append(sp);
    	sqlf.append("and to_char(t1.FBizDate,'yyyy-mm-dd')  ='").append(bizDate).append("'").append(sp);
    	sqlf.append("and t5.FNumber = '00502'--前区产品（后区00501）").append(sp);
    	sqlf.append("and t1.CFCompanyID = '").append(companyID).append("'").append(sp);
//    	sqlf.append("and t8.FID = '").append(companyID).append("'").append(sp);
    	sqlf.append("group by to_char(t1.FBizDate,'yyyy-mm-dd'),t3.fid,t3.fmodel,t3.FName_l2,t3.Fnumber,t6.FPrice,t5.fid").append(sp);
    	sqlf.append("order by t3.Fnumber").append(sp);
    	
    	IRowSet rs = SQLExecutorFactory.getRemoteInstance(sqlf.toString()).executeSQL();
    	try {
    		IRow row;
    		MaterialInfo mInfo;
    		IMaterialGroup imgs=MaterialGroupFactory.getRemoteInstance();
    		BigDecimal sumQty=BigDecimal.ZERO;
        	BigDecimal sumAmt=BigDecimal.ZERO;
			while(rs.next()) {
				if(rs.getBigDecimal("Fweight").compareTo(BigDecimal.ZERO)!=0){
					row=kdtEntry.addRow();
					mInfo=new MaterialInfo();
					mInfo.setId(BOSUuid.read(rs.getString("FMaterialID")));
					mInfo.setNumber(rs.getString("FMaterialNum"));
					mInfo.setName(rs.getString("FMaterialName"));
					mInfo.setModel(rs.getString("Fmodel"));
					
					row.getCell("materialNum").setValue(mInfo);
					row.getCell("materialName").setValue(mInfo.getName());
					row.getCell("model").setValue(mInfo.getModel());
					row.getCell("qty").setValue(rs.getBigDecimal("Fweight"));
					row.getCell("price").setValue(rs.getBigDecimal("FPrice"));
					row.getCell("amount").setValue(rs.getBigDecimal("FAmount"));
					row.getCell("materialGroup").setValue(imgs.getMaterialGroupInfo(new ObjectUuidPK(rs.getString("FMaterialGroupID"))));
				}
				sumQty=sumQty.add(rs.getBigDecimal("Fweight"));
				sumAmt=sumAmt.add(rs.getBigDecimal("FAmount"));
			}
			
			txtbyProductQty.setValue(sumQty);
			txtbyProductAmt.setValue(sumAmt);
		} catch (Exception e) {
			throw new BOSException(e);
		}
    }
    
    /**
     * 插入副产明细
     * @throws BOSException 
     */
    private void insertOtherProductDetail(String bizDate, BOSUuid companyID) throws BOSException {
    	String sp = "\n";
    	StringBuffer sqlf = new StringBuffer();
    	sqlf.append("select ").append(sp);
    	sqlf.append("to_char(t1.FBizDate,'yyyy-mm-dd')	BizDate,").append(sp);
    	sqlf.append("t3.fid			FMaterialID,").append(sp);
    	sqlf.append("t3.FName_l2			FMaterialName,").append(sp);
    	sqlf.append("t3.Fnumber 			FMaterialNum,").append(sp);
    	sqlf.append("t3.FModel 			FModel,").append(sp);
    	sqlf.append("sum(round(case when t2.CFFINISHEDPRODUCTTYPE='退车间' then (-1)*t2.CFWeight else t2.CFWeight end,2))			Fweight,").append(sp);
    	sqlf.append("t6.FPrice			FPrice,").append(sp);
    	sqlf.append("isnull(sum(round(case when t2.CFFINISHEDPRODUCTTYPE='退车间' then (-1)*t2.CFWeight else t2.CFWeight end,2))*t6.FPrice,0)		FAmount,").append(sp);
    	sqlf.append("t5.fid			FMaterialGroupID,t5.fnumber").append(sp);
    	sqlf.append("from").append(sp);
    	sqlf.append("CT_SZC_SzsemiProduct					t1").append(sp);
    	sqlf.append("inner join CT_SZC_SzsemiProductEntry 	t2	on t2.FParentID = t1.FID").append(sp);
    	sqlf.append("inner join T_BD_Material			t3	on t3.FID = t2.CFMaterialID").append(sp);
    	sqlf.append("inner join T_BD_MaterialGroupDetial		t4	on t4.FMaterialID = t3.FID").append(sp);
    	sqlf.append("inner join T_BD_MaterialGroup		t5	on t5.FID = t4.FMaterialGroupID").append(sp);
    	sqlf.append("left join T_STO_SalesPriceEntry		t6	on t6.FMaterialID = t3.FID and t6.forgunitid=t1.cfcompanyid").append(sp);
//    	sqlf.append("inner join T_STO_SalesPrice			t7	on t7.FID = t6.FParentID").append(sp);
    	sqlf.append("and to_char(t6.FBizDate,'yyyy-mm-dd')  ='").append(bizDate).append("'").append(sp);
    	sqlf.append("inner join t_org_baseUnit 			t8 	on t8.fid=t6.forgunitid").append(sp);
    	sqlf.append("where t1.CFCount = '0'").append(sp);
    	sqlf.append("and to_char(t1.FBizDate,'yyyy-mm-dd')  ='").append(bizDate).append("'").append(sp);
    	sqlf.append("and (t5.FNumber = '00503' or t5.fnumber='00504')").append(sp);
    	sqlf.append("and t1.CFCompanyID = '").append(companyID).append("'").append(sp);
//    	sqlf.append("and t8.FID = '").append(companyID).append("'").append(sp);
    	sqlf.append("group by to_char(t1.FBizDate,'yyyy-mm-dd'),t3.fid,t3.fmodel,t3.FName_l2,t3.Fnumber,t6.FPrice,t5.fid,t5.fnumber").append(sp);
    	sqlf.append("order by t5.fnumber,t3.Fnumber").append(sp);
    	
    	IRowSet rs = SQLExecutorFactory.getRemoteInstance(sqlf.toString()).executeSQL();
    	try {
    		IRow row;
    		MaterialInfo mInfo;
    		IMaterialGroup imgs=MaterialGroupFactory.getRemoteInstance();
    		BigDecimal sumQty=BigDecimal.ZERO;
        	BigDecimal sumAmt=BigDecimal.ZERO;
			while(rs.next()) {
				if(rs.getBigDecimal("Fweight").compareTo(BigDecimal.ZERO)!=0){
					row=kdtEntry.addRow();
					mInfo=new MaterialInfo();
					mInfo.setId(BOSUuid.read(rs.getString("FMaterialID")));
					mInfo.setNumber(rs.getString("FMaterialNum"));
					mInfo.setName(rs.getString("FMaterialName"));
					mInfo.setModel(rs.getString("Fmodel"));
					
					row.getCell("materialNum").setValue(mInfo);
					row.getCell("materialName").setValue(mInfo.getName());
					row.getCell("model").setValue(mInfo.getModel());
					row.getCell("qty").setValue(rs.getBigDecimal("Fweight"));
					row.getCell("price").setValue(rs.getBigDecimal("FPrice"));
					row.getCell("amount").setValue(rs.getBigDecimal("FAmount"));
					row.getCell("materialGroup").setValue(imgs.getMaterialGroupInfo(new ObjectUuidPK(rs.getString("FMaterialGroupID"))));
				}
				sumQty=sumQty.add(rs.getBigDecimal("Fweight"));
				sumAmt=sumAmt.add(rs.getBigDecimal("FAmount"));
			}
			txtotherProductQty.setValue(sumQty);
			txtotherProductAmt.setValue(sumAmt);
		} catch (Exception e) {
			throw new BOSException(e);
		}
    }
    
    private String sqlg(String bizDate, BOSUuid companyID) {
		// TODO Auto-generated method stub
    	String sp = "\n";
    	StringBuffer sqlg = new StringBuffer();
    	sqlg.append("/*dialect*/").append(sp);
    	sqlg.append("select nvl(sum(price),0)		总金额   from").append(sp);
    	sqlg.append("(").append(sp);
    	sqlg.append("select ").append(sp);
    	sqlg.append("to_char(t1.FBizDate,'yyyy-mm-dd')	BizDate,").append(sp);
    	sqlg.append("t3.FName_l2			物料名称,").append(sp);
    	sqlg.append("t3.Fnumber 			物料编码,").append(sp);
    	sqlg.append("sum(round(t2.CFWeight,2))			重量,").append(sp);
    	sqlg.append("t6.FPrice			单价,").append(sp);
    	sqlg.append("sum(round(t2.CFWeight,2))*t6.FPrice		price").append(sp);
    	sqlg.append("from").append(sp);
    	sqlg.append("CT_SZC_SzsemiProduct					t1").append(sp);
    	sqlg.append("inner join CT_SZC_SzsemiProductEntry 	t2	on t2.FParentID = t1.FID").append(sp);
    	sqlg.append("inner join T_BD_Material			t3	on t3.FID = t2.CFMaterialID").append(sp);
    	sqlg.append("inner join T_BD_MaterialGroupDetial		t4	on t4.FMaterialID = t3.FID").append(sp);
    	sqlg.append("inner join T_BD_MaterialGroup		t5	on t5.FID = t4.FMaterialGroupID").append(sp);
    	sqlg.append("inner join T_STO_SalesPriceEntry		t6	on t6.FMaterialID = t3.FID").append(sp);
    	sqlg.append("inner join T_STO_SalesPrice			t7	on t7.FID = t6.FParentID").append(sp);
    	sqlg.append("and to_char(t7.FBizDate,'yyyy-mm-dd')  ='").append(bizDate).append("'").append(sp);
    	sqlg.append("inner join t_org_baseUnit 			t8 	on t8.fid=t6.forgunitid").append(sp);
    	sqlg.append("where t1.CFCount = '0'").append(sp);
    	sqlg.append("and to_char(t1.FBizDate,'yyyy-mm-dd')  ='").append(bizDate).append("'").append(sp);
    	sqlg.append("and t5.flongnumber not like '01!0101!010110%'--不含下料").append(sp);
    	sqlg.append("and t1.CFCompanyID = '").append(companyID).append("'").append(sp);
    	sqlg.append("and t8.FID = '").append(companyID).append("'").append(sp);
    	sqlg.append("group by to_char(t1.FBizDate,'yyyy-mm-dd'),t3.FName_l2,t3.Fnumber,t6.FPrice").append(sp);
    	sqlg.append("order by t3.Fnumber").append(sp);
    	sqlg.append(")").append(sp);
		return sqlg.toString();
	}
    private String sqlh(String bizDate, BOSUuid companyID){
    	// TODO Auto-generated method stub
    	String sp = "\n";
    	StringBuffer sqlh = new StringBuffer();
    	sqlh.append("/*dialect*/").append(sp);
    	sqlh.append("select nvl(sum(materialWeight),0)		成品重量  from (").append(sp);
    	sqlh.append("select ").append(sp);
    	sqlh.append("to_char(t1.FBizDate,'yyyy-mm-dd')			BizDate,").append(sp);
    	sqlh.append("t3.FName_l2			materialName,").append(sp);
    	sqlh.append("t2.CFMaterialNumber		materialNumber,").append(sp);
    	sqlh.append("t2.CFMaterialType			materialType,").append(sp);
    	sqlh.append("nvl(sum(t2.CFWeight),0)		materialWeight,").append(sp);
    	sqlh.append("t2.CFFinishedProductType		materialProductType").append(sp);
    	sqlh.append("from").append(sp);
    	sqlh.append("CT_SZC_SzsemiProduct					t1").append(sp);
    	sqlh.append("inner join CT_SZC_SzsemiProductEntry 	t2	on t2.FParentID = t1.FID").append(sp);
    	sqlh.append("inner join T_BD_Material				t3	on t3.FID = t2.CFMaterialID").append(sp);
    	sqlh.append("where t1.CFCount = '0'").append(sp);
    	//sqlh.append("and t1.FBizDate >={d '").append(bizDate).append("'}").append(sp);
    	//sqlh.append("and t1.FBizDate < {d '").append(bizDate).append("'}+1").append(sp);
    	sqlh.append("and to_char(t1.FBizDate,'yyyy-mm-dd')  ='").append(bizDate).append("'").append(sp);
    	sqlh.append("and t1.CFCompanyID ='").append(companyID).append("'").append(sp);
    	sqlh.append("group by").append(sp);
    	sqlh.append("to_char(t1.FBizDate,'yyyy-mm-dd'),t3.FName_l2,t2.CFMaterialNumber,t2.CFMaterialType,t2.CFFinishedProductType").append(sp);
    	sqlh.append("order by to_char(t1.FBizDate,'yyyy-mm-dd'),t2.CFFinishedProductType desc,t2.CFMaterialNumber ").append(sp);
    	sqlh.append(")").append(sp);
    	return sqlh.toString();
    }
	private String sqli(String bizDate, BOSUuid companyID) {
		// TODO Auto-generated method stub
		String sp = "\n";
    	StringBuffer sqli = new StringBuffer();
    	/*	//旧出成率常数
    	sqli.append("/*dialect").append(sp);//dialect后缀删除了
    	sqli.append("select ").append(sp);
    	sqli.append("nvl(min(CFStdyeildrate),0)  出成率常数").append(sp);
//    	sqli.append("nvl(sum(CFStdyeildrate)/count(CFStdyeildrate),0)  出成率常数").append(sp);
		sqli.append("from").append(sp);
		sqli.append("(").append(sp);
		sqli.append("select ").append(sp);
		sqli.append("CFStdyeildrate").append(sp);
		sqli.append("from CT_SET_SettleBill  ").append(sp);
		sqli.append("where to_char(FBizDate,'yyyy-mm-dd') = '").append(bizDate).append("'").append(sp);
		sqli.append("and CFCompanyID = '").append(companyID).append("'").append(sp);
		sqli.append("and (FBillStatus = '4' or FBillStatus='2')").append(sp);
		sqli.append("and CFPurchaseType = '1'").append(sp);
		sqli.append(")").append(sp);*/
    	
    	
			//新出成率常数
    	sqli.append("/*dialect*/").append(sp);
    	sqli.append("select nvl(min(t2.CFRate),0) 出成率常数 from ").append(sp);
    	sqli.append("CT_SET_CarcassDisrate 			t1").append(sp);
    	sqli.append("inner join CT_SET_CarcassDisrateEntry	t2	on t2.FParentID = t1.FID").append(sp);
    	sqli.append("where FhouseBefore  = '0'").append(sp);
    	sqli.append("and   FPurChaseType = '1'").append(sp);
    	sqli.append("and to_char(CFeffectDate,'yyyy-MM-dd') <= '").append(bizDate).append("'").append(sp);
    	sqli.append("and to_char(CFuneffectDate,'yyyy-MM-dd') >= '").append(bizDate).append("'").append(sp);
    	sqli.append("and CFCompanyID = '").append(companyID).append("'").append(sp);
		
		
		return sqli.toString();
	}
	private String sqlj(String bizDate, BOSUuid companyID) {
		// TODO Auto-generated method stub
		String sp = "\n";
    	StringBuffer sqlj = new StringBuffer();
		sqlj.append("/*dialect*/").append(sp);
		sqlj.append("select").append(sp);
		sqlj.append("nvl(sum(t2.CFWeight),0)		鲜品半包").append(sp);
		sqlj.append("from CT_SZC_SzSemiProduct 	t1").append(sp);
		sqlj.append("inner join CT_SZC_SzSemiProductEntry	t2	on t2.FParentID = t1.FID").append(sp);
		sqlj.append("where to_char(t1.FbizDate,'yyyy-mm-dd') = '").append(bizDate).append("'").append(sp);
		sqlj.append("and CFCount = '0'").append(sp);
		sqlj.append("and CFCompanyID ='").append(companyID).append("'").append(sp);
		sqlj.append("and CFFinishedProductType = '半件'").append(sp);
		return sqlj.toString();
	}
	private String sqlk(BOSUuid companyID) {
		// TODO Auto-generated method stub
		String sp = "\n";
    	StringBuffer sqlk = new StringBuffer();
    	sqlk.append("select ").append(sp);
    	sqlk.append("CFChickenBooldPrice		鸡血单价,").append(sp);
    	sqlk.append("CFChickenFeatherPrice	鸡毛单价,").append(sp);
    	sqlk.append("CFChickenCropPrice		鸡嗉子单价,").append(sp);
    	sqlk.append("CFChickenIntestinesPrice	鸡肠单价,").append(sp);
    	sqlk.append("CFChickenMixedOilPrice	杂油单价,").append(sp);
		sqlk.append("CFTonPrice			吨费用").append(sp);
		sqlk.append(" from ").append(sp);
		sqlk.append("CT_SZC_ChickenBasicData ").append(sp);
		sqlk.append("where Fbasestatus = '2'").append(sp);
		sqlk.append("and CFCompanyID = '").append(companyID).append("'").append(sp);
		return sqlk.toString();
	}
    
    //鸡毛血肠嗉子杂油事件
    private void chickenmxcsz(){
    	if(StringUtils.isNotBlank(txtchickenPeatherPrice.getText())&&StringUtils.isNotBlank(txtslaughterAmt.getText())){
			String amtFirst = txtslaughterAmt.getText();
			String amtThen = amtFirst.replaceAll(",","");
			double amt = Double.valueOf(amtThen).doubleValue(); 
			double price  = Double.valueOf(txtchickenPeatherPrice.getText()).doubleValue(); 
			double money = amt*price;
			BigDecimal moneyMiddle = new BigDecimal(money);  
			double moneyLast = moneyMiddle.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();  
			txtchickenPeatherMoney.setValue(new BigDecimal(moneyLast));
		}else{
			txtchickenPeatherMoney.setValue(null);
		}
    	if(StringUtils.isNotBlank(txtchickenBloodPrice.getText())&&StringUtils.isNotBlank(txtslaughterAmt.getText())){
    		String amtFirst = txtslaughterAmt.getText();
			String amtThen = amtFirst.replaceAll(",","");
			double amt = Double.valueOf(amtThen).doubleValue(); 
			double price  = Double.valueOf(txtchickenBloodPrice.getText()).doubleValue(); 
			double money = amt*price;
			BigDecimal moneyMiddle = new BigDecimal(money);  
			double moneyLast = moneyMiddle.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();  
			txtchickenBloodMoney.setValue(new BigDecimal(moneyLast));
		}else{
			txtchickenBloodMoney.setValue(null);
		}
    	if(StringUtils.isNotBlank(txtchickenIntestinePrice.getText())&&StringUtils.isNotBlank(txtslaughterAmt.getText())){
    		String amtFirst = txtslaughterAmt.getText();
			String amtThen = amtFirst.replaceAll(",","");
			double amt = Double.valueOf(amtThen).doubleValue();  
			double price  = Double.valueOf(txtchickenIntestinePrice.getText()).doubleValue(); 
			double money = amt*price;
			BigDecimal moneyMiddle = new BigDecimal(money);  
			double moneyLast = moneyMiddle.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();  
			txtchickenIntestineMoney.setValue(new BigDecimal(moneyLast));
		}else{
			txtchickenIntestineMoney.setValue(null);
		}
    	if(StringUtils.isNotBlank(txtchickenCropPrice.getText())&&StringUtils.isNotBlank(txtslaughterAmt.getText())){
    		String amtFirst = txtslaughterAmt.getText();
			String amtThen = amtFirst.replaceAll(",","");
			double amt = Double.valueOf(amtThen).doubleValue(); 
			double price  = Double.valueOf(txtchickenCropPrice.getText()).doubleValue(); 
			double money = amt*price;
			BigDecimal moneyMiddle = new BigDecimal(money);  
			double moneyLast = moneyMiddle.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();  
			txtchickenCropMoney.setValue(new BigDecimal(moneyLast));
		}else{
			txtchickenCropMoney.setValue(null);
		}
    	if(StringUtils.isNotBlank(txtmixedOilPrice.getText())&&StringUtils.isNotBlank(txtslaughterAmt.getText())){
    		String amtFirst = txtslaughterAmt.getText();
			String amtThen = amtFirst.replaceAll(",","");
			double amt = Double.valueOf(amtThen).doubleValue();  
			double price  = Double.valueOf(txtmixedOilPrice.getText()).doubleValue(); 
			double money = amt*price;
			BigDecimal moneyMiddle = new BigDecimal(money);  
			double moneyLast = moneyMiddle.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();  
			txtmixedOilMoney.setValue(new BigDecimal(moneyLast));
		}else{
			txtmixedOilMoney.setValue(null);
		}
    }
    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.szcount.FreshDailyInfo objectValue = new com.kingdee.eas.custom.szcount.FreshDailyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        return objectValue;
    }

}