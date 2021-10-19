package csakennijottunk.Menu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;

public class Ls extends Label.LabelStyle {
    public Ls(MyGame game) {
        super(game.getMyAssetManager().getFont("Highman.ttf"), Color.WHITE);
    }
}
