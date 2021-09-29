package csakennijottunk.InGame;

import com.badlogic.gdx.utils.viewport.Viewport;

import csakennijottunk.Menu.MenuActors;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class InGameStage extends MyStage {
    MenuActors actor1;
    public InGameStage(MyGame game) {
        super(new ResponseViewport(90), game);
        addBackButtonScreenBackByStackPopListener();
        actor1 = new MenuActors(game);
        addActor(actor1);
    }
}
