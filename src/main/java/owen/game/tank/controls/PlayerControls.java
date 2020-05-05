/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package owen.game.tank.controls;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import javafx.scene.input.KeyCode;
import owen.game.tank.entities.Tank;

/**
 *
 * @author layne
 */
public class PlayerControls {
    Input input = FXGL.getInput();
    
    public PlayerControls(Tank tank){
        input.addAction(new UserAction("Move Right") {
            @Override
            protected void onAction() {
                tank.moveRight(); // move right 5 pixels
            }
        }, KeyCode.RIGHT);
        
        input.addAction(new UserAction("Move Left") {
            @Override
            protected void onAction() {
                tank.moveLeft(); // move left 5 pixels
            }
        }, KeyCode.LEFT);

        input.addAction(new UserAction("Move Up") {
            @Override
            protected void onAction() {
                 tank.moveUp(); // move up 5 pixels
            }
        }, KeyCode.UP);

        input.addAction(new UserAction("Move Down") {
            @Override
            protected void onAction() {
                 tank.moveDown(); // move down 5 pixels
            }
        }, KeyCode.DOWN);
    }
    
}
