package csakennijottunk.Menu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import csakennijottunk.InGame.InGamePlayScreen;
import csakennijottunk.InGame.InGameScreen;
import csakennijottunk.credit.CreditScreen;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

class Ls2 extends Label.LabelStyle {
    public Ls2(MyGame game) {
        super(game.getMyAssetManager().getFont("Highman.ttf"), Color.WHITE);
    }
}

class Header2 extends OneSpriteStaticActor {
    public Header2(MyGame game) {
        super(game, "fejlec.png");
        this.setSize(90,10);
        this.setPosition(0,90 - 10);
    }
}

class MoneyActor2 extends OneSpriteStaticActor {
    public MoneyActor2(MyGame game) {
        super(game, "coin.png");
        this.setSize(10,10);
        this.setPosition(0,80);
        this.setZIndex(15);
    }
}

class MoneyLabel2 extends MyLabel {
    public MoneyLabel2(MyGame game, CharSequence text, LabelStyle style) {
        super(game, text, style);
        this.setPosition(15, 80);
        this.setSize(10,10);
        this.setZIndex(25);
    }
}

class DamilLabel2 extends MyLabel{
    public DamilLabel2(MyGame game, CharSequence text, LabelStyle style) {
        super(game, text, style);
        this.setFontScale((float) 0.40);
        this.setPosition(43,65);

    }
}

class DamilActor2 extends OneSpriteStaticActor {
    ClickListener b1;
    public DamilActor2(MyGame game) {
        super(game, "Damil.png");
        this.setSize(20,10);
        this.setPosition(25, 80);
        this.addListener(b1 = new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new MenuScreen(game));
            }
        });
    }
}
class CsaliActor2 extends OneSpriteStaticActor {
    ClickListener d1;
    public CsaliActor2(MyGame game){
        super(game,"Bait.png");
        this.setSize(10,5);
        this.setPosition(60,40);
        this.addListener(d1 = new ClickListener(){
            @Override
            public void clicked(InputEvent event,float x, float y) {
                super.clicked(event, x, y);
            }
        });
    }
}

class CsaliLabel2 extends MyLabel {
    public CsaliLabel2(MyGame game, CharSequence text, LabelStyle style) {
        super(game, text, style);
        this.setSize(10, 10);
        this.setZIndex(25);

    }
}

class BackGroundActor extends OneSpriteStaticActor {
    public BackGroundActor(MyGame game) {
        super(game, "MenuBackground.png");
        this.setSize(170,90);
        this.setPosition(-45,0);
        this.setZIndex(0);
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
class PlayLabel extends MyLabel {
    ClickListener b1;
    public PlayLabel(MyGame game, CharSequence text, LabelStyle style) {
        super(game, text, style);
        this.setFontScale((float) 0.40);
        this.setPosition(43,65);
        this.setSize(40,20);
        this.addListener(b1 = new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new InGamePlayScreen(game));
            }
        });

    }
}

class ExitLabel extends MyLabel {
    ClickListener b1;
    public ExitLabel(MyGame game, CharSequence text, LabelStyle style) {
        super(game, text, style);
        this.setFontScale((float) 0.40);
        this.setPosition(43,65);
        this.setSize(40,20);
        this.addListener(b1 = new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenBackByStackPop();
            }
        });

    }
}

class CreditLabel extends MyLabel{
    ClickListener a1;
    public CreditLabel(MyGame game, CharSequence text, LabelStyle style) {
        super(game, text, style);
        this.setFontScale((float) 0.40);
        this.setSize(40,20);
        this.setPosition(43,0);
        this.setZIndex(15);
        this.addListener(a1 = new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new CreditScreen(game));
            }
        });
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