import cmath
import math


if __name__ == '__main__':
    a, b, h, m = map(int, input().split())
    zh = cmath.rect(a, math.radians((60 * h + m) / 2))
    zm = cmath.rect(b, math.radians(m * 6))
    print(abs(zh - zm))
