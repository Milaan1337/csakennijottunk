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
        super(game, "badlogic.jpg");
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
class DamilActor extends OneSpriteStaticActor {
    ClickListener b1;
    public DamilActor(MyGame game) {
        super(game, "green.png");
        this.setSize(10,5);
        this.setPosition(40, 40);
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
        super(game,"green.png");
        this.setSize(10,5);
        this.setPosition(60,40);
        this.addListener(d1 = new ClickListener(){
            @Override
            public void clicked(InputEvent event,float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new MenuScreen(game));
            }
        });
    }
}

class Header extends OneSpriteStaticActor {
    public Header(MyGame game) {
        super(game, "fejlec.png");
        this.setSize(90,10);
        this.setPosition(0,90 - 10);
    }
}
