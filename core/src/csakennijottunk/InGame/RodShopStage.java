package csakennijottunk.InGame;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import csakennijottunk.Menu.MenuStage;
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
    CsaliLabel csaliLabel;
    RodLvl1 rodLvl1;
    RodLvl2 rodLvl2;
    RodLvl3 rodLvl3;
    Ls labelStyle;
    DamilActor damilActor;
    DamilLabel damilLabel;
    MoneyLabel moneyLabel;
    MoneyActor moneyActor;
    BasicVariables basicVariables;
    ClickListener clickListener;
    ClickListener c2;
    MusicActor m;
    MusicActor2 m2;
    Music music = game.getMyAssetManager().getMusic("music.wav");
    ClickListener mc1;
    ClickListener mc2;

    public RodShopStage(MyGame game) {
        super(new ResponseViewport(90), game);
        addBackButtonScreenBackByStackPopListener();
        setCameraResetToCenterOfScreen();
        basicVariables = new BasicVariables();
        int money = basicVariables.getMoney();
        int damil = basicVariables.getDamil();
        int csali = basicVariables.getCsali();
        labelStyle = new Ls(game);

        MyLabel vasarlasLabel = new MyLabel(game, "Buy", labelStyle);
        if (basicVariables.getRodLvl2() == false) {
            addActor(vasarlasLabel);
            vasarlasLabel.setFontScale((float) 0.20);
            vasarlasLabel.setPosition(70, 20);
            vasarlasLabel.setZIndex(10);
            vasarlasLabel.addListener(clickListener = new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    if (money >= 10) {
                        basicVariables.buyRodLvl2();
                        basicVariables.setRod(2);
                        System.out.println(basicVariables.getRodLvl2());
                        vasarlasLabel.remove();
                        basicVariables.setMoney(money - 5);
                        updateMoneyLabel();
                    }
                }
            });
        } else {
            //ide kéne egy label amin az van,hogy ez már neked megvan
            System.out.println("megvanmar");
        }
        MyLabel vasarlasLabel2 = new MyLabel(game, "Buy", labelStyle);
        if (basicVariables.getRodLvl3() == false) {
            addActor(vasarlasLabel2);
            vasarlasLabel2.addListener(c2 = new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    updateMoneyLabel();
                    if (money >= 10) {
                        basicVariables.buyRodLvl3();
                        basicVariables.setRod(3);
                        System.out.println(basicVariables.getRodLvl3());
                        vasarlasLabel2.remove();
                        basicVariables.setMoney(money - 10);
                        updateMoneyLabel();
                    }
                }
            });
            vasarlasLabel2.setFontScale((float) 0.20);
            vasarlasLabel2.setPosition(70, -5);
            vasarlasLabel2.setZIndex(10);
        } else {
            //ide kéne egy label amin az van,hogy ez már neked megvan
            System.out.println("test");
        }
        moneyLabel = new MoneyLabel(game, "", labelStyle);
        addActor(moneyLabel);
        moneyLabel.setFontScale((float) 0.40);
        moneyLabel.setText(money);

        moneyActor = new MoneyActor(game);
        addActor(moneyActor);
        moneyActor.setZIndex(15);
        moneyLabel.setZIndex(15);

        csaliActor = new CsaliActor(game);
        csaliActor.setSize(15, 15);
        csaliActor.setPosition(50, 75);
        csaliActor.setZIndex(15);
        addActor(csaliActor);

        csaliLabel = new CsaliLabel(game, "", labelStyle);
        csaliLabel.setPosition(65, 80);
        csaliLabel.setFontScale((float) 0.40);
        addActor(csaliLabel);
        csaliLabel.setText(csali);


        damilLabel = new DamilLabel(game, "0", labelStyle);
        damilLabel.setFontScale((float) 0.40);
        damilLabel.setPosition(45, 80);
        addActor(damilLabel);
        damilLabel.setZIndex(15);
        damilLabel.setText(damil);

        damilActor = new DamilActor(game);
        addActor(damilActor);
        damilActor.setZIndex(15);

        //playLabel = new PlayLabel(game, "0", labelStyle);
        //playLabel.setFontScale((float) 0.40);
        //addActor(playLabel);
        //playLabel.setZIndex(15);


        //creditLabel = new CreditLabel(game, "0", labelStyle);
        //creditLabel.setFontScale((float) 0.40);
        //addActor(creditLabel);
        //creditLabel.setZIndex(15);

        //c = new CsaliActor(game);
        //addActor(c);
        //c.setZIndex(-5);
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
        rodLvl2.setPosition(0, 30);
        rodLvl2.setSize(40, 20);

        rodLvl3 = new RodLvl3(game);
        addActor(rodLvl3);
        rodLvl3.setZIndex(15);
        rodLvl3.setPosition(0, 5);
        rodLvl3.setSize(40, 20);

        m = new MusicActor(game);
        m2 = new MusicActor2(game);
        m2.setZIndex(20);
        if (basicVariables.getIsPlaying() == true) {
            addActor(m);
        }
        else{
            addActor(m2);
        }
        m.setZIndex(20);
        if (basicVariables.getIsPlaying() == true) {
            music.play();
        }
        m.addListener(mc1 = new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                stopMusic();
                m.remove();
                addActor(m2);
            }
        });


        m2.addListener(mc2 = new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                playMusic();
                m2.remove();
                addActor(m);
            }
        });
    }


    public boolean getState(){
        return basicVariables.getIsPlaying();
    }

    public void playMusic(){
        if (basicVariables.getIsPlaying() == false){
            music.play();
        }
        basicVariables.setIsPlaying(true);
    }

    public void stopMusic(){
        if (basicVariables.getIsPlaying() == true){
            music.pause();
        }
        basicVariables.setIsPlaying(false);
    }

    public void updateMoneyLabel() {
        moneyLabel.setText(basicVariables.getMoney());
    }

    public void updateBaitLabel() {
        csaliLabel.setText(basicVariables.getCsali());
    }

    public void updateDamilLabel() {
        damilLabel.setText(basicVariables.getDamil());
    }
}

