#include <iostream>

using namespace std;

void PrintCell(float Cells[], int index)
{
    cout << Cells[index] << endl;
}

void PrintMessage(string message)
{
    cout << message << endl;
}

int main()
{
    float Grades[3];
    bool Enemies[2] = { false, true };


    Grades[2] = 3.1416f;
    PrintCell(Grades, 2);
    PrintCell(Grades, 0);

    cin >> Grades[0];
    PrintCell(Grades, 0);

    string Names[5] = { "Asterix", "Obelix", "Idiafix", "Panoramix", "Asuranceturix"};

    PrintMessage(Names[4]);

    return 0;
}
