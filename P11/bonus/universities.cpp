#include <iostream>
#include <fstream>
#include <string>
#include <map>
#include <vector>
#include <iomanip> // for std::setw

#include "university.h"

typedef std::string State;
typedef std::vector<University> Universities;


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

    std::map<State, Universities> universityMap;
    State state;
    University university;

    while (ifs >> state >> university) {
        universityMap[state].push_back(university);
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

        if (userInput == "-1"){
            return 0;
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