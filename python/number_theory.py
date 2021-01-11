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


def prefixes(lst):
    '''
        Return a list of the prefixes of the given list.
    '''
    return [lst[: i + 1] for i in range(len(lst))]


def suffixes(lst):
    '''
        Return a list of the suffixes of the given list.
    '''
    return [lst[i:] for i in range(len(lst))]
