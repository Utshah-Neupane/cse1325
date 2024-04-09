#include <iostream>
#include <vector>
#include <stdexcept>
#include "polynomial.h"
#include "linear.h"
#include "quadratic.h"

int main(int argc, char* argv[]) {
    if (argc != 3 && argc != 4) {
        std::cerr << "Invalid polynomial size - must be linear or quadratic" << std::endl;
        return -1;
    }

    std::vector<double> coefficients;
    for (int i = 2; i < argc; ++i) {
        coefficients.push_back(std::stod(argv[i]));
    }

    Polynomial* p = nullptr;

    try {
        if (argc == 3) {
            if (coefficients[0] == 0) {
                throw std::runtime_error("a may not be 0");
            }
            p = new Linear({coefficients[0], coefficients[1]});
        } else {
            if (coefficients[0] == 0) {
                throw std::runtime_error("a may not be 0");
            }
            p = new Quadratic({coefficients[0], coefficients[1], coefficients[2]});
        }
        
        std::vector<double> roots = p->solve();
        
        std::cout << "Roots: ";
        for (const auto& root : roots) {
            std::cout << root << " ";
        }
        std::cout << std::endl;

    } catch (const std::exception& e) {
        std::cerr << e.what() << std::endl;
        if (p) delete p;
        return -1;
    }

    if (p) delete p;
    return 0;
}
