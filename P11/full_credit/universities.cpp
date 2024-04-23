#include <iostream>
#include <fstream>
#include <string>
#include <map>
#include <vector>

#include "university.h"

typedef std::string State;
typedef std::vector<University> Universities;

int main(int argc, char* argv[]) {
    if (argc != 2) {
        std::cerr << "Usage: " << argv[0] << " <filename>\n";
        return -1;
    }

    std::ifstream ifs(argv[1]);
    if (!ifs.is_open()) {
        std::cerr << argv[1] << ": file not found\n";
        return -2;
    }

    std::map<State, Universities> universityMap;
    State state;
    University university;

    while (ifs >> state >> university) {
        universityMap[state].push_back(university);
    }

    ifs.close();

    std::string userInput;
    while (true) {
        std::cout << "Enter a 2-character state abbreviation (or empty to exit): ";
        std::cin >> userInput;

        if (userInput.empty()) {
            break;
        }

        auto it = universityMap.find(userInput);
        if (it == universityMap.end()) {
            std::cout << "No universities found in " << userInput << std::endl;
        } else {
            std::cout << "Universities in " << userInput << ":" << std::endl;
            for (const auto& uni : it->second) {
                std::cout << "- " << uni << std::endl;
            }
        }
    }

    return 0;
}
