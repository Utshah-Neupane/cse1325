#include <iostream>
#include <fstream>
#include <string>
#include <map>
#include <vector>
#include <iomanip> // for std::setw

#include "university.h"

typedef std::string State;

int main(int argc, char* argv[]) {
    if (argc != 3) {
        std::cerr << "Usage: " << argv[0] << " <filename> <state_abbrev_file>\n";
        return -1;
    }

    std::ifstream stateAbbrevFile(argv[2]);
    if (!stateAbbrevFile.is_open()) {
        std::cerr << argv[2] << ": state abbreviations file not found\n";
        return -2;
    }

    std::map<std::string, std::string> stateAbbrevMap;
    std::string stateName, abbrev;

    while (std::getline(stateAbbrevFile, abbrev) && std::getline(stateAbbrevFile, stateName)) {
        stateAbbrevMap[abbrev] = stateName;
    }

    stateAbbrevFile.close();

    std::ifstream ifs(argv[1]);
    if (!ifs.is_open()) {
        std::cerr << argv[1] << ": file not found\n";
        return -3;
    }

    std::multimap<State, University> universityMap;
    State state;
    University university;

    while (ifs >> state >> university) {
        universityMap.insert(std::make_pair(state, university));
    }

    ifs.close();

    std::cout << "State Abbreviations Reference Table:" << std::endl;
    std::cout << std::left << std::setw(25) << "Abbreviation" << "State/Territory" << std::endl;
    for (const auto& [abbrev, stateName] : stateAbbrevMap) {
        std::cout << std::left << std::setw(25) << abbrev << stateName << std::endl;
    }

    std::string userInput;
    while (true) {
        std::cout << "\n\nEnter a 2-character state abbreviation (or -1 to exit): ";
        std::cin >> userInput;

        if (userInput.empty()) {
            break;
        }

        if (userInput == "-1") {
            return 0;
        }

        std::cout << "Universities in " << userInput << ":" << std::endl;
        for (auto it = universityMap.begin(); it != universityMap.end(); ++it) {
            if (it->first == userInput) {
                std::cout << "- " << it->second << std::endl;
            }
        }
    }

    return 0;
}
