'''
Project Euler, Problem # 4:
  A palindromic number reads the same both ways. The largest palindrome
  made from the product of two 2-digit numbers is 9009 = 91 × 99.

  Find the largest palindrome made from the product of two 3-digit
  numbers.
'''
import math

def is_palindrome(num):
    return str(num) == (str(num)[::-1])

def get_biggest_palindrome(digits):
    start = int(math.pow(10, digits)) - 1
    biggest = 0

    for i in range(start, 0, -1):
        if i * start < biggest:
            break
        for j in range(start, 0, -1):
            product = i * j
            if product < biggest:
                break
            if product > biggest and is_palindrome(product):
                biggest = product
    return biggest

print(get_biggest_palindrome(1))
print(get_biggest_palindrome(2))
print(get_biggest_palindrome(3))
