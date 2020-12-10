'''
    The number, 197, is called a circular prime because all rotations of the
    digits: 197, 971, and 719, are themselves prime.

    There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37,
    71, 73, 79, and 97.

    How many circular primes are there below one million?
'''

from number_theory import is_prime, rotations


def is_circular(n):
    '''
        Return True if n is a circular prime for n > 0.
    '''
    for rotation in rotations(n):
        if not is_prime(rotation):
            return False

    return True


circulars = [n for n in range(1, 1_000_000) if is_circular(n)]

answer = len(circulars)
print(answer)
