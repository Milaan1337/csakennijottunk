package csakennijottunk;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;

public class MenuStage extends MyStage {

    public MenuStage(MyGame game) {
        super(new ExtendViewport(90,160), game);
    }
}
