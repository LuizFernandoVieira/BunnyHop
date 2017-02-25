package com.libgdx.game.entities.beans;

import com.libgdx.game.geometry.Rect;

public abstract class GameObject {

    private static int nextId = 0;

    private int id;
    private Rect box;

    public GameObject() {
        this.id = nextId;
        this.box = new Rect(0, 0, 0, 0);
        this.nextId++;
    }

    public GameObject(int x, int y) {
        this.id = nextId;
        this.box = new Rect(x, y, 0, 0);
        this.nextId++;
    }

    public GameObject(int x, int y, int w, int h) {
        this.id = nextId;
        this.box = new Rect(x, y, w, h);
        this.nextId++;
    }

    public abstract void update(float dt);

    public abstract void draw();

    public abstract void isDead();

    public abstract void notifyCollision(GameObject other);

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        GameObject.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Rect getBox() {
        return box;
    }

    public void setBox(Rect box) {
        this.box = box;
    }

}
