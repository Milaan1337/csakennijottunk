package csakennijottunk.InGame;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class DamilStage extends MyStage {
    DamilActor e;
    CsaliActor c;
    Header header;
    ShopBg shopBg;
    CsaliActor csaliActor;
    CsaliLabel csaliLabel;
    Ls labelStyle;
    DamilActor damilActor;
    DamilLabel damilLabel;
    MoneyLabel moneyLabel;
    MoneyActor moneyActor;
    BasicVariables basicVariables;
    ClickListener clickListener;
    ClickListener c2;
    public DamilStage(MyGame game) {
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
                        System.out.println(basicVariables.getRodLvl2());
                        vasarlasLabel.remove();
                        basicVariables.setMoney(money - 5);
                        updateMoneyLabel();
                    }
                }
            });
        }

        moneyLabel = new MoneyLabel(game, "", labelStyle);
        addActor(moneyLabel);
        moneyLabel.setFontScale((float)0.40);
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
        damilLabel.setPosition(45,80);
        addActor(damilLabel);
        damilLabel.setZIndex(15);
        damilLabel.setText(damil);

        damilActor = new DamilActor(game);
        addActor(damilActor);
        damilActor.setZIndex(15);


        header = new Header(game);
        addActor(header);
        header.setZIndex(0);

        shopBg = new ShopBg(game);
        addActor(shopBg);
        shopBg.setZIndex(0);


    }


    public void updateMoneyLabel(){
        moneyLabel.setText(basicVariables.getMoney());
    }

    public void updateBaitLabel() {
        csaliLabel.setText(basicVariables.getCsali());
    }

    public void updateDamilLabel(){
        damilLabel.setText(basicVariables.getDamil());
    }
}
