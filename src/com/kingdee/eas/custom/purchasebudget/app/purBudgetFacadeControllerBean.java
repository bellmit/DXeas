package com.kingdee.eas.custom.purchasebudget.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import com.kingdee.bos.*;
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
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import java.lang.String;
import java.math.BigDecimal;

import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.basedata.assistant.PeriodFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerFactory;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitCollection;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitCollection;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CtrlUnitFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.SysContextConstant;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.custom.purchasebudget.PurBudgetEntryInfo;
import com.kingdee.eas.custom.purchasebudget.PurBudgetFactory;
import com.kingdee.eas.custom.purchasebudget.PurBudgetInfo;
import com.kingdee.eas.custom.purchasebudget.billStatus;
import com.kingdee.eas.custom.purchasebudget.purBudgetFacadeFactory;
import com.kingdee.eas.framework.CoreBaseCollection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.kingdee.eas.tools.datatask.DIETemplateInfo;
import com.kingdee.util.NumericExceptionSubItem;

public class purBudgetFacadeControllerBean extends AbstractpurBudgetFacadeControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.purchasebudget.app.purBudgetFacadeControllerBean");

	@SuppressWarnings("unchecked")
	@Override
	protected String _createPurBudgetInfo(Context ctx,IObjectValue DIETemplateInfo, HashMap queryResult)	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		int isBreak=0;

		CompanyOrgUnitInfo FIUnitInfo=null;//��˾
		if(queryResult==null)
			throw new EASBizException(new NumericExceptionSubItem("001","û���ҵ����ʵĵ�������"));
		Iterator entries = queryResult.entrySet().iterator(); 
		PurBudgetInfo info=new PurBudgetInfo();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


		String periodNum="";//�ڼ�
		String companyName="";//��˾
		String bizDate="";//ҵ������
		String description="";//�ο���Ϣ



		while (entries.hasNext()) {  

			Map.Entry entry = (Map.Entry) entries.next();  		  
			Map<Object, Object> sheetValue = (Map<Object,Object>)entry.getValue();
			Iterator rowEntries = sheetValue.entrySet().iterator(); 
			while (rowEntries.hasNext()) {
				Map.Entry rowEntry = (Map.Entry) rowEntries.next();  		  
				Map<Object, Object> colValue = (Map<Object,Object>)rowEntry.getValue();

				if(colValue.get(0)==null){
					isBreak=1;
					break;
				}

				if(companyName.equals(""))//��˾
					companyName=colValue.get(0).toString();
				else if(!colValue.get(0).toString().equals(companyName))
					throw new EASBizException(new NumericExceptionSubItem("001","��˾���Ʋ�һ��"));

				if(periodNum.equals(""))//����ڼ�
					periodNum=colValue.get(1).toString();
				else if(!colValue.get(1).toString().equals(periodNum))
					throw new EASBizException(new NumericExceptionSubItem("001","����ڼ䲻һ��"));

				if(bizDate.equals(""))//ҵ������
					bizDate=colValue.get(2).toString();
				else if(!colValue.get(2).toString().equals(bizDate))
					throw new EASBizException(new NumericExceptionSubItem("001","����ڼ䲻һ��"));

				if(description.equals(""))//����
					description=colValue.get(3).toString();
				else if(!colValue.get(3).toString().equals(description))
					throw new EASBizException(new NumericExceptionSubItem("001","�ο���Ϣ��һ��"));

				PurBudgetEntryInfo entryInfo= addNewPurBudgetEntryInfo(rowEntry.getKey().toString(),colValue);//���entry
				info.getEntrys().add(entryInfo);
			}  
			if(isBreak==1){
				break;
			}
		}


		//������������˿��Ƶ�Ԫ������info��ǰ����CU���Ա��ڵ��ñ������
		CoreBaseCollection coll = CompanyOrgUnitFactory.getLocalInstance(ctx).getCollection("where name='"+companyName+"'");
		if(coll.size()<0)
			throw new EASBizException(new NumericExceptionSubItem("001","û���ҵ����ƶ�Ӧ�Ĺ�˾"));
		else
			FIUnitInfo=(CompanyOrgUnitInfo) coll.get(0);
		info.setCU(CtrlUnitFactory.getLocalInstance(ctx).getCtrlUnitInfo(new ObjectUuidPK(FIUnitInfo.getId().toString())));//���Ƶ�ԪCU
		info.setCompany(FIUnitInfo);//��˾

		try {
			info.setBizDate(sdf.parse(bizDate));//ҵ������
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EASBizException(new NumericExceptionSubItem("001","���ڸ�ʽ���󣬱�׼���ڸ�ʽΪ'2016-01-01'"));
		}

		coll=PeriodFactory.getLocalInstance(ctx).getCollection("where Number='"+periodNum+"'");//�ڼ�
		if(coll.size()==0)
			throw new EASBizException(new NumericExceptionSubItem("001","�ڼ��ֶδ���"));
		PeriodInfo periodInfo = (PeriodInfo) coll.get(0);
		info.setPeriod(periodInfo);

		info.setDescription(description+"ϵͳ����");//����

		coll=PurBudgetFactory.getLocalInstance(ctx).getCollection("where company='"+FIUnitInfo.getId().toString()+"' and period='"+periodInfo.getId().toString()+"'");
		if(coll.size()>0)
			throw new EASBizException(new NumericExceptionSubItem("001","ϵͳ���Ѵ��ڵ�ǰ��˾�ڵ�ǰ�ڼ�Ĳɹ�Ԥ��"));

		//���ɱ���
		ICodingRuleManager codeRuleMgr=CodingRuleManagerFactory.getLocalInstance(ctx);
		if(codeRuleMgr.isExist(info, FIUnitInfo.getId().toString()))
			info.setNumber(codeRuleMgr.getNumber(info, FIUnitInfo.getId().toString()));
		else
			info.setNumber(createNewNumber(ctx,FIUnitInfo));

		info.setBillStatus(billStatus.save);
		PurBudgetFactory.getLocalInstance(ctx).save(info);
		PurBudgetFactory.getLocalInstance(ctx).submit(info);
		PurBudgetFactory.getLocalInstance(ctx).audit(info);
		return "true";
	}

	private PurBudgetEntryInfo addNewPurBudgetEntryInfo(
			String object, Map<Object, Object> colValue) throws EASBizException {
		// TODO Auto-generated method stub

		PurBudgetEntryInfo entryInfo=new PurBudgetEntryInfo();
		if(colValue.get(4)!=null)
			entryInfo.setTypeLvl1(colValue.get(4).toString());//һ�����

		if(colValue.get(5)!=null)
			entryInfo.setTypeLvl2(colValue.get(5).toString());//�������

		if(colValue.get(6)!=null)
			entryInfo.setMaterial(colValue.get(6).toString());//
		else
			throw new EASBizException(new NumericExceptionSubItem("001","��"+(Integer.parseInt(object)+1)+"��Ʒ������Ϊ��"));

		if(colValue.get(7)!=null)
			entryInfo.setModel(colValue.get(7).toString());//���

		if(colValue.get(8)!=null)
			entryInfo.setUnit(colValue.get(8).toString());//��λ

		if(colValue.get(9)!=null)
			entryInfo.setQty(new BigDecimal(colValue.get(9).toString()));//����

		if(colValue.get(10)!=null)
			entryInfo.setPrice(new BigDecimal(colValue.get(10).toString()));//����

		if(colValue.get(11)!=null)
			entryInfo.setAmt(new BigDecimal(colValue.get(11).toString()));//���

		if(colValue.get(12)!=null)
			entryInfo.setRemark(colValue.get(12).toString());//��ע

		if(entryInfo.getPrice()!=null&&entryInfo.getAmt()!=null&&entryInfo.getQty()!=null)
			if((entryInfo.getPrice().multiply(entryInfo.getQty()).compareTo(entryInfo.getAmt())!=0))
				throw new EASBizException(new NumericExceptionSubItem("001","��"+(Integer.parseInt(object)+1)+"�е���*����!=���"));

		return entryInfo;

	}

	/**
	 * �ֶ�����һ�� ��˾����-�ڼ����-��λ˳���   �ı���
	 * @param ctx
	 * @param unitInfo
	 * @return
	 * @throws BOSException
	 */
	private String createNewNumber(Context ctx,CompanyOrgUnitInfo unitInfo) throws BOSException {
		// TODO Auto-generated method stub
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
		String orgUnitNum=unitInfo.getNumber();
		String period=sdf.format(date);
		CoreBaseCollection coll=null;
		String number="";
		int seqNum=1;
		while(1==1){
			number=orgUnitNum+"-"+period+"_"+getSeqNumber(seqNum);
			coll = PurBudgetFactory.getLocalInstance(ctx).getCollection("where number='"+number+"'");
			if(coll.size()>0){
				++seqNum;
			}
			else
				return number;
		}
	}

	/**
	 * ����4λ˳���
	 * @param seqNum
	 * @return
	 */
	private String getSeqNumber(int seqNum) {
		// TODO Auto-generated method stub
		if(seqNum>0&&seqNum<10){
			return "000"+String.valueOf(seqNum);
		}else if(seqNum>=10&&seqNum<100){
			return "00"+String.valueOf(seqNum);
		}else if(seqNum>=100&&seqNum<1000){
			return "0"+String.valueOf(seqNum);
		}else
			return String.valueOf(seqNum);
	}




}