package csakennijottunk.InGame;

import com.badlogic.gdx.utils.viewport.Viewport;

import java.awt.Label;

import csakennijottunk.Menu.MenuActors;
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
    public InGameStage(MyGame game) {
        super(new ResponseViewport(90), game);
        header = new Header(game);
        addActor(header);
        labelStyle = new Ls(game);
        MyLabel moneyLabel = new MyLabel(game,"Ugy tunik meg nincsen horgaszbotod. Vegyel egyet!", labelStyle);
        addActor(moneyLabel);
        //moneyLabel.setFontScale((float) 0.1);
        moneyLabel.setFontScale((float) 0.15, (float) 0.1);
        moneyLabel.setPosition(0,90-28);
        moneyLabel.setZIndex(20);
        addBackButtonScreenBackByStackPopListener();
        setCameraResetToCenterOfScreen();
        ms = new MenuStage(game);
        System.out.println(ms.getState());
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
