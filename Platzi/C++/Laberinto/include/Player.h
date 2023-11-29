#ifndef PLAYER_H
#define PLAYER_H

#include <iostream>



class Player
{
    public:
        Player();

        void CallInput();

        void ForcePosition(int forcedX, int forcedY);
        void ResetLastPosition();
        void SetNewPosition(int NewX, int NewY);

        int GetXCord();
        int GetYCord();

        void PrintScore();
        void AddScore(int value);


        bool alive;

    protected:
        int x;
        int y;

        int score;

        int lastX;
        int lastY;

        int maxWidth;
        int maxHeight;

        void Move(int vx, int vy);


    private:
};

#endif // PLAYER_H
