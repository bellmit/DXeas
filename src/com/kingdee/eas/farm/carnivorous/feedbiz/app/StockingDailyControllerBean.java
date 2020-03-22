package com.kingdee.eas.farm.carnivorous.feedbiz.app;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;

import com.kingdee.bos.*;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyCollection;
import java.lang.String;
import java.math.BigDecimal;

import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class StockingDailyControllerBean extends AbstractStockingDailyControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.feedbiz.app.StockingDailyControllerBean");
	@Override
	//���淽��
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		StockingDailyInfo info = (StockingDailyInfo) model;
		//		info.getBatch().getId().toString()
		if(info.getBaseStatus()==null||info.getBaseStatus().getValue()==-1||info.getBaseStatus().equals(BillBaseStatusEnum.ADD)) {
			info.setBaseStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		}
		return super._save(ctx, info);
	}
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		StockingDailyInfo info = (StockingDailyInfo) model;
		if(info.getBaseStatus()==null||info.getBaseStatus().getValue()==-1||info.getBaseStatus().equals(BillBaseStatusEnum.ADD)||info.getBaseStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
			info.setBaseStatus(BillBaseStatusEnum.SUBMITED);
		}
		//�ύ���Զ����
		this._save(ctx, model);
		this._audit(ctx, model);
		return super._submit(ctx, info);
	}

	protected void _audit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{
		//����һ��Info�������������������Ϣ
		StockingDailyInfo info=(StockingDailyInfo)model;
		//����ҵ��Ԫ��״̬
		info.setBaseStatus(BillBaseStatusEnum.AUDITED);
		//�������ʱ��
		info.setAuditTime(new java.util.Date());
		//���������
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
		//  ��ѯ�Ƿ���Ҫ���¼����������ε���Ϣ
		ArrayList<String> list = checkIsNeedRecalQty(ctx,info);
		for(int i=0;i<list.size();i++){
			_recalStockingByBatchID(ctx, info.getBizDate() , list.get(i));
		}


	}
	/*
	 * ��ѯ�Ƿ���Ҫ���¼����������ε���Ϣ
	 */
	private ArrayList<String> checkIsNeedRecalQty(Context ctx,
			StockingDailyInfo info) {
		// TODO Auto-generated method stub
		//�õ�Info�е�������Ϣ,������Ϣת�����ַ���
		String batchID = info.getBatch().getId().toString();
		//��û���������ڣ���ת������Ӧ�ĸ�ʽ
		Date bizDate = info.getBizDate();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//����һ���б�
		ArrayList<String> list=new ArrayList<String>();
		try {//����ֳ�ձ��� ���� ����ֳ�ձ� ҵ������֮�����ֳ�ձ���������Ϣ
			IRowSet rs = DbUtil.executeQuery(ctx, "select * from T_FM_StockingDaily where FBizDate>={d '"+sdf.format(bizDate)+"'}+1 and FBatchID='"+batchID+"'");
			if(rs.size()>0){
				list.add(batchID);
			}

		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//����һ���б����б��������ֳ�ձ�ҵ������֮���������Ϣ
		return list;
	}
	protected void _unAudit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{//���������Ϣ
		StockingDailyInfo info = (StockingDailyInfo) model;
		//����������ֳ�ձ���״̬Ϊ����
		info.setBaseStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		//����������ֳ�ձ������ʱ��
		info.setAuditTime(null);
		//���������
		info.setAuditor(null);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
		//�����Ҫ���¼����������
		ArrayList<String> list = checkIsNeedRecalQty(ctx,info);
		
		for(int i=0;i<list.size();i++){
			_recalStockingByBatchIDUnAudit(ctx, info.getBizDate() , list.get(i));
		}
	}
	
	//�����б���ĳһ����ֳ�ձ��Ĵ�����
	private String  _recalStockingByBatchIDUnAudit(Context ctx, Date date, String batchID) throws BOSException {
		StringBuffer sb=new StringBuffer();
		//ѡ�� ��ֳ�ձ��� ���ݱ�ţ�����ID��FID��ҵ�����ڡ��Լ� ��ֳ��Ϣ��¼�� FID����¼���к�,������
		String sql = "select t1.Fnumber,t1.FBatchID,t1.FID dailyID,t2.FID entryID,t2.FSeq,t1.FBizDate,t2.CFBreekingStock  from T_FM_StockingDaily t1 inner join T_FM_StockingDailyAssEntry t2 on t1.FID=t2.FParentID where t1.FBatchID='"+batchID+"' and t1.CFBaseStatus= 4 ";
		//date��ָ�����ӵ����ű��ҵ������
		if(date != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//�������ҵ�����ڴ����������ҵ������
			sql += " and t1.FBizDate>{d '"+sdf.format(date)+"'}";
		}
		sql += " order by t1.FBizDate";

		IRowSet rs = DbUtil.executeQuery(ctx,sql);
		IRowSet rsA =null;
		String BatchID;
		String dailyID;
		String entryID;
		Date FBizDate;
		Integer seq;
		String billNum;

		BigDecimal intMaleQty;//������
		BigDecimal CFBreekingStock;
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
		try {
			while(rs.next()){
				intMaleQty=BigDecimal.ZERO;
				BatchID = rs.getString("FBatchID");//����ID
				dailyID=rs.getString("dailyID");//�ձ�ID
				entryID=rs.getString("entryID");//��¼ID
				FBizDate=rs.getDate("FBizDate");//ҵ������
				CFBreekingStock=rs.getBigDecimal("CFBreekingStock");//��ǰ������
				seq=rs.getInt("FSeq");//��¼���к�
				billNum=rs.getString("Fnumber");//���ݱ��
				//�ж������Ƿ�Ϊ��
				if(StringUtils.isEmpty(BatchID)){
					continue;
				}
				rsA=DbUtil.executeQuery(ctx,"select FBatchQty  from T_FM_Batch where FID=?",new String[]{BatchID});
				if(rsA.next()){
					intMaleQty=rsA.getBigDecimal("FBatchQty");
				}
				//�ۼ����ԡ�����������
				rsA=DbUtil.executeQuery(ctx, "/*dialect*/select nvl(sum(t2.CFDeathQty),0) CFDeathQty,nvl(sum(t2.CFCullQty),0)CFCullQty,nvl(sum(t2.FAdjustQty),0) FAdjustQty ,nvl(sum(t2.FMarkedQty),0)  FMarkedQty from T_FM_StockingDailyAssEntry    t2  inner join T_FM_StockingDaily t1 on t1.FID=t2.FParentID and t1.FBatchID=? and t1.FBizDate<{d '"+sdf1.format(FBizDate)+"'}+1 and t1.CFBaseStatus= 4",new String[]{BatchID});
				if(rsA.next()){
					intMaleQty=intMaleQty.subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("CFDeathQty"))).subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("CFCullQty"))).add(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FAdjustQty"))).subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FMarkedQty")));
				}
				if(intMaleQty.compareTo(CFBreekingStock)!=0){
					sb.append(billNum+"   ��"+seq+"������������ȷ,��ȷ����Ϊ"+intMaleQty+",��ǰֵΪ"+CFBreekingStock).append("\n");
					DbUtil.execute(ctx, "update T_FM_StockingDailyAssEntry set CFBreekingStock="+intMaleQty+" where FParentID='"+dailyID+"' and FID='"+entryID+"'");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	protected List _genNextBill(Context ctx, IObjectValue model)throws BOSException
	{
		return null;
	}
	protected void _reShareCoalAndDiesel(Context ctx, IObjectValue model)throws BOSException
	{

	}
	//����ĳ���εĴ�����
	protected String _recalStockingByBatchID(Context ctx, Date date, String batchID)throws BOSException, EASBizException
	{//�б��Ѿ������ˣ���Ҫ�޸Ĵ���������ֳ�ձ���������Ϣ
		StringBuffer sb=new StringBuffer();
		//ѡ�� ��ֳ�ձ��� ���ݱ�ţ�����ID��FID��ҵ�����ڡ��Լ� ��ֳ��Ϣ��¼�� FID����¼���к�,������
		String sql = "select t1.Fnumber,t1.FBatchID,t1.FID dailyID,t2.FID entryID,t2.FSeq,t1.FBizDate,t2.CFBreekingStock  from T_FM_StockingDaily t1 inner join T_FM_StockingDailyAssEntry t2 on t1.FID=t2.FParentID where t1.FBatchID='"+batchID+"' and t1.CFBaseStatus=4 ";
		//������ű�Ϊ�ղ���Ҫ�������ű�Ҫ�����Ժ�ҵ�����ڵĴ���������Ӧ�ı䣩��
		//������ű��ҵ������Ϊ�գ����ű������¼ӵģ�
		if(date != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			sql += " and t1.FBizDate>{d '"+sdf.format(date)+"'}";
		}
		sql += " order by t1.FBizDate";

		IRowSet rs = DbUtil.executeQuery(ctx,sql);
		IRowSet rsA =null;
		String BatchID;
		String dailyID;
		String entryID;
		Date FBizDate;
		Integer seq;
		String billNum;

		BigDecimal intMaleQty;//������
		BigDecimal CFBreekingStock;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			while(rs.next()){
				intMaleQty=BigDecimal.ZERO;
				BatchID = rs.getString("FBatchID");//����ID
				dailyID=rs.getString("dailyID");//�ձ�ID
				entryID=rs.getString("entryID");//��¼ID
				FBizDate=rs.getDate("FBizDate");//ҵ������
				CFBreekingStock=rs.getBigDecimal("CFBreekingStock");//��ǰ������
				seq=rs.getInt("FSeq");//��¼���к�
				billNum=rs.getString("Fnumber");//���ݱ��
				//�ж������Ƿ�Ϊ��
				if(StringUtils.isEmpty(BatchID)){
					continue;
				}
				rsA=DbUtil.executeQuery(ctx,"select FBatchQty  from T_FM_Batch where FID=?",new String[]{BatchID});
				if(rsA.next()){
					intMaleQty=rsA.getBigDecimal("FBatchQty");
				}
				//�ۼ����ԡ�����������
				rsA=DbUtil.executeQuery(ctx, "/*dialect*/select nvl(sum(t2.CFDeathQty),0) CFDeathQty,nvl(sum(t2.CFCullQty),0)CFCullQty,nvl(sum(t2.FAdjustQty),0) FAdjustQty ,nvl(sum(t2.FMarkedQty),0)  FMarkedQty from T_FM_StockingDailyAssEntry    t2  inner join T_FM_StockingDaily t1 on t1.FID=t2.FParentID and t1.FBatchID=? and t1.FBizDate<{d '"+sdf.format(FBizDate)+"'}+1",new String[]{BatchID});
				if(rsA.next()){
					intMaleQty=intMaleQty.subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("CFDeathQty"))).subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("CFCullQty"))).add(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FAdjustQty"))).subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FMarkedQty")));
				}
				if(intMaleQty.compareTo(CFBreekingStock)!=0){
					sb.append(billNum+"   ��"+seq+"������������ȷ,��ȷ����Ϊ"+intMaleQty+",��ǰֵΪ"+CFBreekingStock).append("\n");
					DbUtil.execute(ctx, "update T_FM_StockingDailyAssEntry set CFBreekingStock="+intMaleQty+" where FParentID='"+dailyID+"' and FID='"+entryID+"'");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	@Override
	protected String _recalStockingByBatchID(Context ctx, String String)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		return null;
	}
}