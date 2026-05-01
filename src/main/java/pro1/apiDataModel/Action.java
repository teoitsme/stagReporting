package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;

public class Action {
    @SerializedName("obsazeni")
    public int studentsCount;
    @SerializedName("ucitIdno")
    public long teacherID;
    @SerializedName("typAkceZkr")
    public String typAkceZkr;
    @SerializedName("tydenZkr")
    public String tydenZkr;

    @SerializedName("denZkr")
    public String denZkr;
}
