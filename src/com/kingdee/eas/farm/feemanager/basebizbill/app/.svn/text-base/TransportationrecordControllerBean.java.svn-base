package com.kingdee.eas.farm.feemanager.basebizbill.app;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.feemanager.basebizbill.BillStatusEnum;
import com.kingdee.eas.farm.feemanager.basebizbill.CalfrightFacadeFactory;
import com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordAssEntryCollection;
import com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordAssEntryInfo;
import com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordCollection;
import com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordEntryCollection;
import com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordEntryFactory;
import com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordEntryInfo;
import com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordFactory;
import com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordInfo;
import com.kingdee.eas.farm.feemanager.basedata.CarriageFormatInfo;
import com.kingdee.eas.farm.stocking.processbizill.BatchContractFactory;
import com.kingdee.eas.farm.stocking.processbizill.BatchContractInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class TransportationrecordControllerBean extends AbstractTransportationrecordControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.feemanager.basebizbill.app.TransportationrecordControllerBean");
    @Override 
    //审核
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
    	TransportationrecordInfo info = (TransportationrecordInfo) model;
		// 禁止重复审核 非提交不审核
		if (!info.getStatus().equals(BillStatusEnum.ArrCar)&&!info.getStatus().equals(BillStatusEnum.Save)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不符合确认的条件"));
		}
		
		try {
			info.setStatus(BillStatusEnum.Confirm);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (Exception ex) {
			throw new BOSException(ex);
		}
		if(info.getCar()==null)
			return;
		StringBuffer sb = new StringBuffer();
		sb.append("update ");
		sb.append(" CT_PUB_Car ");
		sb.append("set ");
		//审核后车辆状态为已派
		sb.append("fcarstate = '1'");
		sb.append("where ");
		sb.append("fid  = '").append(info.getCar().toString()).append("' ");
		com.kingdee.eas.util.app.DbUtil.execute(ctx, sb.toString());
			
	}

	@Override
	//反审核
	protected void _auditback(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		TransportationrecordInfo info = (TransportationrecordInfo) model;
		// 反禁止重复审核
		if (!info.getStatus().equals(BillStatusEnum.Confirm)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不符合反确认的条件"));
		}
		try {
			info.setStatus(BillStatusEnum.Save);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			logger.error(e);
			throw new BOSException(e);
		}
		
	}
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		TransportationrecordInfo  tinfo=(TransportationrecordInfo)model;
		if (!tinfo.getStatus().equals(BillStatusEnum.Save)&&!tinfo.getStatus().equals(BillStatusEnum.ArrCar)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不符合派车的条件"));
		}
		tinfo.setStatus(BillStatusEnum.ArrCar);
		return super._submit(ctx, tinfo);
	}
	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		TransportationrecordInfo tinfo=(TransportationrecordInfo)model;
		if (!tinfo.getStatus().equals(BillStatusEnum.Save)&&!tinfo.getStatus().equals(BillStatusEnum.ArrCar)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不符合保存的条件"));
		}
//		tinfo.setStatus(BillStatusEnum.Save);
		return super._save(ctx, model);
	}
	
	@Override
	//派送完成
	protected void _sendend(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		TransportationrecordInfo info = (TransportationrecordInfo) model;
		if(!info.getStatus().equals(BillStatusEnum.Confirm))
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不符合配送完成的条件"));
		info.setStatus(BillStatusEnum.Reback);
		super._save(ctx, info);
		StringBuffer sb = new StringBuffer();
		sb.append("update ");
		sb.append(" CT_PUB_Car ");
		sb.append("set ");
		//派送完成后车辆状态更新为未派
		sb.append("fcarstate = '2'");
		sb.append("where ");
		sb.append("fid  = '").append(info.getCar().toString()).append("' ");
		com.kingdee.eas.util.app.DbUtil.execute(ctx, sb.toString());
		
		
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
		// TODO Auto-generated method stub
		TransportationrecordInfo info = TransportationrecordFactory.getLocalInstance(ctx).getTransportationrecordInfo(pk);
		if (info.getStatus().equals(BillStatusEnum.Confirm)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核，禁止删除！"));
		}
		super._delete(ctx, pk);
	}
	@Override
	//运费计算
	protected void _calfright(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		//自定义sql查询
		TransportationrecordInfo info = (TransportationrecordInfo) model;
		//TransportationrecordAssEntryCollection assEntrys = info.getAssEntrys();
		//TransportationrecordAssEntryInfo assEntryInfo = new TransportationrecordAssEntryInfo();
		
//		HashMap<Object, Object> result = CalfrightFacadeFactory.getLocalInstance(ctx).calfright(carid);
//		IRowSet rs = (IRowSet) result.get("result");
//		try{
//			while(rs.next()){
//				BigDecimal rscala = new BigDecimal(rs.getString("frightamount"));
//				cala = cala.add(rscala);
//				BigDecimal rsduck = new BigDecimal(rs.getString("duckamount"));
//				duck = duck.add(rsduck);
//				System.out.println(duck.toString());
//			}
//			
//		}catch(SQLException e){
//			//TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		TransportationrecordEntryCollection Entrys = info.getEntrys();
//		TransportationrecordEntryInfo EntryInfo = Entrys.get(0);
//		//String sm = EntryInfo.getMateriel().toString();
//
//		//System.out.println(sm);
//		BigDecimal fr1 = new BigDecimal("0");
//		
//	
//		//判断物料类型是否是种鸭苗
//		
//		TransportationrecordEntryCollection tcll;
//		tcll = TransportationrecordEntryFactory.getLocalInstance(ctx).getTransportationrecordEntryCollection("where materiel like '%种鸭%'");
//		
//		//if(sm.equals("75QAAAAV0ZFECefw")||sm.equals("75QAAAAV0adECefw")||sm.equals("75QAAAAV0ZxECefw")||sm.equals("75QAAAAV0Z9ECefw")||sm.equals("75QAAAAV0bFECefw")||sm.equals("75QAAAAV0bNECefw")){
//		//if(1==2){	
//		if(tcll.size()!=0){
//			BigDecimal fr2 = new BigDecimal("0");
//			for(int i = 0; i < Entrys.size(); i++){
//				EntryInfo = Entrys.get(i);
//				fr2 = fr2.add(EntryInfo.getMaterrelnumber());
//			}
//			//info.setFreight(fr2);
//		}else{
//			for(int i = 0; i < Entrys.size(); i++){
//				EntryInfo = Entrys.get(i);
//				fr1 = fr1.add(EntryInfo.getMaterrelnumber());
//			}
//			BigDecimal frcal = new BigDecimal(cala.toString());			
//			BigDecimal frallcal = new BigDecimal(info.getAllmileage().toString());
//			//每公里平均运费与单据头的公里数相乘
//			frcal = frcal.multiply(frallcal);
//			//物料数量与物料补贴单价相乘
//			fr1 = fr1.multiply(duck);
//			//运费+补贴得出总运费
//			fr1 = fr1.add(frcal);
//			System.out.println(fr1);
//			info.setFreight(fr1);
//			try {
//				super._update(ctx, new ObjectUuidPK(info.getId()), info);
//			} catch (EASBizException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	
		
		// 根据 车辆信息   和物料信息获取 结算政策，单个政策，获取政策逻辑，是否政策要与 单据关联
		// 统计鸭苗数量。 鸭苗分为种鸭苗核和商品鸭苗
		// 根据政策计算运费、补贴 
		
	}
	@Override
	protected void _appointPerson(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void _updateMileage(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void _viewUpdateMileage(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		
	}
}
