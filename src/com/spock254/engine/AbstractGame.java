package com.spock254.engine;

public abstract class AbstractGame {

    public abstract void setUp(Kernel kernel);
    public abstract void update(Kernel kernel, float deltaTime);
    public abstract void render(Kernel kernel, Renderer renderer);
}
