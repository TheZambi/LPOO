package com.g75.Controller;

import com.g75.Commands.Command;
import com.g75.Commands.CommandLevel;
import com.g75.Model.*;
import com.g75.View.*;

import java.util.HashMap;
import java.util.List;

public class LinkController {

    SwordController swordController;

    public LinkController(){
        swordController = new SwordController();
    }

    public void takeDamage(LinkModel linkModel) {
        int hp = linkModel.getHP();
        linkModel.setHP(hp-1);
        linkModel.setInvulnerability(60);
    }

    public void updateInvulnerabilty(LinkModel linkModel) {
        int invulTime = linkModel.getInvulnerability();
        if(invulTime > 0) {
            linkModel.setInvulnerability(invulTime-1);
        }
    }

    public void checkForDamage(List<EnemyModel> testingEnemiesList, LinkModel linkModel, Position newPosition, HashMap<Integer, EnemyView> hashMap, Sprite linkSprite)
    {
        for (EnemyModel enemyModel : testingEnemiesList) {
            if (linkModel.getInvulnerability() == 0 && linkGotHit(newPosition,hashMap.get(enemyModel.getTableID()).getSprite(), linkSprite, enemyModel)) {
                this.takeDamage(linkModel);
                break;
            }
        }
    }

    public boolean chechForMoveableStone(ArenaModel arenaModel, Position newPosition, LevelController levelController, ArenaView arenaView)
    {
        LevelModel levelModel = arenaModel.getMapModels().get(arenaModel.getMap()).getLevelModels().get(arenaModel.getLevel());
        for (MovableStoneModel stone: levelModel.getStoneModels()) {
            if (newPosition.onTop(stone.getPosition(), arenaView.getLevelView().getStoneView().getSprite(), arenaView.getLinkView().getSprite())) {
                levelController.getStoneController().moveStone(stone,levelModel,arenaView,arenaModel.getLinkModel().getOrientation());
                return true;
            }
        }
        return false;
    }

    public void update(Command command, ArenaView arenaView, ArenaModel arenaModel, ArenaController arenaController) {
        Position aux;
        LevelController levelController = arenaController.mapController.getLevelController();
        LevelModel levelModel = arenaModel.getMapModels().get(arenaModel.getMap()).getLevelModels().get(arenaModel.getMapModels().get(arenaModel.getMap()).getLevel());
        LinkModel linkModel = arenaModel.getLinkModel();
        linkModel.stopChangeLevel();
        aux = command.execute(linkModel);
        Sprite carpetSprite = arenaView.getLevelView().getCarpetView().getSprite();
        Sprite linkSprite = arenaView.getLinkView().getSprite();
        if(command instanceof CommandLevel){
            for(int i = 0; i< levelModel.getCarpetModels().size();i++) {
                if(linkModel.getPosition().fullyOnTop(levelModel.getCarpetModels().get(i).getPosition(),carpetSprite,linkSprite)) {
                    arenaController.changeLevel(levelModel.getCarpetModels().get(i),arenaModel,arenaView);
                    linkModel.stopChangeLevel();
                    return;
                }
            }
        }
        linkModel.setOrientation(command);
        List<EnemyModel> testingEnemiesList = levelModel.getEnemies();

        this.attackTimerUpdate(linkModel);
        this.updateInvulnerabilty(linkModel);

        checkForDamage(testingEnemiesList, linkModel, aux, arenaView.getHashMap(), linkSprite);

        if(levelModel.getBosses()!=null)
            if (linkModel.getInvulnerability() == 0 && linkGotHitByBoss(aux, arenaView.getLevelView().getModelToBossViewTable().get(levelModel.getBosses().getId()).getSprite(), linkSprite, levelModel.getBosses())) {
                this.takeDamage(linkModel);
            }

        if(linkModel.isAttacking())
            this.swordController.update(linkModel,levelModel,arenaView,levelController);



        if(chechForMoveableStone(arenaModel, aux, levelController, arenaView))
            return;



        int counter = 0;
        while(counter<levelModel.getKeys().size()){
            if(aux.onTop(levelModel.getKeys().get(counter).getPosition(),arenaView.getLevelView().getKeyView().getSprite(),linkSprite))
                pickUpKey(levelController,levelModel,linkModel,counter);
            else
                counter++;
        }

        counter = 0;
        for(CandleModel cm: levelModel.getCandleModels()){
            if(aux.onTop(cm.getPosition(),arenaView.getLevelView().getCandleView().getSprite(),linkSprite)) {
                pickUpCandle(levelController, levelModel, counter);
                break;
            }
            counter++;
        }
        for(StairModel sm: levelModel.getStairModels()) {
            if(aux.onTop(sm.getPosition(),arenaView.getLevelView().getStairView().getSprite(),linkSprite) && sm.getIsActive()==1){
                arenaController.changeMap(sm,arenaModel,arenaView);
                return;
            }
        }

        List<ObstacleModel> testingBushList = levelModel.getObstacles();
        if(canMoveHero(aux, arenaView.getObstacleViewTable(), linkSprite, testingBushList)){
            linkModel.setPosition(aux);
        }


    }

    public void pickUpCandle(LevelController levelController, LevelModel levelModel, int counter) {
        levelController.removeCandle(levelModel,counter);

    }


    private boolean linkGotHitByBoss(Position aux, Sprite sprite, Sprite linkSprite, BossModel bossModel) {
        return aux.onTop(bossModel.getPosition(), sprite, linkSprite);
    }

    public void pickUpKey(LevelController levelController, LevelModel levelModel, LinkModel linkModel,int counter) {
        linkModel.setKeys(linkModel.getKeys()+1);
        levelController.removeKey(levelModel,counter);
    }

    private void attackTimerUpdate(LinkModel linkModel) {
        int attTime = linkModel.getAttackTime();
        if(attTime > 0) {
            linkModel.setAttackTimer(attTime-1);
        }
        if(attTime==0)
            linkModel.stopAttacking();
    }

    public boolean linkGotHit(Position newPosition, Sprite enemySprite, Sprite linkSprite,EnemyModel enemyModel) {

        return newPosition.onTop(enemyModel.getPosition(), enemySprite, linkSprite);
    }

    public boolean canMoveHero(Position newPosition, HashMap<Integer, ObstacleView> obstacleTable, Sprite linkSprite, List<ObstacleModel> testingList){
        if(newPosition.x <= 0)
            return false;
        if(newPosition.y <= 0)
            return false;
        if(newPosition.x + linkSprite.width >= 400)
            return false;
        if(newPosition.y + linkSprite.height >= 161)
            return false;


        for (ObstacleModel obstacleModel : testingList) {
            if (newPosition.onTop(obstacleModel.getPosition(), obstacleTable.get(obstacleModel.getTableID()).getSprite(), linkSprite)) {
                return false;
            }
        }
        return true;
    }
}
