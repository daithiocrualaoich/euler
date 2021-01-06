'''
    Pandigital Multiples
    ===================
    Take the number 192 and multiply it by each of 1, 2, and 3:

        192 × 1 = 192
        192 × 2 = 384
        192 × 3 = 576

    By concatenating each product we get the 1 to 9 pandigital, 192384576. We
    will call 192384576 the concatenated product of 192 and (1,2,3)

    The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4,
    and 5, giving the pandigital, 918273645, which is the concatenated product
    of 9 and (1,2,3,4,5).

    What is the largest 1 to 9 pandigital 9-digit number that can be formed as
    the concatenated product of an integer with (1,2, ... , n) where n > 1?
'''

# A one digit number will admit a 9-digit concatenated product with n = 9 at
# most, e.g. 1 concatenated with (1, 2, ..., 9) is 123,456,789.
#
# A two digit number will admit a 9-digit concatenated product with n = 4 at
# most, e.g. 10 concatenated with (1, 2, ... 4) is 10,203,040 but 10
# concatenated with (1, 2, ..., 5) is 1,020,304,050 is larger than 9 digits.
#
# A three digit number will admit a 9-digit concatenated product with n = 3 at
# most, e.g. 100 concatenated with (1, 2, 3) is 100,200,300 but n > 3 will
# result in too many digits.
#
# A four digit number will admit a 9-digit concatenated product with n = 2 at
# most, e.g. 1000 concatenated with (1, 2) is 10,002,000 but n > 2 will
# result in too many digits.
#
# Since n must be > 1, no more 9-digit concatenations are possible.
#
# i.e. take digits of length d where d <= 4 and use n = floor(d/2) as the
# maximum n.

from itertools import chain
from number_theory import digit_expansion

def flatten(list_of_lists):
    '''
        Convert a list of lists into a flat iterable with the same elements.

        https://stackoverflow.com/questions/1077015/python-list-comprehensions-compressing-a-list-of-lists
    '''
    return chain.from_iterable(list_of_lists)


def is_pandigital(n):
    '''
        Return True if n is a 9-digit number containing each digit exactly once.
    '''
    digits = digit_expansion(n)

    return (len(digits) == 9) and (0 not in digits) and (len(set(digits)) == 9)


def concatenate(d, n):
    '''
        Return the concatenation of d with n.
    '''
    multiples = [d * i for i in range(1, n + 1)]
    concatenation = ''.join(str(multiple) for multiple in multiples)

    return int(concatenation)


def pandigital_concatenations(d):
    '''
        Returns a list of 9-digit pandigital concatenation products that can be
        formed using d.
    '''
    # Numbers with more than four digits cannot form 9-digit concatenations.
    if d >= 10_000:
        return []

    max_n = int(len(digit_expansion(d)) / 2)
    concatenations = [concatenate(d, n) for n in range(1, max_n + 1)]

    return filter(is_pandigital, concatenations)


candidates = range(1, 10_000)
pandigital_concatenations = flatten(map(pandigital_concatenations, candidates))

answer = max(pandigital_concatenations)  # = 932,718,654
print(answer)
