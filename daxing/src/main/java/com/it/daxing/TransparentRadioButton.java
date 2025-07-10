package com.it.daxing;

import javax.swing.*;
import javax.swing.plaf.basic.BasicRadioButtonUI;
import java.awt.*;

public class TransparentRadioButton extends JRadioButton {

    public TransparentRadioButton(String text) {
        super(text);
        setUI(new TransparentRadioButtonUI());
        setOpaque(false); // 设置为不透明
        setContentAreaFilled(false); // 不填充内容区域
        setBorderPainted(true); // 如果需要边框，设置为 true
    }

    private static class TransparentRadioButtonUI extends BasicRadioButtonUI {
        protected void paintBackground(Graphics g, AbstractButton c) {
            // 不绘制背景，实现透明效果
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Transparent JRadioButton");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        // 创建一个透明的 JRadioButton
        JRadioButton transparentRadioButton = new TransparentRadioButton("Transparent RadioButton");
        transparentRadioButton.setBackground(new Color(0, 0, 0, 0)); // 设置背景为透明
        frame.add(transparentRadioButton);

        frame.setVisible(true);
    }
}
