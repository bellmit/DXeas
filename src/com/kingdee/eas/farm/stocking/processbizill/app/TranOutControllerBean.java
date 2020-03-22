package com.kingdee.eas.farm.stocking.processbizill.app;

import mondrian.rolap.BitKey.Big;

import org.apache.derby.tools.sysinfo;
import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kingdee.bos.*;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.ctrl.data.engine.rows.IRow;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.ISQLExecutor;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.farm.stocking.basedata.BreedDataFactory;
import com.kingdee.eas.farm.stocking.basedata.BreedDataInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.FarmFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmersFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmersInfo;
import com.kingdee.eas.farm.stocking.basedata.IStockingBatch;
import com.kingdee.eas.farm.stocking.basedata.StockingBatch;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchHouseEntry;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchHouseEntryCollection;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchHouseEntryFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchHouseEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.basedata.app.sex;
import com.kingdee.eas.farm.stocking.processbizill.ITranIn;
import com.kingdee.eas.farm.stocking.processbizill.TranInEntryCollection;
import com.kingdee.eas.farm.stocking.processbizill.TranInEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.TranInFactory;
import com.kingdee.eas.farm.stocking.processbizill.TranInInfo;
import com.kingdee.eas.farm.stocking.processbizill.TranOutEntryCollection;
import com.kingdee.eas.farm.stocking.processbizill.TranOutEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.TranOutInfo;
import com.kingdee.eas.farm.stocking.processbizill.wzBillBaseStatus;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import java.math.BigDecimal;

