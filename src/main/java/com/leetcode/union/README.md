See: https://leetcode.com/tag/union-find/
Simply code union find:
```
    int find(int parent[], int i)
    {
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }
 
    void Union(int parent[], int x, int y)
    {
        parent[find(x)] = find(y);
    }
```
