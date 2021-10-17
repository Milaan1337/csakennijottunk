package csakennijottunk.InGame;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import hu.csanyzeg.master.MyBaseClasses.Assets.MyAssetManager;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class Ls extends Label.LabelStyle {
    public Ls(MyGame game) {
        super(game.getMyAssetManager().getFont("Highman.ttf"), Color.WHITE);
    }
}
