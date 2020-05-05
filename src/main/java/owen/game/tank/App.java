package owen.game.tank;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import owen.game.tank.controls.PlayerControls;
import owen.game.tank.entities.Tank;

/**
 * JavaFX App
 */
public class App extends GameApplication {
    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(1200);
        settings.setHeight(900);
        settings.setTitle("Basic Game App");
        settings.setVersion("0.1");
    }

    @Override
    protected void initInput() {
        
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("pixelsMoved", 0);
    }

    private Entity player;
    private Tank tank;

    @Override
    protected void initGame() {
        var x = FXGL.getAppWidth()/2;
        var y = FXGL.getAppHeight();
        tank = Tank.create(Tank.Type.PLAYER_TANK1, 300, 300);
        PlayerControls playerControls = new PlayerControls(tank);
        FXGL.getGameTimer().runOnceAfter(() -> {
            var newTank = tank.upgrade(Tank.Type.PLAYER_TANK4); 
            playerControls.setTank(newTank);
        }, Duration.millis(5000));
    }

    @Override
    protected void initUI() {

    }

    public static void main(String[] args) {
        launch(args);
    }
}