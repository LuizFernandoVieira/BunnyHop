package com.libgdx.game.collision;

import com.libgdx.game.geometry.Rect;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class CollisionRectRectDoesntOccursTest {
	
	private Rect a;
	private Rect b;
	
	@After
	public void checkCollision() {
		Assert.assertFalse(Collision.isCollidingRectRect(a, b));
	}

	@Test
	public void checkCollisionSameSizes() {
		a = new Rect(0, 0, 10, 10);
		b = new Rect(10, 10, 10, 10);				
	}
	
	@Test
	public void checkCollisionDifferentSizes() {
		a = new Rect(10, 10, 10, 10);
		b = new Rect(5, 5, 5, 5);				
	}

}
