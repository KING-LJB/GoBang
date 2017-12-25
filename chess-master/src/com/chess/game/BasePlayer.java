package com.chess.game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * 实现了玩家接口的基类
 * 所有的玩家类的父类（包括AI）
 */
public abstract class BasePlayer implements IPlayer {


    //我已下的棋子
    protected List<Point> myPoints = new LinkedList<Point>();
    //棋盘
    protected IChessboard chessboard;
    //棋盘最大横坐标和纵标，
    protected int maxX;
    protected int maxY;

    //所有空白棋子
    protected List<Point> allFreePoints;

    /**
     * 得到我已经下的棋子的集合
     * @return
     */
    @Override
    public final List<Point> getMyPoints() {
        return myPoints;
    }

    @Override
    public void setChessboard(IChessboard chessboard) {
        this.chessboard = chessboard;
        allFreePoints = chessboard.getFreePoints();
        maxX = chessboard.getMaxX();
        maxY = chessboard.getMaxY();
        myPoints.clear();
    }

    private final Point temp = new Point(0, 0);
    //我是否是否赢了, 默认返回 false
    public final boolean hasWin(){
        if(myPoints.size()<5){
            return false;
        }
        Point point = myPoints.get(myPoints.size()-1);// 得到最新下的那个棋子的point对象
        int count = 1;
        int x=point.getX(),y=point.getY();

        /**
         * 横向--
         */
        // 在这一行的已下的连接的棋子的个数
        temp.setX(x).setY(y);
        while (myPoints.contains(temp.setX(temp.getX()-1)) && temp.getX()>=0 && count<5) {
            count ++;
        }
        // 判断现在棋子的个数
        if(count>=5){
            return true;
        }
        // 在这一行的已下的连接的棋子的个数
        temp.setX(x).setY(y);
        while (myPoints.contains(temp.setX(temp.getX()+1)) && temp.getX()<maxX && count<5) {
            count ++;
        }
        // 判断现在棋子的个数
        if(count>=5){
            return true;
        }


        /**
         * 纵向|
         */
        count = 1;
        temp.setX(x).setY(y);
        while (myPoints.contains(temp.setY(temp.getY()-1)) && temp.getY()>=0) {
            count ++;
        }
        if(count>=5){
            return true;
        }
        temp.setX(x).setY(y);
        while (myPoints.contains(temp.setY(temp.getY()+1)) && temp.getY()<maxY && count<5) {
            count ++;
        }
        if(count>=5){
            return true;
        }


        /**
         * 正斜向 /
         * x 向右移动值增加
         * y 向下移动值增加
         */
        count =1;
        temp.setX(x).setY(y);

        // 在已下的棋子(正斜向)的左下方的位置上下一个子
        while (myPoints.contains(temp.setX(temp.getX()-1).setY(temp.getY()+1)) && temp.getX()>=0 && temp.getY()<maxY) {
            count ++;
        }
        if(count>=5){
            return true;
        }

        temp.setX(x).setY(y);
        // 在已下的棋子(正斜向)的右上方的位置上下一个子
        while (myPoints.contains(temp.setX(temp.getX()+1).setY(temp.getY()-1)) && temp.getX()<maxX && temp.getY()>=0 && count<6) {
            count ++;
        }
        if(count>=5){
            return true;
        }


        /**
         * 反斜 \
         */
        count = 1;
        temp.setX(x).setY(y);
        // 在已下的棋子(反斜向，左上方)上的个数
        while (myPoints.contains(temp.setX(temp.getX()-1).setY(temp.getY()-1)) && temp.getX()>=0 && temp.getY()>=0) {
            count ++;
        }
        if(count>=5){
            return true;
        }

        temp.setX(x).setY(y);
        // 在已下的棋子(反斜向)的右下方的个数
        while (myPoints.contains(temp.setX(temp.getX()+1).setY(temp.getY()+1)) && temp.getX()<maxX && temp.getY()<maxY && count<5) {
            count ++;
        }
        if(count>=5){
            return true;
        }
        return false;
    }
}