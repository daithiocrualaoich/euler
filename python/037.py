'''
    Truncatable Primes
    ==================
    The number 3797 has an interesting property. Being prime itself, it is
    possible to continuously remove digits from left to right, and remain prime
    at each stage: 3797, 797, 97, and 7. Similarly we can work from right to
    left: 3797, 379, 37, and 3.

    Find the sum of the only eleven primes that are both truncatable from left
    to right and right to left.

    NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
'''

from itertools import count, islice
from number_theory import digit_expansion, digit_unexpansion, is_prime, prefixes, suffixes


def is_truncatable_prime(n):
    # Single digit primes cannot be truncatable.
    if n < 10:
      return False

    # Calculate left and right truncations.
    digits = digit_expansion(n)
    expansions = list(prefixes(digits)) + list(suffixes(digits))
    truncations = (digit_unexpansion(expansion) for expansion in expansions)

    # And test truncations are primes.
    return all(is_prime(truncation) for truncation in truncations)


integers = count(1)
truncatable_primes = filter(is_truncatable_prime, integers)

# The question tells us there are only 11 truncatable primes.
answer = sum(islice(truncatable_primes, 11))  # = 748,317
print(answer)
