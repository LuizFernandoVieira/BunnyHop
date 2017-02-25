package com.libgdx.game.collision;

import com.libgdx.game.geometry.Circle;
import com.libgdx.game.geometry.Point;

import org.junit.Assert;
import org.junit.Test;

public class CollisionPointCircleOccursTest {

	private Point a;
	private Circle b;
	
	@Test
	public void checkCollision() {
		a = new Point(10, 10);
		b = new Circle(new Point(5, 5), 10);
		Assert.assertTrue(Collision.isCollidingPointCircle(a, b));
	}
	
}
