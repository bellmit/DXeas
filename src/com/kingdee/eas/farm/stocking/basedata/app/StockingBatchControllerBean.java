package com.kingdee.eas.farm.stocking.basedata.app;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo;
import com.kingdee.eas.farm.stocking.basedata.BreedDataFactory;
import com.kingdee.eas.farm.stocking.basedata.BreedDataInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyFactory;
import com.kingdee.eas.fi.newrpt.app.DbUtil;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class StockingBatchControllerBean extends AbstractStockingBatchControllerBean
{
    private static Logger logger =  Logger.getLogger("com.kingdee.eas.farm.stocking.basedata.app.StockingBatchControllerBean");

    @Override
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		StockingBatchInfo info = (StockingBatchInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.enable)) {
			throw new EASBizException(new NumericExceptionSubItem("001","������δ���ã�"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.approve);
		this._update(ctx, pk, info);
	}

    
    
    
	@Override
	protected void _checkNumberDup(Context arg0, IObjectValue arg1)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
//		super._checkNumberDup(arg0, arg1);
		
	}




	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		StockingBatchInfo info = (StockingBatchInfo) model;
//		if(info.getBreedDate()==null) {
//			info.setBreedDate(info.getInDate());
//		}
		return super._save(ctx, info);
	}




	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		StockingBatchInfo info = (StockingBatchInfo) model;
