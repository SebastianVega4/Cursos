#include <iostream>
#include "GameMap.h"
#include "Player.h"

using namespace std;

int main()
{

    bool IsPlaying = true;
    GameMap Map;
    Player* player = new Player();

    //Forcing player initialization
    player->ForcePosition(1,1);
    Map.TryMovePlayer(player->GetXCord(), player->GetYCord());


    //GameLoop while our player is alive
    while(player->alive)
    {
        Map.Draw();
        player->PrintScore();
        //Calling player input
        player->CallInput();

        //Making a prediction if the cell is avaiable

        int PlayerPrediction = Map.TryMovePlayer(player->GetXCord(), player->GetYCord());
        if(PlayerPrediction == 1)
        {
            //if not we reset to last position
            player->ResetLastPosition();
        }
        else if(PlayerPrediction == 3)
        {
            player->AddScore(1);
        }


    }

    Map.LoadAndDrawEnding();
    cout << "Final Score: " << endl;
    player->PrintScore();
    cout << "Thanks for playing my game!" << endl;



    delete player;

    return 0;
}

