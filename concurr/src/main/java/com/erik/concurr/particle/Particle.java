package com.erik.concurr.particle;

import java.util.Random;
import java.awt.Graphics;

public class Particle {
    private int x;
    private int y;
    private final Random rng = new Random();

    public Particle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public synchronized void move() {
        x += rng.nextInt(10) - 5;
        y += rng.nextInt(20) - 10;
    }

    public void draw(Graphics g) {
        int lx, ly;
        synchronized (this) { lx = x; ly = y; }
        g.drawRect(lx, ly, 10, 10);
    }
}