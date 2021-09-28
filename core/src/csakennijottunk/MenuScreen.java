package csakennijottunk;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;
import csakennijottunk.MenuStage;

public class MenuScreen extends MyScreen {

    @Override
    public AssetList getAssetList() {
        return null;
    }

    @Override
    protected void afterAssetsLoaded() {
        addStage(new MenuStage(game),0,true );
    }

    public MenuScreen(MyGame game) {
        super(game);
    }
}
