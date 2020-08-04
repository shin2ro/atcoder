import itertools

N, M, Q = map(int, input().split())
qs = [list(map(int, input().split())) for _ in range(Q)]

ans = 0
for A in itertools.combinations_with_replacement(range(1, M + 1), N):
    ans = max(sum([d for (a, b, c, d) in qs if A[b - 1] - A[a - 1] == c]), ans)

print(ans)

