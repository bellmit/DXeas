package com.kingdee.eas.custom.taihe.weight.app;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.taihe.weight.CarSendBillInfo;
import com.kingdee.eas.custom.weightPlatform.utils.WeightNumUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class CarSendBillControllerBean extends AbstractCarSendBillControllerBean {
	private static Logger logger = Logger.getLogger("com.kingdee.eas.custom.taihe.weight.app.CarSendBillControllerBean");

	@Override
	protected IObjectPK _addnew(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		setWeightNum(ctx, model);
		return super._addnew(ctx, model);
	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		setWeightNum(ctx, model);
		return super._save(ctx, model);
	}
	
	
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		setWeightNum(ctx, model);
		CarSendBillInfo carInfo = (CarSendBillInfo)model;
		if(carInfo.getSupplier()==null){
			throw new EASBizException(new NumericExceptionSubItem("001","供应商不许为空"));
		}
		if(carInfo.getFarmAddress()==null){
			throw new EASBizException(new NumericExceptionSubItem("002","回收地址不许为空"));
		}
		if(carInfo.getSupplier()!=null&&carInfo.getFarmAddress()!=null){
			return super._submit(ctx, model);
		}else{
			MsgBox.showInfo("供应商或养殖场地址不许为空");
		}
		return super._submit(ctx, model);
		
		
	}

	/**
	 * 设置过磅码
	 * @param ctx
	 * @param model
	 * @throws BOSException 
	 */
	private void setWeightNum(Context ctx,IObjectValue model) throws BOSException {
		if(StringUtils.isEmpty(model.getString("weightNum"))) {
			model.setString("weightNum", getNextWeightOrder(ctx, model)+"X"+WeightNumUtil.getWeightNum(ctx, "CT_WEI_CarSendBill", "FWeightNum"));
		}
	}
	/**
	 * 獲取本次過磅顺序
	 * @param ctx
	 * @param model
	 * @return
	 * @throws BOSException 
	 */
	private String getNextWeightOrder(Context ctx,IObjectValue model) throws BOSException {
		String fid=model.getString("fid");
		String carID=model.getObjectValue("car").getString("id");
		String companyID=model.getObjectValue("company").getString("id");
		String bizDate=new SimpleDateFormat("yyyy-MM-dd").format( model.getDate("recycleDate"));
		StringBuffer sql=new StringBuffer();
		sql.append(" select count(1)+1 FCount from CT_WEI_CarSendBill ")
		.append(" where FCompanyID='").append(companyID).append("'")
		.append(" and to_char(cfrecycleDate,'yyyy-MM-dd')='").append(bizDate).append("'")
		.append(" and cfcarID='").append(carID).append("'")
		.append(" and FWeightNum is not null");
		if(StringUtils.isNotEmpty(fid)) {
			sql.append(" and fid!='").append(fid).append("'");
		}
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		try {
			if(rs.next()) {
				return rs.getString("FCount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "1";
	}
	
}