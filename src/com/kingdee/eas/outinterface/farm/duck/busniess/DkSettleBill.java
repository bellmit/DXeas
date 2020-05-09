package com.kingdee.eas.outinterface.farm.duck.busniess;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.castor.util.Base64Decoder;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBill;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.industry.emm.pm.SqlExecuteFacadeFactory;
import com.kingdee.eas.outinterface.base.impl.AbstractOutInterfaceImpl;
import com.kingdee.eas.outinterface.base.utils.JUtils;
import com.kingdee.eas.outinterface.base.utils.ResultUtils;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * ���㵥
 * @author alex_dai
 *
 */
public class DkSettleBill extends AbstractOutInterfaceImpl {

	@Override
	protected String getBosType() {
		// TODO Auto-generated method stub
		return "2A2E0777";
	}



	@Override
	protected String[] getDataSelector() {
		// TODO Auto-generated method stub
		return new String[]{
				"id","number","bizDate","billStatus","confirmTime","feedDays"//����
				,"batch.number","farmer.name","farm.name","costCenter.name","breedData.name" //��ֳ��֯����ͬ����
				,"operator.number","operator.name","person.name","farmer.mobileTel"
				,"settlePolicy.number","settlePolicy.name"//��������				
				,"inDate","batchQty","recDate"//�������ڡ������������������ڣ��������ڣ�
				,"survivalRate","meatRate","oValue"//�ɻ��ʡ�����ȡ�PIֵ
				,"feedDays","recQty","chickenAveWgt"//��������������ֻ����ֻ��				
				,"batchAmt","feedAmt","drugAmt","recAmt"//��������ϿҩƷ�ë����
				,"punishAmt","chickenRetunAmt"//����۲�����������
				,"batchQty","recQty","meatRate","singleDrugAmt","singleDyFee","chickenAveWgt"
				//����ֻ��������ֻ����������(no)������ȡ�ֻҩ��ֻ�������󡢾���
				,"actualPayAmt","tranCost","coalCost","brokenCost"//֧����˷ѡ�ú��ϵ���
				,"marginProfit","borrowAmiunt","specialBorrowinst","reserveRiskCost"
				//��֤����Ϣ�����������Ϣ�����������Ϣ��Ԥ����ҩ�з���Ѻ��
				,"marginGAmount","longBorrowReturn","specialPermitAmt"
				//��֤����ȡ���������������������
				,"equipmentReAmt","noPfoRetAmt","beforeBatchAmount","nowAccountBac"
				//�豸������������𻹿�������������ۼ����
				,"viewItemAmt","chickenRetunAmt","beforeBatchAmount"//���߲����������������������
				,"mRatePAmt","drugLackPAmt","immuneCost"//����Ȳ���۷�����ҩ����۷����������
				,"farmeronlyPro","marginProfit" ,"borrowAmiunt","specialBorrowinst","dyFee"
				//��ֳë������֤��ʹ�÷ѡ��������ʹ�÷ѡ��������ʹ�÷ѡ���ֳ��������
				,"farmerOnlyProOne","feedWgt","settleWgt"//ֻ��������
				,"OtherEntrys.suType.name","OtherEntrys.amount" //�����۲�ҳǩ
				,"entrys.recType","entrys.qty","entrys.price","entrys.amount"





		};
	}


	/**
	 * ��ȡ���ݺ���
	 */
	@Override
	public CoreBaseInfo dealBeforeGetDataJSON(Context ctx, CoreBaseInfo model) {
		CKSettleBillInfo info=(CKSettleBillInfo) model;
		//�Ƴ�ǩ������
		info.setSignData(null);
		info.getPreHouseEntrys().clear();
		info.getSaleEntrys().clear();
		//		info.getEntrys().clear();
		info.getDrugEntrys().clear();
		info.getSeedEntrys().clear();
		info.getQCEntrys().clear();
		info.getSlaughterEntrys().clear();
		info.getFodderEntrys().clear();
		//		
		//		for(int index=0;index<info.getRewardPunish().size();){
		//			BigDecimal amt = info.getRewardPunish().get(index).getAmount();
		//			if(amt==null||amt.compareTo(BigDecimal.ZERO)==0){
		//				info.getRewardPunish().removeObject(index);
		//			}else {
		//				index++;
		//			}
		//		}
		//		
		//		for(int index=0;index<info.getSubsidy().size();){
		//			BigDecimal amt = info.getSubsidy().get(index).getAmount();
		//			if(amt==null||amt.compareTo(BigDecimal.ZERO)==0){
		//				info.getSubsidy().removeObject(index);
		//			}else {
		//				index++;
		//			}
		//		}

		return info;
	}



