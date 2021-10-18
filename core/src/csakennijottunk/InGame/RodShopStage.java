package csakennijottunk.InGame;

import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class RodShopStage extends MyStage {
    DamilActor e;
    CsaliActor c;
    Header header;
    ShopBg shopBg;
    CsaliActor csaliActor;
    RodLvl1 rodLvl1;
    RodLvl2 rodLvl2;
    RodLvl3 rodLvl3;
    Ls labelStyle;
    MoneyLabel moneyLabel;
    MoneyActor moneyActor;
    BasicVariables basicVariables;
    public RodShopStage(MyGame game) {
        super(new ResponseViewport(90), game);
        addBackButtonScreenBackByStackPopListener();
        setCameraResetToCenterOfScreen();
        labelStyle = new Ls(game);
        MyLabel vasarlasLabel = new MyLabel(game, "Vasarlas", labelStyle);
        addActor(vasarlasLabel);
        vasarlasLabel.setFontScale((float) 0.20);
        vasarlasLabel.setPosition(70, 20);
        vasarlasLabel.setZIndex(10);
        MyLabel vasarlasLabel2 = new MyLabel(game, "Vasarlas", labelStyle);
        addActor(vasarlasLabel2);
        vasarlasLabel2.setFontScale((float) 0.20);
        vasarlasLabel2.setPosition(70, -5);
        vasarlasLabel2.setZIndex(10);

        moneyLabel = new MoneyLabel(game, "0", labelStyle);
        addActor(moneyLabel);
        moneyLabel.setFontScale((float)0.40);

        moneyActor = new MoneyActor(game);
        addActor(moneyActor);
        moneyActor.setZIndex(15);
        moneyLabel.setZIndex(15);

        csaliActor = new CsaliActor(game);
        csaliActor.setSize(15, 15);
        csaliActor.setPosition(75, 75);
        csaliActor.setZIndex(15);
        addActor(csaliActor);

        //e = new DamilActor(game);
        //addActor(e);
        //e.setZIndex(-5);

        header = new Header(game);
        addActor(header);
        header.setZIndex(0);

        shopBg = new ShopBg(game);
        addActor(shopBg);
        shopBg.setZIndex(0);

        rodLvl2 = new RodLvl2(game);
        addActor(rodLvl2);
        rodLvl2.setZIndex(15);
        rodLvl2.setPosition(0,30);
        rodLvl2.setSize(40,20);

        rodLvl3 = new RodLvl3(game);
        addActor(rodLvl3);
        rodLvl3.setZIndex(15);
        rodLvl3.setPosition(0,5);
        rodLvl3.setSize(40,20);

        basicVariables = new BasicVariables();
        int money = basicVariables.getMoney();
        moneyLabel.setText(money);


    }
}
