'''
    The decimal number, 585 = 10010010012 (binary), is palindromic in both
    bases.

    Find the sum of all numbers, less than one million, which are palindromic
    in base 10 and base 2.

    (Please note that the palindromic number, in either base, may not include
    leading zeros.)
'''

from number_theory import reverse, digit_expansion


def is_double_base_palindrome(n):
    '''
        Return True if n is a palindrome in base 10 and base 2.
    '''

    # Eliminate non-decimal palindromes first.
    if n != reverse(n):
        return False

    # Use string comparison to shortcut binary digit comparison.
    binary_digits = digit_expansion(n, base=2)
    binary = ''.join(str(d) for d in binary_digits)
    binary_digits.reverse()
    reversed = ''.join(str(d) for d in binary_digits)

    if binary != reversed:
        return False

    return True

double_base_palindromes = [n for n in range(1, 1_000_000) if is_double_base_palindrome(n)]

answer = sum(double_base_palindromes)
print(answer)
