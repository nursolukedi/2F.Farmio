public class PotatoSeed extends Seed{

    private int growthTime, sellingPrice, buyingPrice;
    private int grownStatus;

    public PotatoSeed(int x, int y, boolean availability   )
    {
        super(x,y,availability);
        growthTime = 40;
        sellingPrice = 30;
        buyingPrice = 25;

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
