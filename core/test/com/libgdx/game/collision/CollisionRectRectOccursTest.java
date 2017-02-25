package com.libgdx.game.collision;

import com.libgdx.game.geometry.Rect;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class CollisionRectRectOccursTest {
	
	private Rect a;
	private Rect b;
	
	@After
	public void checkCollision() {
		Assert.assertTrue(Collision.isCollidingRectRect(a, b));
	}

	@Test
	public void checkCollisionSameSizes() {
		a = new Rect(0, 0, 10, 10);
		b = new Rect(5, 5, 10, 10);				
	}
	
	@Test
	public void checkCollisionDifferentSizes() {
		a = new Rect(2, 2, 2, 2);
		b = new Rect(0, 0, 10, 10);				
	}
	
}
