package csakennijottunk.InGame;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

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


class FishFood extends OneSpriteStaticActor {
    public FishFood(MyGame game){
        super(game, "Fishfoodactor.png");
        this.setSize(15,20);


    }

}

class ShopBg extends OneSpriteStaticActor {
    public ShopBg(MyGame game) {
        super(game, "Shop.png");
        int size = 90;
        this.setSize(size,80);
    }
}

class HandRod extends OneSpriteStaticActor {
    public HandRod(MyGame game) {
        super(game, "HandRod.png");
    }
}

class Header extends OneSpriteStaticActor {
    public Header(MyGame game) {
        super(game, "fejlec.png");
        this.setSize(90,10);
        this.setPosition(0,90 - 10);
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
