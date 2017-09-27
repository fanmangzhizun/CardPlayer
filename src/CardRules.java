import java.util.Comparator;

/**
 * Created by faithpercious on 2017/9/26.
 */
public class CardRules implements Comparator<String> {//卡牌玩法创建，简单的比大小，大小相同则比较花色，黑红梅方的大小，黑桃最大
//用于游戏的规则
    @Override
    public int compare(String o1, String o2) {
        String colors = "♦ ♣ ♥ ♠";
        String numbers = "A 2 3 4 5 6 7 8 9 1 J Q K";

        if (o1.length() > 0 && o2.length() > 0) {
            try{
                char snum1 = o1.charAt(1);
                String  s1 = String.valueOf(snum1);
                char  snum2 = o2.charAt(1);
                String  s2= String.valueOf(snum2);
                char cum1 = o1.charAt(0);
            char cum2 = o2.charAt(0);
            String c1 = String.valueOf(cum1);
            String c2 = String.valueOf(cum2);
                if (numbers.indexOf(s1) == numbers.indexOf(s2)) {
                if (colors.indexOf(c1) == colors.indexOf(c2)) {
                    return 0;
                } else {
                    return colors.indexOf(c1) - colors.indexOf(c2);
                }
            } else {
                return numbers.indexOf(s1) - numbers.indexOf(s2);
            }
        }catch (StringIndexOutOfBoundsException e){
                System.out.println("截取位置出错");
                e.printStackTrace();
                return 0;
            }
        }
        else {
            return 0;
        }
    }
}
