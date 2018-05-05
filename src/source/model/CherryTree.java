package src.source.model;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * This is the CherryTree class.
 * <p>
 * You may adjust its watering due time, time required to grow and time
 * required to start producing fruit through the respective setters.
 *
 * @author Eray
 */
public class CherryTree extends Tree {



    ////////////////////////////////////////////////////////////////////////////
    //
    // (additional to those inherited) instance variables
    //
    ////////////////////////////////////////////////////////////////////////////



    private ImageIcon image;
    private ImageIcon temp;

    // and, of course, superclasses' instance variables are inherited



    ////////////////////////////////////////////////////////////////////////////
    //
    // constructors
    //
    ////////////////////////////////////////////////////////////////////////////



    public CherryTree(int x, int y) {


        super(x, y, 30000);





        // I have adapted the following line from Fuad's code
        image = new ImageIcon("src/images/cherry-tree-before.png");
        temp=image;
    }







    ////////////////////////////////////////////////////////////////////////////
    //
    // public OVERRIDDEN functions
    //
    ////////////////////////////////////////////////////////////////////////////



    @Override
    public String getName() {

        return "CherryTree";

    }

    @Override
    public ImageIcon getImage() {

        return image;

    }

    public void draw(Graphics g)
    {
        g.drawImage(image.getImage(),getX(),getY(),40,40,null);
    }

    @Override
    public int getStoreSellingPrice() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setImage1() {
        image = new ImageIcon("src/images/cherry-tree-after.png");

    }


    @Override
    public void setImage2() {
        image = temp;

    }

}