package csakennijottunk.credit;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import csakennijottunk.InGame.InGamePlayScreen;
import csakennijottunk.Menu.MenuScreen;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class CreditActor extends OneSpriteStaticActor {
    public CreditActor(MyGame game) {
        super(game, "MenuBackground.png");
        this.setSize(170, 90);
        this.setPosition(-45, 0);

    }
}

class BackLabel extends MyLabel {
    ClickListener d1;
    public BackLabel(MyGame game, CharSequence text, LabelStyle style) {
        super(game, text, style);
        this.setFontScale((float) 0.40);
        this.setPosition(-30, -13);
        this.addListener(d1 = new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenBackByStackPop();
            }
        });

    }
}

class CreditlistActor extends OneSpriteStaticActor {
    public CreditlistActor(MyGame game) {
        super(game, "Developers.png");
        this.setSize(100, 150);
        this.setPosition(0, -60);


    }
}
class MusicActor extends OneSpriteStaticActor {
    ClickListener d2;
    boolean isMuted = false;
    public MusicActor(MyGame game) {
        super(game, "SoundON.png");
        this.setSize(10, 10);
        this.setPosition(100, 0);
    }
}

class MusicActor2 extends OneSpriteStaticActor {
    ClickListener d2;
    boolean isMuted = false;
    public MusicActor2(MyGame game) {
        super(game, "SoundOFF.png");
        this.setSize(10, 10);
        this.setPosition(100, 0);
    }
}
