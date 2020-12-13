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


def reverse(n):
    '''
        Reverse the digits in an integer.
    '''

    digits = digit_expansion(n)
    digits.reverse()

    return int(''.join(str(d) for d in digits))
