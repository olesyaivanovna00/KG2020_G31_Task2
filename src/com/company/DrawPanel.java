package com.company;

import com.company.line_drawers.BresenhamLineDrawer;
import com.company.line_drawers.DDALineDrawer;
import com.company.line_drawers.GraphicsLineDrawer;
import com.company.line_drawers.WuLineDrawer;
import com.company.utils.DrawUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel implements MouseMotionListener {
    private Point position = new Point(0, 0);

    public DrawPanel() {
        this.addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);

        Graphics bi_g = bi.createGraphics();
        bi_g.setColor(Color.WHITE);
        bi_g.fillRect(0, 0, getWidth(), getHeight());
        bi_g.setColor(Color.BLACK);
        PixelDrawer pd = new GraphicsPixelDrawer(bi_g);
        LineDrawer ld = new WuLineDrawer((pd));
/***/
        drawAll(ld);
/***/
        g.drawImage(bi, 0, 0, null);
        bi_g.dispose();
    }

    private void drawAll(LineDrawer ld){
        DrawUtils.drawSnowflake(ld, getWidth()/2, getHeight()/2, 50, 32);
        ld.drawLine(getWidth()/2, getHeight()/2, position.x, position.y);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        position = new Point(e.getX(), e.getY());
        repaint();
    }
}
