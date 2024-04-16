#include <iostream>
#include <fstream>
#include "inch.h"

int main(int argc, char* argv[]) {
    Inch in, last_in, sum;

    std::ifstream ifs;
    std::ofstream ofs;

    // Open input file if provided
    if (argc > 1) {
        ifs.open(argv[1]);
        if (!ifs.is_open()) {
            std::cerr << "Error opening input file." << std::endl;
            return 1;
        }

        // Read Inch objects from the file
        while (ifs >> in) {
            sum = sum + in;
            std::cout << "\n\nRead: " << in <<" from "<<argv[1]<< std::endl;

            if (in == last_in) {
            std::cout << "The same length as last time." << std::endl;
            }
            if (in != last_in) {
                std::cout << "NOT the same length as last time." << std::endl;
            }
            if (in > last_in) {
                std::cout << "Bigger lenth than last time." << std::endl;
            }
            if (in >= last_in) {
                std::cout << "Bigger or same length as last time." << std::endl;
            }
            if (in < last_in) {
                std::cout << "Smaller lenth than last time." << std::endl;
            }
            if (in <= last_in) {
                std::cout << "Smaller or same length as last time." << std::endl;
            }

            std::cout << "Sum so far is: " << sum << std::endl;

            last_in = in;
        }

        ifs.close();
    }

    // Open output file if provided
    if (argc > 2) {
        ofs.open(argv[2]);
        if (!ofs.is_open()) {
            std::cerr << "Error opening output file." << std::endl;
            return 1;
        }
    }

    // Read Inch objects from std::cin until end of file
    while (std::cin >> in) {
        sum = sum + in;
        std::cout << "You entered: " << in << std::endl;

        if (ofs.is_open() && ofs.good()) {
            ofs << in << std::endl;  // Write Inch object to the output file
        }

        if (in == last_in) {
            std::cout << "The same length as last time." << std::endl;
        }
        if (in != last_in) {
            std::cout << "NOT the same length as last time." << std::endl;
        }
        if (in > last_in) {
            std::cout << "Bigger length than last time." << std::endl;
        }
        if (in >= last_in) {
            std::cout << "Bigger or same length as last time." << std::endl;
        }
        if (in < last_in) {
            std::cout << "Smaller length than last time." << std::endl;
        }
        if (in <= last_in) {
            std::cout << "Smaller or same length as last time." << std::endl;
        }

        last_in = in;
    }

    if (ofs.is_open()) {
        ofs.close();
    }

    std::cout << "Sum so far is: " << sum << std::endl;

    return 0;
}
