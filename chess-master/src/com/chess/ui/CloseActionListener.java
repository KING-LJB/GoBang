package com.chess.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 关闭
 *
 * ActionListener: ActionListener用于接收操作事件的侦听器接口。
 * 对处理操作事件感兴趣的类可以实现此接口，而使用该类创建的对象可使用组件的 addActionListener 方法向该组件注册。
 * 在发生操作事件时，调用该对象的 actionPerformed 方法。
 */
public class CloseActionListener implements ActionListener{

    private Window window;
    private boolean confirm = true;

    public CloseActionListener(Window window) {
        this.window = window;
    }

    public CloseActionListener(Window window, boolean confirm) {
        this.window = window;
        this.confirm = confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!confirm||MyOptionPane.showConfirmDialog(window,"退出","您真要退出吗？","是","否")==JOptionPane.OK_OPTION){
            window.dispose();
        }
    }
}
