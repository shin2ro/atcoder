N, M, X = map(int, input().split())
books = [list(map(int, input().split())) for _ in range(N)]

ans = -1

for bits in range(1 << N):
    cost = 0
    a = [0] * M
    for i in range(N):
        if (bits >> i) & 1 == 1:
            cost += books[i][0]
            for j in range(M):
                a[j] += books[i][j + 1]

    if min(a) >= X:
        ans = min(cost, ans) if ans >= 0 else cost

print(ans)
