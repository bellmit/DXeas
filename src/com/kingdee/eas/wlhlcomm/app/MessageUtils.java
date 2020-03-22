package com.kingdee.eas.wlhlcomm.app;

import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.MetaDataLoaderFactory;
import com.kingdee.bos.metadata.management.LanguageCollection;
import com.kingdee.bos.metadata.management.SolutionInfo;
import com.kingdee.bos.service.message.Message;
import com.kingdee.bos.service.message.agent.MessageFactory;
import com.kingdee.bos.service.message.agent.SenderAgent;
import com.kingdee.eas.base.core.fm.ContextHelperFactory;
import com.kingdee.eas.base.message.MsgBizType;
import com.kingdee.eas.base.message.MsgPriority;
import com.kingdee.eas.base.message.MsgSourceStatus;
import com.kingdee.eas.base.message.MsgType;

public class MessageUtils {
	/**
     * 发送信息
     * @param ctx
     * @param remindPersonId 接受人id
     * @param title 消息标题
     * @param sendMessage 消息内容
     */
    public static void sendMessage(Context ctx, String remindPersonId, String title, String sendMessage){
    	try{
    		SolutionInfo solution = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx).getSolution();
    		SenderAgent sender = SenderAgent.getSenderAgent();
    		LanguageCollection language = null;
            if(solution != null){
            	language = solution.getLanguages();
            }
            Message message = MessageFactory.newMessage("kingdee.workflow");
            if(language.size()>0){
            	for(int i=0; i<language.size(); i++){
		           	 message.setLocaleStringHeader("title", title, language.get(i).getLocale());
		           	 message.setLocaleStringHeader("sender", ContextHelperFactory.getLocalInstance(ctx).getCurrentUser().getName(), language.get(i).getLocale());
		           	 message.setLocaleStringHeader("body", sendMessage, language.get(i).getLocale());
	           	 }
	           	 message.setIntHeader("type", MsgType.NOTICE_VALUE);//设置消息类型为通知
	           	 message.setIntHeader("bizType", MsgBizType.WORKFLOW_VALUE);//业务类型设置为工作流
	           	 message.setIntHeader("sourceStatus", MsgSourceStatus.COMPLETED_VALUE);//设置任务状态，此处是通知消息，所以设置空
	           	 message.setIntHeader("priority", MsgPriority.MIDDLE_VALUE);//设置消息优先级，自己根据需要设定相应的级别
	           	 message.setStringHeader("databaseCenter", ctx.getAIS());//得到数据中心
	           	 message.setStringHeader("solution", ctx.getSolution());//设置解决方案
	           	 message.setStringHeader("receiver",remindPersonId);//设置接收用户ID
	           	 sender.sendMessage(message,true);//发送消息 true,false 是否弹出条目提示
            }
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
}
