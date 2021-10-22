package csakennijottunk.InGame;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.audio.Music;

import java.util.ArrayList;

import csakennijottunk.Menu.MenuScreen;
import hu.csanyzeg.master.Math.Ballistics2;
import hu.csanyzeg.master.MyBaseClasses.Box2dWorld.MyContactListener;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleOverlapsUtil;
import hu.csanyzeg.master.MyBaseClasses.Timers.IntervalTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.IntervalTimerListener;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class GamStage extends MyStage {

    public Vector2 fisherMan = new Vector2(200, 190);
    public Vector2 fishingRod = new Vector2(10, 10);
    public MyLabel vLabel;
    public MyLabel dLabel;
    public MyLabel myLabel;
    public boolean isOnWindow = true;
    IngameBackground ingameBackground2;
    Music music = game.getMyAssetManager().getMusic("music.mp3");
    MusicActor m;
    MusicActor2 m2;
    ClickListener d1;
    ClickListener d2;
    BasicVariables basicVariables;
    FishFoodActor fishFoodActor;
    FisherManGroup fisherManActor;
    WhiteActor whiteActor;
    OneSpriteStaticActor test;
    OneSpriteStaticActor sensorActor;
    MyContactListener l1;
    BaitActor baitActor;
    public int worms = 3;

    public void generateFlying(){
        ArrayList<Actor> actors = new ArrayList<Actor>();
        for (Actor a:getActors()) {
            if (a instanceof FlyActor){
                actors.add(a);
            }
        }
        for (Actor a:actors) {
            getActors().removeValue(a, true);
        }
        Ballistics2 ballistics2 = new Ballistics2(fisherManActor.v0, MathUtils.degreesToRadians * fisherManActor.degree, fisherManActor.get_handEnd().x, fisherManActor.get_handEnd().y);
        for(float x = fisherManActor.get_handEnd().x; x < getViewport().getWorldWidth(); x+=20) {
            addActor(new FlyActor(game, x, ballistics2.getY(x)));
        }
    }

    public Vector2 getFishingRodEnd(){
        Vector2 fishingRodEnd = new Vector2(fishingRod);
        fishingRodEnd.rotate(fisherManActor.degree);
        fishingRodEnd.add(fisherMan);
        return fishingRodEnd;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        //if (sensorActor.getStage() != null & baitActor.getStage() != null) {
            //if (SimpleOverlapsUtil.overlaps(sensorActor, baitActor)) {
              //  System.out.println("HE_LO");
            //}
       // }
    }

    public GamStage(MyGame game) {
        super(new ResponseViewport(1200), game);
        //addActor(new GameActor(game));
        addBackButtonScreenBackByStackPopListener();
        //generateFlying();
       sensorActor = new OneSpriteStaticActor(game,"badlogic.jpg");
       sensorActor.setSize(1500,250);
       sensorActor.setPosition(750,0);
       sensorActor.setVisible(true);
       //addActor(sensorActor);
       addActor(test = new OneSpriteStaticActor(game,"FeedFish.png"));
       test.setZIndex(10000);
       test.setSize(1000,1000);
       test.setPosition(500,100);
       test.addListener(new ClickListener(){
           @Override
           public void clicked(InputEvent event, float x, float y) {
               super.clicked(event, x, y);
               test.remove();
               IntervalTimer t1 = new IntervalTimer(1, new IntervalTimerListener(){
                   @Override
                   public void onTick(IntervalTimer sender, float correction) {
                       super.onTick(sender, correction);
                   }

                   @Override
                   public void onStop(IntervalTimer sender) {
                       super.onStop(sender);
                       isOnWindow = false;
                       System.out.println("okxd");
                   }

                   @Override
                   public void onStart(IntervalTimer sender) {
                       super.onStart(sender);
                   }
               });
               addTimer(t1);
           }
       });
        addListener(new ClickListener(){
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                if(isOnWindow == false) {
                    System.out.println("x= " + x + " y= " + y);
                    fisherManActor.set_angle(heightToDegree(y));
                    fisherManActor.set_speed(widthToSpeed(x));
                    vLabel.setText("" + (int) fisherManActor.degree + "°");
                    dLabel.setText("" + (int) fisherManActor.v0 + "m/s");
                    generateFlying();
                    super.touchDragged(event, x, y, pointer);
                }
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                if (isOnWindow == false) {
                    if (fisherManActor.get_hand() == FisherManGroup.Handtype.hand) {
                        addActor(fishFoodActor = new FishFoodActor(game, new Ballistics2(fisherManActor.v0, MathUtils.degreesToRadians * fisherManActor.degree, fisherManActor.get_handEnd().x, fisherManActor.get_handEnd().y),        120));
                        fisherManActor.set_hand(FisherManGroup.Handtype.none);
                        generateFlying();
                        IntervalTimer intervalTimer2 = new IntervalTimer(5,new IntervalTimerListener(){
                            @Override
                            public void onTick(IntervalTimer sender, float correction) {
                                super.onTick(sender, correction);
                            }

                            @Override
                            public void onStop(IntervalTimer sender) {
                                super.onStop(sender);
                                OneSpriteStaticActor castRod = new OneSpriteStaticActor(game,"CastRod.png");
                                addActor(castRod);
                                castRod.setSize(1000,1000);
                                castRod.setPosition(500,100);
                                castRod.setZIndex(10000);
                                isOnWindow = true;
                                castRod.addListener(new ClickListener(){
                                    @Override
                                    public void clicked(InputEvent event, float x, float y) {
                                        super.clicked(event, x, y);
                                        castRod.remove();
                                        fisherManActor.set_hand(FisherManGroup.Handtype.fishingrod);
                                        generateFlying();
                                        IntervalTimer intervalTimer = new IntervalTimer(1,new IntervalTimerListener(){
                                            @Override
                                            public void onTick(IntervalTimer sender, float correction) {
                                                super.onTick(sender, correction);
                                            }

                                            @Override
                                            public void onStop(IntervalTimer sender) {
                                                super.onStop(sender);
                                                isOnWindow = false;
                                            }

                                            @Override
                                            public void onStart(IntervalTimer sender) {
                                                super.onStart(sender);
                                            }
                                        });
                                        addTimer(intervalTimer);
                                    }
                                });
                            }

                            @Override
                            public void onStart(IntervalTimer sender) {
                                super.onStart(sender);
                            }
                        });
                        addTimer(intervalTimer2);
                    }if (fisherManActor.get_hand() == FisherManGroup.Handtype.fishingrod){
                        System.out.println("ok");
                        if (baitActor != null){
                            baitActor.remove();
                        }
                        addActor(baitActor = new BaitActor(game, new Ballistics2(fisherManActor.v0, MathUtils.degreesToRadians * fisherManActor.degree, fisherManActor.get_handEnd().x, fisherManActor.get_handEnd().y), 100));
                        baitActor.setOnStopListener(new BallisticActor.OnStopListener() {
                            @Override
                            void stop(BallisticActor sender) {
                                System.out.println("Most esett le.");
                            }
                        });
                        fisherManActor.set_hand(FisherManGroup.Handtype.bugFix);
                        generateFlying();
                        IntervalTimer intervalTimer = new IntervalTimer(5,new IntervalTimerListener(){
                            @Override
                            public void onRepeat(IntervalTimer sender) {
                                super.onRepeat(sender);
                            }

                            @Override
                            public void onTick(IntervalTimer sender, float correction) {
                                super.onTick(sender, correction);
                            }

                            @Override
                            public void onStop(IntervalTimer sender) {
                                super.onStop(sender);
                                float baitX = baitActor.getX();
                                float fishFoodX = fishFoodActor.getX();
                                if(baitX > fishFoodX){
                                    if (baitX - fishFoodX > 250){
                                        worms = worms -1;
                                        if (worms == 2){
                                            OneSpriteStaticActor twoWormsLeft = new OneSpriteStaticActor(game,"2Wormleft.png");
                                            addActor(twoWormsLeft);
                                            twoWormsLeft.setPosition(2000/2 - 500,100);
                                            twoWormsLeft.setSize(1000,1000);
                                            twoWormsLeft.setZIndex(10000);
                                            isOnWindow = true;
                                            twoWormsLeft.addListener(new ClickListener(){
                                                @Override
                                                public void clicked(InputEvent event, float x, float y) {
                                                    super.clicked(event, x, y);
                                                    twoWormsLeft.remove();
                                                    IntervalTimer intervalTimer1 = new IntervalTimer(1,new IntervalTimerListener(){
                                                        @Override
                                                        public void onTick(IntervalTimer sender, float correction) {
                                                            super.onTick(sender, correction);
                                                        }

                                                        @Override
                                                        public void onStop(IntervalTimer sender) {
                                                            super.onStop(sender);
                                                            isOnWindow = false;
                                                            fisherManActor.set_hand(FisherManGroup.Handtype.fishingrod);
                                                            generateFlying();
                                                        }

                                                        @Override
                                                        public void onStart(IntervalTimer sender) {
                                                            super.onStart(sender);
                                                        }
                                                    });
                                                    addTimer(intervalTimer1);
                                                }
                                            });
                                        }if (worms == 1){
                                            OneSpriteStaticActor oneWormsLeft = new OneSpriteStaticActor(game,"1Wormleft.png");
                                            addActor(oneWormsLeft);
                                            oneWormsLeft.setPosition(2000/2 - 500,100);
                                            oneWormsLeft.setSize(1000,1000);
                                            oneWormsLeft.setZIndex(10000);
                                            isOnWindow = true;
                                            oneWormsLeft.addListener(new ClickListener(){
                                                @Override
                                                public void clicked(InputEvent event, float x, float y) {
                                                    super.clicked(event, x, y);
                                                    oneWormsLeft.remove();
                                                    IntervalTimer intervalTimer1 = new IntervalTimer(1,new IntervalTimerListener(){
                                                        @Override
                                                        public void onTick(IntervalTimer sender, float correction) {
                                                            super.onTick(sender, correction);
                                                        }

                                                        @Override
                                                        public void onStop(IntervalTimer sender) {
                                                            super.onStop(sender);
                                                            isOnWindow = false;
                                                            fisherManActor.set_hand(FisherManGroup.Handtype.fishingrod);
                                                            generateFlying();
                                                        }

                                                        @Override
                                                        public void onStart(IntervalTimer sender) {
                                                            super.onStart(sender);
                                                        }
                                                    });
                                                    addTimer(intervalTimer1);
                                                }
                                            });
                                        }if (worms == 0){
                                            OneSpriteStaticActor noWormsLeft = new OneSpriteStaticActor(game,"NoWormleft.png");
                                            addActor(noWormsLeft);
                                            noWormsLeft.setPosition(2000/2 - 500,100);
                                            noWormsLeft.setSize(1000,1000);
                                            noWormsLeft.setZIndex(10000);
                                            isOnWindow = true;
                                            OneSpriteStaticActor restartButton = new OneSpriteStaticActor(game,"Restartbutton.png");
                                            addActor(restartButton);
                                            restartButton.setSize(200,200);
                                            restartButton.setPosition(1000 - 100 - 300,50);
                                            restartButton.addListener(new ClickListener(){
                                                @Override
                                                public void clicked(InputEvent event, float x, float y) {
                                                    super.clicked(event, x, y);
                                                    game.setScreen(new InGamePlayScreen(game));
                                                }
                                            });
                                            OneSpriteStaticActor backButton = new OneSpriteStaticActor(game,"BackButton.png");
                                            addActor(backButton);
                                            backButton.setSize(200,200);
                                            backButton.setPosition(1000 - 100 + 300,50);
                                            backButton.addListener(new ClickListener(){
                                                @Override
                                                public void clicked(InputEvent event, float x, float y) {
                                                    super.clicked(event, x, y);
                                                    game.setScreen(new MenuScreen(game));
                                                }
                                            });
                                        }
                                        System.out.println("szar");
                                    }else{
                                        OneSpriteStaticActor niceCatch = new OneSpriteStaticActor(game,"Catchedfish.png");
                                        addActor(niceCatch);
                                        niceCatch.setSize(1000,1000);
                                        niceCatch.setPosition(2000/2 - 500,250);
                                        niceCatch.setZIndex(10000);
                                        isOnWindow = true;
                                        System.out.println("jó");
                                        OneSpriteStaticActor restartButton = new OneSpriteStaticActor(game,"Restartbutton.png");
                                        addActor(restartButton);
                                        restartButton.setSize(200,200);
                                        restartButton.setPosition(1000 - 100 - 300,50);
                                        restartButton.setZIndex(10001);
                                        restartButton.addListener(new ClickListener(){
                                            @Override
                                            public void clicked(InputEvent event, float x, float y) {
                                                super.clicked(event, x, y);
                                                game.setScreen(new InGamePlayScreen(game));
                                            }
                                        });
                                        OneSpriteStaticActor backButton = new OneSpriteStaticActor(game,"BackButton.png");
                                        addActor(backButton);
                                        backButton.setSize(200,200);
                                        backButton.setPosition(1000 - 100 + 300,50);
                                        backButton.setZIndex(10001);
                                        backButton.addListener(new ClickListener(){
                                            @Override
                                            public void clicked(InputEvent event, float x, float y) {
                                                super.clicked(event, x, y);
                                                game.setScreen(new MenuScreen(game));
                                            }
                                        });
                                    }
                                }if(fishFoodX > baitX){
                                    if (fishFoodX - baitX > 250){
                                        worms = worms - 1;
                                        if (worms == 2){
                                            OneSpriteStaticActor twoWormsLeft = new OneSpriteStaticActor(game,"2Wormleft.png");
                                            addActor(twoWormsLeft);
                                            twoWormsLeft.setPosition(2000/2 - 500,100);
                                            twoWormsLeft.setSize(1000,1000);
                                            twoWormsLeft.setZIndex(10000);
                                            isOnWindow = true;
                                            twoWormsLeft.addListener(new ClickListener(){
                                                @Override
                                                public void clicked(InputEvent event, float x, float y) {
                                                    super.clicked(event, x, y);
                                                    twoWormsLeft.remove();
                                                    IntervalTimer intervalTimer1 = new IntervalTimer(1,new IntervalTimerListener(){
                                                        @Override
                                                        public void onTick(IntervalTimer sender, float correction) {
                                                            super.onTick(sender, correction);
                                                        }

                                                        @Override
                                                        public void onStop(IntervalTimer sender) {
                                                            super.onStop(sender);
                                                            isOnWindow = false;
                                                            fisherManActor.set_hand(FisherManGroup.Handtype.fishingrod);
                                                            generateFlying();
                                                        }

                                                        @Override
                                                        public void onStart(IntervalTimer sender) {
                                                            super.onStart(sender);
                                                        }
                                                    });
                                                    addTimer(intervalTimer1);
                                                }
                                            });
                                        }if (worms == 1){
                                            OneSpriteStaticActor oneWormsLeft = new OneSpriteStaticActor(game,"1Wormleft.png");
                                            addActor(oneWormsLeft);
                                            oneWormsLeft.setPosition(2000/2 - 500,100);
                                            oneWormsLeft.setSize(1000,1000);
                                            oneWormsLeft.setZIndex(10000);
                                            isOnWindow = true;
                                            oneWormsLeft.addListener(new ClickListener(){
                                                @Override
                                                public void clicked(InputEvent event, float x, float y) {
                                                    super.clicked(event, x, y);
                                                    oneWormsLeft.remove();
                                                    IntervalTimer intervalTimer1 = new IntervalTimer(1,new IntervalTimerListener(){
                                                        @Override
                                                        public void onTick(IntervalTimer sender, float correction) {
                                                            super.onTick(sender, correction);
                                                        }

                                                        @Override
                                                        public void onStop(IntervalTimer sender) {
                                                            super.onStop(sender);
                                                            isOnWindow = false;
                                                            fisherManActor.set_hand(FisherManGroup.Handtype.fishingrod);
                                                            generateFlying();
                                                        }

                                                        @Override
                                                        public void onStart(IntervalTimer sender) {
                                                            super.onStart(sender);
                                                        }
                                                    });
                                                    addTimer(intervalTimer1);
                                                }
                                            });
                                        }if (worms == 0){
                                            OneSpriteStaticActor noWormsLeft = new OneSpriteStaticActor(game,"NoWormleft.png");
                                            addActor(noWormsLeft);
                                            noWormsLeft.setPosition(2000/2 - 500,100);
                                            noWormsLeft.setSize(1000,1000);
                                            noWormsLeft.setZIndex(10000);
                                            isOnWindow = true;
                                            OneSpriteStaticActor restartButton = new OneSpriteStaticActor(game,"Restartbutton.png");
                                            addActor(restartButton);
                                            restartButton.setSize(200,200);
                                            restartButton.setPosition(1000 - 100 - 300,50);
                                            restartButton.addListener(new ClickListener(){
                                                @Override
                                                public void clicked(InputEvent event, float x, float y) {
                                                    super.clicked(event, x, y);
                                                    game.setScreen(new InGamePlayScreen(game));
                                                }
                                            });
                                            OneSpriteStaticActor backButton = new OneSpriteStaticActor(game,"BackButton.png");
                                            addActor(backButton);
                                            backButton.setSize(200,200);
                                            backButton.setPosition(1000 - 100 + 300,50);
                                            backButton.addListener(new ClickListener(){
                                                @Override
                                                public void clicked(InputEvent event, float x, float y) {
                                                    super.clicked(event, x, y);
                                                    game.setScreen(new MenuScreen(game));
                                                }
                                            });
                                        }
                                        System.out.println("szar");
                                    }else{
                                        OneSpriteStaticActor niceCatch = new OneSpriteStaticActor(game,"Catchedfish.png");
                                        addActor(niceCatch);
                                        niceCatch.setSize(1000,1000);
                                        niceCatch.setPosition(2000/2 - 500,250);
                                        niceCatch.setZIndex(10000);
                                        isOnWindow = true;
                                        System.out.println("jó");
                                        OneSpriteStaticActor restartButton = new OneSpriteStaticActor(game,"Restartbutton.png");
                                        addActor(restartButton);
                                        restartButton.setSize(200,200);
                                        restartButton.setPosition(1000 - 100 - 300,50);
                                        restartButton.addListener(new ClickListener(){
                                            @Override
                                            public void clicked(InputEvent event, float x, float y) {
                                                super.clicked(event, x, y);
                                                game.setScreen(new InGamePlayScreen(game));
                                            }
                                        });
                                        OneSpriteStaticActor backButton = new OneSpriteStaticActor(game,"BackButton.png");
                                        addActor(backButton);
                                        backButton.setSize(200,200);
                                        backButton.setPosition(1000 - 100 + 300,50);
                                        backButton.addListener(new ClickListener(){
                                            @Override
                                            public void clicked(InputEvent event, float x, float y) {
                                                super.clicked(event, x, y);
                                                game.setScreen(new MenuScreen(game));
                                            }
                                        });
                                    }
                                }
                            }

                            @Override
                            public void onStart(IntervalTimer sender) {
                                super.onStart(sender);
                            }
                        });
                        addTimer(intervalTimer);
                        //addActor(new BaitActor(game, new Ballistics2(fisherManActor.v0, MathUtils.degreesToRadians * fisherManActor.degree, fisherManActor.get_handEnd().x, fisherManActor.get_handEnd().y), 150));
                    }
                }

            }
        });
        //addActor(vLabel = new MyLabel(game, "", new Label.LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), null)));
        addActor(ingameBackground2 = new IngameBackground(game));
        ingameBackground2.setHeightWhithAspectRatio(getViewport().getWorldHeight());
        addActor(fisherManActor = new FisherManGroup(game));
        fisherManActor.setPosition(330, 230);
        m = new MusicActor(game);
        m.setSize(133, 133);
        m.setPosition(2000, 0);
        m.setZIndex(50);
        m2 = new MusicActor2(game);
        m2.setSize(133, 133);
        m2.setPosition(2000, 0);
        m2.setZIndex(50);
        basicVariables = new BasicVariables();
        if (basicVariables.getIsPlaying() == true) {
            addActor(m);
        }
        else{
            addActor(m2);
        }
        if (basicVariables.getIsPlaying() == true) {
            music.play();
        }
        m.addListener(d1 = new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                stopMusic();
                m.remove();
                addActor(m2);
            }
        });


        m2.addListener(d2 = new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                playMusic();
                m2.remove();
                addActor(m);
            }
        });
        addActor(vLabel = new MyLabel(game, "", new Label.LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), null)));
        addActor(dLabel = new MyLabel(game, "", new Label.LabelStyle(game.getMyAssetManager().getFont("alegreyaregular.otf"), null)));
        dLabel.setPosition(200,75);
        vLabel.setPosition(0,75);
        vLabel.setFontScale(3);
        dLabel.setFontScale(3);
        //addActor(new TesztActor(game, fisherMan.x, fisherMan.y));
        //addActor(new TesztActor(game, fishingRod.x, fishingRod.y));
        //addActor(fishingRodEndActor = new TesztActor2(game, getFishingRodEnd().x, getFishingRodEnd().y));
        generateFlying();
    }

    public float widthToSpeed(float x) {
        float d = x / getViewport().getWorldWidth() * 100;
        return d < 0 ? 0 : d > 100 ? 100 : d;
    }

    public float heightToDegree(float y){
        float d = y / getViewport().getWorldHeight() * 90;
        return d < 0 ? 0 : d > 85 ? 85 : d;
    }

    public boolean getState(){
        return basicVariables.getIsPlaying();
    }

    public void playMusic(){
        if (basicVariables.getIsPlaying() == false){
            music.play();
        }
        basicVariables.setIsPlaying(true);
    }

    public void stopMusic(){
        if (basicVariables.getIsPlaying() == true){
            music.pause();
        }
        basicVariables.setIsPlaying(false);
    }

}
