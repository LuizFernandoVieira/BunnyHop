package com.libgdx.game.collision;

import com.libgdx.game.geometry.Circle;
import com.libgdx.game.geometry.Point;
import com.libgdx.game.geometry.Rect;

public class Collision {
	
	public static boolean isCollidingRectRect(Rect a, Rect b) {
		if((a.getX() < b.getX() + b.getW()) && 
		   (a.getX() + a.getW() > b.getX()) &&
		   (a.getY() < b.getY() + b.getH()) &&
		   (a.getY() + a.getH() > b.getY()) ){
			return true;
		}
		return false;
	} 
	
	public static boolean isCollidingPointCircle(Point a, Circle c) {
		Point b = c.getCenter();
		int radius = c.getRadius();
		int i = (int) (Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
		if(i < Math.pow(radius, 2)) {
			return true;
		}
		return false;
	}
	
	public static boolean isComplexCollidingRectRect(Rect a, Rect b, int angleA, int angleB) {
		Point[] A = {
			new Point(a.getX(), a.getY() + a.getH()),
			new Point(a.getX() + a.getW(), a.getY() + a.getH()),
			new Point(a.getX() + a.getW(), a.getY()),
			new Point(a.getX(), a.getY())
		};
		
		Point[] B = {
			new Point(b.getX(), b.getY() + b.getH()),
			new Point(b.getX() + b.getW(), b.getY() + b.getH()),
			new Point(b.getX() + b.getW(), b.getY()),
			new Point(b.getX(), b.getY())
		};
		
		for(Point p : A) {
			
		}
		
		for(Point p : B) {
			
		}
		
		return false;
	}

}
