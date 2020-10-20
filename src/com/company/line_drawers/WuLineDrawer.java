package com.company.line_drawers;

import com.company.LineDrawer;
import com.company.PixelDrawer;

import java.awt.*;

public class WuLineDrawer implements LineDrawer {

    private PixelDrawer pd;

    public WuLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    void drawPixel(int x, int y, double brightness) {
        int c = (int)(255 * brightness);
        pd.drawPixel(x, y, new Color(c, c, c));
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {

       if (Math.abs(x2 - x1) > Math.abs(y2 - y1)){
           if (x1 > x2){
               int tmp = x1; x1 = x2; x2 = tmp;
               tmp = y1; y1 = y2; y2 = tmp;
           }
           double dx = x2 - x1;
           double dy = y2 - y1;
           double gradient = dy / dx;
           if (dx == 0.0){
               gradient = 1;
           }
           double y = y1;

               for (int x = x1; x <= x2; x++) {
                   drawPixel(x, (int)(y), inverseFraction(y));
                   drawPixel(x, (int)(y) - 1, fractionalPart(y));
                   y += gradient;
               }

       } else {
           int tmp = x1;
           x1 = y1; y1 = tmp; tmp = x2;
           x2 = y2; y2 = tmp;

           if (x1 > x2){
               tmp = x1; x1 = x2; x2 = tmp;
               tmp = y1; y1 = y2; y2 = tmp;
           }
           double dx = x2 - x1;
           double dy = y2 - y1;
           double gradient = dy / dx;
           if (dx == 0.0){
               gradient = 1;
           }
           double y = y1;

           for (int x = x1 ; x <= x2 ; x++) {
               drawPixel((int)(y), x, inverseFraction(y));
               drawPixel((int)(y) - 1, x, fractionalPart(y));
               y += gradient;
           }

       }
    }
    double inverseFraction(double x) { return 1 - fractionalPart(x); }

    double fractionalPart(double x) {
        if (x > 0) {
            return x - (int)(x);
        } else {
            return x;
        }

    }

}
