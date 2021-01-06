'''
    Double-base Palindromes
    =======================
    The decimal number, 585 = 10010010012 (binary), is palindromic in both
    bases.

    Find the sum of all numbers, less than one million, which are palindromic
    in base 10 and base 2.

    (Please note that the palindromic number, in either base, may not include
    leading zeros.)
'''

from number_theory import digit_expansion


def reverse_digits(n):
    '''
        Reverse the digits in an integer.
    '''
    digits = digit_expansion(n)
    digits.reverse()

    return int(''.join(str(d) for d in digits))


def is_double_base_palindrome(n):
    '''
        Return True if n is a palindrome in base 10 and base 2.
    '''
    # Eliminate non-decimal palindromes first.
    if n != reverse_digits(n):
        return False

    # Use string comparison to shortcut binary digit comparison.
    binary_digits = digit_expansion(n, base=2)
    binary = ''.join(str(d) for d in binary_digits)

    binary_digits.reverse()
    reversed = ''.join(str(d) for d in binary_digits)

    return binary == reversed


candidates = range(1, 1_000_000)
double_base_palindromes = filter(is_double_base_palindrome, candidates)

answer = sum(double_base_palindromes)  # = 872,187
print(answer)
