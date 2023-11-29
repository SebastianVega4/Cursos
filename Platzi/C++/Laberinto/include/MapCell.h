#ifndef MAPCELL_H
#define MAPCELL_H

#include <iostream>

class MapCell
{
    public:
        MapCell();
        virtual ~MapCell();

        void SetType(int newID);
        int GetType();

        void DrawCell(bool LastOfLine = false);

        void CleanCell();

        bool CanWalk();

    protected:
        int CellID;
    private:
};

#endif // MAPCELL_H
