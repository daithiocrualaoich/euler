'''
    Support functions for Number Theory calculations.
'''


def is_prime(n):
    '''
        Test if n is prime by trial division.
    '''

    if n < 2:
        return False

    d = 2

    while d * d <= n:
        if n % d == 0:
            return False
        d += 1

    return True


def factorial(n):
    '''
        Return n! for n >= 0.
    '''

    if n < 0:
        raise ValueError('Negative factorial.')

    if n == 0 or n == 1:
        return 1

    return n * factorial(n - 1)


def digit_expansion(n, base=10):
    '''
        Return a list of the digits in n for n >= 0.
    '''

    if n < base:
        return [n]
    else:
        digits = digit_expansion(n // base, base)
        digits.append(n % base)

        return digits


def digit_unexpansion(digits):
    '''
        Reverse the digit_expansion operation and return a single integer.
    '''

    # Use string operations to concatenate digits.
    return int(''.join(str(digit) for digit in digits))


def rotations(n):
    '''
        Return a list of the digit rotations of n for n >= 0.
    '''

    rotations = []
    digits = digit_expansion(n)

    for i in range(len(digits)):
        # Make the next rotation.
        digits.append(digits.pop(0))
        rotation = int(''.join(str(d) for d in digits))

        rotations.append(rotation)

    # Some rotations can be the same number.
    rotations = set(rotations)

    return rotations


def prefixes(l):
    '''
        Return a list of the prefixes of the given list.
    '''
    return (l[:i+1] for i in range(len(l)))


def suffixes(l):
    '''
        Return a list of the suffixes of the given list.
    '''
    return (l[i:] for i in range(len(l)))


def reverse(n):
    '''
        Reverse the digits in an integer.
    '''

    digits = digit_expansion(n)
    digits.reverse()

    return int(''.join(str(d) for d in digits))
