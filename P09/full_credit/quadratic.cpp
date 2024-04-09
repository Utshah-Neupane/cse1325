#include "quadratic.h"
#include <stdexcept>
#include <cmath>

Quadratic::Quadratic(const std::vector<double>& coefficients) : Polynomial(coefficients) {
    if (_coefficients.size() != 3 || _coefficients[0] == 0) {
        throw std::runtime_error("a may not be 0");
    }
}

Quadratic::~Quadratic() {
    // Virtual destructor
}

std::vector<double> Quadratic::solve() const {
    double a = _coefficients[0];
    double b = _coefficients[1];
    double c = _coefficients[2];

    double discriminant = b*b - 4*a*c;
    
    if (discriminant < 0) {
        throw std::runtime_error("No real roots!");
    }
    
    std::vector<double> roots;
    roots.push_back((-b + std::sqrt(discriminant)) / (2*a));
    roots.push_back((-b - std::sqrt(discriminant)) / (2*a));

    
    return roots;
}


