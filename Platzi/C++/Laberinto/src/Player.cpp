#include "Player.h"

using namespace std;

Player::Player()
{
    maxWidth = 15;
    maxHeight = 10;
    alive = true;
    score = 0;
}

void Player::CallInput()
{
    char input = ' ';

    cin >> input;

    switch(input)
    {
    case 'w':
        Move(0,-1);
        break;

    case 'd':
        Move(1,0);
        break;

    case 'a':
        Move(-1,0);
        break;

    case 's':
        Move(0,1);
        break;

    case 'k':
        alive = false;
        break;

    default:
        cout << "Please enter a correct player command: 'w' 'a' 's' 'd' ('p' to exit game). :)" << endl;
        break;

    }
}

void Player::Move(int vx, int vy)
{
    vx = x + vx;
    vy = y + vy;

    /*if(x - vx < 0)
        vx = 0;

    if(x + vx > maxWidth)
        vx = maxWidth;

    if(y - vy < 0)
        vy = 0;

    if(y + vy > maxHeight)
        vy = maxHeight;*/

    SetNewPosition(vx,vy);

}

void Player::PrintScore()
{
    cout << "Player Score: " << score << endl;
}

void Player::AddScore(int value)
{
    score += value;

    if(score >= 1)
    {
        alive = false;
    }
}

void Player::SetNewPosition(int NewX, int NewY)
{
    lastX = x;
    lastY = y;

    x = NewX;
    y = NewY;
}

void Player::ResetLastPosition()
{
    x = lastX;
    y = lastY;
}


void Player::ForcePosition(int forcedX, int forcedY)
{
    lastX = x;
    lastY = y;

    x = forcedX;
    y = forcedY;
}


int Player::GetXCord()
{
    return x;
}

int Player::GetYCord()
{
    return y;
}
