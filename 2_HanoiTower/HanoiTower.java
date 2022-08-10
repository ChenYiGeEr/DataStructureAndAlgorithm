
/***
 * 汉诺塔
 * 详情见百度百科
 *  @link https://baike.baidu.com/item/%E6%B1%89%E8%AF%BA%E5%A1%94
 */
public class HanoiTower {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(n + "层汉诺塔需要移动" + getMoveTimes(n)  + "次");
    }

   /**
    * 根据汉诺塔层数towerLayers获取汉诺塔的移动次数
    *
    * @method getMoveTimes
    * @author lim
    * @date 2022/8/10 22:39
    * @param towerLayers 汉诺塔层数
    * @return long 移动汉诺塔需要的步骤数
    * @exception
    */
    private static long getMoveTimes(int towerLayers){
        if(towerLayers == 0){
            return 0;
        }
        return 2L * getMoveTimes(towerLayers - 1) + 1L;
    }

}