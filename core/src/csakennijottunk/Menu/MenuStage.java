package csakennijottunk.Menu;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;

public class MenuStage extends MyStage {
    MenuActors e;
    MenuActors2 b;
    public MenuStage(MyGame game) {
        super(new ExtendViewport(90,160), game);
        addBackButtonScreenBackByStackPopListener();
        e = new MenuActors(game);
        addActor(e);
        e.setSize(50,50);
        b = new MenuActors2(game);
        addActor(b);
    }
}
