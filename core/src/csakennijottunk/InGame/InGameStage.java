package csakennijottunk.InGame;

import com.badlogic.gdx.utils.viewport.Viewport;

import csakennijottunk.Menu.MenuActors;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class InGameStage extends MyStage {
    InActors rodShop;
    public InGameStage(MyGame game) {
        super(new ResponseViewport(90), game);
        addBackButtonScreenBackByStackPopListener();
        setCameraResetToCenterOfScreen();
        boolean isRod = false;
        int rodType = 0;
        int money = 100;
        int horog = 0;
        int bait = 0;
        int damil = 0;
        if (isRod == false) {
            rodShop = new InActors(game);
            addActor(rodShop);
        }



    }
}