package com.chess.game;

import java.util.List;

public class HumanPlayer extends BasePlayer {

    //自己的下一步棋子，以及传入对手已经下的棋子集合
    @Override
    public void run(List<Point> enemyPoints,Point p) {
        getMyPoints().add(p);
        allFreePoints.remove(p);
    }
}