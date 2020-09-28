package leetcodelrucache;//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
//
// 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在
//写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
//
// 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得关键字 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得关键字 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计 
// 👍 914 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    private int capacity;
    private Cache head;
    private Cache tail;
    private HashMap<Integer, Cache> map = new HashMap<>();


    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Cache(-1, -1);
        tail = new Cache(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Cache current = map.get(key);
        moveToTail(current);
        return current.val;
    }

    public void put(int key, int value) {
        //存在
        if (get(key) != -1) {
            Cache cache = map.get(key);
            cache.val = value;
            return;
        }
        //不存在
        if (map.size() == capacity) {
            map.remove(map.remove(head.next.key));
            head.next.next.prev=head;
            head.next = head.next.next;

        }
        Cache cache = new Cache(key, value);
        tail.prev.next = cache;
        cache.prev = tail.prev;
        tail.prev = cache;
        cache.next = tail;
        map.put(key, cache);

    }

    public void moveToTail(Cache current) {
        if(current.next==tail){
            return;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        tail.prev.next = current;
        current.prev = tail.prev;
        tail.prev = current;
        current.next = tail;
    }

    private class Cache {
        public int key;
        public int val;
        public Cache prev;
        public Cache next;

        public Cache(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(1));
        lruCache.put(5, 5);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(5));

        System.out.println("----");
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
