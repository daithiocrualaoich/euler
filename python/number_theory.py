'''
    Support functions for Number Theory calculations.
'''


def factorial(n):
    '''
        Return n! for n >= 0.
    '''

    if n < 0:
        raise ValueError('Negative factorial.')

    if n == 0 or n == 1:
        return 1

    return n * factorial(n - 1)


def digit_expansion(n):
    '''
        Return a list of the digits in n for n >= 0.
    '''

    if n < 10:
        return [n]
    else:
        digits = digit_expansion(n // 10)
        digits.append(n % 10)

        return digits
