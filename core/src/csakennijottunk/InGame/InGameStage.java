package csakennijottunk.InGame;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.awt.Label;
import csakennijottunk.Menu.MenuStage;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class InGameStage extends MyStage {
    InActors rodShop;
    Header header;
    Ls labelStyle;
    MenuStage ms;
    BasicVariables basicVariables;
    PlayLabel1 playLabel1;
    public InGameStage(MyGame game) {
        super(new ResponseViewport(90), game);
        header = new Header(game);
        addActor(header);
        labelStyle = new Ls(game);
        playLabel1 = new PlayLabel1(game, "Start",labelStyle);
        addActor(playLabel1);
        //MyLabel moneyLabel = new MyLabel(game,"Ugy tunik meg nincsen horgaszbotod. Vegyel egyet!", labelStyle);
        //addActor(moneyLabel);
        //moneyLabel.setFontScale((float) 0.1);
        //moneyLabel.setFontScale((float) 0.15, (float) 0.1);
        //moneyLabel.setPosition(0,90-28);
        //moneyLabel.setHeight(10);
        //moneyLabel.setZIndex(20);

        addBackButtonScreenBackByStackPopListener();
        setCameraResetToCenterOfScreen();
        basicVariables = new BasicVariables();
        //boolean isRod = basicVariables.vanBot();
        //if (isRod == false) {
           // rodShop = new InActors(game);
           // addActor(rodShop);
       // }

    }
}
