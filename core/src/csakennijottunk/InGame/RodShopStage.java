package csakennijottunk.InGame;

import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class RodShopStage extends MyStage {
    DamilActor e;
    CsaliActor c;
    Header header;
    ShopBg shopBg;
    RodLvl1 rodLvl1;
    RodLvl2 rodLvl2;
    RodLvl3 rodLvl3;
    public RodShopStage(MyGame game) {
        super(new ResponseViewport(90), game);
        addBackButtonScreenBackByStackPopListener();
        setCameraResetToCenterOfScreen();
        //c = new CsaliActor(game);
        //addActor(c);
        //c.setZIndex(-5);
        //e = new DamilActor(game);
        //addActor(e);
        //e.setZIndex(-5);

        header = new Header(game);
        addActor(header);
        header.setZIndex(10);

        shopBg = new ShopBg(game);
        addActor(shopBg);
        shopBg.setZIndex(0);

        rodLvl1 = new RodLvl1(game);
        addActor(rodLvl1);
        rodLvl1.setZIndex(15);
        rodLvl1.setPosition(0,30);
        rodLvl1.setSize(40,20);

        rodLvl2 = new RodLvl2(game);
        addActor(rodLvl2);
        rodLvl2.setZIndex(15);
        rodLvl2.setPosition(50,30);
        rodLvl2.setSize(40,20);

        rodLvl3 = new RodLvl3(game);
        addActor(rodLvl3);
        rodLvl3.setZIndex(15);
        rodLvl3.setPosition(0,5);
        rodLvl3.setSize(40,20);



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
