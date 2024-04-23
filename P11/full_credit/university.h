#ifndef UNIVERSITY_H
#define UNIVERSITY_H

#include <iostream>
#include <string>
#include <stdexcept>

class University {
private:
    std::string _name;
    int _enrollment;

    void validate();

public:
    University(const std::string& name = "", int enrollment = 0);

    const std::string& name() const;
    int enrollment() const;

    friend std::istream& operator>>(std::istream& is, University& university);
    friend std::ostream& operator<<(std::ostream& os, const University& university);
};

#endif // UNIVERSITY_H
