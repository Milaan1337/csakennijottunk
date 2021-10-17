package csakennijottunk.credit;

import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import csakennijottunk.InGame.Ls;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class CreditStage extends MyStage {
    Ls labelStyle;
    Ls labelStyle2;
    Ls labelStyle3;
    Ls labelStyle4;
    Ls labelStyle5;
    CreditActor pista;
    public CreditStage(MyGame game) {
        super(new ResponseViewport(90), game);
        setCameraResetToCenterOfScreen();
        addBackButtonScreenBackByStackPopListener();
        labelStyle = new Ls(game);
        MyLabel creditLabel = new MyLabel(game, "Developers:", labelStyle);
        addActor(creditLabel);
        creditLabel.setPosition(25, 40);
        creditLabel.setFontScale((float) 0.15);
        creditLabel.setZIndex(20);
        labelStyle2 = new Ls(game);
        MyLabel creditLabel2 = new MyLabel(game, "Fellner Milan", labelStyle);
        addActor(creditLabel2);
        creditLabel2.setPosition(25, 30);
        creditLabel2.setFontScale((float) 0.15);
        creditLabel2.setZIndex(20);
        labelStyle3 = new Ls(game);
        MyLabel creditLabel3 = new MyLabel(game, "Kancsal Mate", labelStyle);
        addActor(creditLabel3);
        creditLabel3.setPosition(25, 20);
        creditLabel3.setFontScale((float) 0.15);
        creditLabel3.setZIndex(20);
        labelStyle4 = new Ls(game);
        MyLabel creditLabel4 = new MyLabel(game, "Zsebök David Ferenc", labelStyle);
        addActor(creditLabel4);
        creditLabel4.setPosition(25, 10);
        creditLabel4.setFontScale((float) 0.15);
        creditLabel4.setZIndex(20);
        labelStyle5 = new Ls(game);
        MyLabel creditLabel5 = new MyLabel(game, "Nemeth Csaba Bence", labelStyle);
        addActor(creditLabel5);
        creditLabel5.setPosition(25, 0);
        creditLabel5.setFontScale((float) 0.15);
        creditLabel5.setZIndex(20);
        pista = new CreditActor(game);
        addActor(pista);
    }
}
