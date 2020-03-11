package Thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public void f01(){
        Map<String,Object> integerHashMap = new HashMap<>(8);
        Map<String,Object> map = new ConcurrentHashMap<>(8);
        ConcurrentHashMap<String,Object> concurrentHashMap =
                new ConcurrentHashMap<>(30,1);

        map.put("ttt",1);

        map.get("ttt");
        /*
        final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
        boolean evict) {
            HashMap.Node<K,V>[] tab; HashMap.Node<K,V> p; int n, i;
            if ((tab = table) == null || (n = tab.length) == 0)
                //初始化
                n = (tab = resize()).length;
            if ((p = tab[i = (n - 1) & hash]) == null)//算出数组下标，如果下标等于空
                //创建一个新节点
                tab[i] = newNode(hash, key, value, null);
            else {//数组当前位置非空
                HashMap.Node<K,V> e; K k;
                ///
                if (p.hash == hash &&
                        ((k = p.key) == key || (key != null && key.equals(k))))
                    e = p;
                ///链表还是tree
                else if (p instanceof HashMap.TreeNode)
                    ///tree，将节点加入到tree
                    e = ((HashMap.TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
                else {
                    //链表，阈值是否符合
                    for (int binCount = 0; ; ++binCount) {//遍历链表，统计元素
                        if ((e = p.next) == null) {//判断结点的next是否为空，即判断是否是尾节点
                            p.next = newNode(hash, key, value, null);
                            //与阈值进行比较
                            if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                                treeifyBin(tab, hash);//链表转红黑树
                            break;
                        }
                        if (e.hash == hash &&
                                ((k = e.key) == key || (key != null && key.equals(k))))
                            break;
                        p = e;
                    }
                }
                if (e != null) { // existing mapping for key
                    V oldValue = e.value;
                    if (!onlyIfAbsent || oldValue == null)
                        e.value = value;
                    afterNodeAccess(e);
                    return oldValue;
                }
            }
            ++modCount;
            if (++size > threshold)
                resize();
            afterNodeInsertion(evict);
            return null;
        }
        */
    }
}
