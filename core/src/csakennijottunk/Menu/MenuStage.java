package csakennijottunk.Menu;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class MenuStage extends MyStage {
    MenuActors e;
    Creditactor k;
    MenuActors2 b;
    BackGroundActor h;
    public MenuStage(MyGame game) {
        super(new ResponseViewport(90), game);
        setCameraResetToCenterOfScreen();
        addBackButtonScreenBackByStackPopListener();
        e = new MenuActors(game);
        addActor(e);
        e.setZIndex(1);
        b = new MenuActors2(game);
        addActor(b);
        b.setZIndex(0);
        h = new BackGroundActor(game);
        addActor(h);
        h.setZIndex(-10);
        k = new Creditactor(game);
        addActor(k);
        k.setZIndex(-5);
    }
}
