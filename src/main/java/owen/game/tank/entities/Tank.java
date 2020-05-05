/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package owen.game.tank.entities;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.CollidableComponent;
import javafx.scene.shape.Circle;

/**
 *
 * @author owen
 */
public class Tank {
    
    public static enum Type {
        PLAYER_TANK1,
        PLAYER_TANK2,
        PLAYER_TANK3,
        PLAYER_TANK4
    }
    
    private int speed;
    private Entity entity;
    private int life;
    private int bulletInterval;
    private Type type;

    public Tank(int speed, Entity entity, int life, int bulletInterval, Type type) {
        this.speed = speed;
        this.entity = entity;
        this.life = life;
        this.bulletInterval = bulletInterval;
        this.type = type;
    }

    public Tank() {
        this.speed = 5;
        this.life = 1;
    }
          
    
    public void moveUp() {            
        entity.setRotation(0);
        entity.translateY(-speed);
    }
    
    public void moveDown() {        
        entity.setRotation(180);
        entity.translateY(speed);
    }
    
    public void moveLeft() {        
        entity.setRotation(270);
        entity.translateX(-speed);
    }
    
    public void moveRight() {
        entity.setRotation(90);
        entity.translateX(speed);
    }
    
    public void shoot() {
        
    }
    
    public void die() {
        
    }
    
    public void upgrade() {
        
    } 
    
    public static Tank create(Type type, double x, double y) {
        var tank = new Tank();
        switch(type) {
            case PLAYER_TANK4: {
                var entity = FXGL.entityBuilder()
                    .at(x, y)
                    .viewWithBBox(AssetUtils.PLAYER1_TANK4)
                    .buildAndAttach();
                tank.setEntity(entity);
            }
        }
        return tank;
    }
        
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getBulletInterval() {
        return bulletInterval;
    }

    public void setBulletInterval(int bulletInterval) {
        this.bulletInterval = bulletInterval;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    
}
