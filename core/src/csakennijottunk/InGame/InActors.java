package csakennijottunk.InGame;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

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
        this.setSize(10,10);

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

class CsaliLabel extends MyLabel {
    public CsaliLabel(MyGame game, CharSequence text, LabelStyle style) {
        super(game, text, style);
        this.setSize(10, 10);
        this.setZIndex(25);

    }
}

class ShopLabel extends MyLabel {
    ClickListener k1;
    public ShopLabel(MyGame game, CharSequence text, LabelStyle style) {
        super(game, text, style);
        this.setFontScale((float) 0.40);
        this.setSize(40,40);
        this.setPosition(75,10);
        this.addListener(k1 = new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new RodShopScreen(game));
            }
        });

    }
}


class RodShopLabel extends MyLabel {
    ClickListener i1;
    public RodShopLabel(MyGame game, CharSequence text, LabelStyle style) {
        super(game,text, style);
        this.setFontScale((float) 0.40);
        this.setSize(40,40);
        this.setPosition(75,10);
        this.addListener(i1 = new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new RodShopScreen(game));
            }
        });

    }
}
class CsaliShopLabel extends MyLabel {
    ClickListener i1;
    public CsaliShopLabel(MyGame game, CharSequence text, LabelStyle style) {
        super(game,text, style);
        this.setFontScale((float) 0.40);
        this.setSize(40,40);
        this.setPosition(75,10);
        this.addListener(i1 = new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new RodShopScreen(game));
            }
        });

    }
}
class DamilShopLabel extends MyLabel {
    ClickListener i1;
    public DamilShopLabel(MyGame game, CharSequence text, LabelStyle style) {
        super(game,text, style);
        this.setFontScale((float) 0.40);
        this.setSize(40,40);
        this.setPosition(75,10);
        this.addListener(i1 = new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new RodShopScreen(game));
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
        this.setSize(1040,520);
    }
}

class PlayLabel1 extends MyLabel {
    ClickListener b1;
    public PlayLabel1(MyGame game, CharSequence text, LabelStyle style) {
        super(game, text, style);
        this.setFontScale((float) 0.40);
        this.setPosition(30,10);
        this.setSize(40,40);
        this.addListener(b1 = new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new InGamePlayScreen(game));
            }
        });

    }
}

class MusicActor extends OneSpriteStaticActor {
    ClickListener d2;
    boolean isMuted = false;
    public MusicActor(MyGame game) {
        super(game, "SoundON.png");
        this.setSize(10, 10);
        this.setPosition(115, 0);
    }
}

class MusicActor2 extends OneSpriteStaticActor {
    ClickListener d2;
    boolean isMuted = false;
    public MusicActor2(MyGame game) {
        super(game, "SoundOFF.png");
        this.setSize(10, 10);
        this.setPosition(115, 0);
    }
}