	@Override
	public JSONObject getData(Context ctx, String jsonStr) throws BOSException,
	EASBizException, RemoteException {
		// TODO Auto-generated method stub
		//		JSONObject paramsJson=JSONObject.parseObject(jsonStr);
		//		JSONObject reusltJson = super.getData(ctx, jsonStr);
		//        BigDecimal price =BigDecimal.ZERO ,qty=BigDecimal.ZERO, amount=BigDecimal.ZERO;
		//		if(reusltJson.getString("result").equals("0")) {
		//			JSONObject dataJson=reusltJson.getJSONObject("data");
		//			
		//		}
		return super.getData(ctx, jsonStr);
	}



	@Override
	protected String[] getListSelector() {
		// TODO Auto-generated method stub
		return new String[]{"id","number","bizDate","billStatus","farmer.name","farm.name","batch.number","batch.name",
				"chickenPay","endTotal","confirmTime","person.name","inDate"
				,"feedDays","survivalRate","meatRate","costCenter.name","oValue","chickenAveWgt","feedWgt"
				//�����������ɻ��ʡ�����ȡ���ֳ��֯��PIֵ��ֻ��
				,"batchQty","mlyAllAmt","recQty","settleWgt","recAmt","farmeronlyPro"
				//��������������ҩ�ܽ�����ֻ������������,���ս�����ë��
				,"batchContract.number","chickenAveWgt","recDate","batchContract.id"
		};
	}

