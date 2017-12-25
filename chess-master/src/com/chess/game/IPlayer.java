package com.chess.game;

import java.util.List;


/**
 * 玩家接口
 */
public interface IPlayer {
    //自己的下一步棋子，以及传入对手已经下的棋子集合
    public void run(List<Point> enemyPoints, Point point);

    public boolean hasWin();

    public void setChessboard(IChessboard chessboard);

    public List<Point> getMyPoints();
}
