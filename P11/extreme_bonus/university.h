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

    friend std::istream& operator>>(std::istream& ist, University& reading);
    friend std::ostream& operator<<(std::ostream& ist, const University& reading);
};

#endif // UNIVERSITY_H
