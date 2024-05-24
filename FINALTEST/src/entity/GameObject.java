package entity;

import core.Position;
import core.Size;
import game.Game;

import java.awt.*;


// Abstract class GameObject, so bale iniinherit ng Player at enemy or any other entities pa yung gameobject which is kung nainherit na nila meron na silang attributes kung ano mang attributes nasa GameObject.
public abstract class GameObject {
    protected Position position;
    protected Size size;
    public Game game;

    public GameObject() {
        position = new Position(50,50);
        size = new Size(64, 64);
    }

    public abstract void update();
    public abstract Image getSprite();

    public Position getPosition() {
        return position;
    }

    public Size getSize() {
        return size;
    }
}