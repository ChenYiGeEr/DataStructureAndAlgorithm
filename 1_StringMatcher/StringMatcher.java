/***
 * 字符串匹配算法
 */
public class StringMatcher {

    public static void main(String[] args) {
        String string = "hey,jude",
               targetString = "jude",
               soutPrefix = "[" + targetString + "]在[" + string + "]中第一次出现的下标是：";
        // jdk封装方法 indexOf
        System.out.println(soutPrefix + getFirstMatchIndex2(string, targetString));
        // 使用一个byte一个byte匹配的算法
        System.out.println(soutPrefix + getFirstMatchIndex1(string, targetString));
    }

    /**
     * 获取 targrtString 在 string 第一次全句匹配的下标，若string中不包含targetString则返回下标-1；
     *
     * @method getFirstMatchIndex1
     * @author lim
     * @date 2022/8/9 23:46
     * @param string
     * @param targrtString
     * @return java.lang.Integer
     * @exception
     */
    private static int getFirstMatchIndex1(String string, String targrtString){
        long start = getCurrentTimeMillis();
        byte[] bytes = string.getBytes(),
               bytes1 = targrtString.getBytes();
        if(bytes1.length > bytes.length || bytes1.length == 0){
            methodEnd(start);
            return -1;
        }
        return recursion(bytes, 0, bytes1, 0, start);
    }

    /**
     * 递归实现下标计算
     *
     * @method recursion
     * @author lim
     * @date 2022/8/10 00:29
     * @param bytes             string转化成的数组
     * @param bytesStartIndex   bytes开始遍历的下标
     * @param bytes1            targrtString转化成的数组
     * @param byte1StartIndex   targrtString开始遍历的下标
     * @param start             开始时间
     * @return int
     * @exception
     */
    private static int recursion(byte[] bytes, int bytesStartIndex, byte[] bytes1, int byte1StartIndex, long start){
        int result = -1;
        if(byte1StartIndex == bytes1.length){
            methodEnd(start);
            return bytesStartIndex - byte1StartIndex;
        } else if(byte1StartIndex < bytes1.length && bytesStartIndex < bytes.length){
            if(bytes1[byte1StartIndex] == bytes[bytesStartIndex] ){
                if(byte1StartIndex == bytes1.length){
                    methodEnd(start);
                    return bytesStartIndex - byte1StartIndex;
                } else {
                    return recursion(bytes, ++bytesStartIndex, bytes1, ++byte1StartIndex , start);
                }
            }else {
                return recursion(bytes, ++bytesStartIndex, bytes1, 0 , start);
            }
        }
        methodEnd(start);
        return result;
    }

    private static int getFirstMatchIndex2(String string, String targrtString){
        long start = getCurrentTimeMillis();
        int result = string.indexOf(targrtString);
        methodEnd(start);
        return result;
    }

    // 公共方法
    private static long getCurrentTimeMillis(){
        return System.currentTimeMillis();
    }

    // 公共方法
    private static void methodEnd(long start){
        long end = System.currentTimeMillis();
        System.out.println("用时" + (end - start) + "毫秒！");
    }
}