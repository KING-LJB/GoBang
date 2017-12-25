package com.chess.game;


import java.io.Serializable;

/**
 * 棋子类的实现
 */

/**
 * 实现java.io.Serializable 接口的类是可序列化的。
 * 没有实现此接口的类将不能使它们的任一状态被序列化或逆序列化。
 */
public class Point implements Serializable{
    private static final long serialVersionUID = 4958644533922626552L;
    // 这了性能，设成公有
    public int x;
    public int y;

    public Point() {
    }


    public int getX() {
        return x;
    }

    public Point setX(int x) {
        this.x = x;
        return this;
    }

    public int getY() {
        return y;
    }

    public Point setY(int y) {
        this.y = y;
        return this;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    /**
     * 1、hashCode的存在主要是用于查找的快捷性，如Hashtable，HashMap等，hashCode是用来在散列存储结构中确定对象的存储地址的；
     * 2、如果两个对象相同，就是适用于equals(java.lang.Object) 方法，那么这两个对象的hashCode一定要相同；
     * 3、如果对象的equals方法被重写，那么对象的hashCode也尽量重写，并且产生hashCode使用的对象，
     *    一定要和equals方法中使用的一致，否则就会违反上面提到的第2点；
     * 4、两个对象的hashCode相同，并不一定表示两个对象就相同，也就是不一定适用于equals(java.lang.Object) 方法，
     * 只能够说明这两个对象在散列存储结构中，如Hashtable，他们“存放在同一个篮子里”。
     *
     * @return
     */
    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Point("+x+","+y+")";
    }
}