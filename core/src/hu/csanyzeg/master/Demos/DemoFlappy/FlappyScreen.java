package hu.csanyzeg.master.Demos.DemoFlappy;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class FlappyScreen extends MyScreen {
    public FlappyScreen(MyGame game) {
        super(game);
    }

    @Override
    public AssetList getAssetList() {
        AssetList assetList = new AssetList();
        assetList.addTexture(BirdActor.birdTexture);
        assetList.addTexture(PipeActor.pipeTexture);
        assetList.addTexture(CityActor.hatterTexture);
        return assetList;
    }

    @Override
    protected void afterAssetsLoaded() {
        addStage(new FlappyStage(game),1,true);
    }

    @Override
    public void init() {

    }
}