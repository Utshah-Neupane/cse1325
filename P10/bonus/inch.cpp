#include "inch.h"

void Inch::validate() {
    if (_denominator != 1 && _denominator != 2 && _denominator != 4 && _denominator != 8 &&
        _denominator != 16 && _denominator != 32 && _denominator != 64) {
        throw std::invalid_argument("Denominator must be 1, 2, 4, 8, 16, 32, or 64");
    }
    while (_numerator >= _denominator) {
        _numerator -= _denominator;
        _whole++;
    }
    int gcd = std::gcd(_numerator, _denominator);
    _numerator /= gcd;
    _denominator /= gcd;
}


int Inch::compare(const Inch& rhs) const {
    double left_value = _whole + static_cast<double>(_numerator) / _denominator;
    double right_value = rhs._whole + static_cast<double>(rhs._numerator) / rhs._denominator;
    return left_value < right_value ? -1 : (left_value > right_value ? 1 : 0);
}


Inch::Inch() : Inch(0, 0, 2) {}

Inch::Inch(int whole, int numerator, int denominator)
    : _whole(whole), _numerator(numerator), _denominator(denominator) {
    validate();
}


Inch Inch::operator+(const Inch& rhs) const {
    int new_numerator = _numerator * (64 / _denominator) + rhs._numerator * (64 / rhs._denominator);
    int new_whole = _whole + rhs._whole;
    return Inch(new_whole, new_numerator, 64);
}


bool Inch::operator==(const Inch& rhs) const {
    return compare(rhs) == 0;
}

bool Inch::operator!=(const Inch& rhs) const {
    return compare(rhs) != 0;
}

bool Inch::operator<(const Inch& rhs) const {
    return compare(rhs) < 0;
}

bool Inch::operator<=(const Inch& rhs) const {
    return compare(rhs) <= 0;
}

bool Inch::operator>(const Inch& rhs) const {
    return compare(rhs) > 0;
}

bool Inch::operator>=(const Inch& rhs) const {
    return compare(rhs) >= 0;
}


std::ostream& operator<<(std::ostream& ost, const Inch& inch) {
    ost << inch._whole << " " << inch._numerator << "/" << inch._denominator;
    return ost;
}

std::istream& operator>>(std::istream& ist, Inch& inch) {
    char slash;
    ist >> inch._whole >> inch._numerator >> slash >> inch._denominator;
    inch.validate();
    return ist;
}
