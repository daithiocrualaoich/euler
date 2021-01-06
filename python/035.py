'''
    Circular Primes
    ===============
    The number, 197, is called a circular prime because all rotations of the
    digits: 197, 971, and 719, are themselves prime.

    There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37,
    71, 73, 79, and 97.

    How many circular primes are there below one million?
'''

from number_theory import is_prime, digit_expansion, digit_unexpansion


def rotations(n):
    '''
        Return a list of the digit rotations of n for n >= 0.
    '''
    digits = digit_expansion(n)

    # Rotate the digits.
    rotations = [digits[i:] + digits[:i] for i in range(len(digits))]

    # Convert back into integers.
    rotations = (digit_unexpansion(rotation) for rotation in rotations)

    # Some rotations might be the same number.
    rotations = set(rotations)

    return rotations


def is_circular(n):
    '''
        Return True if n is a circular prime for n > 0.
    '''
    return all(is_prime(rotation) for rotation in rotations(n))


candidates = range(1, 1_000_000)
circulars = list(filter(is_circular, candidates))

answer = len(circulars)  # 55
print(answer)
