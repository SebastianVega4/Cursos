#include "MapCell.h"
using namespace std;

MapCell::MapCell()
{
    //ctor
    CellID = 0;
}

MapCell::~MapCell()
{
    //dtor
}

void MapCell::SetType(int newID)
{
    CellID = newID;
}

bool MapCell::CanWalk()
{
    return CellID != 1;
}

void MapCell::CleanCell()
{
    CellID = 0;
}

int MapCell::GetType()
{
    return CellID;
}

void MapCell::DrawCell(bool LastOfLine)
{
    cout << CellID;

    if(LastOfLine)
    {
        cout << endl;
    }
}
