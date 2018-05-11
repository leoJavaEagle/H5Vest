package com.neo.entity;

import java.io.Serializable;
import java.util.Date;

public class TProduct implements Serializable
{
	private static final long serialVersionUID = 2320116274422182236L;

	/**
     * 产品主键ID
     */
    private String id;
    
    /**
     * 0：现金贷、1：消费贷、2：抵押贷、3：租房分期、4：学生贷、5：业主贷
     */
    private String productType;
    
    /**
     * 借款产品名称
     */
    private String productName;
    
    /**
     * 申请金额大于等于
     */
    private String applyMoneyStart;
    
    /**
     * 申请金额小于等于
     */
    private String applyMoneyEnd;
    
    /**
     * 0：一次性还本付息、1：等额本息、2：等额本金、3：按月付息，到期还本
     */
    private String repaymentTypes;
    
    /**
     * 现金贷：借款手续费率
     */
    private String borrowFeeRate;
    
    /**
     * 是否收取违约金：0：是、1：否
     */
    private String isWeiyuejin;
    
    /**
     * 日违约金费率
     */
    private String weiyuejinRate;
    
    /**
     * 消费贷/服务管理费设置（现金贷/服务费设置）：0：固定金额、1：百分比
     */
    private String serviceFeeSetting;
    
    /**
     * 逾期费用设置：0：是国定金额、1：是百分比
     */
    private String overdueFeeSetting;
    
    /**
     * 产品图标URL
     */
    private String productPictureUrl;
    
    /**
     * 产品简介
     */
    private String productOverview;
    
    /**
     * 月利率
     */
    private String dayRate;
    
    /**
     * 月利率
     */
    private String monthRate;
    
    /**
     * 月利率
     */
    private String yearhRate;
    
    /**
     * 借款期限（1-30天；6个月；12个月；18个月）
     */
    private String borrowPeriods;
    
    /**
     * 多长时间下款
     */
    private String  bizTime;
    
    /**
     * 第三方产品的URL
     */
    private String url;
    
    /**
     * 额度范围
     */
    private String amountLimit;
    
   

    /**
     * 流程管理模块里的名称
     */
    private String productProcessName;
    
    /**
     * 流程管理模块里的ID
     */
    private String productProcessId;
    
    /**
     * 评分卡模板ID 外键关联 t_offline_card_tmplate.card_template_id
     */
    private String cardTemplateId;
    
    /**
     * 0：启用、1：停用、2：待提交
     */
    private String status;
    
    /**
     * 创建人
     */
    private String createId;
    
    /**
     * 创建时间
     */
    private Date createTime;
    
    /**
     * 修改人
     */
    private String updateId;
    
    /**
     * 最后修改时间
     */
    private Date updateTime;
    
    /**
     * 是否默认产品
     */
    private String isDefault;
    
    /**
     * 小logo图片
     */
    private String logoTip;
    
    /**
     * 小logo右边的产品提示
     */
    private String productTip;
    
    
    public String getLogoTip() {
		return logoTip;
	}

	public void setLogoTip(String logoTip) {
		this.logoTip = logoTip;
	}

	public String getProductTip() {
		return productTip;
	}

	public void setProductTip(String productTip) {
		this.productTip = productTip;
	}