//		if(info.getBreedDate()==null) {
//			info.setBreedDate(info.getInDate());
//		}
		return super._submit(ctx, model);
	}




	@Override
	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		StockingBatchInfo info = (StockingBatchInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
			throw new EASBizException(new NumericExceptionSubItem("001","������δ��׼��"));
		}
		if (info.getBaseStatus().equals(FarmBaseStatusEnum.enable)) {
			throw new EASBizException(new NumericExceptionSubItem("001","�����Ѿ����ã�"));
		}

		info.setBaseStatus(FarmBaseStatusEnum.enable);
		this._update(ctx, pk, info);
	}

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		StockingBatchInfo info = (StockingBatchInfo) model;
		if (info.getBaseStatus().equals(FarmBaseStatusEnum.approve) || info.getBaseStatus().equals(FarmBaseStatusEnum.enable)) {
			throw new EASBizException(new NumericExceptionSubItem("001","�����Ѿ���׼�����ã�"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.approve);
		try {
			BaseSysSettingInfo sysSetting = StockingComm.getSysSetting(ctx, info.getCompany().getString("id"));
			
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add(new SelectorItemInfo("*"));
			slor.add(new SelectorItemInfo("material.*"));
			slor.add(new SelectorItemInfo("bridMaterial.*"));
			slor.add(new SelectorItemInfo("Entry.*"));
			slor.add(new SelectorItemInfo("Entry.material.*"));
			BreedDataInfo bInfo = null;
			if(info.getBreedData() != null){
			 bInfo = BreedDataFactory.getLocalInstance(ctx).getBreedDataInfo(new ObjectUuidPK(info.getBreedData().getId()),slor);
			}else{
				throw new BOSException("Ʒ����Ϣ����Ϊ�գ�");
			}
			CreateCreatCostObject createCostObject = new CreateCreatCostObject();
			createCostObject.create(bInfo, info, sysSetting, ctx);
			/*if(sysSetting!=null) {
				//�����ɱ�����
				CoreBaseCollection cCols=new CoreBaseCollection();
				
				if(info.getCostItem()==null) {
					
					//���ɳɱ�����
					CostObjectInfo cInfo=new CostObjectInfo();
					cInfo.setCompany(info.getCompany());
					cInfo.setNumber("YC-"+info.getNumber());
					cInfo.setBatchNumber(info.getNumber());
					if(StringUtils.isEmpty(info.getName())) {
						cInfo.setName(info.getNumber());
					}else {
						cInfo.setName(info.getName());
					}
					cInfo.setCalculateMode(CalculateModeEnum.BYBATCH);//���㷽��
		//			cInfo.setRelatedType(item);//��������
					cInfo.setRelatedId(bInfo.getBridMaterial().getId());//����id
					cInfo.setRelatedNumber(bInfo.getBridMaterial().getNumber());
					cInfo.setRelatedName(bInfo.getBridMaterial().getName());
					cInfo.setCostObjectGroup(sysSetting.getCostGroup());//�ɱ��������
					cInfo.setStdProductID(bInfo.getBridMaterial());//�������� ����������
					
					
					CostObjectEntryInfo ceInfo=new CostObjectEntryInfo();
					ceInfo.setIsMainProduct(true);
					ceInfo.setQuotiety(BigDecimal.ONE);
					ceInfo.setRelatedID(bInfo.getBridMaterial().getId());
					ceInfo.setRelatedNumber(bInfo.getBridMaterial().getNumber());
					ceInfo.setRelatedName(bInfo.getBridMaterial().getName());
					cInfo.getEntries().add(ceInfo);
					cCols.add(cInfo);

					info.setCostItem(cInfo);
				}
				//
				if(info.getEggCostItem()==null) {
					//����ɱ�����
					CostObjectInfo cInfo2=new CostObjectInfo();
					cInfo2.setCompany(info.getCompany());
					cInfo2.setNumber("CD-"+info.getNumber());
					cInfo2.setBatchNumber(info.getNumber());
					if(StringUtils.isEmpty(info.getName())) {
						cInfo2.setName(info.getNumber());
					}else {
						cInfo2.setName(info.getName());
					}
					cInfo2.setCalculateMode(CalculateModeEnum.BYBATCH);//���㷽��
		//			cInfo2.setRelatedType(item);//��������
					for(int j=0;j<bInfo.getEntry().size();j++) {
						if(bInfo.getEntry().get(j).isIsQualified()) {
							cInfo2.setRelatedId(bInfo.getEntry().get(j).getMaterial().getId());//����id
							cInfo2.setRelatedNumber(bInfo.getEntry().get(j).getMaterial().getNumber());
							cInfo2.setRelatedName(bInfo.getEntry().get(j).getMaterial().getName());
							break;
						}
					}
					
					cInfo2.setCostObjectGroup(sysSetting.getCostGroup());//�ɱ��������
					cInfo2.setStdProductID(bInfo.getBridMaterial());//��������--�ϸ�����
					
					
					CostObjectEntryInfo ceInfo2=new CostObjectEntryInfo();
					ceInfo2.setIsMainProduct(true);
					ceInfo2.setQuotiety(BigDecimal.ONE);
					ceInfo2.setRelatedID(bInfo.getBridMaterial().getId());
					ceInfo2.setRelatedNumber(bInfo.getBridMaterial().getNumber());
					ceInfo2.setRelatedName(bInfo.getBridMaterial().getName());
					cInfo2.getEntries().add(ceInfo2);
					cCols.add(cInfo2);
					
					info.setEggCostItem(cInfo2);	
				}
				if(cCols.size()>0) {
					CostObjectFactory.getLocalInstance(ctx).save(cCols);
				}
			}*/
			
			info.setAuditTime(new java.util.Date());
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			this._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			e.printStackTrace();
			
		}catch(BOSException e1){
			throw new BOSException(e1.getMessage());
		}
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		StockingBatchInfo info = (StockingBatchInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.approve) || info.getBaseStatus().equals(FarmBaseStatusEnum.enable)) {
			throw new EASBizException(new NumericExceptionSubItem("001","������δ��׼���Ѿ����ã�"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);
		try {
			this._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		StockingBatchInfo info = StockingBatchFactory.getLocalInstance(ctx).getStockingBatchInfo(pk);
		if (info.getBaseStatus().equals(FarmBaseStatusEnum.approve) || info.getBaseStatus().equals(FarmBaseStatusEnum.enable)) {
			throw new EASBizException(new NumericExceptionSubItem("001","�����Ѿ���׼�����ã�"));
		}
		
		
		//У��������Ƿ��Ѿ�Ӧ�õ���ֳ�ձ�
		checkBatchApply(ctx,info);
		
		super._delete(ctx, pk);
	}

	/**
	 * У��������Ƿ��Ѿ�Ӧ�õ���ֳ�ձ�
	 * ����Ѿ�Ӧ�õ���ֳ�ձ���ֹɾ����
	 * @param ctx 
	 * @param info
	 * @throws BOSException 
	 */
	private void checkBatchApply(Context ctx, StockingBatchInfo info) throws BOSException {
		// TODO Auto-generated method stub
		
		StringBuffer sq = new StringBuffer();
		sq.append("select max(t2.fid) billid from T_FM_StockingBatch  t1 inner join T_FM_StockingBreedDaily t2 on t2.CFStockingBatchID=t1.fid where t1.fid='");
		sq.append(info.getId());
		sq.append("'");
		
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sq.toString());
			String billid = null;
			//�����ֳ�ձ���id���ھͲ�����ɾ����ֳ�ձ�
			if(rs.next()){
				billid = rs.getString("billid");
				if(billid != null){
					throw new BOSException("�������Ѿ�������ֳ�ձ��У���ֹɾ����");
				}
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BOSException(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}




	/**
	 * �������ε��ձ�������
	 */
	@Override
	protected void _recalQty(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		StockingBreedDailyFactory.getLocalInstance(ctx).recalStockingByBatchID(model.getString("id"));
	}

	
	
}