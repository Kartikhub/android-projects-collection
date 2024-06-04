package com.example.lenovo.savedata.model;

/**
 * Created by LENOVO on 17-07-2016.
 */
public class RowCounter {
    private long mId;
    private long mFinalAmount;
    private long mCurrentAmount;

    public void addOneRow(){
        if(mCurrentAmount<mFinalAmount)
            mCurrentAmount++;
    }
    public long getCurrentAmount(){
        return mCurrentAmount;
    }
    public long getFinalAmount(){
        return mFinalAmount;
    }
    public long getId(){
        return (mId);
    }
    public void removeOneRow(){
        if(mCurrentAmount>0)
            mCurrentAmount--;
    }
    public  void setCurrentAmount(long currentAmount){
        mCurrentAmount =currentAmount;
    }
    public  void setFinalAmount(long finalAmount){
        mFinalAmount =finalAmount;

    }
    public  void setId(long id){
        mId =id;
    }

    @Override
    public String toString() {
        return (mCurrentAmount+"/"+mFinalAmount);
    }
}
