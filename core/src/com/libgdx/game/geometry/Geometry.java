package com.libgdx.game.geometry;

public class Geometry {

    public static int projectionX(int module, double angle) {
        angle = angle * Math.PI / 180;
        return (int) Math.cos(angle) * module;
    }

    public static int projectionY(int module, double angle) {
        angle = angle * Math.PI / 180;
        return (int) Math.sin(angle) * module;
    }

    public static double distance(Point p1, Point p2) {
        double powX = Math.pow(p1.getX() - p1.getX(), 2);
        double powY = Math.pow(p2.getX() - p2.getX(), 2);
        return Math.sqrt(powX);
    }

}
