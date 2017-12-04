package au.com.sensis.bigdata.csv;

import com.opencsv.bean.CsvBindByName;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Created by lf on 01/12/17.
 * .
 */
public class YPAcquisioCsv implements Serializable {

    @CsvBindByName(required = true, column = "DATE")
    private String date;
    @CsvBindByName(required = true, column = "ROW_TYPE")
    private String rowType;
    @CsvBindByName(column = "AGENCY_ID")
    private String agencyId;
    @CsvBindByName(column = "AGENCY_NAME")
    private String agencyName;
    @CsvBindByName(required = true, column = "ACCOUNT_ID")
    private long accountId;
    @CsvBindByName(column = "ACCOUNT_NAME")
    private String accountName;
    @CsvBindByName(column = "ADVERTISER ID")
    private String advertiserId;
    @CsvBindByName(column = "ADVERTISER EMAIL")
    private String advertiserEmail;
    @CsvBindByName(column = "ADVERTISER CONTACT NAME")
    private String advertiserContactName;
    @CsvBindByName(column = "ADVERTISER URL")
    private String advertiserUrl;
    @CsvBindByName(column = "CAMPAIGN MANAGER EMAIL")
    private String campaignManagerEmail;
    @CsvBindByName(column = "CAMPAIGN MANAGER")
    private String campaignManager;
    @CsvBindByName(column = "ACCOUNT MANAGER EMAIL")
    private String accountManagerEmail;
    @CsvBindByName(column = "ACCOUNT MANAGER")
    private String accountManager;
    @CsvBindByName(column = "SALES REP EMAIL")
    private String salesRepEmail;
    @CsvBindByName(column = "SALES REP")
    private String salesRep;
    @CsvBindByName(column = "BC PRODUCT ID")
    private String bcProductId;
    @CsvBindByName(column = "PRODUCT TIER")
    private String productTier;
    @CsvBindByName(column = "HEADING NAME")
    private String headingName;
    @CsvBindByName(column = "HEADING ID")
    private String headingId;
    @CsvBindByName(column = "DWT FLAG")
    private String dwtFlag;
    @CsvBindByName(column = "START DATE")
    private String productStartDate;
    @CsvBindByName(column = "END DATE")
    private String productEndDate;
    @CsvBindByName(column = "PRODUCT STATUS")
    private String productStatus;
    @CsvBindByName(column = "CUSTOMER SEGMENT")
    private String customerSegment;
    @CsvBindByName(column = "MIGRATION STATUS")
    private String migrationStatus;
    @CsvBindByName(column = "REMAINING BUDGET")
    private float remainingBudget;
    @CsvBindByName(column = "END OF CYCLE TARGET")
    private float endOfCycleTarget;
    @CsvBindByName(column = "TO DATE ROLLOVER")
    private float toDateRollover;
    @CsvBindByName(column = "CUMULATIVE SPEND")
    private float cumulativeSpend;
    @CsvBindByName(column = "MANUAL ROLLOVER")
    private float manualRollover;
    @CsvBindByName(column = "LANDING PAGES FLAG")
    private float landingPagesFlag;
    @CsvBindByName(column = "APPLY DISCOUNT MANAGEMENT FEE")
    private float applyDiscountManagementFee;
    @CsvBindByName(column = "DISCOUNTED MANAGEMENT FEE")
    private float discountedManagementFee;
    @CsvBindByName(column = "TARGET BUDGET")
    private float targetBudget;
    @CsvBindByName(column = "Z(NOT SET 30)")
    private String accountField30;
    @CsvBindByName(column = "CAMPAIGN_GROUP_ID")
    private long campaignGroupId;
    @CsvBindByName(column = "CAMPAIGN_GROUP")
    private String campaignGroup;
    @CsvBindByName(column = "PUBLISHER_ID")
    private long publisherId;
    @CsvBindByName(column = "PUBLISHER_ENGINE_ID")
    private String publisherEngineId;
    @CsvBindByName(column = "PUBLISHER")
    private String publisher;
    @CsvBindByName(column = "PUBLISHER_ACCOUNT_NAME")
    private String publisherAccountName;
    @CsvBindByName(column = "PUBLISHER_CURRENCY")
    private String publisherCurrency;
    @CsvBindByName(column = "CAMPAIGN_ID")
    private long campaignId;
    @CsvBindByName(column = "CAMPAIGN_PUBLISHER_ID")
    private long campaignPublisherId;
    @CsvBindByName(column = "CAMPAIGN_NAME")
    private String campaignName;
    @CsvBindByName(column = "CAMPAIGN_STATUS")
    private String campaignStatus;
    @CsvBindByName(column = "CAMPAIGN_DESCRIPTION")
    private String campaignDescription;
    @CsvBindByName(column = "ENHANCED")
    private String enhanced;
    @CsvBindByName(column = "NETWORKS")
    private String networks;
    @CsvBindByName(column = "LOCATION_TARGET_METHOD")
    private String locationTargetMethod;
    @CsvBindByName(column = "LOCATION_EXCLUSION_METHOD")
    private String locationExclusionMethod;
    @CsvBindByName(column = "TIMEZONE")
    private String timezone;
    @CsvBindByName(column = "DAILY_BUDGET")
    private float dailyBudget;
    @CsvBindByName(column = "MONTHLY_BUDGET")
    private float monthlyBudget;
    @CsvBindByName(column = "BUDGET_TYPE")
    private String budgetType;
    @CsvBindByName(column = "AD_ROTATION")
    private String adRotation;
    @CsvBindByName(column = "BUDGET_DELIVERY")
    private String budgetDelivery;
    @CsvBindByName(column = "BIDDING_STRATEGY")
    private String biddingStrategy;
    @CsvBindByName(column = "START_DATE")
    private String startDate;
    @CsvBindByName(column = "END_DATE")
    private String endDate;
    @CsvBindByName(column = "LANGUAGE_MARKET")
    private String languageMarket;
    @CsvBindByName(column = "FREQ_IMPRESSION_CAP")
    private long freqImpressionCap;
    @CsvBindByName(column = "CAPPING_TIME_UNIT")
    private String cappingTimeUnit;
    @CsvBindByName(column = "CAPPING_LEVEL")
    private String cappingLevel;
    @CsvBindByName(required = true, column = "CLICKS")
    private long clicks;
    @CsvBindByName(column = "CONV.")
    private long conv;
    @CsvBindByName(column = "SPEND")
    private float cost;
    @CsvBindByName(required = true, column = "IMPR.")
    private long impr;
    @CsvBindByName(column = "TOTAL CONVERSION COUNT")
    private long totalConversionCount;
    @CsvBindByName(column = "CTR")
    private String ctr;
    @CsvBindByName(column = "BBM COST")
    private float bbmCost;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRowType() {
        return rowType;
    }

