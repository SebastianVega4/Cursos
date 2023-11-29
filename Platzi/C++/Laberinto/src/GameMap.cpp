#include "GameMap.h"

#include <fstream>
using namespace std;

GameMap::GameMap()
{

    //Create map file
   /* ofstream myfile ("Intro.txt");
    if (myfile.is_open())
    {

        myfile.close();
    }*/

    LoadAndDrawIntro();


    LoadMapFromFile();
}

GameMap::~GameMap()
{
    //dtor
}

void GameMap::Draw()
{
    DrawMap(MapData,15,10);
}

void GameMap::DrawMap(MapCell gameMap[15][10], int width, int height)
{
    for(int i = 0; i < height; i++)
    {
        for(int p = 0; p < width; p ++)
        {
            if(p != width -1)
            {
                 gameMap[p][i].DrawCell();
            }
            else
            {
                 gameMap[p][i].DrawCell(true);
            }

        }
    }
}

void GameMap::LoadMapFromFile()
{
    string line;
    ifstream myfile ("Map.txt");

    int rows = 0;
    if (myfile.is_open())
    {
        while ( getline (myfile,line) )
        {
            for(int column = 0; column < line.length(); column++)
            {
                switch(line[column])
                {
                case '0':
                    MapData[column][rows].SetType(0);
                    break;

                case '1':
                    MapData[column][rows].SetType(1);
                    break;

                case '3':
                    MapData[column][rows].SetType(3);
                    break;


                default:
                    break;

                }
            }

            rows++;

        }
        myfile.close();
    }
}

int GameMap::TryMovePlayer(int NewX, int NewY)
{
    if(MapData[NewX][NewY].GetType() == 0)
    {
        SetPlayerCell(NewX,NewY);
        return 0;
    }
    else if(MapData[NewX][NewY].GetType() == 3)
    {
        MapData[NewX][NewY].SetType(0);
        return 3;
    }
    else
    {
        return 1;
    }
}

void GameMap::LoadAndDrawIntro()
{
    string line;
    ifstream myfile ("Intro.txt");

    int rows = 0;
    if (myfile.is_open())
    {
        while ( getline (myfile,line) )
        {
            cout << line << endl;
        }
    }

    myfile.close();

    cin >> line;
}

void GameMap::LoadAndDrawEnding()
{
    string line;
    ifstream myfile ("Ending.txt");

    int rows = 0;
    if (myfile.is_open())
    {
        while ( getline (myfile,line) )
        {
            cout << line << endl;
        }
    }
    myfile.close();
}

void GameMap::SetPlayerCell(int x, int y)
{
    if(PlayerCell != NULL)
    {
        PlayerCell->CleanCell();
    }

    PlayerCell = &MapData[x][y];
    PlayerCell->SetType(2);
}
