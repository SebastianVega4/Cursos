#include <iostream>
#include <fstream>

using namespace std;

int main()
{
    ofstream myfile ("GameData.txt");
    string NewName;

    cin >> NewName;

    if (myfile.is_open())
    {
        myfile << "Name:" << endl;
        myfile << NewName << endl;
        myfile.close();
    }
    else cout << "Unable to open file";

        string line;
        string PlayerName;
        int lineCount = 0;
        ifstream myfileRead ("GameData.txt");

      if (myfileRead.is_open())
      {

        while ( getline (myfileRead,line) )
        {
          //  cout << line << endl;
            if(lineCount == 1)
            {
                PlayerName = line;
            }

            lineCount++;
        }
        myfileRead.close();
      }else
      {
          cout << "Unable to open file";
      }

      cout << PlayerName;






     return 0;
}