    public void setRowType(String rowType) {
        this.rowType = rowType;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(String advertiserId) {
        this.advertiserId = advertiserId;
    }

    public String getAdvertiserEmail() {
        return advertiserEmail;
    }

    public void setAdvertiserEmail(String advertiserEmail) {
        this.advertiserEmail = advertiserEmail;
    }

    public String getAdvertiserContactName() {
        return advertiserContactName;
    }

    public void setAdvertiserContactName(String advertiserContactName) {
        this.advertiserContactName = advertiserContactName;
    }

    public String getAdvertiserUrl() {
        return advertiserUrl;
    }

    public void setAdvertiserUrl(String advertiserUrl) {
        this.advertiserUrl = advertiserUrl;
    }

    public String getCampaignManagerEmail() {
        return campaignManagerEmail;
    }

    public void setCampaignManagerEmail(String campaignManagerEmail) {
        this.campaignManagerEmail = campaignManagerEmail;
    }

    public String getCampaignManager() {
        return campaignManager;
    }

    public void setCampaignManager(String campaignManager) {
        this.campaignManager = campaignManager;
    }

    public String getAccountManagerEmail() {
        return accountManagerEmail;
    }

    public void setAccountManagerEmail(String accountManagerEmail) {
        this.accountManagerEmail = accountManagerEmail;
    }

    public String getAccountManager() {
        return accountManager;
    }

    public void setAccountManager(String accountManager) {
        this.accountManager = accountManager;
    }

    public String getSalesRepEmail() {
        return salesRepEmail;
    }

    public void setSalesRepEmail(String salesRepEmail) {
        this.salesRepEmail = salesRepEmail;
    }

    public String getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(String salesRep) {
        this.salesRep = salesRep;
    }

    public String getBcProductId() {
        return bcProductId;
    }

    public void setBcProductId(String bcProductId) {
        this.bcProductId = bcProductId;
    }

    public String getProductTier() {
        return productTier;
    }

    public void setProductTier(String productTier) {
        this.productTier = productTier;
    }

    public String getHeadingName() {
        return headingName;
    }

    public void setHeadingName(String headingName) {
        this.headingName = headingName;
    }

    public String getHeadingId() {
        return headingId;
    }

    public void setHeadingId(String headingId) {
        this.headingId = headingId;
    }

    public String getDwtFlag() {
        return dwtFlag;
    }

    public void setDwtFlag(String dwtFlag) {
        this.dwtFlag = dwtFlag;
    }

    public String getProductStartDate() {
        return productStartDate;
    }

    public void setProductStartDate(String productStartDate) {
        this.productStartDate = productStartDate;
    }

    public String getProductEndDate() {
        return productEndDate;
    }

    public void setProductEndDate(String productEndDate) {
        this.productEndDate = productEndDate;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getCustomerSegment() {
        return customerSegment;
    }

    public void setCustomerSegment(String customerSegment) {
        this.customerSegment = customerSegment;
    }

    public String getMigrationStatus() {
        return migrationStatus;
    }

    public void setMigrationStatus(String migrationStatus) {
        this.migrationStatus = migrationStatus;
    }

    public float getRemainingBudget() {
        return remainingBudget;
    }

    public void setRemainingBudget(float remainingBudget) {
        this.remainingBudget = remainingBudget;
    }

    public float getEndOfCycleTarget() {
        return endOfCycleTarget;
    }

    public void setEndOfCycleTarget(float endOfCycleTarget) {
        this.endOfCycleTarget = endOfCycleTarget;
    }

    public float getToDateRollover() {
        return toDateRollover;
    }

    public void setToDateRollover(float toDateRollover) {
        this.toDateRollover = toDateRollover;
    }

    public float getCumulativeSpend() {
        return cumulativeSpend;
    }

    public void setCumulativeSpend(float cumulativeSpend) {
        this.cumulativeSpend = cumulativeSpend;
    }

    public float getManualRollover() {
        return manualRollover;
    }

    public void setManualRollover(float manualRollover) {
        this.manualRollover = manualRollover;
    }

    public float getLandingPagesFlag() {
        return landingPagesFlag;
    }

    public void setLandingPagesFlag(float landingPagesFlag) {
        this.landingPagesFlag = landingPagesFlag;
    }

    public float getApplyDiscountManagementFee() {
        return applyDiscountManagementFee;
    }

    public void setApplyDiscountManagementFee(float applyDiscountManagementFee) {
        this.applyDiscountManagementFee = applyDiscountManagementFee;
    }

    public float getDiscountedManagementFee() {
        return discountedManagementFee;
    }

    public void setDiscountedManagementFee(float discountedManagementFee) {
        this.discountedManagementFee = discountedManagementFee;
    }

    public float getTargetBudget() {
        return targetBudget;
    }

    public void setTargetBudget(float targetBudget) {
        this.targetBudget = targetBudget;
    }

    public String getAccountField30() {
        return accountField30;
    }

    public void setAccountField30(String accountField30) {
        this.accountField30 = accountField30;
    }

    public long getCampaignGroupId() {
        return campaignGroupId;
    }

    public void setCampaignGroupId(long campaignGroupId) {
        this.campaignGroupId = campaignGroupId;
    }

    public String getCampaignGroup() {
        return campaignGroup;
    }

    public void setCampaignGroup(String campaignGroup) {
        this.campaignGroup = campaignGroup;
    }

    public long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(long publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherEngineId() {
        return publisherEngineId;
    }

    public void setPublisherEngineId(String publisherEngineId) {
        this.publisherEngineId = publisherEngineId;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisherAccountName() {
        return publisherAccountName;
    }

    public void setPublisherAccountName(String publisherAccountName) {
        this.publisherAccountName = publisherAccountName;
    }

    public String getPublisherCurrency() {
        return publisherCurrency;
    }

    public void setPublisherCurrency(String publisherCurrency) {
        this.publisherCurrency = publisherCurrency;
    }

    public long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(long campaignId) {
        this.campaignId = campaignId;
    }

    public long getCampaignPublisherId() {
        return campaignPublisherId;
    }

    public void setCampaignPublisherId(long campaignPublisherId) {
        this.campaignPublisherId = campaignPublisherId;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getCampaignStatus() {
        return campaignStatus;
    }

    public void setCampaignStatus(String campaignStatus) {
        this.campaignStatus = campaignStatus;
    }

    public String getCampaignDescription() {
        return campaignDescription;
    }

    public void setCampaignDescription(String campaignDescription) {
        this.campaignDescription = campaignDescription;
    }

    public String getEnhanced() {
        return enhanced;
    }

    public void setEnhanced(String enhanced) {
        this.enhanced = enhanced;
    }

    public String getNetworks() {
        return networks;
    }

    public void setNetworks(String networks) {
        this.networks = networks;
    }

    public String getLocationTargetMethod() {
        return locationTargetMethod;
    }

    public void setLocationTargetMethod(String locationTargetMethod) {
        this.locationTargetMethod = locationTargetMethod;
    }

    public String getLocationExclusionMethod() {
        return locationExclusionMethod;
    }

    public void setLocationExclusionMethod(String locationExclusionMethod) {
        this.locationExclusionMethod = locationExclusionMethod;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public float getDailyBudget() {
        return dailyBudget;
    }

    public void setDailyBudget(float dailyBudget) {
        this.dailyBudget = dailyBudget;
    }

    public float getMonthlyBudget() {
        return monthlyBudget;
    }

    public void setMonthlyBudget(float monthlyBudget) {
        this.monthlyBudget = monthlyBudget;
    }

    public String getBudgetType() {
        return budgetType;
    }

    public void setBudgetType(String budgetType) {
        this.budgetType = budgetType;
    }

    public String getAdRotation() {
        return adRotation;
    }

    public void setAdRotation(String adRotation) {
        this.adRotation = adRotation;
    }

    public String getBudgetDelivery() {
        return budgetDelivery;
    }

    public void setBudgetDelivery(String budgetDelivery) {
        this.budgetDelivery = budgetDelivery;
    }

    public String getBiddingStrategy() {
        return biddingStrategy;
    }

    public void setBiddingStrategy(String biddingStrategy) {
        this.biddingStrategy = biddingStrategy;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getLanguageMarket() {
        return languageMarket;
    }

    public void setLanguageMarket(String languageMarket) {
        this.languageMarket = languageMarket;
    }

    public long getFreqImpressionCap() {
        return freqImpressionCap;
    }

    public void setFreqImpressionCap(long freqImpressionCap) {
        this.freqImpressionCap = freqImpressionCap;
    }

    public String getCappingTimeUnit() {
        return cappingTimeUnit;
    }

    public void setCappingTimeUnit(String cappingTimeUnit) {
        this.cappingTimeUnit = cappingTimeUnit;
    }

    public String getCappingLevel() {
        return cappingLevel;
    }

    public void setCappingLevel(String cappingLevel) {
        this.cappingLevel = cappingLevel;
    }

    public long getClicks() {
        return clicks;
    }

    public void setClicks(long clicks) {
        this.clicks = clicks;
    }

    public long getConv() {
        return conv;
    }

    public void setConv(long conv) {
        this.conv = conv;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public long getImpr() {
        return impr;
    }

    public void setImpr(long impr) {
        this.impr = impr;
    }

    public long getTotalConversionCount() {
        return totalConversionCount;
    }

    public void setTotalConversionCount(long totalConversionCount) {
        this.totalConversionCount = totalConversionCount;
    }

    public String getCtr() {
        return ctr;
    }

    public void setCtr(String ctr) {
        this.ctr = ctr;
    }

    public float getBbmCost() {
        return bbmCost;
    }

    public void setBbmCost(float bbmCost) {
        this.bbmCost = bbmCost;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("date", date)
                .append("rowType", rowType)
                .append("agencyId", agencyId)
                .append("agencyName", agencyName)
                .append("accountId", accountId)
                .append("accountName", accountName)
                .append("advertiserId", advertiserId)
                .append("advertiserEmail", advertiserEmail)
                .append("advertiserContactName", advertiserContactName)
                .append("advertiserUrl", advertiserUrl)
                .append("campaignManagerEmail", campaignManagerEmail)
                .append("campaignManager", campaignManager)
                .append("accountManagerEmail", accountManagerEmail)
                .append("accountManager", accountManager)
                .append("salesRepEmail", salesRepEmail)
                .append("salesRep", salesRep)
                .append("bcProductId", bcProductId)
                .append("productTier", productTier)
                .append("headingName", headingName)
                .append("headingId", headingId)
                .append("dwtFlag", dwtFlag)
                .append("productStartDate", productStartDate)
                .append("productEndDate", productEndDate)
                .append("productStatus", productStatus)
                .append("customerSegment", customerSegment)
                .append("migrationStatus", migrationStatus)
                .append("remainingBudget", remainingBudget)
                .append("endOfCycleTarget", endOfCycleTarget)
                .append("toDateRollover", toDateRollover)
                .append("cumulativeSpend", cumulativeSpend)
                .append("manualRollover", manualRollover)
                .append("landingPagesFlag", landingPagesFlag)
                .append("applyDiscountManagementFee", applyDiscountManagementFee)
                .append("discountedManagementFee", discountedManagementFee)
                .append("targetBudget", targetBudget)
                .append("accountField30", accountField30)
                .append("campaignGroupId", campaignGroupId)
                .append("campaignGroup", campaignGroup)
                .append("publisherId", publisherId)
                .append("publisherEngineId", publisherEngineId)
                .append("publisher", publisher)
                .append("publisherAccountName", publisherAccountName)
                .append("publisherCurrency", publisherCurrency)
                .append("campaignId", campaignId)
                .append("campaignPublisherId", campaignPublisherId)
                .append("campaignName", campaignName)
                .append("campaignStatus", campaignStatus)
                .append("campaignDescription", campaignDescription)
                .append("enhanced", enhanced)
                .append("networks", networks)
                .append("locationTargetMethod", locationTargetMethod)
                .append("locationExclusionMethod", locationExclusionMethod)
                .append("timezone", timezone)
                .append("dailyBudget", dailyBudget)
                .append("monthlyBudget", monthlyBudget)
                .append("budgetType", budgetType)
                .append("adRotation", adRotation)
                .append("budgetDelivery", budgetDelivery)
                .append("biddingStrategy", biddingStrategy)
                .append("startDate", startDate)
                .append("endDate", endDate)
                .append("languageMarket", languageMarket)
                .append("freqImpressionCap", freqImpressionCap)
                .append("cappingTimeUnit", cappingTimeUnit)
                .append("cappingLevel", cappingLevel)
                .append("clicks", clicks)
                .append("conv", conv)
                .append("cost", cost)
                .append("impr", impr)
                .append("totalConversionCount", totalConversionCount)
                .append("ctr", ctr)
                .append("bbmCost", bbmCost)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        YPAcquisioCsv that = (YPAcquisioCsv) o;

        return new EqualsBuilder()
                .append(accountId, that.accountId)
                .append(remainingBudget, that.remainingBudget)
                .append(endOfCycleTarget, that.endOfCycleTarget)
                .append(toDateRollover, that.toDateRollover)
                .append(cumulativeSpend, that.cumulativeSpend)
                .append(manualRollover, that.manualRollover)
                .append(landingPagesFlag, that.landingPagesFlag)
                .append(applyDiscountManagementFee, that.applyDiscountManagementFee)
                .append(discountedManagementFee, that.discountedManagementFee)
                .append(targetBudget, that.targetBudget)
                .append(campaignGroupId, that.campaignGroupId)
                .append(publisherId, that.publisherId)
                .append(publisherEngineId, that.publisherEngineId)
                .append(campaignId, that.campaignId)
                .append(campaignPublisherId, that.campaignPublisherId)
                .append(dailyBudget, that.dailyBudget)
                .append(monthlyBudget, that.monthlyBudget)
                .append(freqImpressionCap, that.freqImpressionCap)
                .append(clicks, that.clicks)
                .append(conv, that.conv)
                .append(cost, that.cost)
                .append(impr, that.impr)
                .append(totalConversionCount, that.totalConversionCount)
                .append(bbmCost, that.bbmCost)
                .append(date, that.date)
                .append(rowType, that.rowType)
                .append(agencyId, that.agencyId)
                .append(agencyName, that.agencyName)
                .append(accountName, that.accountName)
                .append(advertiserId, that.advertiserId)
                .append(advertiserEmail, that.advertiserEmail)
                .append(advertiserContactName, that.advertiserContactName)
                .append(advertiserUrl, that.advertiserUrl)
                .append(campaignManagerEmail, that.campaignManagerEmail)
                .append(campaignManager, that.campaignManager)
                .append(accountManagerEmail, that.accountManagerEmail)
                .append(accountManager, that.accountManager)
                .append(salesRepEmail, that.salesRepEmail)
                .append(salesRep, that.salesRep)
                .append(bcProductId, that.bcProductId)
                .append(productTier, that.productTier)
                .append(headingName, that.headingName)
                .append(headingId, that.headingId)
                .append(dwtFlag, that.dwtFlag)
                .append(productStartDate, that.productStartDate)
                .append(productEndDate, that.productEndDate)
                .append(productStatus, that.productStatus)
                .append(customerSegment, that.customerSegment)
                .append(migrationStatus, that.migrationStatus)
                .append(accountField30, that.accountField30)
                .append(campaignGroup, that.campaignGroup)
                .append(publisher, that.publisher)
                .append(publisherAccountName, that.publisherAccountName)
                .append(publisherCurrency, that.publisherCurrency)
                .append(campaignName, that.campaignName)
                .append(campaignStatus, that.campaignStatus)
                .append(campaignDescription, that.campaignDescription)
                .append(enhanced, that.enhanced)
                .append(networks, that.networks)
                .append(locationTargetMethod, that.locationTargetMethod)
                .append(locationExclusionMethod, that.locationExclusionMethod)
                .append(timezone, that.timezone)
                .append(budgetType, that.budgetType)
                .append(adRotation, that.adRotation)
                .append(budgetDelivery, that.budgetDelivery)
                .append(biddingStrategy, that.biddingStrategy)
                .append(startDate, that.startDate)
                .append(endDate, that.endDate)
                .append(languageMarket, that.languageMarket)
                .append(cappingTimeUnit, that.cappingTimeUnit)
                .append(cappingLevel, that.cappingLevel)
                .append(ctr, that.ctr)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(date)
                .append(rowType)
                .append(agencyId)
                .append(agencyName)
                .append(accountId)
                .append(accountName)
                .append(advertiserId)
                .append(advertiserEmail)
                .append(advertiserContactName)
                .append(advertiserUrl)
                .append(campaignManagerEmail)
                .append(campaignManager)
                .append(accountManagerEmail)
                .append(accountManager)
                .append(salesRepEmail)
                .append(salesRep)
                .append(bcProductId)
                .append(productTier)
                .append(headingName)
                .append(headingId)
                .append(dwtFlag)
                .append(productStartDate)
                .append(productEndDate)
                .append(productStatus)
                .append(customerSegment)
                .append(migrationStatus)
                .append(remainingBudget)
                .append(endOfCycleTarget)
                .append(toDateRollover)
                .append(cumulativeSpend)
                .append(manualRollover)
                .append(landingPagesFlag)
                .append(applyDiscountManagementFee)
                .append(discountedManagementFee)
                .append(targetBudget)
                .append(accountField30)
                .append(campaignGroupId)
                .append(campaignGroup)
                .append(publisherId)
                .append(publisherEngineId)
                .append(publisher)
                .append(publisherAccountName)
                .append(publisherCurrency)
                .append(campaignId)
                .append(campaignPublisherId)
                .append(campaignName)
                .append(campaignStatus)
                .append(campaignDescription)
                .append(enhanced)
                .append(networks)
                .append(locationTargetMethod)
                .append(locationExclusionMethod)
                .append(timezone)
                .append(dailyBudget)
                .append(monthlyBudget)
                .append(budgetType)
                .append(adRotation)
                .append(budgetDelivery)
                .append(biddingStrategy)
                .append(startDate)
                .append(endDate)
                .append(languageMarket)
                .append(freqImpressionCap)
                .append(cappingTimeUnit)
                .append(cappingLevel)
                .append(clicks)
                .append(conv)
                .append(cost)
                .append(impr)
                .append(totalConversionCount)
                .append(ctr)
                .append(bbmCost)
                .toHashCode();
    }

}
