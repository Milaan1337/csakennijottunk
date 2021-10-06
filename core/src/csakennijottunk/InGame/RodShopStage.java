package csakennijottunk.InGame;

import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class RodShopStage extends MyStage {
    public RodShopStage(MyGame game) {
        super(new ResponseViewport(90), game);
        addBackButtonScreenBackByStackPopListener();
        setCameraResetToCenterOfScreen();
        boolean basicrod = false;
        boolean betterrod = false;
        boolean bestrod = false;

        int basicrodPrice = 50;
        int betterrodPrice = 100;
        int bestrodPrice = 200;

        int basicrodLength = 3;
        int betterrodLength = 4;
        int bestrodLength = 5;


    }
}
