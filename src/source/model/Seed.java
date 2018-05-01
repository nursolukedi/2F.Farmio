
import java.util.*;

public class Seed {
    protected boolean hasWater, isFertilized, isGMCApplied, isPlanted, isDeveloped,isSpoiled , availability ;
    protected int price,timeCounter, waterStatus, waterTime , growSpeed,  x, y, grownStatus ;
    protected Timer seedTimer;


        /**
        * Seed Name : growTime  , sellPrice , buyPrice , growSpeed
        * Potato Seed Time : 40 , 30 , 25 , 5
        * Tomato Seed Time : 50 , 20 , 15 , 5
        * Corn Seed Time : 100 , 40 , 35 , 5
        * Sunflower Seed : 30 , 10 , 5 , 5
        * Strawberry Seed : 60 , 50 , 45 , 5
        *
        * */

    public Seed( int x, int y, boolean availability)
    {
        isGMCApplied = false ;
        isDeveloped = false;
        isPlanted = false;
        isSpoiled = false;
        hasWater = false;
        isFertilized = false;
        grownStatus = 0;
        this.x = x;
        this.y = y;
        this.availability = availability;
        waterStatus = 0;
        growSpeed = 5;

    }


    public void water()
    {
        if(waterStatus < 100 ){
            waterStatus = 100;
            hasWater = true;
        }
        else
            System.out.println("This plant is already watered");
    }
    public boolean getFertilizedStatus()
    {
        return isFertilized;
    }

    public void plant()
    {
        isPlanted = true;
    }

    public void consumeWater()
    {
        waterStatus -= 5;
    }

    public boolean isHasWater() {
        return hasWater;
    }

    public void setHasWater(boolean hasWater) {
        this.hasWater = hasWater;
    }

    public boolean isFertilized() {
        return isFertilized;
    }

    public void setFertilized(boolean fertilized) {
        isFertilized = fertilized;
    }

    public boolean isGMCApplied() {
        return isGMCApplied;
    }

    public void setGMCApplied(boolean GMCApplied) {
        isGMCApplied = GMCApplied;
    }

    public boolean isPlanted() {
        return isPlanted;
    }

    public void setPlanted(boolean planted) {
        isPlanted = planted;
    }

    public boolean isDeveloped() {
        return isDeveloped;
    }

    public void setDeveloped(boolean developed) {
        isDeveloped = developed;
    }

    public boolean isSpoiled() {
        return isSpoiled;
    }

    public void setSpoiled(boolean spoiled) {
        isSpoiled = spoiled;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTimeCounter() {
        return timeCounter;
    }

    public void setTimeCounter(int timeCounter) {
        this.timeCounter = timeCounter;
    }

    public int getWaterStatus() {
        return waterStatus;
    }

    public void setWaterStatus(int waterStatus) {
        this.waterStatus = waterStatus;
    }

    public int getWaterTime() {
        return waterTime;
    }

    public void setWaterTime(int waterTime) {
        this.waterTime = waterTime;
    }

    public int getGrowSpeed() {
        return growSpeed;
    }

    public void setGrowSpeed(int growSpeed) {
        this.growSpeed = growSpeed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getGrownStatus() {
        return grownStatus;
    }

    public void setGrownStatus(int grownStatus) {
        this.grownStatus = grownStatus;
    }

    public Timer getSeedTimer() {
        return seedTimer;
    }

    public void setSeedTimer(Timer seedTimer) {
        this.seedTimer = seedTimer;
    }
}
