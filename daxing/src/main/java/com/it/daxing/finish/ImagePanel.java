package com.it.daxing.finish;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    private Image bgImage;

    public ImagePanel(Image img) {
        this.bgImage = img;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 绘制背景图片
        g.drawImage(bgImage, 0, 0, this);
    }
}
