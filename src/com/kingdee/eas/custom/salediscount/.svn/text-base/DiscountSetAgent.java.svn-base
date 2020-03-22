/*     */ package com.kingdee.eas.custom.salediscount;
/*     */ 
/*     */ import com.kingdee.bos.BOSException;
/*     */ import com.kingdee.bos.dao.AbstractObjectCollection;
/*     */ import com.kingdee.bos.dao.IObjectPK;
/*     */ import com.kingdee.bos.dao.IObjectValue;
/*     */ import com.kingdee.bos.framework.agent.AgentManager;
/*     */ import com.kingdee.bos.framework.agent.AgentState;
/*     */ import com.kingdee.bos.framework.agent.IObjectValueAgent;
/*     */ import com.kingdee.bos.util.BOSObjectType;
/*     */ import com.kingdee.util.marshal.Marshaller;
/*     */ import com.kingdee.util.marshal.Unmarshaller;
/*     */ import java.io.IOException;
/*     */ import java.util.Enumeration;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class DiscountSetAgent extends DiscountSetInfo
/*     */   implements IObjectValueAgent
/*     */ {
/*  17 */   public static final BOSObjectType bosType = new BOSObjectType("32599B86");
/*     */   private final AgentManager manager;
/*     */ 
/*     */   public DiscountSetAgent()
/*     */   {
/*  22 */     this.manager = new AgentManager();
/*     */   }
/*     */ 
/*     */   public static DiscountSetAgent copyOvToAgent(IObjectValue vo) {
/*  26 */     DiscountSetAgent agent = new DiscountSetAgent();
/*  27 */     return ((DiscountSetAgent)agent.manager.copyOvToAgent(agent, vo));
/*     */   }
/*     */ 
/*     */   public static DiscountSetAgent copyOvAsNewAgent(IObjectValue vo) {
/*  31 */     DiscountSetAgent agent = new DiscountSetAgent();
/*  32 */     return ((DiscountSetAgent)agent.manager.copyOvToAgentAsNew(agent, vo));
/*     */   }
/*     */ 
/*     */   public static DiscountSetAgent find(IObjectPK id) throws BOSException
/*     */   {
/*  37 */     DiscountSetAgent agent = new DiscountSetAgent();
/*  38 */     return ((DiscountSetAgent)agent.manager.find(agent, id));
/*     */   }
/*     */ 
/*     */   public static DiscountSetAgent create() throws BOSException
/*     */   {
/*  43 */     return ((DiscountSetAgent)AgentManager.create(new DiscountSetAgent()));
/*     */   }
/*     */ 
/*     */   public void agentRemove() throws BOSException
/*     */   {
/*  48 */     AgentManager.remove(this);
/*     */   }
/*     */ 
/*     */   public IObjectPK agentSave() throws BOSException
/*     */   {
/*  53 */     return AgentManager.save(this);
/*     */   }
/*     */ 
/*     */   public AgentState getAgentState()
/*     */   {
/*  58 */     return this.manager.getAgentState();
/*     */   }
/*     */ 
/*     */   public void setAgentState(AgentState state)
/*     */   {
/*  63 */     this.manager.setAgentState(state);
/*     */   }
/*     */ 
/*     */   public void recursiveSetAgentState(AgentState state) {
/*  67 */     recursiveSetAgentState(state, new HashSet());
/*     */   }
/*     */ 
/*     */   public void recursiveSetAgentState(AgentState state, Set handledSet) {
/*  71 */     if (handledSet == null) {
/*  72 */       throw new IllegalArgumentException("The second argument should not be null.");
/*     */     }
/*  74 */     setAgentState(state);
/*  75 */     handledSet.add(new Integer(System.identityHashCode(this)));
/*     */ 
/*  77 */     Enumeration enumer = keys();
/*  78 */     Object obj = null;
/*  79 */     AbstractObjectCollection collection = null;
/*  80 */     while (enumer.hasMoreElements()) {
/*  81 */       obj = get((String)enumer.nextElement());
/*  82 */       if (obj instanceof IObjectValueAgent) {
/*  83 */         if (!(handledSet.contains(new Integer(System.identityHashCode(obj)))));
/*  84 */         ((IObjectValueAgent)obj).recursiveSetAgentState(state, handledSet);
/*     */       }
/*  86 */       if (obj instanceof AbstractObjectCollection);
/*  87 */       collection = (AbstractObjectCollection)obj;
/*  88 */       IObjectValue vo = null;
/*  89 */       int i = 0; for (int j = collection.size(); i < j; ++i) {
/*  90 */         vo = collection.getObject(i);
/*  91 */         if ((!(vo instanceof IObjectValueAgent)) || 
/*  92 */           (handledSet.contains(new Integer(System.identityHashCode(vo))))) continue;
/*  93 */         ((IObjectValueAgent)vo).recursiveSetAgentState(state, handledSet);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public IObjectValue getTarget()
/*     */   {
/* 104 */     return this;
/*     */   }
/*     */ 
/*     */   public IObjectValue getInfoInstance()
/*     */   {
/* 109 */     return this.manager.getSourceInfo();
/*     */   }
/*     */ 
/*     */   public void marshal(Marshaller marshaller) throws IOException {
/* 113 */     super.marshal(marshaller);
/* 114 */     this.manager.marshal(marshaller);
/*     */   }
/*     */ 
/*     */   public void unmarshal(Unmarshaller unmarshaller) throws IOException, ClassNotFoundException {
/* 118 */     super.unmarshal(unmarshaller);
/* 119 */     this.manager.unmarshal(unmarshaller);
/*     */   }
/*     */ }

/* Location:           D:\KDBosNew\bos140117\lib\client\eas\bd_scm-client.jar
 * Qualified Name:     com.kingdee.eas.basedata.scm.sd.sale.PricePolicyAgent
 * Java Class Version: 1.4 (48.0)
 * JD-Core Version:    0.5.3
 */