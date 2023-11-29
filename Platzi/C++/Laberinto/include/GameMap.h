#ifndef GAMEMAP_H
#define GAMEMAP_H

#include "MapCell.h"


class GameMap
{
    public:
        MapCell* PlayerCell;

        GameMap();
        virtual ~GameMap();

        void LoadAndDrawIntro();
        void LoadAndDrawEnding();

        void Draw();

        int TryMovePlayer(int NewX, int NewY);



    protected:
        MapCell MapData[15][10];

        void LoadMapFromFile();


        void SetPlayerCell(int x, int y);
        void DrawMap(MapCell gameMap[15][10], int width, int height);

    private:
};

#endif // GAMEMAP_H
