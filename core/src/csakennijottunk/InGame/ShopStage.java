package csakennijottunk.InGame;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class ShopStage extends MyStage {
    BasicVariables basicVariables;
    RodShopLabel RodShopLabel;
    Ls labelStyle;
    public ShopStage(MyGame game) {
        super(new ResponseViewport(90), game);
        labelStyle = new Ls(game);
        RodShopLabel = new RodShopLabel(game, "FishingRod", labelStyle);
        addActor(RodShopLabel);


        addBackButtonScreenBackByStackPopListener();
        setCameraResetToCenterOfScreen();
        basicVariables = new BasicVariables();

    }
}
