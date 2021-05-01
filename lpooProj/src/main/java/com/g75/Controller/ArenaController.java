package com.g75.Controller;

import com.g75.Commands.Command;
import com.g75.Model.*;
import com.g75.View.ArenaView;

public class ArenaController {
    LinkController linkController;
    MapController mapController;


    public ArenaController() {
        this.mapController = new MapController();
        this.linkController = new LinkController();
    }

    public void updateLink(ArenaModel arenaModel, Command command, ArenaView arenaView) {
        this.linkController.update(command, arenaView, arenaModel, this);
    }

    public void updateEnemies(ArenaModel arenaModel, ArenaView arenaView) {
        this.mapController.update(arenaModel.getLinkModel(), arenaModel.getMapModels().get(arenaModel.getMap()), arenaView.getLevelView());
    }


    public void changeLevel(CarpetModel carpetModel, ArenaModel arenaModel, ArenaView arenaView) {
        if (arenaModel.getMapModels().get(arenaModel.getMap()).getLevelModels().get(arenaModel.getLevel()).getBosses() == null) {
            if (carpetModel.getIsLocked() == 0) {
                arenaModel.getMapModels().get(arenaModel.getMap()).setLevel(carpetModel.getNextLevel());
                arenaView.getMapViews().get(arenaModel.getMap()).draw(arenaView.graphics);
                String func = "initMap" + arenaModel.getMap() + "Level" + carpetModel.getNextLevel();
                try {
                    arenaModel.getClass().getDeclaredMethod(func, boolean.class, Position.class).invoke(arenaModel, true, carpetModel.getPosition());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (arenaModel.getLinkModel().getKeys() > 0 && carpetModel.getIsLocked() == 1) {
                carpetModel.unlock();
                arenaModel.getLinkModel().setKeys(arenaModel.getLinkModel().getKeys() - 1);
            } else if (arenaModel.getLinkModel().getKeys() == 0 && carpetModel.getIsLocked() == 1) {
                arenaModel.getMapModels().get(arenaModel.getMap()).getLevelModels().get(arenaModel.getLevel()).getPopUpModel().setPopUpTime(120);

            }
        }
    }

    public void updatePopUp(ArenaModel arenaModel) {
        PopUpModel aux = arenaModel.getMapModels().get(arenaModel.getMap()).getLevelModels().get(arenaModel.getLevel()).getPopUpModel();
        aux.setPopUpTime(aux.getPopUpTime() - 1);

    }

    public void changeMap(StairModel sm, ArenaModel arenaModel, ArenaView arenaView) {
        arenaModel.setMap(sm.getNextMap());
        arenaView.getMapViews().get(arenaModel.getMap()).draw(arenaView.graphics);
        String func = "initMap" + sm.getNextMap() + "Level0";
        try {
            arenaModel.getLinkModel().setHP(3);
            arenaModel.getClass().getDeclaredMethod(func, boolean.class, Position.class).invoke(arenaModel, true, null);
            arenaView.getMapViews().get(arenaModel.getMap()).draw(arenaView.graphics); //Draw current map
            arenaView.screen.refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
