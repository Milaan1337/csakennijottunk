package csakennijottunk.Menu;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import csakennijottunk.InGame.InGameScreen;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class MenuActors extends OneSpriteStaticActor {
    ClickListener c1;
    public MenuActors(MyGame game) {
        super(game, "badlogic.jpg");
        this.addListener(c1 = new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreenBackByStackPop();
            }
        });
    }
}

class MenuActors2 extends OneSpriteStaticActor {
    ClickListener c2;
    public MenuActors2(MyGame game) {
        super(game, "badlogic.jpg");
        this.setSize(50,50);
        this.setPosition(100,100);
        this.addListener(c2 = new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new InGameScreen(game));
            }
        });
    }
}
