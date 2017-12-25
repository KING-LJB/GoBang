package com.chess.game;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * 棋盘的实现类
 */
public class ChessBoard implements IChessboard{

    private List<Point> pointList;

    /**
     * 定义一个 15*15 的棋盘
     */
    public ChessBoard(){
        pointList = new LinkedList<>();
        for(int i=0;i<15;i++){
            for(int j=0;j<15;j++){
                pointList.add(new Point(i,j));
            }
        }
    }

    public void setPointList(List<Point> pointList) {
        this.pointList = pointList;
    }

    @Override
    public int getMaxX() {
        return 15;
    }

    @Override
    public int getMaxY() {
        return 15;
    }

    /**
     * 获取空闲的棋位
     * @return
     */
    @Override
    public List<Point> getFreePoints() {
        return pointList;
    }
}
