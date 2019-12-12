package hu.csanyzeg.master.Demos.DemoMenu;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

import hu.csanyzeg.master.Demos.DemoActor.ActorScreen;
import hu.csanyzeg.master.Demos.DemoFlappy.FlappyScreen;
import hu.csanyzeg.master.Demos.DemoSzakkor.SzakkorScreen;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Assets.MyAssetManager;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;

/**
 * Created by tuskeb on 2016. 09. 30..
 */
public class MenuStage extends MyStage {

    public static AssetList assetList = new AssetList();
    static {
        MyAssetManager.collectAssetDescriptor(MenuButton.class, assetList);
    }


    public MenuStage(final MyGame game) {
        super(new FitViewport(720,720), game);


        addBackButtonScreenBackByStackPopListener();

        addActor(new MenuButton(game, "Flappy Demo"){
            @Override
            public void init() {
                super.init();
                setPosition(0,300);
                setSize(200,50);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new FlappyScreen(game));
                    }
                });
            }
        });

        addActor(new MenuButton(game, "Szakkör Demo"){
            @Override
            public void init() {
                super.init();
                setPosition(0,200);
                setSize(200,50);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new SzakkorScreen(game));
                    }
                });
            }
        });


        addActor(new MenuButton(game, "Actor Demo"){
            @Override
            public void init() {
                super.init();
                setPosition(0,100);
                setSize(200,50);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new ActorScreen(game));
                    }
                });
            }
        });


        addActor(new MenuButton(game, "Exit"){
            @Override
            public void init() {
                super.init();
                setPosition(0,0);
                setSize(200,50);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreenBackByStackPop();
                    }
                });
            }
        });
    }

    public void init()
    {


    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    protected void resized() {

    }

    @Override
    public void dispose() {
        super.dispose();

    }
}
