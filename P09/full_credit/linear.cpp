#include "linear.h"
#include <stdexcept>
#include <cmath>

Linear::Linear(const std::vector<double>& coefficients) : Polynomial(coefficients) {
    if (_coefficients.size() != 2 || _coefficients[0] == 0) {
        throw std::runtime_error("a may not be 0");
    }
}

Linear::~Linear() {
    // Virtual destructor
}

std::vector<double> Linear::solve() const {
    double a = _coefficients[0];
    double b = _coefficients[1];

    std::vector<double> roots;
    roots.push_back(-b / a);

    
    return roots;
}


