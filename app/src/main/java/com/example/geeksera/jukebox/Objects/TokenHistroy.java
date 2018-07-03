
package com.example.geeksera.jukebox.Objects;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class TokenHistroy {

    @SerializedName("GetRequestsResult")
    private List<com.example.geeksera.jukebox.Objects.GetRequestsResult> mGetRequestsResult;

    public List<com.example.geeksera.jukebox.Objects.GetRequestsResult> getGetRequestsResult() {
        return mGetRequestsResult;
    }

    public void setGetRequestsResult(List<com.example.geeksera.jukebox.Objects.GetRequestsResult> GetRequestsResult) {
        mGetRequestsResult = GetRequestsResult;
    }

}
