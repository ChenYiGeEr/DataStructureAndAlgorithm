
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 二维数组和稀疏数组相互转换
 *
 */
public class SparseArray2TwoDimensionalArray {

    /** BASE_VALUE */
    private static final int BASE_VALUE = 0;

    /**
     * 二维数组和稀疏数组相互转化
     *
     * @method main
     * @author lim
     * @date 2022/8/11 22:52
     * @param args
     * @exception
     */
    public static void main(String[] args) {
        int[][] param = new int[][]{
                new int[]{-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                new int[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                new int[]{0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0},
                new int[]{0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
                new int[]{0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10}
        };
        System.out.println("遍历打印原始的二维数组");
        ergodicPrintArray(param);
        int[][] sparseArray = twoDimensionalArray2SparseArray(param);
        System.out.println("遍历打印稀疏数组");
        ergodicPrintArray(sparseArray);
        System.out.println("遍历打印稀二维组");
        ergodicPrintArray(sparseArray2TwoDimensionalArray(sparseArray));
    }

    /**
     * 二维数组转稀疏数组
     *
     * @method twoDimensionalArray2SparseArray
     * @author lim
     * @date 2022/8/11 22:50
     * @param twoDimensionalArray 二维数组
     * @return int[][] 稀疏数组
     * @exception
     */
    private static int[][] twoDimensionalArray2SparseArray(int[][] twoDimensionalArray){
        // 初始化elementAndShowTimes，key为二维数组中出现的元素，value为key出现的坐标，value[0]为行 value[1]为列
        Map<Integer, Integer[]> elementAndShowTimes = new HashMap<Integer, Integer[]>();
        // 遍历二维数组，补充稀疏数组信息
        for (int i = 0; i < twoDimensionalArray.length; i++) {
            for (int j = 0; j < twoDimensionalArray[i].length; j++) {
                elementAndShowTimes.put(twoDimensionalArray[i][j], new Integer[]{i,j});
            }
        }
        // 移除基数及其坐标
        elementAndShowTimes.remove(BASE_VALUE);
        int[][] sparseArray = new int[elementAndShowTimes.size() + 1][3];
        // 稀疏数组[0][0] 位置是二维数组的行数
        sparseArray[0][0] = twoDimensionalArray.length;
        // 稀疏数组[0][1] 位置是二维数组的列数
        sparseArray[0][1] = twoDimensionalArray[0].length;
        // 稀疏数组[0][2] 位置是二维数组中的元素去重后的元素数，
        sparseArray[0][2] = elementAndShowTimes.size();
        Set<Integer> keys = elementAndShowTimes.keySet();
        int index = 1;
        for (Integer key : keys) {
            sparseArray[index][0] = elementAndShowTimes.get(key)[0];
            sparseArray[index][1] = elementAndShowTimes.get(key)[1];
            sparseArray[index][2] = key;
            index ++;
        }
        return sparseArray;
    }

    /**
     * 稀疏数组转二维数组
     *
     * @method sparseArray2TwoDimensionalArray
     * @author lim
     * @date 2022/8/11 22:49
     * @param sparseArray 稀疏数组
     * @return int[][] 二维数组
     * @exception
     */
    private static int[][] sparseArray2TwoDimensionalArray(int[][] sparseArray){
        int[][] twoDimensionalArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            twoDimensionalArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return twoDimensionalArray;
    }

    /**
     * 遍历打印数组
     *
     * @method ergodicPrintArray
     * @author lim
     * @date 2022/8/11 23:03
     * @param array 被打印的二维数组
     * @exception
     */
    private static void ergodicPrintArray(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(j == array[i].length - 1){
                    System.out.println(array[i][j]);
                }else{
                    System.out.print(array[i][j] + "\t");
                }
            }
        }
    }
}
