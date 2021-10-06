package csakennijottunk.InGame;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

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