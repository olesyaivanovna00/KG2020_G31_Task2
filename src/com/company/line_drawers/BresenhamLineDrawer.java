package com.company.line_drawers;

import com.company.LineDrawer;
import com.company.PixelDrawer;

import java.awt.*;

public class BresenhamLineDrawer implements LineDrawer {

    private PixelDrawer pd;

    public BresenhamLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;



        //pd.drawPixel(x1, y1, Color.red);

        if (Math.abs(dx) > Math.abs(dy)){
            int error = Math.abs(dx) / 2;
            for (int i = 0; i < Math.abs(dx); i++) {
                error -= Math.abs(dy);
                if (error < 0) {
                    error += Math.abs(dx);
                    x1 += sign(dx);
                    y1 += sign(dy);
                } else {
                    x1 += sign(dx);
                    y1 += 0;
                }
                pd.drawPixel(x1, y1, Color.red);
            }
        } else {
            int error = Math.abs(dy) / 2;
            for (int i = 0; i < Math.abs(dy); i++) {
                error -= Math.abs(dx);
                if (error < 0) {
                    error += Math.abs(dy);
                    x1 += sign(dx);
                    y1 += sign(dy);
                } else {
                    x1 += 0;
                    y1 += sign(dy);
                }
                pd.drawPixel(x1, y1, Color.red);
            }
        }


    }

    private int sign(int a){
        if (a > 0)
            return 1;
        else if (a < 0)
            return -1;
        return 0;
    }
}
