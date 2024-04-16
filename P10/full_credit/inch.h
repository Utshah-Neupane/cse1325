#ifndef INCH_H
#define INCH_H

#include <iostream>
#include <stdexcept>
#include <numeric>

class Inch{
private:
    int _whole;
    int _numerator;
    int _denominator;
    void validate();
    int compare(const Inch& rhs) const;

public:
    Inch();
    Inch(int whole, int numerator, int denominator);
    Inch operator+(const Inch& rhs) const;
    bool operator==(const Inch& rhs) const;
    bool operator!=(const Inch& rhs) const;
    bool operator<(const Inch& rhs) const;
    bool operator<=(const Inch& rhs) const;
    bool operator>(const Inch& rhs) const;
    bool operator>=(const Inch& rhs) const;
    friend std::ostream& operator<<(std::ostream& ost, const Inch& inch);
    friend std::istream& operator>>(std::istream& ist, Inch& inch);
};

#endif
