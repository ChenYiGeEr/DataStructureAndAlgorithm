
/**
 * 项目中使用到的公共方法
 *
 * @author lim
 * @date 2022/8/10 22:38
 */
public class CommonMethods {

    /**
     * 记录方法开始时间
     *
     * @method methodStart
     * @author lim
     * @date 2022/8/10 22:36
     * @return long
     */
    public static long methodStart(){
        return System.currentTimeMillis();
    }

    /**
     * 根据传入方法开始时间计算方法执行时间，单位毫秒
     *
     * @method methodEnd
     * @author lim
     * @date 2022/8/10 22:37
     * @param start 方法开始时间
     */
    public static void methodEnd(long start){
        long end = System.currentTimeMillis();
        System.out.println("用时" + (end - start) + "毫秒！");
    }

}
