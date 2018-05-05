package src.source.model;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.util.TimerTask;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//  [MISSING] Trees should create fruit / food instances (and let MapManager
//  know about this) when they are harvested.



/**
 * This the abstract (general) "Tree" class.
 * <p>
 *
 * @author Eray
 */
public abstract class Tree extends Item {

    private int stateCnt;

    protected int updateRate;

    private boolean isWatered;




    Timer timer;
    TimerTask toUpdate;




    public Tree(int x, int y, int updateRate) {

        super(x, y);

        isWatered = false;
        this.updateRate=updateRate;

        stateCnt=0;



        timer = new Timer(updateRate, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                updateState();
            }
        });
        timer.start();
    } // constructor



    public void stopTimer(){
        timer.stop();
    }

    public void resumeTimer(){
        stateCnt=0;
        isWatered=false;//reseting values to start again in case of stop
        timer.start();

    }

    ////////////////////////////////////////////////////////////////////////////
    //
    // private functions
    //
    ////////////////////////////////////////////////////////////////////////////






    /**
     * The below function, based on the state diagram in the analysis report,
     * updates the status of this tree by drawing on thier properties.
     * <p>
     * In other words, by using the instance variables like "isWatered", and
     * by comparing such values with similar ones, this function ensures that
     * the tree is in the right state according to their boolean properties.
     *
     */
    public void updateState() {


        if(stateCnt==0 && isWatered==false) {
          //  System.out.println("HELLO HES 000000000000000");
            stateCnt=0;
            updateView();
        }
        else if(stateCnt==0 && isWatered==true) {
            stateCnt=1;
            updateView();
        }

        else if(stateCnt==1)  {
            stateCnt=2;
            updateView();
        }
        else if(stateCnt==2){
            stateCnt=0;
            updateView();
        }
        // planted
    } // updateState



    public void updateView(){
        if(stateCnt==0) setImage1();
        if(stateCnt==2) setImage2();

    }
    /**
     * This is used to water the tree. It has no effect if the tree is
     * in a state other than state 0 or state 2.
     */
    public void water() {

        isWatered=true;


    } // water




    public boolean getIsWatered() {
        return isWatered;
    }

    public void setIsWatered(boolean isWatered) {
        this.isWatered = isWatered;
    }


    public abstract void setImage1();
    public abstract void setImage2();

}