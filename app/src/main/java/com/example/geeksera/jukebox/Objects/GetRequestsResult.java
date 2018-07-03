
package com.example.geeksera.jukebox.Objects;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class GetRequestsResult {

    @SerializedName("History")
    private List<Object> mHistory;
    @SerializedName("Imei")
    private String mImei;
    @SerializedName("Purchasedate")
    private String mPurchasedate;
    @SerializedName("Purchasedby")
    private String mPurchasedby;
    @SerializedName("T_id")
    private String mTId;
    @SerializedName("TableNumber")
    private String mTableNumber;
    @SerializedName("Tcount")
    private String mTcount;
    @SerializedName("Tokenstatus")
    private String mTokenstatus;
    @SerializedName("Tokentitle_id")
    private String mTokentitleId;

    public List<Object> getHistory() {
        return mHistory;
    }

    public void setHistory(List<Object> History) {
        mHistory = History;
    }

    public String getImei() {
        return mImei;
    }

    public void setImei(String Imei) {
        mImei = Imei;
    }

    public String getPurchasedate() {
        return mPurchasedate;
    }

    public void setPurchasedate(String Purchasedate) {
        mPurchasedate = Purchasedate;
    }

    public String getPurchasedby() {
        return mPurchasedby;
    }

    public void setPurchasedby(String Purchasedby) {
        mPurchasedby = Purchasedby;
    }

    public String getTId() {
        return mTId;
    }

    public void setTId(String TId) {
        mTId = TId;
    }

    public String getTableNumber() {
        return mTableNumber;
    }

    public void setTableNumber(String TableNumber) {
        mTableNumber = TableNumber;
    }

    public String getTcount() {
        return mTcount;
    }

    public void setTcount(String Tcount) {
        mTcount = Tcount;
    }

    public String getTokenstatus() {
        return mTokenstatus;
    }

    public void setTokenstatus(String Tokenstatus) {
        mTokenstatus = Tokenstatus;
    }

    public String getTokentitleId() {
        return mTokentitleId;
    }

    public void setTokentitleId(String TokentitleId) {
        mTokentitleId = TokentitleId;
    }

}
