package com.kingdee.eas.custom.depPlungin.client;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.AbstractObjectValue;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.fi.ap.PayRequestBillFactory;
import com.kingdee.eas.fi.ap.PayRequestBillInfo;
import com.kingdee.eas.fi.ap.client.PayRequestBillEditUI;
import com.kingdee.eas.fi.ap.client.PayRequestBillListUI;
import com.kingdee.eas.fi.ar.BillStatusEnum;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.client.IIDList;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class payRequestBillDep {
	/**
	 * 付款申请单手动选择关闭
	 * @param ui
	 * @param isClosed
	 * @throws EASBizException
	 * @throws BOSException 
	 */
	public static Map<String,Object> functionClosedFromPayReqBillEditUI(Object ui,boolean isClosed) throws EASBizException, BOSException{

		Map<String,Object> map=new HashMap<String, Object>();
		//传入的是界面参数，获取付款申请的info和info的分录
		PayRequestBillEditUI editUI = (PayRequestBillEditUI)ui;

		PayRequestBillInfo info = (PayRequestBillInfo) editUI.getEditData();
		if(isClosed)
			throw new EASBizException(new NumericExceptionSubItem("001","已关闭的单据不需要重新关闭"));//不符合条件的校验一
		if(info.getId()==null)
			throw new EASBizException(new NumericExceptionSubItem("001","不能关闭尚未提交和保存的付款申请单"));//不符合条件的校验二
		if(!BillStatusEnum.AUDITED.equals(info.getBillStatus()))
			throw new EASBizException(new NumericExceptionSubItem("001","只能手动关闭已审核的付款申请单"));//不符合条件的校验三



		Date date = updatePayRequestBillInfoSetIsLockedTrueClient(info,true,SysContext.getSysContext().getCurrentUserInfo(),new Date(),"EditUI");

		map.put("bool", true);
		map.put("userInfo", SysContext.getSysContext().getCurrentUserInfo());
		if(date!=null)
			map.put("date", date);
		else
			map.put("date", new Date());

		return map;
	}

	/**
	 * 修改单个付款申请单的信息
	 * @param info
	 * @param bool
	 * @param userInfo
	 * @param date
	 * @throws EASBizException
	 * @throws BOSException 
	 */
	protected static Date updatePayRequestBillInfoSetIsLockedTrueClient(PayRequestBillInfo info, boolean bool, UserInfo userInfo, Date date,String UIType) throws EASBizException, BOSException {
		// TODO Auto-generated method stub
		if(info.getId()==null)
			throw new EASBizException(new NumericExceptionSubItem("001","只能手动关闭已审核的付款申请单"));
		if(UIType.equals("EditUI"))
			if(!BillStatusEnum.AUDITED.equals(info.getBillStatus()))
				throw new EASBizException(new NumericExceptionSubItem("001","只能手动关闭已审核的付款申请单"));
		String ID = info.getId().toString();
		Date closeDate = com.kingdee.eas.custom.payReqBillFacadeFactory.getRemoteInstance().setPayReqBillCloseStatus(ID, bool, userInfo, null);
		return closeDate;
		//		updatePayRequestBillSetIsLockedTrueClient(ID, bool,userInfo,date);
	}


	/**
	 * 付款申请单手动选择反关闭
	 * @param ui
	 * @param isClosed
	 * @throws EASBizException
	 */
	public static Map<String,Object> functionUnClosedFromPayReqBillEditUI(Object ui,boolean isClosed) throws EASBizException{

		Map<String,Object> map=new HashMap<String, Object>();

		//传入的是界面参数，获取付款申请的info和info的分录
		PayRequestBillEditUI editUI = (PayRequestBillEditUI)ui;
		PayRequestBillInfo info = (PayRequestBillInfo) editUI.getEditData();

		if(!isClosed)
			throw new EASBizException(new NumericExceptionSubItem("001","尚未关闭的单据不需要反关闭"));

		BigDecimal sum = BigDecimal.ZERO;
		for(int i=0;i<info.getEntrys().size();i++)
			if(info.getEntrys().get(i).getTotalPayAmt()!=null)
				sum=sum.add(info.getEntrys().get(i).getTotalPayAmt());
		if(sum.compareTo(info.getAuditAmount())==0)
			throw new EASBizException(new NumericExceptionSubItem("001","申请付款金额与付款金额相等，不需要反关闭"));


		String ID = info.getId().toString();
		updatePayRequestBillSetIsLockedTrueClient(ID, false,SysContext.getSysContext().getCurrentUserInfo(),new Date());

		map.put("bool", false);
		map.put("userInfo", SysContext.getSysContext().getCurrentUserInfo());
		return map;
	}

	/**
	 * 设置单据状态
	 * @param ID
	 * @param userInfo 
	 * @param status
	 */
	private static void updatePayRequestBillSetIsLockedTrueClient(String payRequestBillID,boolean bool,
			UserInfo userInfo, Date  date) {
		// TODO Auto-generated method stub
		int boolValue=0;
		if(bool)
			boolValue=1;
		else
			boolValue=0;
		String userID="";
		if(userInfo.getId()!=null)
			userID=userInfo.getId().toString();

		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=sdf.format(date);

		StringBuffer sb=new StringBuffer();
		sb.append("/*dialect*/update T_AP_PayRequestBill set");
		sb.append(" CFisClosed=").append(boolValue).append(",");//是否关闭
		if(bool){
			sb.append(" CFClosePersonID='").append(userID).append("',");//设置关闭人
			sb.append(" CFUnClosePersonID=null,");//设置反关闭人
			sb.append(" CFCloseTime=to_date('"+time+"','yyyy-MM-dd:hh24:mi:ss')");//设置关闭时间
		}else{
			sb.append(" CFClosePersonID=null,");//设置关闭人
			sb.append(" CFUnClosePersonID='").append(userID).append("',");
			sb.append(" CFCloseTime=null");
		}
		sb.append(" where fid='"+payRequestBillID+"'");
		try {
			SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 付款申请单手动选择关闭
	 * @param ui
	 * @param isClosed
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public static String functionClosedFromPayReqBillListUI(Object ui) throws Exception{
		PayRequestBillListUI listUI = (PayRequestBillListUI)ui;
		ArrayList<String> list = listUI.getAllSelecteIDListValues();
		UserInfo userInfo = SysContext.getSysContext().getCurrentUserInfo();
		Date date = new Date();
		PayRequestBillInfo info=null;

		int number=0;

		for(int i=0;i<list.size();i++){
			if(checkIsClose(list.get(i))){
				++number;
				continue;
			}
			CoreBaseCollection coll = PayRequestBillFactory.getRemoteInstance().getCollection("where ID='"+list.get(i)+"'");
			if(coll.size()>0){
				info=(PayRequestBillInfo) coll.get(0);
				if(!info.getBillStatus().equals(BillStatusEnum.AUDITED)){
					++number;
					continue;
				}
				updatePayRequestBillInfoSetIsLockedTrueClient(info, true, userInfo, date, "ListUI");
			}
		}
		listUI.refreshList();
		if(number>0)
			return "关闭完成，其中"+String.valueOf(number)+"条未能关闭，未能关闭原因：单据已关闭或未处于审核状态";
		else
			return "所有单据关闭完成";
	}

	/**
	 * 检查当前单据是否已经关闭
	 * @param ID
	 * @return
	 */
	private static boolean checkIsClose(String ID) {
		// TODO Auto-generated method stub
		String str="select CFIsClosed from T_AP_PayRequestBill where FID='"+ID+"'";
		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(str).executeSQL();
			if(rs.next())
				if(rs.getInt("CFIsClosed")==1)
					return true;
				else
					return false;
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 付款申请单手动选择反关闭
	 * @param ui
	 * @param isClosed
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public static String functionUnClosedFromPayReqBillListUI(Object ui) throws Exception{

		PayRequestBillListUI listUI = (PayRequestBillListUI)ui;
		ArrayList<String> list = listUI.getAllSelecteIDListValues();
		UserInfo userInfo = SysContext.getSysContext().getCurrentUserInfo();
		Date date = new Date();
		PayRequestBillInfo info=null;

		int number=0;

		BigDecimal sum=BigDecimal.ZERO;
		for(int i=0;i<list.size();i++){
			CoreBaseCollection coll = PayRequestBillFactory.getRemoteInstance().getCollection("where ID='"+list.get(i)+"'");
			if(coll.size()>0)
				info=(PayRequestBillInfo) coll.get(0);

			for(int j=0;j<info.getEntrys().size();j++)
				sum=sum.add(info.getEntrys().get(j).getTotalPayAmt());
			if(sum.compareTo(info.getAuditAmount())==0){
				sum=BigDecimal.ZERO;
				continue;
			}
			sum=BigDecimal.ZERO;
			updatePayRequestBillInfoSetIsLockedTrueClient(info, false, userInfo, date, "ListUI");
			++number;
		}
		listUI.refreshList();
		if(number<list.size())
			return "反关闭完成，其中"+String.valueOf(list.size()-number)+"条未能反关闭，未能反关闭原因：已付款金额=申请付款金额或单据状态不需要反关闭";
		else
			return "所有单据反关闭完成";
	}
}
