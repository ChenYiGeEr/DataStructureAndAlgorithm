
/***
 * 字符串匹配算法
 */
public class StringMatcher {

    public static void main(String[] args) {
        String string = "i'm lim, not lee, lim!",
               targetString = "lim",
               soutPrefix = "[" + targetString + "]在[" + string + "]中第一次出现的下标是：";
        // 使用一个byte一个byte匹配的算法
        System.out.println(soutPrefix + getFirstMatchIndex1(string, targetString));
        // jdk封装方法 indexOf
        System.out.println(soutPrefix + getFirstMatchIndex2(string, targetString));
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
        long start = CommonMethods.methodStart();
        int result = -1;
        if(string == null || targrtString == null){ return result; }
        byte[] bytes = string.getBytes(), bytes1 = targrtString.getBytes();
        if(bytes1.length > bytes.length){
            CommonMethods.methodEnd(start);
            return result;
        }
        return recursion(bytes, 0, bytes1, 0, 0, start);
    }

    /**
     * （暴力匹配）递归实现第一次出现的下标计算
     *
     * @method recursion
     * @author lim
     * @date 2022/8/10 00:29
     * @param bytes             string转化成的数组
     * @param bytesStartIndex   bytes开始遍历的下标
     * @param bytes1            targrtString转化成的数组
     * @param byte1StartIndex   bytes1开始遍历的下标
     * @param firstTimeMatchIndex 第一次匹配的下标，用于回滚匹配使用
     * @param start             开始时间,用于输出方法执行耗时
     * @return int
     * @exception
     */
    private static int recursion(byte[] bytes, int bytesStartIndex, byte[] bytes1, int byte1StartIndex, int firstTimeMatchIndex, long start){
        int result = -1;
        // 下标判断，防止下标溢出
        if(byte1StartIndex == bytes1.length || bytesStartIndex == bytes.length){ return result; }
        if(bytes1[byte1StartIndex] == bytes[bytesStartIndex]){
            if(byte1StartIndex == 0) { firstTimeMatchIndex = bytesStartIndex;}
            if(byte1StartIndex == bytes1.length - 1){
                CommonMethods.methodEnd(start);
                // return bytesStartIndex - byte1StartIndex;
                return bytesStartIndex + ~byte1StartIndex + 1;
            }else if (bytesStartIndex == bytes.length - 1){
                CommonMethods.methodEnd(start);
                return result;
            }
            return recursion(bytes, ++bytesStartIndex, bytes1, ++byte1StartIndex , firstTimeMatchIndex, start);
        }else {
            return recursion(bytes, (firstTimeMatchIndex != 0 ? ++firstTimeMatchIndex : ++bytesStartIndex), bytes1, 0 , firstTimeMatchIndex, start);
        }
    }

    private static int getFirstMatchIndex2(String string, String targrtString){
        long start = CommonMethods.methodStart();
        int result = string.indexOf(targrtString);
        CommonMethods.methodEnd(start);
        return result;
    }


}