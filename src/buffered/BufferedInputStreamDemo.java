package buffered;

import java.io.BufferedInputStream;
import java.io.InputStream;

public class BufferedInputStreamDemo {
    /*
    protected byte[] buf -- 这是其中数据存储在内部缓冲器阵列。
    protected int count -- 这是该指数1大于在缓冲器中的最后一个有效字节的索引。
    protected int marklimit -- 这是预读之前，后续调用reset方法失败调用mark方法后允许的最大值。
    protected int markpos -- 这是pos区域在最后标记方法被调用时的值。
    protected int pos -- 这是在缓冲器中的当前位置。
    protected InputStream in -- 这是将进行过滤的输入流。
     */
    InputStream inputStream = null;
    BufferedInputStream bufferedInputStream = null;


}
