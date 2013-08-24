Largest palindrome product
==========================
A palindromic number reads the same both ways. The largest palindrome made from
the product of two 2-digit numbers is 9009 = 91 x 99.

Find the largest palindrome made from the product of two 3-digit numbers.


Answer
======
Include library functions for Number Theory.

    require('./number-theory')

Test for palindromic numbers by converting to strings and reversing.

    Number.prototype.is_palindromic = () -> this.toString().reverse() == this.toString()

Crossing [100..999] with [100..999] in a list comprehension is exhausting for
the call stack. Instead form all the products of two 3-digit numbers as follows.

    products = []
    for n in [100..999]
      for m in [n..999]
        products.push(n*m)

Filter nonpalindromic numbers.

    palindromes = (n for n in products when n.is_palindromic())

And take the maximum.

    answer = palindromes.max()
    console.log(answer)
