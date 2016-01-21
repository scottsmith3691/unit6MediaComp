import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
public class collage
{
    public  static void main(String[] args)
    {
        Picture original = new Picture("barbaraS.jpg");
        Picture copy1 = new Picture("barbaraS.jpg");
        Picture copy2 = new Picture("barbaraS.jpg");
        Picture copy3 = new Picture("barbaraS.jpg");
        Pixel[][] originalPix = original.getPixels2D();
        int height = originalPix.length;
        int width = originalPix[0].length;
        Picture canvas = new Picture(height*2,width*2);
        copy1.mirrorVertical();
        copy2.mirrorVertical();
        copy2.negateFinal();
        copy3.mirrorVertical();
        copy3.negateFinal();
        copy3.mirrorHorizontal();
        
        canvas.cropAndCopy(original, 0, height, 0, width, 0, 0);
        canvas.cropAndCopy(copy1, 0, height, 0, width, 0 + height, 0);
        canvas.cropAndCopy(copy2, 0, height, 0, width, 0, 0 + width);
        canvas.cropAndCopy(copy3, 0, height, 0, width, 0 + height, 0 + width);
    }
}