import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.farm.stocking.processbizill.TranOutCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
//import com.kingdee.eas.rptclient.gr.rptclient.util.DbUtil;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.BotpAppCommon;
import com.kingdee.eas.basedata.assistant.CORelatedType;
import com.kingdee.eas.basedata.assistant.CalculateModeEnum;
import com.kingdee.eas.basedata.assistant.CostObject;
import com.kingdee.eas.basedata.assistant.CostObjectEntryInfo;
import com.kingdee.eas.basedata.assistant.CostObjectFactory;
import com.kingdee.eas.basedata.assistant.CostObjectGroupFactory;
import com.kingdee.eas.basedata.assistant.CostObjectGroupInfo;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.basedata.assistant.ICostObject;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class TranOutControllerBean extends AbstractTranOutControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.stocking.processbizill.app.TranOutControllerBean");

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		TranOutInfo info = (TranOutInfo)model;
		info.setBaseStatus(wzBillBaseStatus.audit);
		info.setAuditTime(new java.util.Date());
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		//点击审核自动生成转入单
		auditListen(ctx,info);
		try {
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw  new BOSException(e);
		}
		super._audit(ctx, model);
	}

	/**
	 * 点击审核自动生成转入单
	 * @param ctx
	 * @param info
	 * @throws BOSException 
	 */
	private void auditListen(Context ctx, TranOutInfo info) throws BOSException {
		//定义一个转入单
		TranInInfo tranInInfo = new TranInInfo();
		ITranIn itranInInfo = null;
		try {
			itranInInfo = TranInFactory.getLocalInstance(ctx);
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//获取转出单编码
		String billNum = null;
		if(info.getNumber() != null){
			billNum = info.getNumber();
		}else{
			billNum =  "1";
		}

		//获取转出单
		//转出日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
		Date outDate = null;
		if(info.getBizDate() != null){
			outDate = info.getBizDate();
		}else{
			throw new BOSException("转出日期不能为空！");
		}


		//设置转入单转入日期
		tranInInfo.setBizDate(outDate);
		//设置转入单的转出单编号字段
		tranInInfo.setTranOutNum(billNum);
		//出场时间
		Date outTime = null;
		Time startTimeFmt = null;
		if(info.getOutTime() != null){
			outTime = info.getOutTime();
			startTimeFmt = new Time(outTime.getTime());
		}else{
			throw new BOSException("出场时间不能为空！");
		}
		//设置转入单入场时间
		tranInInfo.setOutTime(startTimeFmt);

		//获取转出单分录
		TranOutEntryCollection tranOutCol = info.getEntrys();
		TranOutEntryInfo tranOutEntryInfo = null;

		//设置转入单分录collection并赋值
		TranInEntryCollection tranInCol = new TranInEntryCollection();
		//定义一个转入单分录Info
		TranInEntryInfo tranInEntryInfo = null;
		//定义一个List存放棚舍id
		List<String> entryList = null;
		for(int i=0,colSize = tranOutCol.size();i<colSize;i++){
			tranInEntryInfo = new TranInEntryInfo();
			tranOutEntryInfo = tranOutCol.get(i);
			//是否转入新批次
			boolean isNewBatch = tranOutEntryInfo.isIsNewBatch();
			//转出养殖场
			FarmInfo farmInfo = null;
			//转出批次
			StockingBatchInfo batchInfo = null;
			//转出棚舍
			FarmHouseEntryInfo houseInfo= null;
			//转出周龄
			String week = tranOutEntryInfo.getOutWeek();
			//转出日龄
			String dayAge = tranOutEntryInfo.getOutDay();
			//转出公鸡数
			BigDecimal maleQty= BigDecimal.ZERO;
			if(tranOutEntryInfo.getOutmaleQty() != null && !tranOutEntryInfo.getOutmaleQty().equals(new BigDecimal("0"))){
				maleQty = tranOutEntryInfo.getOutmaleQty();
			}
			//转出母鸡数
			BigDecimal femaleQty= BigDecimal.ZERO;
			if(tranOutEntryInfo.getOutFemaleQty() != null 
					&& !tranOutEntryInfo.getOutFemaleQty().equals(new BigDecimal("0"))){
				femaleQty = tranOutEntryInfo.getOutFemaleQty();
			}

			//转入养殖场
			FarmInfo inFarm = null;
			//转入批次
			StockingBatchInfo inBatchInfo = null;
			//转入棚舍
			FarmHouseEntryInfo inHouseInfo = null;

			if(tranOutEntryInfo.getOutFarm() == null){
				throw new BOSException("转出养殖场不能为空！");
			}
			if(tranOutEntryInfo.getOutBatch() == null){
				throw new BOSException("转出批次不能为空！");
			}
			if(tranOutEntryInfo.getOutHouse() == null){
				throw new BOSException("转出棚舍不能为空！");
			}
			if(tranOutEntryInfo.getInFarm() == null){
				throw new BOSException("转入养殖场不能为空！");
			}
			if(tranOutEntryInfo.getInHouse() == null){
				throw new BOSException("转入棚舍不能为空！");
			}
			try {
				//转出单--转出养殖场
				farmInfo = FarmFactory.getLocalInstance(ctx).getFarmInfo(new ObjectUuidPK(tranOutEntryInfo.getOutFarm().getId()));
				//转出单--转出批次
				batchInfo = StockingBatchFactory.getLocalInstance(ctx).getStockingBatchInfo(new ObjectUuidPK(tranOutEntryInfo.getOutBatch().getId()));
				//转出单--转出棚舍
				houseInfo = FarmHouseEntryFactory.getLocalInstance(ctx).getFarmHouseEntryInfo(new ObjectUuidPK(tranOutEntryInfo.getOutHouse().getId()));
				//转出单--转入养殖场
				inFarm = FarmFactory.getLocalInstance(ctx).getFarmInfo(new ObjectUuidPK(tranOutEntryInfo.getInFarm().getId()));
				//转出单--转入棚舍
				inHouseInfo = FarmHouseEntryFactory.getLocalInstance(ctx).getFarmHouseEntryInfo(new ObjectUuidPK(tranOutEntryInfo.getInHouse().getId()));


				//根据转出批次和转出0棚舍，反写转出批次的是否完全出栏字段和完全出栏日期
				//				String s1 = "/*dialect*/ select t2.FQty maleQty,t2.FFemaleQty femaleQty,t2.fid entryid from T_FM_StockingBatch t1" +
				//				" inner join T_FM_StockingBatchHouseEntry t2 on t2.fparentid = t1.fid" +
				//				" where t1.fid ='"+batchInfo.getId()+"' and t2.FHouseID = '"+houseInfo.getId()+"'";
				//				IRowSet r1 = DbUtil.executeQuery(ctx, s1);
				//				BigDecimal male = BigDecimal.ZERO;
				//				BigDecimal female = BigDecimal.ZERO;
				//				String entryid = null;
				//				if(r1.next()){
				//					male = r1.getBigDecimal("maleQty");
				//					female = r1.getBigDecimal("femaleQty");
				//					entryid = r1.getString("entryid");
				//					//反写完全出栏标识
				//					if(male.compareTo(maleQty) == 0 && femaleQty.compareTo(female) == 0){
				//						String s2 = "/*dialect*/ update T_FM_StockingBatchHouseEntry  set FIsAllOut = 1 , FAllOutDate = {d '"+sdf.format(info.getBizDate())+"'} where  fid = '"+entryid+"'";
				//						com.kingdee.eas.util.app.DbUtil.execute(ctx, s2.toString());
				//					}
				//
				//				}




			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			//转入养殖场
			tranInEntryInfo.setInFarm(inFarm);
			//转入棚舍
			tranInEntryInfo.setInHouse(inHouseInfo);
			//转入周龄
			tranInEntryInfo.setOutWeek(week);
			//转入日龄
			tranInEntryInfo.setOutDay(dayAge);
			//转入公鸡数
			tranInEntryInfo.setOutmaleQty(maleQty);
			//转入母鸡数
			tranInEntryInfo.setOutFemaleQty(femaleQty);
			//转出养殖场
			tranInEntryInfo.setOutFarm(farmInfo);
			//转出批次
			tranInEntryInfo.setOutBatch(batchInfo);
			//转出棚舍
			tranInEntryInfo.setOutHouse(houseInfo);


			//设置转入单的转入批次
			//如果该条分录的‘是否转入新批次’和‘批次’同时不为空，就生成新的批次，
			//否则就使用  转出单的--转入批次
			if(isNewBatch && tranOutEntryInfo.getBatchid() != null){

				//如果是生成新的批次，就要校验是否已经存在这个批次
				StringBuffer sql = new StringBuffer();
				sql.append("/*dialect*/ select distinct t1.fid billid from T_FM_StockingBatch t1 inner join T_FM_StockingBatchHouseEntry t2 on t2.fparentid=t1.fid ");
				sql.append("where t1.fnumber='");
				sql.append(tranOutEntryInfo.getBatchid().toString());
				sql.append("' ");
				sql.append("and t1.FFarmID='");
				sql.append(tranOutEntryInfo.getInFarm().getId().toString());
				sql.append("'");
				IRowSet rs = null;
				try {
					rs = DbUtil.executeQuery(ctx,sql.toString());
					//如果已经存在，就在该批次的基础上面增加
					if(rs.next()){
						//批次id
						String	 billid = rs.getString("billid");
						//实例化批次信息
						StockingBatchInfo stockingBatchInfo = StockingBatchFactory.getLocalInstance(ctx).getStockingBatchInfo(new ObjectUuidPK(billid));
						//实例化批次信息分录
						StockingBatchHouseEntryCollection stockingBatchHouseEntryCol = stockingBatchInfo.getHouseEntry();
						StockingBatchHouseEntryInfo stockingBatchHouseEntryInfo = null;
						IStockingBatch istockingBatch = StockingBatchFactory.getLocalInstance(ctx);





						//将分录中所有的棚舍id放到一个List里面
						entryList = new ArrayList<String>();
						String houseid = null;
						for(int j=0,collectionSize=stockingBatchHouseEntryCol.size();j<collectionSize;j++){
							stockingBatchHouseEntryInfo = stockingBatchHouseEntryCol.get(j);
							houseid = stockingBatchHouseEntryInfo.getHouse().getId().toString();
							entryList.add(houseid);
						}

						//初始公禽，母禽数量
						BigDecimal maleQty1 = BigDecimal.ZERO;
						BigDecimal femaleQty1 = BigDecimal.ZERO;
						//新增公禽，母禽数量
						BigDecimal addMaleQty = BigDecimal.ZERO;
						BigDecimal addFemaleQty = BigDecimal.ZERO;
						//增加之后现在有的
						BigDecimal nowMaleQty = BigDecimal.ZERO;
						BigDecimal nowFemaleQty = BigDecimal.ZERO;

						//List里面存在转出单的转入棚舍，就在初始公禽，母禽的数量基础上加
						if(entryList.contains(tranOutEntryInfo.getInHouse().getId().toString())){

							if(stockingBatchHouseEntryInfo.getQty() != null){
								maleQty1 = stockingBatchHouseEntryInfo.getQty();
							}
							if(stockingBatchHouseEntryInfo.getFemaleQty() != null){
								femaleQty1 = stockingBatchHouseEntryInfo.getFemaleQty();
							}
							if(tranOutEntryInfo.getOutmaleQty() != null){
								addMaleQty = tranOutEntryInfo.getOutmaleQty();
							}
							if(tranOutEntryInfo.getOutFemaleQty() != null){
								addFemaleQty = tranOutEntryInfo.getOutFemaleQty();
							}
							nowMaleQty = maleQty1.add(addMaleQty);
							nowFemaleQty = femaleQty1.add(addFemaleQty);
							//							stockingBatchHouseEntryInfo.setQty(nowMaleQty);
							//							stockingBatchHouseEntryInfo.setFemaleQty(nowFemaleQty);
						}else{
							//如果list里面不包含转出单的转入棚舍，就新增一行
							stockingBatchHouseEntryInfo = new StockingBatchHouseEntryInfo();
							//设置棚舍
							stockingBatchHouseEntryInfo.setHouse(inHouseInfo);

							//获取
							Date inDate = null;
							StockingBatchHouseEntryCollection batchCol = batchInfo.getHouseEntry();
							StockingBatchHouseEntryInfo entryHouseInfo  = null;
							entryHouseInfo = StockingBatchHouseEntryFactory.getLocalInstance(ctx).getStockingBatchHouseEntryInfo(new ObjectUuidPK(batchCol.get(0).getId()));
							inDate = entryHouseInfo.getInData();
							//设置入雏日期
							stockingBatchHouseEntryInfo.setInData(inDate);
							//设置入栏日期
							stockingBatchHouseEntryInfo.setRlData(outDate);

							if(tranOutEntryInfo.getOutmaleQty() != null){
								addMaleQty = tranOutEntryInfo.getOutmaleQty();
							}
							if(tranOutEntryInfo.getOutFemaleQty() != null){
								addFemaleQty = tranOutEntryInfo.getOutFemaleQty();
							}

							//公禽数量
							//							stockingBatchHouseEntryInfo.setQty(addMaleQty);
							//							//母禽数量
							//							stockingBatchHouseEntryInfo.setFemaleQty(addFemaleQty);

						}


						stockingBatchHouseEntryCol.add(stockingBatchHouseEntryInfo);

						//设置批次的养殖总数--在原来的养殖总数上添加
						BigDecimal totalQty = stockingBatchInfo.getTotalQty();
						stockingBatchInfo.setTotalQty(totalQty.add(addMaleQty).add(addFemaleQty));
						stockingBatchInfo.getHouseEntry().addCollection(stockingBatchHouseEntryCol);
						istockingBatch.save(stockingBatchInfo);
						tranInEntryInfo.setInBbatch(stockingBatchInfo);
					}else{
						inBatchInfo = produceNewBatch(ctx,tranOutEntryInfo,batchInfo,info);
						tranInEntryInfo.setInBbatch(inBatchInfo);
					}
				} catch (EASBizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				//如果不是转入新批次，而是转入已有批次，需要增加一个校验
				//得到这个批次，遍历这个批次的分录信息，如果存在棚舍和转出单上的转入棚舍不一致的情况
				//就需要在这个分录上面新增一行棚舍的分录				
				if(tranOutEntryInfo.getInBbatch()==null){
					throw new BOSException("转入批次不能为空！");
				}
				StockingBatchInfo stockingBatchInfo = null;
				try {
					//实例化批次信息
					stockingBatchInfo = StockingBatchFactory.getLocalInstance(ctx).getStockingBatchInfo(new ObjectUuidPK(tranOutEntryInfo.getInBbatch().getId().toString()));
					//实例化批次信息分录
					StockingBatchHouseEntryCollection stockingBatchHouseEntryCol = stockingBatchInfo.getHouseEntry();
					StockingBatchHouseEntryInfo stockingBatchHouseEntryInfo = null;
					IStockingBatch istockingBatch = StockingBatchFactory.getLocalInstance(ctx);

					//设置养殖总数
					BigDecimal initTottalQty = stockingBatchInfo.getTotalQty();

					//将分录中所有的棚舍id放到一个List里面
					entryList = new ArrayList<String>();
					String houseid = null;
					for(int j=0,collectionSize=stockingBatchHouseEntryCol.size();j<collectionSize;j++){
						stockingBatchHouseEntryInfo = stockingBatchHouseEntryCol.get(j);
						houseid = stockingBatchHouseEntryInfo.getHouse().getId().toString();
						entryList.add(houseid);
					}
					//新增公禽，母禽数量
					BigDecimal addMaleQty = BigDecimal.ZERO;
					BigDecimal addFemaleQty = BigDecimal.ZERO;
					//如果list里面不包含转出单的转入棚舍，就新增一行
					if(!entryList.contains(tranOutEntryInfo.getInHouse().getId().toString())){
						stockingBatchHouseEntryInfo = new StockingBatchHouseEntryInfo();
						//设置棚舍
						stockingBatchHouseEntryInfo.setHouse(inHouseInfo);

						//获取
						Date inDate = null;
						StockingBatchHouseEntryCollection batchCol = batchInfo.getHouseEntry();
						StockingBatchHouseEntryInfo entryHouseInfo  = null;
						entryHouseInfo = StockingBatchHouseEntryFactory.getLocalInstance(ctx).getStockingBatchHouseEntryInfo(new ObjectUuidPK(batchCol.get(0).getId()));
						inDate = entryHouseInfo.getInData();

						//设置入雏日期
						stockingBatchHouseEntryInfo.setInData(inDate);
						//设置入栏日期
						stockingBatchHouseEntryInfo.setRlData(outDate);
						//公禽数量
						stockingBatchHouseEntryInfo.setQty(addMaleQty);
						//母禽数量
						stockingBatchHouseEntryInfo.setFemaleQty(addFemaleQty);
					}
					addMaleQty = UIRuleUtil.getBigDecimal(tranOutEntryInfo.getOutmaleQty());
					addFemaleQty = UIRuleUtil.getBigDecimal(tranOutEntryInfo.getOutFemaleQty());
					//设置养殖总数
					stockingBatchInfo.setTotalQty(addMaleQty.add(addFemaleQty).add(initTottalQty));

					stockingBatchHouseEntryCol.add(stockingBatchHouseEntryInfo);
					stockingBatchInfo.getHouseEntry().addCollection(stockingBatchHouseEntryCol);
					istockingBatch.save(stockingBatchInfo);
					tranInEntryInfo.setInBbatch(stockingBatchInfo);
				} catch (EASBizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			tranInCol.add(tranInEntryInfo);
		}
		tranInInfo.getEntrys().addCollection(tranInCol);
		try {
			IObjectPK pk = itranInInfo.save(tranInInfo);
			//添加关联关系
			BotpAppCommon.addRelations(ctx,info.getBOSType().toString(), info.getId().toString(),tranInInfo.getBOSType().toString(), pk.toString());
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	/**
	 * 生成 新的批次，并将新生成的批次返回
	 * @param ctx 
	 * @param tranOutEntryInfo
	 * @param batchInfo
	 * @param info 
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private StockingBatchInfo produceNewBatch(
			Context ctx, TranOutEntryInfo tranOutEntryInfo, StockingBatchInfo batchInfo, TranOutInfo info) throws BOSException, EASBizException {

		//保存批次
		IStockingBatch iStockingBatch = null;
		//表头
		StockingBatchInfo batchInfo1 = new StockingBatchInfo();
		//分录collection
		StockingBatchHouseEntryCollection farmHouseEntryColl = new StockingBatchHouseEntryCollection();
		//分录
		StockingBatchHouseEntryInfo farmHouseEntryInfo = null;
		//财务组织
		CompanyOrgUnitInfo companyInfo = null;

		try {
			companyInfo = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(new ObjectUuidPK(info.getCompany().getId()));
			iStockingBatch = StockingBatchFactory.getLocalInstance(ctx);
		} catch (EASBizException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (BOSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//获取批次名称
		String batchName = tranOutEntryInfo.getBatchid();
		BigDecimal maleQty = BigDecimal.ZERO;
		BigDecimal femaleQty = BigDecimal.ZERO;
		//实例化分录行 
		farmHouseEntryInfo = new StockingBatchHouseEntryInfo();
		//获取转入公禽数量和母禽数量
		if(tranOutEntryInfo.getOutmaleQty() != null && !tranOutEntryInfo.getOutmaleQty().equals(new BigDecimal("0"))){
			maleQty = tranOutEntryInfo.getOutmaleQty();
		}
		if(tranOutEntryInfo.getOutFemaleQty() != null && !tranOutEntryInfo.getOutFemaleQty().equals(new BigDecimal("0"))){
			femaleQty =  tranOutEntryInfo.getOutFemaleQty();
		}

		//获取入雏时间
		Date inDate = (Date) info.getBizDate();

		//设置表头信息
		//设置编码
		batchInfo1.setNumber(batchName);
		//设置名称
		batchInfo1.setName(batchName);
		//设置财务组织
		batchInfo1.setCompany(companyInfo);
		//设置批次状态
		batchInfo1.setBaseStatus(FarmBaseStatusEnum.unApprove);


		//养殖户
		FarmersInfo farmersInfo = null;

		//设置分录信息
		//获取棚舍名称
		FarmHouseEntryInfo houseInfo =null;
		//养殖场
		FarmInfo farmInfo = null;
		//转出批次
		StockingBatchInfo stockingBatchInfo = null;
		//		转出批次棚舍分录
		//		StockingBatchHouseEntryInfo entryHouseInfo = null;
		//品种信息
		BreedDataInfo breedData = null;
		try {
			houseInfo = FarmHouseEntryFactory.getLocalInstance(ctx).getFarmHouseEntryInfo(new ObjectUuidPK(tranOutEntryInfo.getInHouse().getId()));
			farmInfo = FarmFactory.getLocalInstance(ctx).getFarmInfo(new ObjectUuidPK(tranOutEntryInfo.getInFarm().getId()));
			//转出单分录--转出批次
			stockingBatchInfo = StockingBatchFactory.getLocalInstance(ctx).getStockingBatchInfo(new ObjectUuidPK(tranOutEntryInfo.getOutBatch().getId()));

			//根据养殖场设置养殖户
			String s1 = " /*dialect*/ select t1.fid farmerid from T_FM_Farmers t1 inner join T_FM_FarmersFarmEntry t2 on t2.FParentID = t1.fid where t2.FFarmID ='"+farmInfo.getId()+"'";
			IRowSet r1 = DbUtil.executeQuery(ctx, s1.toString());
			String farmid = null;
			if(r1.next()){
				farmid = r1.getString("farmerid");
				farmersInfo = FarmersFactory.getLocalInstance(ctx).getFarmersInfo(new ObjectUuidPK(farmid));
			}

			breedData = BreedDataFactory.getLocalInstance(ctx).getBreedDataInfo(new ObjectUuidPK(stockingBatchInfo.getBreedData().getId()));
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//设置性别
		String sexValue = stockingBatchInfo.getSex().getValue();	
		if("1".equalsIgnoreCase(sexValue)){
			batchInfo1.setSex(sex.male);
		}else if("2".equalsIgnoreCase(sexValue)){
			batchInfo1.setSex(sex.female);
		}else if("3".equalsIgnoreCase(sexValue)){
			batchInfo1.setSex(sex.both);
		}

		//设置养殖户
		batchInfo1.setFarmer(farmersInfo);

		//设置养殖场
		batchInfo1.setFarm(farmInfo);
		//设置品种信息
		batchInfo1.setBreedData(breedData);
		//设置养殖总数
		batchInfo1.setTotalQty(maleQty.add(femaleQty));
		//设置上苗日期
		batchInfo1.setInDate(stockingBatchInfo.getInDate());
		//设置棚舍
		farmHouseEntryInfo.setHouse(houseInfo);

		//获取
		Date inate = null;
		StockingBatchHouseEntryCollection batchCol = batchInfo.getHouseEntry();
		StockingBatchHouseEntryInfo entryHouseInfo  = null;
		entryHouseInfo = StockingBatchHouseEntryFactory.getLocalInstance(ctx).getStockingBatchHouseEntryInfo(new ObjectUuidPK(batchCol.get(0).getId()));
		inate = entryHouseInfo.getInData();


		//设置入雏时间
		farmHouseEntryInfo.setInData(inate);
		//设置入栏日期
		farmHouseEntryInfo.setRlData(inDate);
		//		//转入公禽数量
		//		farmHouseEntryInfo.setQty(maleQty);
		//		//转入母禽数量
		//		farmHouseEntryInfo.setFemaleQty(femaleQty);

		//		try {
		//			//---------------育雏期-------
		//			//校验该批次育雏期成本对象是否已经存在，如果存在就直接赋值，不存在就生成成本对象
		//			StringBuffer sq1 = new StringBuffer();
		//			sq1.append("select t1.fid broodCostObject from T_BD_CostObject     t1 ");
		//			sq1.append(" inner join T_BD_CostObjectEntry t2 on t2.fparentid=t1.fid");
		//			sq1.append(" inner join T_BD_Material t3 on t3.fid=t2.FRelatedID");
		//			sq1.append(" inner join T_FM_StockingBatch t4 on t4.fnumber =t1.FBatchNumber");
		//			sq1.append(" inner join T_FM_BreedData  t5 on t5.fid=t4.FBreedDataID and t5.CFBroodMaterialID=t3.fid");
		//			sq1.append(" where t4.fnumber='");
		//			sq1.append(tranOutEntryInfo.getBatchid());
		//			sq1.append("'");
		//			IRowSet rs1 = DbUtil.executeQuery(ctx,sq1.toString());	
		//			String broodid = null;
		//			CostObjectInfo broodObject = null;
		//			try {
		//				if(rs1.next()){
		//					broodid = rs1.getString("broodCostObject");
		//					broodObject = CostObjectFactory.getLocalInstance(ctx).getCostObjectInfo(new ObjectUuidPK(broodid));
		//					batchInfo1.setBroodCostObject(broodObject);
		//				}else{
		//					produceBroodCostObject(ctx,breedData,tranOutEntryInfo,batchInfo,info,batchInfo1,companyInfo);
		//				}
		//			} catch (SQLException e) {
		//				// TODO Auto-generated catch block
		//				e.printStackTrace();
		//			}
		//
		//
		//			//---------------育成期-----
		//			//校验该批次育成期成本对象是否已经存在，如果存在就直接赋值，不存在就生成成本对象
		//			StringBuffer sq2 = new StringBuffer();
		//			sq2.append("select t1.fid broodCostObject from T_BD_CostObject     t1 ");
		//			sq2.append(" inner join T_BD_CostObjectEntry t2 on t2.fparentid=t1.fid");
		//			sq2.append(" inner join T_BD_Material t3 on t3.fid=t2.FRelatedID");
		//			sq2.append(" inner join T_FM_StockingBatch t4 on t4.fnumber =t1.FBatchNumber");
		//			sq2.append(" inner join T_FM_BreedData  t5 on t5.fid=t4.FBreedDataID and t5.FBridMaterialID=t3.fid");
		//			sq2.append(" where t4.fnumber='");
		//			sq2.append(tranOutEntryInfo.getBatchid());
		//			sq2.append("'");
		//			IRowSet rs2 = DbUtil.executeQuery(ctx,sq2.toString());
		//			String breedid = null;
		//			CostObjectInfo breedObject = null;
		//			if(rs2.next()){
		//				breedid = rs2.getString("broodCostObject");
		//				breedObject = CostObjectFactory.getLocalInstance(ctx).getCostObjectInfo(new ObjectUuidPK(breedid));
		//				batchInfo1.setCostItem(breedObject);
		//			}else{
		//				produceBreedCostObject(ctx,breedData,tranOutEntryInfo,batchInfo,info,batchInfo1,companyInfo);
		//			}
		//
		//			//------------预产期--------------
		//			//校验该批次预产期成本对象是否已经存在，如果存在就直接赋值，不存在就生成成本对象
		//			StringBuffer sq3 = new StringBuffer();
		//			sq3.append("select t1.fid broodCostObject from T_BD_CostObject     t1 ");
		//			sq3.append(" inner join T_BD_CostObjectEntry t2 on t2.fparentid=t1.fid");
		//			sq3.append(" inner join T_BD_Material t3 on t3.fid=t2.FRelatedID");
		//			sq3.append(" inner join T_FM_StockingBatch t4 on t4.fnumber =t1.FBatchNumber");
		//			sq3.append(" inner join T_FM_BreedData  t5 on t5.fid=t4.FBreedDataID and t5.CFPreEggMaterialID=t3.fid");
		//			sq3.append(" where t4.fnumber='");
		//			sq3.append(tranOutEntryInfo.getBatchid());
		//			sq3.append("'");
		//			IRowSet rs3 = DbUtil.executeQuery(ctx,sq3.toString());
		//			String preEggid = null;
		//			CostObjectInfo preEggObject = null;
		//			if(rs3.next()){
		//				preEggid = rs3.getString("broodCostObject");
		//				preEggObject = CostObjectFactory.getLocalInstance(ctx).getCostObjectInfo(new ObjectUuidPK(preEggid));
		//				batchInfo1.setPreCostObject(preEggObject);
		//			}else{
		//				producePreEggCostObject(ctx,breedData,tranOutEntryInfo,batchInfo,info,batchInfo1,companyInfo);
		//			}
		//
		//			//批次的前8位
		//			String costNum = tranOutEntryInfo.getBatchid().substring(0,8);
		//
		//
		//			//---------产蛋期--------
		//			//校验该批次产蛋期成本对象是否已经存在，如果存在就直接赋值，不存在就生成成本对象
		//			StringBuffer sq4 = new StringBuffer();
		//			sq4.append("/*dialect*/ select  distinct  t1.fid broodCostObject from T_BD_CostObject     t1 ");
		//			sq4.append(" inner join T_BD_CostObjectEntry t2 on t2.fparentid=t1.fid");
		//			sq4.append(" inner join T_BD_Material t3 on t3.fid=t2.FRelatedID");
		//			sq4.append(" inner join T_FM_StockingBatch t4 on  substr(t4.fnumber,0,8) = substr(t1.FBatchNumber,0,8)");
		//			sq4.append(" inner join T_FM_BreedData  t5 on t5.fid=t4.FBreedDataID and t5.CFEggMaterialID=t3.fid");
		//			sq4.append(" where substr(t4.fnumber,0,8)='");
		//			sq4.append(costNum);
		//			sq4.append("'");
		//			IRowSet rs4 = DbUtil.executeQuery(ctx,sq4.toString());
		//			String Eggid = null;
		//			CostObjectInfo EggObject = null;
		//			if(rs4.next()){
		//				Eggid = rs4.getString("broodCostObject");
		//				EggObject = CostObjectFactory.getLocalInstance(ctx).getCostObjectInfo(new ObjectUuidPK(Eggid));
		//				batchInfo1.setEggCostItem(EggObject);
		//			}else{
		//				produceEggCostObject(ctx,breedData,tranOutEntryInfo,batchInfo,info,batchInfo1,companyInfo);
		//			}
		//		} catch (SQLException e1) {
		//			// TODO Auto-generated catch block
		//			e1.printStackTrace();
		//		}
		farmHouseEntryColl.add(farmHouseEntryInfo);
		batchInfo1.getHouseEntry().addCollection(farmHouseEntryColl);
		try {
			iStockingBatch.save(batchInfo1);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BOSException(e.getMessage());
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BOSException(e.getMessage());
		}
		return batchInfo1;
	}




	/**
	 * 创建育雏期成本对象
	 * @param ctx
	 * @param companyInfo 
	 * @param batchInfo1 
	 * @param info 
	 * @param batchInfo 
	 * @param tranOutEntryInfo 
	 * @param breedData 
	 * @throws BOSException 
	 */
	private void produceBroodCostObject(Context ctx, BreedDataInfo breedData,
			TranOutEntryInfo tranOutEntryInfo, StockingBatchInfo batchInfo,
			TranOutInfo info, StockingBatchInfo batchInfo1, CompanyOrgUnitInfo companyInfo2) throws BOSException {
		// TODO Auto-generated method stub

		//获取批次名称
		String batchNum = tranOutEntryInfo.getBatchid();
		//获取品种信息
		BreedDataInfo breedDataInfo = null;
		//获取财务组织
		CompanyOrgUnitInfo companyInfo = null;
		//获取品种信息育雏期物料
		MaterialInfo broodMatInfo = null;
		//成本对象
		ICostObject iCostObject = null;

		//育成期、预产期成本对象分组
		String broodObjectGroupid = "xZ4+MUw2QA6VSzS9nkSsYsw5rkg=";
		CostObjectGroupInfo broodObjectGroup = null;
		//产蛋期,种蛋期成本对象分组
		String eggObjectGroupid = "ISxtCxmlRI6UedcfrsoGhsw5rkg=";
		CostObjectGroupInfo eggObjectGroup = null;

		try {
			//成本对象保存
			iCostObject = CostObjectFactory.getLocalInstance(ctx);
			//育成期、预产期成本对象分组
			broodObjectGroup = CostObjectGroupFactory.getLocalInstance(ctx).getCostObjectGroupInfo(new ObjectUuidPK(broodObjectGroupid));
			//产蛋期
			eggObjectGroup = CostObjectGroupFactory.getLocalInstance(ctx).getCostObjectGroupInfo(new ObjectUuidPK(eggObjectGroupid));
			//财务组织
			companyInfo = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(new ObjectUuidPK(companyInfo2.getId().toString()));
			//品种资料
			breedDataInfo = BreedDataFactory.getLocalInstance(ctx).getBreedDataInfo(new ObjectUuidPK(breedData.getId().toString()));
			//育雏期物料
			if(breedDataInfo.getBroodMaterial() != null){
				broodMatInfo = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(breedDataInfo.getBroodMaterial().getId().toString()));
			}else{
				throw new BOSException("品种资料的育雏期物料没有设置！");
			}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//设置育雏成本对象编码名称
		String broodCostObjectN = batchNum+"-"+broodMatInfo.getName().toString();

		//----------------------------------育雏期--------------------------------------
		//育雏期成本对象表头
		CostObjectInfo broodCostObjectInfo = new CostObjectInfo();
		//分录
		CostObjectEntryInfo broodEntryCostObjectInfo = new CostObjectEntryInfo();

		broodCostObjectInfo.setId(BOSUuid.create(broodCostObjectInfo.getBOSType()));

		//名称
		broodCostObjectInfo.setName(broodCostObjectN);
		//编码
		broodCostObjectInfo.setNumber(broodCostObjectN);
		//批次
		broodCostObjectInfo.setBatchNumber(batchNum);
		//财务组织
		broodCostObjectInfo.setCompany(companyInfo);
		//关联类型--产品
		broodCostObjectInfo.setRelatedType(CORelatedType.Product);
		//成本计算方法--分批法
		broodCostObjectInfo.setCalculateMode(CalculateModeEnum.BYBATCH);
		broodCostObjectInfo.setRelatedId(broodMatInfo.getId());//物料id
		broodCostObjectInfo.setRelatedNumber(broodMatInfo.getNumber());
		broodCostObjectInfo.setRelatedName(broodMatInfo.getName());
		broodCostObjectInfo.setCostObjectGroup(broodObjectGroup);//成本对象分组
		broodCostObjectInfo.setStdProductID(broodMatInfo);//关联物料

		//分录
		broodEntryCostObjectInfo.setIsMainProduct(true);
		broodEntryCostObjectInfo.setQuotiety(BigDecimal.ZERO);
		broodEntryCostObjectInfo.setRelatedID(broodMatInfo.getId());
		broodEntryCostObjectInfo.setRelatedNumber(broodMatInfo.getNumber());
		broodEntryCostObjectInfo.setRelatedName(broodMatInfo.getName());
		broodCostObjectInfo.getEntries().add(broodEntryCostObjectInfo);


		try {
			//育雏期成本对象保存
			iCostObject.save(broodCostObjectInfo);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CostObjectInfo broodObject = null;
		if(broodCostObjectInfo.getId() != null){
			try {
				broodObject = CostObjectFactory.getLocalInstance(ctx).getCostObjectInfo(new ObjectUuidPK(broodCostObjectInfo.getId()));
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			batchInfo1.setBroodCostObject(broodObject);
		}else{
			throw new BOSException("育雏期成本对象没有生成！");
		}
	}

	/**
	 * 创建育成期成本对象
	 * @param ctx
	 * @param companyInfo 
	 * @param batchInfo1 
	 * @param info 
	 * @param batchInfo 
	 * @param tranOutEntryInfo 
	 * @param breedData 
	 * @throws BOSException 
	 */
	private void produceBreedCostObject(Context ctx, BreedDataInfo breedData,
			TranOutEntryInfo tranOutEntryInfo, StockingBatchInfo batchInfo,
			TranOutInfo info, StockingBatchInfo batchInfo1, CompanyOrgUnitInfo companyInfo2) throws BOSException {

		//获取批次名称
		String batchNum = tranOutEntryInfo.getBatchid();
		//获取品种信息
		BreedDataInfo breedDataInfo = null;
		//获取财务组织
		CompanyOrgUnitInfo companyInfo = null;
		//获取品种信息育成期物料
		MaterialInfo breedMatInfo = null;
		//成本对象
		ICostObject iCostObject = null;

		//育成期、预产期成本对象分组
		String broodObjectGroupid = "xZ4+MUw2QA6VSzS9nkSsYsw5rkg=";
		CostObjectGroupInfo broodObjectGroup = null;

		try {
			//成本对象保存
			iCostObject = CostObjectFactory.getLocalInstance(ctx);
			//育成期、预产期成本对象分组
			broodObjectGroup = CostObjectGroupFactory.getLocalInstance(ctx).getCostObjectGroupInfo(new ObjectUuidPK(broodObjectGroupid));
			//财务组织
			companyInfo = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(new ObjectUuidPK(companyInfo2.getId().toString()));
			//品种资料
			breedDataInfo = BreedDataFactory.getLocalInstance(ctx).getBreedDataInfo(new ObjectUuidPK(breedData.getId().toString()));
			//育成期物料
			if(breedDataInfo.getBridMaterial() != null){
				breedMatInfo = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(breedDataInfo.getBridMaterial().getId().toString()));
			}else{
				throw new BOSException("品种资料的育成期物料没有设置！");
			}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//设置育成成本对象编码名称
		String breedCostObjectN = batchNum+"-"+breedMatInfo.getName().toString();



		//----------------------------------育成期--------------------------------------
		//育成期成本对象表头
		CostObjectInfo breedCostObjectInfo = new CostObjectInfo();
		//分录
		CostObjectEntryInfo breedEntryCostObjectInfo = new CostObjectEntryInfo();

		breedCostObjectInfo.setId(BOSUuid.create(breedCostObjectInfo.getBOSType()));

		//名称
		breedCostObjectInfo.setName(breedCostObjectN);
		//编码
		breedCostObjectInfo.setNumber(breedCostObjectN);
		//批次
		breedCostObjectInfo.setBatchNumber(batchNum);
		//财务组织
		breedCostObjectInfo.setCompany(companyInfo);
		//关联类型--产品
		breedCostObjectInfo.setRelatedType(CORelatedType.Product);
		//成本计算方法--分批法
		breedCostObjectInfo.setCalculateMode(CalculateModeEnum.BYBATCH);
		breedCostObjectInfo.setRelatedId(breedMatInfo.getId());//物料id
		breedCostObjectInfo.setRelatedNumber(breedMatInfo.getNumber());
		breedCostObjectInfo.setRelatedName(breedMatInfo.getName());
		breedCostObjectInfo.setCostObjectGroup(broodObjectGroup);//成本对象分组
		breedCostObjectInfo.setStdProductID(breedMatInfo);//关联物料

		//分录
		breedEntryCostObjectInfo.setIsMainProduct(true);
		breedEntryCostObjectInfo.setQuotiety(BigDecimal.ZERO);
		breedEntryCostObjectInfo.setRelatedID(breedMatInfo.getId());
		breedEntryCostObjectInfo.setRelatedNumber(breedMatInfo.getNumber());
		breedEntryCostObjectInfo.setRelatedName(breedMatInfo.getName());
		breedCostObjectInfo.getEntries().add(breedEntryCostObjectInfo);


		try {
			//育成期成本对象保存
			iCostObject.save(breedCostObjectInfo);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		CostObjectInfo breedObject = null;


		if(breedCostObjectInfo.getId() != null){
			try {
				breedObject = CostObjectFactory.getLocalInstance(ctx).getCostObjectInfo(new ObjectUuidPK(breedCostObjectInfo.getId()));
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			batchInfo1.setCostItem(breedObject);
		}else{
			throw new BOSException("育成期成本对象没有生成！");
		}

	}

	/**
	 * 创建预产期成本对象
	 * @param ctx
	 * @param companyInfo 
	 * @param batchInfo1 
	 * @param info 
	 * @param batchInfo 
	 * @param tranOutEntryInfo 
	 * @param breedData 
	 * @throws BOSException 
	 */
	private void producePreEggCostObject(Context ctx, BreedDataInfo breedData,
			TranOutEntryInfo tranOutEntryInfo, StockingBatchInfo batchInfo,
			TranOutInfo info, StockingBatchInfo batchInfo1, CompanyOrgUnitInfo companyInfo2) throws BOSException {
		// TODO Auto-generated method stub

		//获取批次名称
		String batchNum = tranOutEntryInfo.getBatchid();
		//获取品种信息
		BreedDataInfo breedDataInfo = null;
		//获取财务组织
		CompanyOrgUnitInfo companyInfo = null;
		//获取品种信息预产期物料
		MaterialInfo preEggMatInfo = null;
		//成本对象
		ICostObject iCostObject = null;

		//产蛋期,种蛋期成本对象分组
		String eggObjectGroupid = "ISxtCxmlRI6UedcfrsoGhsw5rkg=";
		CostObjectGroupInfo eggObjectGroup = null;

		try {
			//成本对象保存
			iCostObject = CostObjectFactory.getLocalInstance(ctx);
			//产蛋期
			eggObjectGroup = CostObjectGroupFactory.getLocalInstance(ctx).getCostObjectGroupInfo(new ObjectUuidPK(eggObjectGroupid));
			//财务组织
			companyInfo = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(new ObjectUuidPK(companyInfo2.getId().toString()));
			//品种资料
			breedDataInfo = BreedDataFactory.getLocalInstance(ctx).getBreedDataInfo(new ObjectUuidPK(breedData.getId().toString()));
			//预产期物料
			if(breedDataInfo.getPreEggMaterial() != null){
				preEggMatInfo = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(breedDataInfo.getPreEggMaterial().getId().toString()));
			}else{
				throw new BOSException("品种资料的预产期物料没有设置！");
			}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//设置预产成本对象编码名称
		String preEggCostObjectN = batchNum+"-"+preEggMatInfo.getName().toString();



		//----------------------------------预产期--------------------------------------
		//预产期成本对象表头
		CostObjectInfo preCostObjectInfo = new CostObjectInfo();
		//分录
		CostObjectEntryInfo preEntryCostObjectInfo = new CostObjectEntryInfo();

		preCostObjectInfo.setId(BOSUuid.create(preCostObjectInfo.getBOSType()));

		//名称
		preCostObjectInfo.setName(preEggCostObjectN);
		//编码
		preCostObjectInfo.setNumber(preEggCostObjectN);
		//批次
		preCostObjectInfo.setBatchNumber(batchNum);
		//财务组织
		preCostObjectInfo.setCompany(companyInfo);
		//关联类型--产品
		preCostObjectInfo.setRelatedType(CORelatedType.Product);
		//成本计算方法--分批法
		preCostObjectInfo.setCalculateMode(CalculateModeEnum.BYBATCH);
		preCostObjectInfo.setRelatedId(preEggMatInfo.getId());//物料id
		preCostObjectInfo.setRelatedNumber(preEggMatInfo.getNumber());
		preCostObjectInfo.setRelatedName(preEggMatInfo.getName());
		preCostObjectInfo.setCostObjectGroup(eggObjectGroup);//成本对象分组
		preCostObjectInfo.setStdProductID(preEggMatInfo);//关联物料

		//分录
		preEntryCostObjectInfo.setIsMainProduct(true);
		preEntryCostObjectInfo.setQuotiety(BigDecimal.ZERO);
		preEntryCostObjectInfo.setRelatedID(preEggMatInfo.getId());
		preEntryCostObjectInfo.setRelatedNumber(preEggMatInfo.getNumber());
		preEntryCostObjectInfo.setRelatedName(preEggMatInfo.getName());
		preCostObjectInfo.getEntries().add(preEntryCostObjectInfo);


		try {
			//预产期成本对象保存
			iCostObject.save(preCostObjectInfo);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		CostObjectInfo preObject = null;

		if(preCostObjectInfo.getId() != null){
			try {
				preObject = CostObjectFactory.getLocalInstance(ctx).getCostObjectInfo(new ObjectUuidPK(preCostObjectInfo.getId()));
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			batchInfo1.setPreCostObject(preObject);
		}else{
			throw new BOSException("预产期成本对象没有生成！");
		}
	}

	/**
	 * 创建产蛋期成本对象
	 * @param ctx
	 * @param breedData
	 * @param tranOutEntryInfo
	 * @param batchInfo
	 * @param info
	 * @param batchInfo1
	 * @param companyInfo
	 * @throws BOSException 
	 */
	private void produceEggCostObject(Context ctx, BreedDataInfo breedData,
			TranOutEntryInfo tranOutEntryInfo, StockingBatchInfo batchInfo,
			TranOutInfo info, StockingBatchInfo batchInfo1, CompanyOrgUnitInfo companyInfo2) throws BOSException {
		// TODO Auto-generated method stub

		//获取批次名称
		String batchNum = tranOutEntryInfo.getBatchid();
		//获取品种信息
		BreedDataInfo breedDataInfo = null;
		//获取财务组织
		CompanyOrgUnitInfo companyInfo = null;
		//获取品种信息产蛋期物料
		MaterialInfo eggMatInfo = null;
		//成本对象
		ICostObject iCostObject = null;

		//产蛋期,种蛋期成本对象分组
		String eggObjectGroupid = "ISxtCxmlRI6UedcfrsoGhsw5rkg=";
		CostObjectGroupInfo eggObjectGroup = null;

		try {
			//成本对象保存
			iCostObject = CostObjectFactory.getLocalInstance(ctx);
			//产蛋期
			eggObjectGroup = CostObjectGroupFactory.getLocalInstance(ctx).getCostObjectGroupInfo(new ObjectUuidPK(eggObjectGroupid));
			//财务组织
			companyInfo = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(new ObjectUuidPK(companyInfo2.getId().toString()));
			//品种资料
			breedDataInfo = BreedDataFactory.getLocalInstance(ctx).getBreedDataInfo(new ObjectUuidPK(breedData.getId().toString()));
			//产蛋期物料
			if(breedDataInfo.getEggMaterial() != null){
				eggMatInfo = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(breedDataInfo.getEggMaterial().getId().toString()));
			}else{
				throw new BOSException("品种资料的产蛋期物料没有设置！");
			}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//设置产蛋成本对象编码名称
		String eggCostObjectN = batchNum.substring(0,8)+eggMatInfo.getName().toString();

		//----------------------------------产蛋期--------------------------------------
		//产蛋期成本对象表头
		CostObjectInfo eggCostObjectInfo = new CostObjectInfo();
		//分录
		CostObjectEntryInfo eggEntryCostObjectInfo = new CostObjectEntryInfo();

		eggCostObjectInfo.setId(BOSUuid.create(eggCostObjectInfo.getBOSType()));

		//名称
		eggCostObjectInfo.setName(eggCostObjectN);
		//编码
		eggCostObjectInfo.setNumber(eggCostObjectN);
		//批次
		eggCostObjectInfo.setBatchNumber(batchNum);
		//财务组织
		eggCostObjectInfo.setCompany(companyInfo);
		//关联类型--产品
		eggCostObjectInfo.setRelatedType(CORelatedType.Product);
		//成本计算方法--分批法
		eggCostObjectInfo.setCalculateMode(CalculateModeEnum.BYBATCH);
		eggCostObjectInfo.setRelatedId(eggMatInfo.getId());//物料id
		eggCostObjectInfo.setRelatedNumber(eggMatInfo.getNumber());
		eggCostObjectInfo.setRelatedName(eggMatInfo.getName());
		eggCostObjectInfo.setCostObjectGroup(eggObjectGroup);//成本对象分组
		eggCostObjectInfo.setStdProductID(eggMatInfo);//关联物料

		//分录
		eggEntryCostObjectInfo.setIsMainProduct(true);
		eggEntryCostObjectInfo.setQuotiety(BigDecimal.ZERO);
		eggEntryCostObjectInfo.setRelatedID(eggMatInfo.getId());
		eggEntryCostObjectInfo.setRelatedNumber(eggMatInfo.getNumber());
		eggEntryCostObjectInfo.setRelatedName(eggMatInfo.getName());
		eggCostObjectInfo.getEntries().add(eggEntryCostObjectInfo);

		try {
			//产蛋期成本对象保存
			iCostObject.save(eggCostObjectInfo);

		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CostObjectInfo eggObject = null;

		if(eggCostObjectInfo.getId() != null){
			try {
				eggObject = CostObjectFactory.getLocalInstance(ctx).getCostObjectInfo(new ObjectUuidPK(eggCostObjectInfo.getId()));
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			batchInfo1.setEggCostItem(eggObject);
		}else{
			throw new BOSException("产蛋期成本对象没有生成！");
		}




	}



	/**
	 * 生成成本对象
	 * @param ctx
	 * @param breedData
	 * @param tranOutEntryInfo
	 * @param batchInfo
	 * @param info
	 * @param batchInfo1 
	 * @param companyInfo2 
	 */
	private void produceCostObject(Context ctx, BreedDataInfo breedData,
			TranOutEntryInfo tranOutEntryInfo, StockingBatchInfo batchInfo,
			TranOutInfo info, StockingBatchInfo batchInfo1, CompanyOrgUnitInfo companyInfo2
	) throws BOSException,EASBizException {

		//获取批次名称
		String batchNum = tranOutEntryInfo.getBatchid();
		//获取品种信息
		BreedDataInfo breedDataInfo = null;
		//获取财务组织
		CompanyOrgUnitInfo companyInfo = null;
		//获取品种信息育雏期物料
		MaterialInfo broodMatInfo = null;
		//获取品种信息育成期物料
		MaterialInfo breedMatInfo = null;
		//获取品种信息预产期物料
		MaterialInfo preEggMatInfo = null;
		//获取品种信息产蛋期物料
		MaterialInfo eggMatInfo = null;
		//成本对象
		ICostObject iCostObject = null;

		//育成期、预产期成本对象分组
		String broodObjectGroupid = "xZ4+MUw2QA6VSzS9nkSsYsw5rkg=";
		CostObjectGroupInfo broodObjectGroup = null;
		//产蛋期,种蛋期成本对象分组
		String eggObjectGroupid = "ISxtCxmlRI6UedcfrsoGhsw5rkg=";
		CostObjectGroupInfo eggObjectGroup = null;

		try {
			//成本对象保存
			iCostObject = CostObjectFactory.getLocalInstance(ctx);
			//育成期、预产期成本对象分组
			broodObjectGroup = CostObjectGroupFactory.getLocalInstance(ctx).getCostObjectGroupInfo(new ObjectUuidPK(broodObjectGroupid));
			//产蛋期
			eggObjectGroup = CostObjectGroupFactory.getLocalInstance(ctx).getCostObjectGroupInfo(new ObjectUuidPK(eggObjectGroupid));
			//财务组织
			companyInfo = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(new ObjectUuidPK(companyInfo2.getId().toString()));
			//品种资料
			breedDataInfo = BreedDataFactory.getLocalInstance(ctx).getBreedDataInfo(new ObjectUuidPK(breedData.getId().toString()));
			//育雏期物料
			if(breedDataInfo.getBroodMaterial() != null){
				broodMatInfo = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(breedDataInfo.getBroodMaterial().getId().toString()));
			}else{
				throw new BOSException("品种资料的育雏期物料没有设置！");
			}
			//育成期物料
			if(breedDataInfo.getBridMaterial() != null){
				breedMatInfo = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(breedDataInfo.getBridMaterial().getId().toString()));
			}else{
				throw new BOSException("品种资料的育成期物料没有设置！");
			}
			//预产期物料
			if(breedDataInfo.getPreEggMaterial() != null){
				preEggMatInfo = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(breedDataInfo.getPreEggMaterial().getId().toString()));
			}else{
				throw new BOSException("品种资料的预产期物料没有设置！");
			}
			//产蛋期物料
			if(breedDataInfo.getEggMaterial() != null){
				eggMatInfo = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(breedDataInfo.getEggMaterial().getId().toString()));
			}else{
				throw new BOSException("品种资料的产蛋期物料没有设置！");
			}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//设置育雏成本对象编码名称
		String broodCostObjectN = batchNum+"-"+broodMatInfo.getName().toString();
		//设置育成成本对象编码名称
		String breedCostObjectN = batchNum+"-"+breedMatInfo.getName().toString();
		//设置预产成本对象编码名称
		String preEggCostObjectN = batchNum+"-"+preEggMatInfo.getName().toString();
		//设置产蛋成本对象编码名称
		String eggCostObjectN = batchNum+"-"+eggMatInfo.getName().toString();



		//----------------------------------育雏期--------------------------------------
		//育雏期成本对象表头
		CostObjectInfo broodCostObjectInfo = new CostObjectInfo();
		//分录
		CostObjectEntryInfo broodEntryCostObjectInfo = new CostObjectEntryInfo();

		broodCostObjectInfo.setId(BOSUuid.create(broodCostObjectInfo.getBOSType()));

		//名称
		broodCostObjectInfo.setName(broodCostObjectN);
		//编码
		broodCostObjectInfo.setNumber(broodCostObjectN);
		//批次
		broodCostObjectInfo.setBatchNumber(batchNum);
		//财务组织
		broodCostObjectInfo.setCompany(companyInfo);
		//关联类型--产品
		broodCostObjectInfo.setRelatedType(CORelatedType.Product);
		//成本计算方法--分批法
		broodCostObjectInfo.setCalculateMode(CalculateModeEnum.BYBATCH);
		broodCostObjectInfo.setRelatedId(broodMatInfo.getId());//物料id
		broodCostObjectInfo.setRelatedNumber(broodMatInfo.getNumber());
		broodCostObjectInfo.setRelatedName(broodMatInfo.getName());
		broodCostObjectInfo.setCostObjectGroup(broodObjectGroup);//成本对象分组
		broodCostObjectInfo.setStdProductID(broodMatInfo);//关联物料

		//分录
		broodEntryCostObjectInfo.setIsMainProduct(true);
		broodEntryCostObjectInfo.setQuotiety(BigDecimal.ZERO);
		broodEntryCostObjectInfo.setRelatedID(broodMatInfo.getId());
		broodEntryCostObjectInfo.setRelatedNumber(broodMatInfo.getNumber());
		broodEntryCostObjectInfo.setRelatedName(broodMatInfo.getName());
		broodCostObjectInfo.getEntries().add(broodEntryCostObjectInfo);

		//----------------------------------育成期--------------------------------------
		//育成期成本对象表头
		CostObjectInfo breedCostObjectInfo = new CostObjectInfo();
		//分录
		CostObjectEntryInfo breedEntryCostObjectInfo = new CostObjectEntryInfo();

		breedCostObjectInfo.setId(BOSUuid.create(breedCostObjectInfo.getBOSType()));

		//名称
		breedCostObjectInfo.setName(breedCostObjectN);
		//编码
		breedCostObjectInfo.setNumber(breedCostObjectN);
		//批次
		breedCostObjectInfo.setBatchNumber(batchNum);
		//财务组织
		breedCostObjectInfo.setCompany(companyInfo);
		//关联类型--产品
		breedCostObjectInfo.setRelatedType(CORelatedType.Product);
		//成本计算方法--分批法
		breedCostObjectInfo.setCalculateMode(CalculateModeEnum.BYBATCH);
		breedCostObjectInfo.setRelatedId(breedMatInfo.getId());//物料id
		breedCostObjectInfo.setRelatedNumber(breedMatInfo.getNumber());
		breedCostObjectInfo.setRelatedName(breedMatInfo.getName());
		breedCostObjectInfo.setCostObjectGroup(broodObjectGroup);//成本对象分组
		breedCostObjectInfo.setStdProductID(breedMatInfo);//关联物料

		//分录
		breedEntryCostObjectInfo.setIsMainProduct(true);
		breedEntryCostObjectInfo.setQuotiety(BigDecimal.ZERO);
		breedEntryCostObjectInfo.setRelatedID(breedMatInfo.getId());
		breedEntryCostObjectInfo.setRelatedNumber(breedMatInfo.getNumber());
		breedEntryCostObjectInfo.setRelatedName(breedMatInfo.getName());
		breedCostObjectInfo.getEntries().add(breedEntryCostObjectInfo);

		//----------------------------------预产期--------------------------------------
		//预产期成本对象表头
		CostObjectInfo preCostObjectInfo = new CostObjectInfo();
		//分录
		CostObjectEntryInfo preEntryCostObjectInfo = new CostObjectEntryInfo();

		preCostObjectInfo.setId(BOSUuid.create(preCostObjectInfo.getBOSType()));

		//名称
		preCostObjectInfo.setName(preEggCostObjectN);
		//编码
		preCostObjectInfo.setNumber(preEggCostObjectN);
		//批次
		preCostObjectInfo.setBatchNumber(batchNum);
		//财务组织
		preCostObjectInfo.setCompany(companyInfo);
		//关联类型--产品
		preCostObjectInfo.setRelatedType(CORelatedType.Product);
		//成本计算方法--分批法
		preCostObjectInfo.setCalculateMode(CalculateModeEnum.BYBATCH);
		preCostObjectInfo.setRelatedId(preEggMatInfo.getId());//物料id
		preCostObjectInfo.setRelatedNumber(preEggMatInfo.getNumber());
		preCostObjectInfo.setRelatedName(preEggMatInfo.getName());
		preCostObjectInfo.setCostObjectGroup(eggObjectGroup);//成本对象分组
		preCostObjectInfo.setStdProductID(preEggMatInfo);//关联物料

		//分录
		preEntryCostObjectInfo.setIsMainProduct(true);
		preEntryCostObjectInfo.setQuotiety(BigDecimal.ZERO);
		preEntryCostObjectInfo.setRelatedID(preEggMatInfo.getId());
		preEntryCostObjectInfo.setRelatedNumber(preEggMatInfo.getNumber());
		preEntryCostObjectInfo.setRelatedName(preEggMatInfo.getName());
		preCostObjectInfo.getEntries().add(preEntryCostObjectInfo);

		//----------------------------------产蛋期--------------------------------------
		//产蛋期成本对象表头
		CostObjectInfo eggCostObjectInfo = new CostObjectInfo();
		//分录
		CostObjectEntryInfo eggEntryCostObjectInfo = new CostObjectEntryInfo();

		eggCostObjectInfo.setId(BOSUuid.create(eggCostObjectInfo.getBOSType()));

		//名称
		eggCostObjectInfo.setName(eggCostObjectN);
		//编码
		eggCostObjectInfo.setNumber(eggCostObjectN);
		//批次
		eggCostObjectInfo.setBatchNumber(batchNum);
		//财务组织
		eggCostObjectInfo.setCompany(companyInfo);
		//关联类型--产品
		eggCostObjectInfo.setRelatedType(CORelatedType.Product);
		//成本计算方法--分批法
		eggCostObjectInfo.setCalculateMode(CalculateModeEnum.BYBATCH);
		eggCostObjectInfo.setRelatedId(eggMatInfo.getId());//物料id
		eggCostObjectInfo.setRelatedNumber(eggMatInfo.getNumber());
		eggCostObjectInfo.setRelatedName(eggMatInfo.getName());
		eggCostObjectInfo.setCostObjectGroup(eggObjectGroup);//成本对象分组
		eggCostObjectInfo.setStdProductID(eggMatInfo);//关联物料

		//分录
		eggEntryCostObjectInfo.setIsMainProduct(true);
		eggEntryCostObjectInfo.setQuotiety(BigDecimal.ZERO);
		eggEntryCostObjectInfo.setRelatedID(eggMatInfo.getId());
		eggEntryCostObjectInfo.setRelatedNumber(eggMatInfo.getNumber());
		eggEntryCostObjectInfo.setRelatedName(eggMatInfo.getName());
		eggCostObjectInfo.getEntries().add(eggEntryCostObjectInfo);

		try {
			//育雏期成本对象保存
			iCostObject.save(broodCostObjectInfo);
			//育成期成本对象保存
			iCostObject.save(breedCostObjectInfo);
			//预产期成本对象保存
			iCostObject.save(preCostObjectInfo);
			//产蛋期成本对象保存
			iCostObject.save(eggCostObjectInfo);

		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EASBizException(new NumericExceptionSubItem("0002",e.getMessage()));

		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		CostObjectInfo broodObject = null;
		CostObjectInfo breedObject = null;
		CostObjectInfo preObject = null;
		CostObjectInfo eggObject = null;

		if(broodCostObjectInfo.getId() != null){
			try {
				broodObject = CostObjectFactory.getLocalInstance(ctx).getCostObjectInfo(new ObjectUuidPK(broodCostObjectInfo.getId()));
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			batchInfo1.setBroodCostObject(broodObject);
		}else{
			throw new BOSException("育雏期成本对象没有生成！");
		}

		if(breedCostObjectInfo.getId() != null){
			try {
				breedObject = CostObjectFactory.getLocalInstance(ctx).getCostObjectInfo(new ObjectUuidPK(breedCostObjectInfo.getId()));
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			batchInfo1.setCostItem(breedObject);
		}else{
			throw new BOSException("预产期成本对象没有生成！");
		}


		if(preCostObjectInfo.getId() != null){
			try {
				preObject = CostObjectFactory.getLocalInstance(ctx).getCostObjectInfo(new ObjectUuidPK(preCostObjectInfo.getId()));
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			batchInfo1.setPreCostObject(preObject);
		}else{
			throw new BOSException("预产期成本对象没有生成！");
		}

		if(eggCostObjectInfo.getId() != null){
			try {
				eggObject = CostObjectFactory.getLocalInstance(ctx).getCostObjectInfo(new ObjectUuidPK(eggCostObjectInfo.getId()));
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			batchInfo1.setEggCostItem(eggObject);
		}else{
			throw new BOSException("产蛋期成本对象没有生成！");
		}

	}




	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		TranOutInfo info = (TranOutInfo)model;
		if(info.getBaseStatus()==null||info.getBaseStatus().equals(wzBillBaseStatus.add)) {
			info.setBaseStatus(wzBillBaseStatus.save);
		}
		return super._save(ctx, model);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		TranOutInfo info = (TranOutInfo)model;
		if(info.getBaseStatus()==null||info.getBaseStatus().equals(wzBillBaseStatus.add)||info.getBaseStatus().equals(wzBillBaseStatus.save)) {
			info.setBaseStatus(wzBillBaseStatus.submit);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		}
		return super._submit(ctx, model);
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		TranOutInfo info = (TranOutInfo)model;
		if(DbUtil.executeQuery(ctx, "select * from T_BOT_Relation where FSrcObjectID='"+info.getString("id")+"'").size()>0)
			throw new EASBizException(new NumericExceptionSubItem("001","有下游单据的单据禁止反审核"));

		info.setBaseStatus(wzBillBaseStatus.save);
		info.setAuditTime(null);
		info.setAuditor(null);

		TranOutEntryCollection coll = info.getEntrys();
		TranOutEntryInfo entryInfo = null;
		for(int i = 0,size = info.getEntrys().size();i<size;i++){
			entryInfo = coll.get(i);

			//校验是否已经生成新的批次
			String billNum = entryInfo.getBatchid();
			if(billNum != null){
				String s1 = "/*dialect*/ select t1.fid batchid from T_FM_StockingBatch t1 where fnumber = '"+billNum+"'";
				IRowSet r1 = DbUtil.executeQuery(ctx, s1);
				String batchid = null;
				try {
					if(r1.next()){
						batchid = r1.getString("batchid");
						if(batchid != null){
							throw new EASBizException(new NumericExceptionSubItem("001","已存在批次信息，不允许反审核！"));
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				//反写已存在批次的养殖总数，再远的基础上减去 公禽和母禽的数量
				StockingBatchInfo stockingBatchInfo = StockingBatchFactory.getLocalInstance(ctx).getStockingBatchInfo(new ObjectUuidPK(entryInfo.getInBbatch().getId()));
				BigDecimal maleQty = UIRuleUtil.getBigDecimal(entryInfo.getOutmaleQty());
				BigDecimal femaleQty = UIRuleUtil.getBigDecimal(entryInfo.getOutFemaleQty());
				BigDecimal actualQty = stockingBatchInfo.getTotalQty().subtract(maleQty).subtract(femaleQty);
				String s2 = "/*dialect*/ update T_FM_StockingBatch set FTotalQty = "+actualQty+"  where fid = '"+stockingBatchInfo.getId()+"'";
				com.kingdee.eas.util.app.DbUtil.execute(ctx, s2.toString());
			}

		}


		try {
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw  new BOSException(e);
		}
		super._unAudit(ctx, model);
	}


}