	public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id == null ? null : id.trim();
    }
    
    public String getProductType()
    {
        return productType;
    }
    
    public void setProductType(String productType)
    {
        this.productType = productType == null ? null : productType.trim();
    }
    
    public String getProductName()
    {
        return productName;
    }
    
    public void setProductName(String productName)
    {
        this.productName = productName == null ? null : productName.trim();
    }
    
    public String getRepaymentTypes()
    {
        return repaymentTypes;
    }
    
    public void setRepaymentTypes(String repaymentTypes)
    {
        this.repaymentTypes = repaymentTypes == null ? null : repaymentTypes.trim();
    }
    
    public String getIsWeiyuejin()
    {
        return isWeiyuejin;
    }
    
    public void setIsWeiyuejin(String isWeiyuejin)
    {
        this.isWeiyuejin = isWeiyuejin == null ? null : isWeiyuejin.trim();
    }
    
    public String getServiceFeeSetting()
    {
        return serviceFeeSetting;
    }
    
    public void setServiceFeeSetting(String serviceFeeSetting)
    {
        this.serviceFeeSetting = serviceFeeSetting == null ? null : serviceFeeSetting.trim();
    }
    
    public String getOverdueFeeSetting()
    {
        return overdueFeeSetting;
    }
    
    public String getBizTime()
    {
        return bizTime;
    }

    public void setBizTime(String bizTime)
    {
        this.bizTime = bizTime;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getAmountLimit()
    {
        return amountLimit;
    }

    public void setAmountLimit(String amountLimit)
    {
        this.amountLimit = amountLimit;
    }
    
    
    public void setOverdueFeeSetting(String overdueFeeSetting)
    {
        this.overdueFeeSetting = overdueFeeSetting == null ? null : overdueFeeSetting.trim();
    }
    
    public String getProductPictureUrl()
    {
        return productPictureUrl;
    }
    
    public void setProductPictureUrl(String productPictureUrl)
    {
        this.productPictureUrl = productPictureUrl == null ? null : productPictureUrl.trim();
    }
    
    public String getProductOverview()
    {
        return productOverview;
    }
    
    public void setProductOverview(String productOverview)
    {
        this.productOverview = productOverview == null ? null : productOverview.trim();
    }
    
    public String getBorrowPeriods()
    {
        return borrowPeriods;
    }
    
    public void setBorrowPeriods(String borrowPeriods)
    {
        this.borrowPeriods = borrowPeriods == null ? null : borrowPeriods.trim();
    }
    
    public String getProductProcessName()
    {
        return productProcessName;
    }
    
    public void setProductProcessName(String productProcessName)
    {
        this.productProcessName = productProcessName == null ? null : productProcessName.trim();
    }
    
    public String getProductProcessId()
    {
        return productProcessId;
    }
    
    public void setProductProcessId(String productProcessId)
    {
        this.productProcessId = productProcessId == null ? null : productProcessId.trim();
    }
    
    public String getCardTemplateId()
    {
        return cardTemplateId;
    }
    
    public void setCardTemplateId(String cardTemplateId)
    {
        this.cardTemplateId = cardTemplateId == null ? null : cardTemplateId.trim();
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setStatus(String status)
    {
        this.status = status == null ? null : status.trim();
    }
    
    public String getCreateId()
    {
        return createId;
    }
    
    public void setCreateId(String createId)
    {
        this.createId = createId == null ? null : createId.trim();
    }
    
    public Date getCreateTime()
    {
        return createTime;
    }
    
    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }
    
    public String getUpdateId()
    {
        return updateId;
    }
    
    public void setUpdateId(String updateId)
    {
        this.updateId = updateId == null ? null : updateId.trim();
    }
    
    public Date getUpdateTime()
    {
        return updateTime;
    }
    
    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }
    
    public String getApplyMoneyStart()
    {
        return applyMoneyStart;
    }
    
    public void setApplyMoneyStart(String applyMoneyStart)
    {
        this.applyMoneyStart = applyMoneyStart;
    }
    
    public String getApplyMoneyEnd()
    {
        return applyMoneyEnd;
    }
    
    public void setApplyMoneyEnd(String applyMoneyEnd)
    {
        this.applyMoneyEnd = applyMoneyEnd;
    }
    
    public String getBorrowFeeRate()
    {
        return borrowFeeRate;
    }
    
    public void setBorrowFeeRate(String borrowFeeRate)
    {
        this.borrowFeeRate = borrowFeeRate;
    }
    
    public String getWeiyuejinRate()
    {
        return weiyuejinRate;
    }
    
    public void setWeiyuejinRate(String weiyuejinRate)
    {
        this.weiyuejinRate = weiyuejinRate;
    }
    
    public String getMonthRate()
    {
        return monthRate;
    }
    
    public String getDayRate() {
		return dayRate;
	}

	public void setDayRate(String dayRate) {
		this.dayRate = dayRate;
	}

	public String getYearhRate() {
		return yearhRate;
	}

	public void setYearhRate(String yearhRate) {
		this.yearhRate = yearhRate;
	}

	public void setMonthRate(String monthRate)
    {
        this.monthRate = monthRate;
    }
    
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TProduct other = (TProduct)obj;
        if (id == null)
        {
            if (other.id != null)
                return false;
        }
        else if (!id.equals(other.id))
            return false;
        return true;
    }
    
    public String getIsDefault()
    {
        return isDefault;
    }

    public void setIsDefault(String isDefault)
    {
        this.isDefault = isDefault;
    }

}
