'''
    Integer Right Triangles
    =======================
    If p is the perimeter of a right angle triangle with integral length sides,
    {a,b,c}, there are exactly three solutions for p = 120.

    {20,48,52}, {24,45,51}, {30,40,50}

    For which value of p ≤ 1000, is the number of solutions maximised?
'''

# In a right angle triangle a^2 + b^2 = c^2. Rather than search for right angle
# triangles of perimeter exactly p for each p, instead find all right angle
# triangles with p <= 1,000 in any order and tabulate them based on their
# perimeters.
#
# To avoid duplication by symmetry in a, b, we ensure a <= b in the search. In
# a right angle triangle the hypotenuse c is the largest side, so b < c also.
# And since a + b + c <= p_max and a <= b < c, it must be then a < p_max/3 and
# b < p_max/2 or the perimeter will be > than p_max.

from math import sqrt

p_max = 1000
counts = [0] * (p_max + 1)  # Extra element so can index as p instead of p - 1.

for a in range(1, int(p_max / 3)):
    for b in range(a, int(p_max / 2)):
        # Check c is an integer by rounding it to the closest integer and
        # confirming the equality without float operations.
        c = round(sqrt(a * a + b * b))
        if a * a + b * b == c * c:
            # Count the right triangle if perimeter is not larger than p_max.
            if a + b + c <= p_max:
                counts[a + b + c] += 1

max_index, _ = max(enumerate(counts), key=lambda pair: pair[1])

answer = max_index  # = 840
print(answer)
