package csakennijottunk.InGame;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import csakennijottunk.Menu.MenuScreen;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class InActors extends OneSpriteStaticActor {
    ClickListener c1;
    public InActors(MyGame game) {
        super(game, "DefaultRodbg.png");
        this.setSize(20,10);
        this.setPosition(45 - 10, 50);
        this.addListener(c1 = new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new RodShopScreen(game));
            }
        });
    }
}
class DamilLabel extends MyLabel{
    public DamilLabel(MyGame game, CharSequence text, LabelStyle style) {
        super(game, text, style);
        this.setFontScale((float) 0.40);
        this.setPosition(43,65);

    }
}
class PlayLabel extends MyLabel{
    public PlayLabel(MyGame game, CharSequence text, LabelStyle style) {
        super(game, text, style);
        this.setFontScale((float) 0.40);
        this.setPosition(43,65);

    }
}
class CreditLabel extends MyLabel{
    public CreditLabel(MyGame game, CharSequence text, LabelStyle style) {
        super(game, text, style);
        this.setFontScale((float) 0.40);
        this.setPosition(43,65);

    }
}
class DamilActor extends OneSpriteStaticActor {
    ClickListener b1;
    public DamilActor(MyGame game) {
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
class CsaliActor extends OneSpriteStaticActor {
    ClickListener d1;
    public CsaliActor(MyGame game){
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

class ShopBg extends OneSpriteStaticActor {
    public ShopBg(MyGame game) {
        super(game, "Shop.png");
        int size = 90;
        this.setSize(size,80);
    }
}

class Header extends OneSpriteStaticActor {
    public Header(MyGame game) {
        super(game, "fejlec.png");
        this.setSize(90,10);
        this.setPosition(0,90 - 10);
    }
}

class MoneyActor extends OneSpriteStaticActor {
    public MoneyActor(MyGame game) {
        super(game, "coin.png");
        this.setSize(10,10);
        this.setPosition(0,80);
        this.setZIndex(15);
    }
}

class MoneyLabel extends MyLabel {
    public MoneyLabel(MyGame game, CharSequence text, LabelStyle style) {
        super(game, text, style);
        this.setPosition(15, 80);
        this.setSize(10,10);
        this.setZIndex(25);
    }
}
class RodLvl1 extends OneSpriteStaticActor {
    public RodLvl1(MyGame game) {
        super(game, "DefaultRod.png");
    }
}

class RodLvl2 extends OneSpriteStaticActor {
    public RodLvl2(MyGame game) {
        super(game, "Upgrade.png");
    }
}

class RodLvl3 extends OneSpriteStaticActor {
    public RodLvl3(MyGame game) {
        super(game, "Upgrade2.png");
    }
}

class IngameBackground extends OneSpriteStaticActor{
    public IngameBackground(MyGame game) {
        super(game, "IngameBackground.png");
        this.setSize(90,90);
    }
}