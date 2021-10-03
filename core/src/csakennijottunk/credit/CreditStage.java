package csakennijottunk.credit;

import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class CreditStage extends MyStage {
    CreditActor pista;
    public CreditStage(MyGame game) {
        super(new ResponseViewport(90), game);
        setCameraResetToCenterOfScreen();
        addBackButtonScreenBackByStackPopListener();
        pista = new CreditActor(game);
        addActor(pista);
    }
}
