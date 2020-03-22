package com.kingdee.eas.custom.echickeninterface.billFacade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.business.CommecialChilkenDailyInfo;
import  com.kingdee.eas.farm.breed.business.CommecialChilkenDailyFactory;
import com.kingdee.eas.farm.breed.business.ICommecialChilkenDaily;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;

public class CommecialChilkenDailySupport implements IBillSupport{
	protected BigDecimal zero;
	private Context ctx;
	@Override
	public List audit(List list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class getInfoClass() {
		// TODO Auto-generated method stub
		
		return CommecialChilkenDailyInfo.class;
	}

	@Override
	public boolean isSupportAudit() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isSupportSbumit() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List save(AbstractObjectCollection col)
			throws EASBizException, BOSException {
		// TODO Auto-generated method stub
		return saveOrSubmitData(col, false);
	}

	@Override
	public void setContext(Context context) {
		this.ctx = context;
		
	}

	@Override
	public List submit(AbstractObjectCollection col)
			throws EASBizException, BOSException {
		// TODO Auto-generated method stub
		return saveOrSubmitData(col, false);
	}

	private List saveOrSubmitData(AbstractObjectCollection col, boolean isSave) throws EASBizException, BOSException {
		List results = new ArrayList();
		CommecialChilkenDailyInfo info=null;//商品鸡养殖日报
		int i=0;
		for(int size=col.size();i<size;i++){
			info=(CommecialChilkenDailyInfo) col.getObject(i);
			List errorMsg = setData(ctx, info);// --设置值，并且返回错误信息列表
			
			if (errorMsg != null && errorMsg.size() > 0) {
				BillResultInfo result = new BillResultInfo();
				result.setErrorMsgs(errorMsg);
				result.setNumber(info.getNumber());
				result.setStatus(1);
				results.add(result);
				continue;
			}
			BillResultInfo resultInfo = new BillResultInfo();
			resultInfo.setNumber(info.getNumber());
			
			try {
				IObjectPK pk = new ObjectUuidPK();
				// 检查单据是否已经存在。
				// boolean exist = BaseBillImportUtils.checkBillNumberExist(ctx,
				// info.getBOSType(), info.getNumber());
				// 先不检查是否存在单据exists =true
				boolean exist = false;
				if(exist){
					errorMsg.add("单据编号" + info.getNumber() + "已经存在不能重复导入");
					resultInfo.setErrorMsgs(errorMsg);
					resultInfo.setStatus(1);
				}else{
					// 不存在单据，则创建。
					BillBaseStatusEnum status = info.getBaseStatus();
					
					if (BillBaseStatusEnum.TEMPORARILYSAVED.equals(status)) {
						if (info.getCU() == null
								|| info.getCU().getId() == null) {
							errorMsg.add("无法获取cu");
						}

						pk = getInterface().save(info);
					} else if (BillBaseStatusEnum.SUBMITED.equals(status)) {
						pk = getInterface().submit(info);
					} else if (BillBaseStatusEnum.AUDITED.equals(status)) {
						info.setBaseStatus(BillBaseStatusEnum.SUBMITED);
						pk = getInterface().submit(info);

						info = getInterface().getCommecialChilkenDailyInfo(pk);
						try {
							if (BillBaseStatusEnum.SUBMITED.equals(info
									.getBaseStatus())) {
								// 审核
								getInterface().audit(info);
							}
						} catch (Exception e) {
							e.printStackTrace();
							getInterface().delete(pk);
							pk = null;
							throw new Exception("审核时报错" + e.getMessage());
						}
						
						if (pk != null) {
							// resultInfo.setErrorMsgs("SUCCESS");
							resultInfo.setId(pk.toString());
							resultInfo.setStatus(0);
						}
					} else {
						errorMsg.add("单据状态只能传入保存、提交、审核三种");
						resultInfo.setErrorMsgs(errorMsg);
						resultInfo.setId("");
						resultInfo.setStatus(1);
					}
				
				}
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				errorMsg.add(e.getMessage());
				resultInfo.setErrorMsgs(errorMsg);
				resultInfo.setStatus(1);
			}
			results.add(resultInfo);
		}
		
		
		return results;
	}

	public ICommecialChilkenDaily getInterface() throws BOSException {
		// TODO Auto-generated method stub
		return  CommecialChilkenDailyFactory.getLocalInstance(ctx);
	}
	public Context getContext() {
		return ctx;
	}
	//赋值操作
	private List setData(Context ctx, CommecialChilkenDailyInfo info) throws EASBizException, BOSException {
		// TODO Auto-generated method stub
		List errorMsg = new ArrayList();
		dealWithData(ctx, info, errorMsg);
		autoSetNumber(info, errorMsg);// 自动设置编码
		return errorMsg;
	}

	private void autoSetNumber(CommecialChilkenDailyInfo info, List errorMsg) throws EASBizException, BOSException {
		String number = "";
		String cuid = info.getCU().getId().toString();
		if (BaseBillImportUtils.isCodeRuleEnable(ctx, info, cuid) == true) {
			number = BaseBillImportUtils.getAutoCode(ctx, info, cuid);
		} else {
			errorMsg.add("不存在编码规则");
			
		}
		info.setNumber(number);
	}

	



	private void dealWithData(Context ctx, CommecialChilkenDailyInfo info,
			List errorMsg) throws EASBizException, BOSException {
		BaseBillImportUtils.setInfoByNumber(ctx, info, errorMsg);
	}

}