	@Override
	protected String getSortStr(JSONObject jo) {
		// TODO Auto-generated method stub
		String type=jo.getString("type");
		if(StringUtils.isEmpty(type)){
			type="ASC";
		}
		String bizDate=jo.getString("bizDate");
		String inDate=jo.getString("inDate");
		String farmerName=jo.getString("farmer.name");
		String costCenter=jo.getString("costCenter.name");
		String str=null;
		if(StringUtils.isNotEmpty(bizDate)){
			str=" bizDate desc";
		}else if(StringUtils.isNotEmpty(inDate)){
			str=" inDate desc ";
		}else if(StringUtils.isNotEmpty(farmerName)){
			str=" farmer.name " +type;
		}else if(StringUtils.isNotEmpty(costCenter)){
			str=" costCenter.name " +type;
		}else{
			str=" bizDate desc";
		}
		return "order by "+str;
	}
	@Override
	public JSONObject getList(Context ctx, String jsonStr) throws BOSException,
	EASBizException, RemoteException {
		// TODO Auto-generated method stub
		JSONObject paramsJson=JSONObject.parseObject(jsonStr);
		JSONObject reusltJson = super.getList(ctx, jsonStr);
		JSONObject dataJsonDetail=null;
		JSONArray dataJson=null;
		StringBuffer sql=new StringBuffer();
		BigDecimal batchQty=BigDecimal.ZERO, mlyAllAmt=BigDecimal.ZERO ,recQty=BigDecimal.ZERO;
		BigDecimal settleWgt=BigDecimal.ZERO, recAmt=BigDecimal.ZERO ,farmeronlyPro=BigDecimal.ZERO;
		BigDecimal abqty=BigDecimal.ZERO;
		BigDecimal abamt=BigDecimal.ZERO;
		BigDecimal bbqty=BigDecimal.ZERO;
		BigDecimal bbamt=BigDecimal.ZERO;
		if(reusltJson.getString("result").equals("0")) {
			dataJson=reusltJson.getJSONArray("data");
			if(!dataJson.isEmpty()){
				//        		for(int i=0;i<dataJson.size();i++){
				//        			batchQty=batchQty.add(dataJson.getJSONObject(i).getBigDecimal("batchQty")==null ?BigDecimal.ZERO
				//        					:dataJson.getJSONObject(i).getBigDecimal("batchQty"));
				//        			mlyAllAmt=mlyAllAmt.add(dataJson.getJSONObject(i).getBigDecimal("mlyAllAmt")==null ?BigDecimal.ZERO
				//        					:dataJson.getJSONObject(i).getBigDecimal("mlyAllAmt"));
				//        			recQty=recQty.add(dataJson.getJSONObject(i).getBigDecimal("recQty")==null ?BigDecimal.ZERO
				//        					:dataJson.getJSONObject(i).getBigDecimal("recQty"));
				//        			settleWgt=settleWgt.add(dataJson.getJSONObject(i).getBigDecimal("settleWgt")==null ?BigDecimal.ZERO
				//        					:dataJson.getJSONObject(i).getBigDecimal("settleWgt"));
				//        			recAmt=recAmt.add(dataJson.getJSONObject(i).getBigDecimal("recAmt")==null ?BigDecimal.ZERO
				//        					:dataJson.getJSONObject(i).getBigDecimal("recAmt"));
				//        			farmeronlyPro=farmeronlyPro.add(dataJson.getJSONObject(i).getBigDecimal("farmeronlyPro")==null ?BigDecimal.ZERO
				//        					:dataJson.getJSONObject(i).getBigDecimal("farmeronlyPro"));
				//        		}

				//����ҳ�뷵�أ����ز�ѯ�����������
				try {
					sql.append("/*dialect*/ select sum(t3.batchQty) batchQty,sum(t3.mlyAllAmt) mlyAllAmt,sum(t3.recQty) recQty,sum(t3.settleWgt) settleWgt, \n")
					.append(" sum(t3.recAmt) recAmt,sum(t3.farmeronlyPro) farmeronlyPro,sum(t3.abqty) abqty,sum(t3.abamt) abamt,sum(t3.bbqty) bbqty,sum(t3.bbamt) bbamt from ( \n")
					.append("select sum(nvl(cs.CFbatchQty,0)) batchQty, sum(nvl(cs.CFmlyAllAmt,0)) mlyAllAmt,  \n")
					.append(" sum(nvl(cs.CFrecQty,0)) recQty,sum(nvl(cs.CFsettleWgt,0)) settleWgt, \n")
					.append(" sum(nvl(cs.CFrecAmt,0)) recAmt,sum(nvl(cs.CFfarmeronlyPro,0)) farmeronlyPro,0 abqty,0 abamt,0 bbqty,0 bbamt  from CT_FM_CKSettleBill cs \n")
					.append(" inner join CT_FM_Farmer farmer on farmer.fid= cs.CFFarmerID \n")
					.append(" where "+getListQueryStr2(ctx,paramsJson)+" \n")
					.append("union all select 0 batchQty,0 mlyAllAmt,0 recQty,0 settleWgt,0 recAmt,0 farmeronlyPro,sum(nvl(t2.CFQty,0)) abqty,  \n")
					.append(" sum(nvl(t2.CFAmount,0)) abamt,0 bbqty,0 bbamt  from CT_FM_CKSettleBill t1 inner join CT_FM_CKSettleBillentry t2 on t2.fparentid = t1.fid  \n")
					.append(" inner join CT_FM_Farmer farmer on farmer.fid= t1.CFFarmerID \n")
					.append(" where  "+getListQueryStr2(ctx,paramsJson)+" and t2.CFRecType = 0")
					.append(" union all select 0 batchQty,0 mlyAllAmt,0 recQty,0 settleWgt,0 recAmt,0 farmeronlyPro,0 abqty,  \n")
					.append(" 0 abamt,sum(nvl(t2.CFQty,0)) bbqty,sum(nvl(t2.CFAmount,0)) bbamt from CT_FM_CKSettleBill t1 inner join CT_FM_CKSettleBillentry t2 on t2.fparentid = t1.fid  \n")
					.append(" inner join CT_FM_Farmer farmer on farmer.fid= t1.CFFarmerID \n")
					.append(" where "+getListQueryStr2(ctx,paramsJson)+" and t2.CFRecType = 1 ) t3");
					IRowSet rs= SqlExecuteFacadeFactory.getLocalInstance(ctx).executeQuery(sql.toString());
					if(rs.next()){
						batchQty=rs.getBigDecimal("batchQty");
						mlyAllAmt=rs.getBigDecimal("mlyAllAmt");
						recQty=rs.getBigDecimal("recQty");
						settleWgt=rs.getBigDecimal("settleWgt");
						recAmt=rs.getBigDecimal("recAmt");
						farmeronlyPro=rs.getBigDecimal("farmeronlyPro");
						abqty=rs.getBigDecimal("abqty");
						abamt=rs.getBigDecimal("abamt");
						bbqty=rs.getBigDecimal("bbqty");
						bbamt=rs.getBigDecimal("bbamt");
					}
				} catch (Exception e) {
					e.printStackTrace();
				} 
				dataJsonDetail=dataJson.getJSONObject(0);
				dataJsonDetail.put("sum_batchQty", batchQty);//��������
				dataJsonDetail.put("sum_mlyAllAmt", mlyAllAmt);//����ҩ�ܽ��
				dataJsonDetail.put("sum_recQty", recQty);//����ֻ��
				dataJsonDetail.put("sum_settleWgt", settleWgt);//��������
				dataJsonDetail.put("sum_recAmt", recAmt);//���ս��
				dataJsonDetail.put("sum_farmeronlyPro", farmeronlyPro);//����ë��
				dataJsonDetail.put("sum_abqty", abqty);//A����������
				dataJsonDetail.put("sum_abamt", abamt);//A��������
				dataJsonDetail.put("sum_bbqty", bbqty);//B����������
				dataJsonDetail.put("sum_bbamt", bbamt);//B��������
			}
			//�б����չʾÿ�Ž��㵥��AB�����ۣ����������
			JSONObject batchJson = null;
			for(int i = 0,size = dataJson.size();i<size;i++){
				StringBuffer sql1=new StringBuffer();
				batchJson = (JSONObject) dataJson.get(i);
				String batciid = batchJson.getString("id");
				sql1.append(" /*dialect*/ select t2.CFRecType rectype,nvl(t2.CFQty,0) aqty,nvl(t2.CFPrice,0) aprice,nvl(t2.CFAmount,0) aamt ");
				sql1.append(" from CT_FM_CKSettleBill t1  inner join CT_FM_CKSettleBillentry t2 on t2.fparentid = t1.fid");
				sql1.append(" where t1.CFBillStatus = 4 and t1.fid = '");
				sql1.append(batciid);
				sql1.append("'");
				IRowSet r1 = DbUtil.executeQuery(ctx,sql1.toString());
				int rectype = 0;
				BigDecimal aqty = BigDecimal.ZERO;
				BigDecimal aprice = BigDecimal.ZERO;
				BigDecimal aamt = BigDecimal.ZERO;
				try {
					JSONObject json1 = null;
					while(r1.next()){
						json1 = new JSONObject();
						rectype = UIRuleUtil.getIntValue(r1.getInt("rectype"));
						aqty = UIRuleUtil.getBigDecimal(r1.getBigDecimal("aqty"));
						aprice = UIRuleUtil.getBigDecimal(r1.getBigDecimal("aprice"));
						aamt = UIRuleUtil.getBigDecimal(r1.getBigDecimal("aamt"));
						json1.put("aqty", aqty);
						json1.put("aprice", aprice);
						json1.put("aamt", aamt);
						if(rectype == 0){//A��
							batchJson.put("aInfo",json1);
						}else{
							batchJson.put("bInfo",json1);
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}		
		return reusltJson;
	}
	@Override
	protected String getListQueryStr(Context ctx, JSONObject jo) throws BOSException {
		String beginDate=JUtils.getDateStr(jo, "beginDate", JUtils.SDF_DAY);
		String endDate=JUtils.getDateStr(jo, "endDate", JUtils.SDF_DAY);
		StringBuffer queryStr= new StringBuffer();
		queryStr.append(" bizDate>={d '").append(beginDate).append("'}")
		.append(" and bizDate<{d '").append(endDate).append("'}");

		//ֻ��ʾ��˵�
		queryStr.append(" and billStatus=4");

		//��������
		if(StringUtils.isNotEmpty(jo.getString("farmer.id"))) {
			queryStr.append(" and farmer.id='").append(jo.getString("farmer.id")).append("'");
		}
		//��ֳ������
		if(StringUtils.isNotEmpty(jo.getString("farm.id"))) {
			queryStr.append(" and farm.id='").append(jo.getString("farm.id")).append("'");
		}
		//���κ�ͬ
		if(StringUtils.isNotEmpty(jo.getString("batchContract.id"))) {
			queryStr.append(" and batchContract.id='").append(jo.getString("batchContract.id")).append("'");
		}
		//��ɫ
		StringBuffer rolesStr=new StringBuffer();
		JSONArray rolesArray = jo.getJSONArray("roles");
		for(int index=0;index<rolesArray.size();index++) {
			String role=rolesArray.getString(index);
			if(rolesStr.length()>0) {
				rolesStr.append(" OR ");
			}
			if(StringUtils.equalsIgnoreCase(role,"farmer")){
				rolesStr.append(" farmer.identity='").append(jo.getString("idNo")).append("'");
			}
			if(StringUtils.equalsIgnoreCase(role,"manager")){
				rolesStr.append(" farmer.id in (")
				.append(" select distinct tentry.FFarmerID")
				.append(" from T_FM_PersonFarmerRange tmain")
				.append(" inner join T_FM_PersonFarmerRangeEntry tentry on tentry.fparentid=tmain.fid")
				.append(" inner join t_pm_user tuser on tuser.fpersonid=tmain.FPersonID")
				.append(" where tuser.fnumber='").append(jo.getString("userNum")).append("'")
				.append(" and tmain.FBaseStatus=2")
				.append(")");
			}
		}
		if(rolesStr.length()>0) {
			queryStr.append(" AND (").append(rolesStr).append(") and entrys.seq=1");
		}

		return queryStr.toString();
	}

	/**
	 * ȷ�ϵ���
	 */
	public static String confirm(Context ctx,String jsonStr) {
		JSONObject jo=JSONObject.parseObject(jsonStr);
		String id=jo.getString("id");
		String signData=jo.getString("signData");
		jo=ResultUtils.getResultSuccess();
		try {
			ICKSettleBill is= CKSettleBillFactory.getLocalInstance(ctx);
			SelectorItemCollection slor=new SelectorItemCollection();

			CKSettleBillInfo info = is.getCKSettleBillInfo(new ObjectUuidPK(id));
			info.setConfirmTime(new Date());
			slor.add("confirmTime");

			if(StringUtils.isNotBlank(signData)){
				info.setSignData(Base64Decoder.decode(signData));
				slor.add("signData");
			}
			is.updatePartial(info,slor);
		} catch (Exception e) {
			jo=ResultUtils.getResultError(e);
		}
		return jo.toJSONString();
	}
	protected String getListQueryStr2(Context ctx, JSONObject jo) throws BOSException {
		String beginDate=JUtils.getDateStr(jo, "beginDate", JUtils.SDF_DAY);
		String endDate=JUtils.getDateStr(jo, "endDate", JUtils.SDF_DAY);
		StringBuffer queryStr= new StringBuffer();
		queryStr.append(" FBizDate>={d '").append(beginDate).append("'}")
		.append(" and FBizDate<{d '").append(endDate).append("'}");

		//ֻ��ʾ��˵�
		queryStr.append(" and CFBillStatus=4");
		//��������
		if(StringUtils.isNotEmpty(jo.getString("farmer.id"))) {
			queryStr.append(" and CFFarmerID='").append(jo.getString("farmer.id")).append("'");
		}
		//��ֳ������
		if(StringUtils.isNotEmpty(jo.getString("farm.id"))) {
			queryStr.append(" and CFFarmID='").append(jo.getString("farm.id")).append("'");
		}
		//���κ�ͬ
		if(StringUtils.isNotEmpty(jo.getString("batchContract.id"))) {
			queryStr.append(" and CFBatchContractID='").append(jo.getString("batchContract.id")).append("'");
		}
		//��ɫ
		StringBuffer rolesStr=new StringBuffer();
		JSONArray rolesArray = jo.getJSONArray("roles");
		for(int index=0;index<rolesArray.size();index++) {
			String role=rolesArray.getString(index);
			if(rolesStr.length()>0) {
				rolesStr.append(" OR ");
			}
			if(StringUtils.equalsIgnoreCase(role,"farmer")){
				rolesStr.append(" farmer.FIdentity='").append(jo.getString("idNo")).append("'");
			}
			if(StringUtils.equalsIgnoreCase(role,"manager")){
				rolesStr.append(" farmer.fid in (")
				.append(" select distinct tentry.FFarmerID")
				.append(" from T_FM_PersonFarmerRange tmain")
				.append(" inner join T_FM_PersonFarmerRangeEntry tentry on tentry.fparentid=tmain.fid")
				.append(" inner join t_pm_user tuser on tuser.fpersonid=tmain.FPersonID")
				.append(" where tuser.fnumber='").append(jo.getString("userNum")).append("'")
				.append(" and tmain.FBaseStatus=2")
				.append(")");
			}
		}
		if(rolesStr.length()>0) {
			queryStr.append(" AND (").append(rolesStr).append(")");
		}

		return queryStr.toString();
	}

}