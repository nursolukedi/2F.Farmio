package src.source.model;
import java.awt.Graphics;

import javax.swing.ImageIcon;

/**
 * This is the AppleTree class.
 * <p>
 * You may adjust its watering due time, time required to grow and time
 * required to start producing fruit through the respective setters.
 *
 * @author Eray
 */
public class AppleTree extends Tree {



    ////////////////////////////////////////////////////////////////////////////
    //
    // instance variables
    //
    ////////////////////////////////////////////////////////////////////////////


    private ImageIcon image;
    private ImageIcon temp;
    // and, of course, superclasses' instance variables are inherited



    ////////////////////////////////////////////////////////////////////////////
    //
    // (additional to those inherited) constructors
    //
    ////////////////////////////////////////////////////////////////////////////



    public AppleTree(int x, int y) {


        super(x, y, 15000);





        // I have adapted the following line from Fuad's code
        image = new ImageIcon("src/images/apple-tree-before.png");
        temp=image;

    }

    @Override
    public String getName() {

        return "AppleTree";

    }

    @Override
    public ImageIcon getImage() {

        return image;

    }



    @Override
    public int getStoreSellingPrice() {
        // TODO Auto-generated method stub
        return 0;
    }

    public void draw(Graphics g)
    {
        g.drawImage(image.getImage(),getX(),getY(),40,40,null);
    }



    @Override
    public void setImage1() {
        image = new ImageIcon("src/images/apple-tree-after.png");

    }


    @Override
    public void setImage2() {
        image = temp;

    }


}