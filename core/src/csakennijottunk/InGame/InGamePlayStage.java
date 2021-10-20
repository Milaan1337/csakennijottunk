package csakennijottunk.InGame;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import csakennijottunk.InGame.InActors;
import hu.csanyzeg.master.Math.Ballistics1;
import hu.csanyzeg.master.Math.Ballistics2;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class InGamePlayStage extends MyStage {
     IngameBackground ingameBackground;
     CsaliActor csaliActor;
     ClickListener c1;
     Ballistics1 ballistics1;
     Ballistics2 ballistics2;
     IngameBackground ingameBackground2;
    public InGamePlayStage(MyGame game) {
        super(new ResponseViewport(90), game);
        setCameraResetToCenterOfScreen();
        addBackButtonScreenBackByStackPopListener();
        ingameBackground = new IngameBackground(game);
        addActor(ingameBackground);
        csaliActor = new CsaliActor(game);
        addActor(csaliActor);
        csaliActor.setSize(50,50);
    }
}
