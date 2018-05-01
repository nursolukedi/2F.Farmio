import java.util.*;


public class SunflowerSeed extends Seed {

    private int growthTime, sellingPrice, buyingPrice , grownStatus;

    // since growtime , selling price and buying price is different on each seed ,
    // they are declared on each subclass of seed.

    public SunflowerSeed(int x, int y, boolean availability   )
    {
        super(x,y,availability);
        growthTime = 30;
        sellingPrice = 10;
        buyingPrice = 5;
    }

    // growing ability changes from seed to seed
    public void grow()
    {
        if(!isDeveloped && hasWater ){
            grownStatus += growSpeed ;
            consumeWater();
        }
    }

    // fertilized status will be set according to tha different type of growing speeds
    // fertilizing will improve grow speed and also it will increase selling price

    public void setFertilizedStatus(boolean fertilized )
    {
        isFertilized = fertilized;
        if(fertilized && !isSpoiled){
            growSpeed += 20;
            sellingPrice += 5;
        }

    }

    //  checking if gmc applied before, if seed is spoile or if it is developed
    // appliying gmc will increase growing speed and it will lower it's harvested selling price

    public void setGMCStatus( boolean gmcStatus )
    {
        if(!isDeveloped && !isSpoiled && !isGMCApplied)
        {
            isGMCApplied = gmcStatus ;
            if( gmcStatus )
            {
                growSpeed += 25;
                sellingPrice -= 5;

            }

        }
    }

    // getter and setter methods

    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(int buyingPrice) {
        this.buyingPrice = buyingPrice;
    }
    public int getGrowthTime() {
        return growthTime;
    }

    public void setGrowthTime(int growthTime) {
        this.growthTime = growthTime;
    }

    public int getGrownStatus() {
        return grownStatus;
    }

    public void setGrownStatus(int grownStatus) {
        this.grownStatus = grownStatus;
    }


}
