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
            pd.drawPixel(x, y, new Color(0, 0, 0, (float) brightness));
        }

        @Override
        public void drawLine(int x1, int y1, int x2, int y2) {



            if (Math.abs(y1 - y2) > Math.abs(x1 - x2)){
                if (y1 > y2){
                    int tmp = y1; y1 = y2; y2 = tmp;
                    tmp = x1; x1 = x2; x2 = tmp;
                }

                double dx = x2 - x1;
                double dy = y2 - y1;
                double gradient = dx / dy;


                double x = x1;

                for (int y = y1; y <= y2 ; y++) {
                    drawPixel((int)(x) + 1, y, fractionalPart(x));
                    drawPixel((int)(x), y, inverseFraction(x));
                    x += gradient;
                }

            } else {
                if (x1 > x2){
                    int tmp = x1; x1 = x2; x2 = tmp;
                    tmp = y1; y1 = y2; y2 = tmp;
                }

                double dx = x2 - x1;
                double dy = y2 - y1;
                double gradient = dy / dx;

                double y = y1;

                for (int x = x1; x <= x2; x++) {
                    drawPixel(x, (int)(y) + 1, fractionalPart(y));
                    drawPixel(x, (int)(y), inverseFraction(y));
                    y += gradient;
                }

            }
        }
        double inverseFraction(double x) { return 1 - fractionalPart(x); }

        double fractionalPart(double x) {
          return (x - (int)(x));
        }
    }


