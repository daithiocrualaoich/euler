'''
    145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

    Find the sum of all numbers which are equal to the sum of the
    factorial of their digits.

    Note: As 1! = 1 and 2! = 2 are not sums they are not included.
'''

# The largest contribution from a digit in the factorial sum is 9! = 362880.
#
# Therefore the largest possible seven digit factorial sum from 9,999,999 is
# 7 * 9! = 2,540,160. Since this is a seven digit number it is conceivable
# that seven digit curious numbers exist.
#
# However the largest possible eight digit factorial sum is 8 * 9! = 2,903,040.
# Since this is only a seven digit number it cannot be curious. Similarly,
# neither can any number with more than eight digits.
#
# => Can stop searching for curious numbers at 10,000,000.


from number_theory import factorial, digit_expansion


def digit_factorial_sum(n):
    '''
        Take the individual digits of n and calculate n!, returning the sum.
        n >= 0.
    '''
    factorials = [factorial(d) for d in digit_expansion(n)]
    return sum(factorials)


curious = [n for n in range(3, 10_000_000) if digit_factorial_sum(n) == n]

answer = sum(curious)
print(answer)
