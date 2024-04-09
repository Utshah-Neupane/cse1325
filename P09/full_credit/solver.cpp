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
            p = new Linear(coefficients);
        } else {
            p = new Quadratic(coefficients);
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