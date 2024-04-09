#include "polynomial.h"

Polynomial::Polynomial(const std::vector<double>& coefficients) 
    : _coefficients(coefficients) {}

Polynomial::~Polynomial() {  // Virtual destructor
}

